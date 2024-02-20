import { useState } from 'react'
import { analyse } from "./services/api"
import React from 'react';
import {Results} from './pages/Results.jsx';
import './App.css'

function App() {
  const [result, setResult] = useState();
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

  
  const onsubmitData = async () => {
    const data = await analyse(username, power, lactate, lactate_two, heartrate)
    console.log(data) // alle getters uit analysor.java
    setResult(data.username)
    setData(data.calcLactateDifference)
    setReturnMessage(data.outputAnalysis)
    setoutputPower(data.powerInputList.map((item) => <p>{item}</p>))
    setXaxis([...xaxisdata,power])
    setYaxis([...yaxisdata,heartrate])
    setydataLTdiff([...ydataLTdiff, data.calcLactateDifference])
  }

  function ShowUsername() {
   return <div>username: {result}</div>}


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
