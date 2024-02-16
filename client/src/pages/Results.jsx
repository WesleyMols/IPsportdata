import { useEffect, useState } from "react";



export const Results = ({xaxisdata, yaxisdata, ydataLTdiff}) => {
    
    var trace1 = {
        x: xaxisdata,
        y: yaxisdata,
        name: 'HR',
        type: 'scatter',
    };
    
    var trace2 = {
    x: xaxisdata,
    y: ydataLTdiff,
    name: 'lt_diff',
    yaxis: 'y2',
    type: 'scatter'
    };
    
    var data = [trace1, trace2];
    
    var layout = {
    title: 'MLSS data analysis scatter plot',
    yaxis: {title: 'heart rate over power'},
    yaxis2: {
        title: 'lactate difference over power',
        titlefont: {color: 'rgb(148, 103, 189)'},
        tickfont: {color: 'rgb(148, 103, 189)'},
        overlaying: 'y',
        side: 'right'
    }
    };
    
    useEffect(() => {Plotly.newPlot('myDiv', data, layout)})
      

    return <div >
        
            <h1>Plot</h1>
            <p>
                This plot is generated on your input.
            </p>
        
        <div id = 'myDiv'>
        </div>
    </div>
}
