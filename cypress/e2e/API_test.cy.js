describe("POST request test", () => {
    it("validate creation by post request", () => {
        //cy.visit("/");
        cy.request({
            method: "POST",
            url: "https://localhost:5173",
            body: {
                title: "test title",
                body: "test body",
            },
            headers: { "Content-type": "application/josn; charset=UTF-8" },
        })
            .its("status")
            .should("eq", 200);
    });
});
