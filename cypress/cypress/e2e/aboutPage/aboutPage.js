import { Given, When, Then } from '@badeball/cypress-cucumber-preprocessor'


Given('Jack is on a {string}', (page) => {
    cy.visit(`${page}`)
})

When('Jack navigates to the about page', () => {
    cy.get('[data-cy="aboutpage"]').contains('About').click()
})

Then('the about page should be loaded', () => {
    cy.url().should('include', '/About')
    cy.get('[data-cy="headerAbout"]').should('be.visible').contains("Welcome")
})