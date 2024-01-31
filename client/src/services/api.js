

export async function start(username) {
    const response = await fetch("sogyo/wesley/ipsportdata/app/start", {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            username: username
        }),
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

export async function analyse() {
    const response = await fetch("sogyo/wesley/ipsportdata/app/analyse", {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            
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