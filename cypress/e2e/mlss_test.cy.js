describe("multiple inputs followed by analysis", () => {
    beforeEach(() => {
        cy.visit('/')
    })
    it("first input", () => {
        cy.get('#username').type('wes')
        cy.get('#weigth').type('60')
        cy.get('#power').type(200)
        cy.get('#lactate').type(2.2)
        cy.get('#lactate2').type(3)
        cy.get('#heart_rate').type(155)
        cy.get('button').click()
    })
    it("second input", () => {
        cy.get('#username').type('wes') // Cypress deletes previous inputs in contrast with the browser
        cy.get('#weigth').type('60')
        cy.get('#power').type(250)
        cy.get('#lactate').type(3.2)
        cy.get('#lactate2').type(3.9)
        cy.get('#heart_rate').type(165)
        cy.get('button').click()
    })
    it("final input", () => {
        cy.get('#username').type('wes')
        cy.get('#weigth').type('60')
        cy.get('#power').type(300)
        cy.get('#lactate').type(4)
        cy.get('#lactate2').type(7.5)
        cy.get('#heart_rate').type(185)
        cy.get('button').click()
        cy.get('table > :nth-child(2) > :nth-child(3)')
          .contains("198")
    })
})