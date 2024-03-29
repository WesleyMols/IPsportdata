import { useState } from "react";
import { RampAnalysis } from "../services/api"
import {RampOutput} from "./RampOutput.jsx"

function RampInput() {
    const[speed, setSpeed] = useState();
    const[heartrate, setHeartrate] = useState();
    const onsubmitData = async () => {
        const data = await RampAnalysis(speed, heartrate)
        console.log(data)
        setSpeed(data.speed)
        setHeartrate(data.heartrate)
    }
    
    return (
    <>
    <input
        data-cy="inputX"
        type="number"
        placeholder="speed"
        id="one"
        value={speed}
        onChange={e => setSpeed(e.target.value)}
    />
    <input 
        type="number"
        data-cy="inputY"
        placeholder="heart rate"
        id="HR"
        value={heartrate}
        onChange={e => setHeartrate(e.target.value)}
    />
    
    <button
    data-cy="submitbutton"
        onClick={() => onsubmitData()}>submit</button>
    <br/><br/>
    <RampOutput speed={speed}/>
    </>
    )
}
export {RampInput}