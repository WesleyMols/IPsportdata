
function SubmitRampInputButton() {
    const [speed, setSpeed] = useState();
    const [heartrate, setHeartrate] = useState();

    const onsubmit = async () => {
        const data = await RampAnalysis(speed, heartrate)
        setSpeed(data.speed)
        setHeartrate(data.heartrate)
    }
    return (
    <button data-cy="SubmitRampInputButton"
        onClick={onsubmit()}>submit</button>
        )}