import { useState } from 'react'
import lacatelogo from '/lactatelogo.png'
import { start } from "./services/api"
//import classNames from "classnames";
import './App.css'

function App() {
  
  var result;
  const [username, setUsername] = useState("");
  const onsubmit = async () =>{
    console.log("clicked")
    result = await start(username);
    console.log(result)
    return <div>{result}</div>;
    
  }

  function ShowUsername() {
   return <div>username: {username}</div>}

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
          Analyse 
        </button>
        
        <ShowUsername
       />
      </div>
    </>
  )
}

export default App
