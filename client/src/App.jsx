import { useState } from 'react'
import { analyse } from "./services/api"
import React from 'react';
import {Results} from './pages/Results.jsx';
import './App.css'

function App() {
  const [dbUsername, setdbUsername] = useState();
  const [username, setUsername] = useState("");
  const [power, setPower] = useState();
  const [lactate, setLactate] = useState();
  const [lactate_two, setLactateTwo] = useState();
  const [data, setData] = useState();
  const [returnMessage, setReturnMessage] = useState("");
  const [outputPower, setoutputPower] = useState();
  const [heartrate, setHeartrate] = useState();
  const [xaxisdata, setXaxis] = useState([]);
  const [yaxisdata, setYaxis] = useState([]);
  const [ydataLTdiff, setydataLTdiff] = useState([]);
  const [weigth, setWeigth] = useState();
  const [size, setSize] = useState();
  
  const onsubmitData = async () => {
    const data = await analyse(username, power, lactate, lactate_two, heartrate, weigth, size)
    
    setdbUsername(data.username)
    setData(data.calcLactateDifference)
    setReturnMessage(data.outputAnalysis)
    setoutputPower(data.powerInputList.map((item) => <p>{item}</p>))
    setXaxis([...xaxisdata,power])
    setYaxis([...yaxisdata,heartrate])
    setydataLTdiff([...ydataLTdiff, data.calcLactateDifference])
    setWeigth(data.weigth)
    setSize(data.size)
    console.log(data) // alle getters uit analysor.java
  }

  function ShowUsername() {
   return <div>username: {dbUsername}</div>}


  function ShowData() {
    return <>
    
    <div>{returnMessage} </div>
    <div>Power inputs: {outputPower}</div>
    </>
  }
  
  return (
    <>
        <div>                 
            <input
              type = "text"
              id="username"
              placeholder="enter your name"
              value={username}
              onChange={e => setUsername(e.target.value)}
              />
              <input
              type = "text"
              id="weigth"
              placeholder="enter your weigth in kilograms"
              value={weigth}
              onChange={e => setWeigth(e.target.value)}
              />
              <input
              type = "text"
              id="size"
              placeholder="enter your length in centimeters"
              value={size}
              onChange={e => setSize(e.target.value)}
              />          
        <ShowUsername
       />
       <br />
       <div className="grid grid-cols-4 gap-4">
       <input
        type="text"
        id="power"
        placeholder="power"
        value={power}
        onChange={e => setPower(e.target.value)}
        />
        <input
        type="text"
        id="lactate"
        placeholder="lactate at 3min"
        value={lactate}
        onChange={e => setLactate(e.target.value)}
        />
        <input 
        type="text"
        id="lactate2"
        placeholder="lactate at 9min"
        value={lactate_two}
        onChange={e => setLactateTwo(e.target.value)}
        />
        <input 
        type="text"
        id="heart_rate"
        placeholder="avg HR last 4min"
        value={heartrate}
        onChange={e => setHeartrate(e.target.value)}
        />
        <br />
       
      </div>
      <button onClick={() => onsubmitData()}>
        analyse
      </button>
      <br /><br />
      <ShowData/>
      <br /><br />
      </div>
      <Results xaxisdata={xaxisdata} yaxisdata={yaxisdata} ydataLTdiff={ydataLTdiff}/>
    </>
  )
}

export default App
