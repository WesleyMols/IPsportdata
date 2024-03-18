describe('The Home Page', () => {
    beforeEach(() => {
        cy.visit('/')
    })

    context("table selection", () => {
        it('successfully loads', () => {
      cy.get('#username')
        .type('wes')
      cy.get('#weigth').type('60') // doesnot look like it matters if this value is a string or number
      cy.get('#power').type(200)
      cy.get('#lactate').type(2.2)
      cy.get('#lactate2').type(3)
      cy.get('#heart_rate').type(155)
      cy.get('button')
        .should('exist')
        .contains('analyse')
        .click()
    })
    it('get table headers', () => {
        cy.get('table > :nth-child(1) > :nth-child(3)')
        cy.get('table')
    })
    })
    
    it('go to about page', () => {
        cy.get('ul > :nth-child(2) > a').contains('About').click()
        cy.location("pathname").should("eq", "/About")
    })
  })