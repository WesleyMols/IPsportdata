import { draw } from "../services/api"

function RampGraph() {

    const onPlot = async () => {
        const go = await draw()
    }

    return(
        <button onClick={() => onPlot()}>
        Create plot
        </button>
    )
}
export {RampGraph}