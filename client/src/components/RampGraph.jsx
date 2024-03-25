import { useState } from "react"
import { draw } from "../services/api"
import { PlotRamp } from "./plotRamp"

function ShowPlot(isPlot) {
    if(isPlot) return <PlotRamp/>
    
}

function RampGraph() {
    const [isPlot, setIsPlot] = useState(false);

    const onPlot = async () => {
        const go = await draw()
        setIsPlot(true)
        }
    

    return(
        <><button
            data-cy="plotbutton"
            onClick={() => onPlot()}>
            Create plot
        </button>
        <br/>
        
        <ShowPlot isPlot={isPlot}/>
        </>
    )
}
export {RampGraph}