import my_image from "../../../Tekeningen/my_image.png"

function PlotRamp() {

return (
    <img key={Date.now()} src={my_image} alt="plot" />
)
}
export {PlotRamp}