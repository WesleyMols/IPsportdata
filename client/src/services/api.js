
export async function analyse(username, power, lactate, lactate_two, heartrate, weigth, size) {
    const response = await fetch("sogyo/wesley/ipsportdata/app/analyse", {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            username: username,
            power: power,
            lactate: lactate,
            lactate_two: lactate_two,
            heartrate: heartrate,
            weigth: weigth,
            size: size
        })
    });

    if (response.ok) {
        const state = await response.json();
        return state;
    } else {
        return {
            statusCode: response.status,
            statusText: response.statusText
        };
    }
}