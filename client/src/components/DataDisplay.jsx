// eslint-disable-next-line no-unused-vars
import React from "react";

// eslint-disable-next-line react/prop-types
const DataDisplay = ({outputPower, returnmessage, aerobePower, speed}) => {
    return <div>
        <p>{outputPower}</p>
        <p>{returnmessage}</p>
        <p>{aerobePower}</p>
        <p>{speed}</p>
    </div>
}
export default DataDisplay