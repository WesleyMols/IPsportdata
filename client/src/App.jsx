import { useState } from 'react'
import lacatelogo from '/lactatelogo.png'
import { analyse, start } from "./services/api"
//import classNames from "classnames";
import './App.css'

function App() {
  
  const [result, setResult] = useState();
  const [username, setUsername] = useState("");
  const [power, setPower] = useState(0);
  const [lactate, setLactate] = useState(0);
  const [lactate_two, setLactateTwo] = useState(0);
  const [data, setData] = useState();
  const onsubmit = async () => {
    console.log("clicked")
    const result = await start(username)
    console.log(result)
    setResult(result.username)
  }

  const onsubmitData = async () => {
    console.log("clicked2")
    const data = await analyse(power, lactate, lactate_two)
    console.log(data)
    setData(data.lt_diff)
  }

  function ShowUsername() {
   return <div>username: {result}</div>}


  function ShowData() {
    return <div>lactate: {data}</div>
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
        <button onClick={() => onsubmit()}  >
          submit 
        </button>
        
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
        <ShowData/>
      </div>
      <button onClick={() => onsubmitData()}>
        analyse
      </button>
      
      </div>
    </>
  )
}

export default App
