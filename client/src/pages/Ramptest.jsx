
import { RampInput } from "../components/RampInput";
import {RampOutput} from "../components/RampOutput";
import { RampGraph } from "../components/RampGraph";
function Ramptest() {
    
    return (
    <>
    <h1>Page to analyse a ramp test based on speed/power versus heart rate/lactate.</h1>
    
    <RampInput/>
    <RampOutput/>
    <RampGraph/>
    {/* <RampInput/>
    <RampInput/>
    <RampInput/>
    <RampInput/>
    <RampInput/>
    <RampInput/> */}
    </>
    )
}

export default Ramptest;