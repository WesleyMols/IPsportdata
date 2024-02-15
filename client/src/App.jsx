import { useState } from 'react'
import lacatelogo from '/lactatelogo.png'
import { analyse } from "./services/api"
//import classNames from "classnames";
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
  
  const onsubmitData = async () => {
    console.log("clicked")
    
    const data = await analyse(username, power, lactate, lactate_two, heartrate)
    console.log(data) // alle getters uit analysor.java
    setResult(data.username)
    setData(data.calcLactateDiff)
    setReturnMessage(data.outputAnalysis)
    setoutputPower(data.resultList.join(", "))
  }

  function ShowUsername() {
   return <div>username: {result}</div>}


  function ShowData() {
    return <><div>lactate difference: {data}</div>
    <div>{returnMessage} </div>
    <div>power inputs: {outputPower}</div>
    </>
  }

  return (
    <>
      <div>
          <img src={lacatelogo} className='lactate logo' alt='Lactate logo'/>
      </div>
      <h1>MLSS data analysis</h1>
      
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
      <ShowData/>
      </div>
    </>
  )
}

export default App
