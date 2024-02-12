import { useState } from 'react'
import lacatelogo from '/lactatelogo.png'
import { analyse } from "./services/api"
//import classNames from "classnames";
import './App.css'

function App() {
  
  const [result, setResult] = useState();
  const [username, setUsername] = useState("");
  const [power, setPower] = useState(0);
  const [lactate, setLactate] = useState(0);
  const [lactate_two, setLactateTwo] = useState(0);
  const [data, setData] = useState();
  
  const onsubmitData = async () => {
    console.log("clicked")
    const data = await analyse(username, power, lactate, lactate_two)
    console.log(data) // alle getters uit analysor.java
    setData(data.calcLactateDiff)
  }

  function ShowUsername() {
   return <div>username: {result}</div>}


  function ShowData() {
    return <><div>lactate difference: {data}</div>
    <div>therefore your MLSS power lies between power-1 and {power} </div></>
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
