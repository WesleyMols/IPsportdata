import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import { start } from "./services/api"
//import { FloatingInput } from "../components/FloatingInput.jsx"
//import classNames from "classnames";
import './App.css'
//initiate branch commit

function App() {
  const [count, setCount] = useState(0);
  var div;
  const [username, setUsername] = useState("");
  const onsubmit = async () => {
    console.log("clicked")
    const result = await start(username);
    console.log(result)
  }

  function ShowUsername() {
   return <div>username: {username}</div>}

  return (
    <>
      <div>
          <img src={viteLogo} className="logo" alt="Vite logo" />
          <img src={reactLogo} className="logo react" alt="React logo" />
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        </div>
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
