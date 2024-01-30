import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import { start } from "./services/api"
//import { FloatingInput } from "../components/FloatingInput.jsx"
//import classNames from "classnames";
import './App.css'


function App() {
  const [count, setCount] = useState(0);
  const [username, setUsername] = useState("");
  const onsubmit = async () => {
    const result = await start(username);
    setGameState(result);

  }
  return (
    <>
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
        </div>
        <div>

        <form>          
            <input
              type = "text"
              id="username"
              placeholder="enter your name"
              name="name"
              value={username}
              onChange={e => setUsername(e.target.value)} 
              />         
          
        <button onClick={() => onsubmit()}  >
          Analyse
          {console.log("clicked")}
        </button>
        </form>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default App
