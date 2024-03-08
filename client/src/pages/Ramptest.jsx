import { useState } from "react";
import App from "../App"

function Ramptest() {
    const[x, setx] = useState();
    return (
    <>
    <h1>Page to analyse a ramp test based on speed/power versus heart rate/lactate.</h1>
    <input
        type="number"
        placeholder="speed"
        id="one"
        value={x}
        onChange={e => setx(e.target.value)}
    />
    <input /><input /><input /><input /><br/>
   
    </>
    )
}

export default Ramptest;