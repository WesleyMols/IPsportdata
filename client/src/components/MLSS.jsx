import { useState } from "react";
import { analyse } from "../services/api"
import { ShowData } from "./outputMLSS";
import {Results} from '../pages/Results.jsx';

function MLSS() {
    const [dbUsername, setdbUsername] = useState();
    const [username, setUsername] = useState("");
    const [power, setPower] = useState();
    const [lactate, setLactate] = useState();
    const [lactate_two, setLactateTwo] = useState();
    const [heartrate, setHeartrate] = useState();
    const [xaxisdata, setXaxis] = useState([]);
    const [yaxisdata, setYaxis] = useState([]);
    const [ydataLTdiff, setydataLTdiff] = useState([]);
    const [weigth, setWeigth] = useState();
    const [size, setSize] = useState();
    const [returnMessage, setReturnMessage] = useState("");
    const [outputPower, setoutputPower] = useState();
    const [aerobePower, setaerobePower] = useState(0);
    const [speed, setSpeed] = useState(0);
    
    
   
    const onsubmitData = async () => {
      const data = await analyse(username, power, lactate, lactate_two, heartrate, weigth, size)
      
      setdbUsername(data.username)
      setReturnMessage(data.outputAnalysis)
      setoutputPower(data.powerInputList.map((item) => <p key={item}> {item}</p>))
      setaerobePower(data.aerobePower)
      setXaxis([...xaxisdata,power])
      setYaxis([...yaxisdata,heartrate])
      setydataLTdiff([...ydataLTdiff, data.calcLactateDifference])
      setWeigth(data.weigth)
      setSize(data.size)
      
      setSpeed(data.speedFromMLSSPower)
      console.log(data) // alle getters 
    }

return (
    <><input
            data-cy="username"
            type="text"
            id="username"
            placeholder="enter your name"
            value={username}
            onChange={e => setUsername(e.target.value)} />
        <input
            data-cy="weigth"
            type="number"
            id="weigth"
            placeholder="enter your weigth in kilograms"
            value={weigth}
            onChange={e => setWeigth(e.target.value)} />
        <input
            data-cy="size"
            type="number"
            id="size"
            placeholder="enter your length in centimeters"
            value={size}
            onChange={e => setSize(e.target.value)} /><br />
        <input
            data-cy="power"
            type="number"
            id="power"
            placeholder="power"
            value={power}
            onChange={e => setPower(e.target.value)} />
        <input
            data-cy="lactateone"
            type="number"
            id="lactate"
            placeholder="lactate at 3min"
            value={lactate}
            onChange={e => setLactate(e.target.value)} />
        <input
            data-cy="lactatetwo"
            type="number"
            id="lactate2"
            placeholder="lactate at 9min"
            value={lactate_two}
            onChange={e => setLactateTwo(e.target.value)} />
        <input
            data-cy="heartrate"
            type="number"
            id="heart_rate"
            placeholder="avg HR last 4min"
            value={heartrate}
            onChange={e => setHeartrate(e.target.value)} />

        <button onClick={() => onsubmitData()}>
            analyse
        </button>
<br/>
{dbUsername && <div>username: {dbUsername}</div>}
<br/>
<ShowData 
    outputPower={outputPower}
    returnMessage={returnMessage}
    aerobePower={aerobePower}
    speed={speed}
/>
<Results xaxisdata={xaxisdata} yaxisdata={yaxisdata} ydataLTdiff={ydataLTdiff}/>
</>
)
}
export {MLSS}