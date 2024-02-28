describe('The Home Page', () => {
    it('successfully loads', () => {
      cy.visit('/') // URL in cypress.config
      cy.get('#username')
        .type('wes')
      cy.get('#weigth').type('60')
      cy.get('#power').type(200)
      cy.get('#lactate').type(2.2)
      cy.get('#lactate2').type(3)
      cy.get('#heart_rate').type(155)
      cy.get('button')
        .should('exist')
        .click()
    })
  })