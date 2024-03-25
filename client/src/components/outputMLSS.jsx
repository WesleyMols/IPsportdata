
function ShowData({returnMessage, outputPower, aerobePower, speed}) {
   

    return <table data-cy= "table">
      <tr>
    <th>Power Inputs</th>
   <th> Message </th>
   <th> AerobePower </th>
   <th>Calculated speed at MLSS power</th>
   </tr>
   <tr>
   <td>{outputPower} </td>
  <td data-cy="message" >{returnMessage} </td>
    <td data-cy="aerobepower"> {aerobePower}</td>
    <td> {speed}</td>
    </tr>
    </table>
  }
  export {ShowData}