import { useState } from "react";
function RampInput() {
    const[x, setx] = useState();
    const[heartrate, setHeartrate] = useState()
    return (
    <>
    <input
        type="number"
        placeholder="speed"
        id="one"
        value={x}
        onChange={e => setx(e.target.value)}
    />
    <input 
        type="number"
        placeholder="heart rate"
        id="HR"
        value={heartrate}
        onChange={e => setHeartrate(e.target.value)}
    />
    <br/>
    </>
    )
}
export {RampInput}