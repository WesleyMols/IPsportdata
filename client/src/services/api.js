
export async function analyse(username, power, lactate, lactate_two, heartrate, weight, size) {
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
            weight: weight,
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
 
export async function RampAnalysis(speed, heartrate) {
    const response = await fetch("sogyo/wesley/ipsportdata/app/rampanalysis", {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            speed: speed,
            heartrate: heartrate
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

export async function draw() {
    const response = await fetch("sogyo/wesley/ipsportdata/app/draw", {
        method: "POST",
        headers: {
            Accept: "application/json",
            
        },
        
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