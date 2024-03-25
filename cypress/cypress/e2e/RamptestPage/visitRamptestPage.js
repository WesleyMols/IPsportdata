import { Given, When, Then } from "@badeball/cypress-cucumber-preprocessor";

Given('Jack is on a {string}', (page) => {
    cy.visit(`${page}`)
})
When('Jack navigates to the ramptest page', () => {
    cy.get('[data-cy="ramppage"]').contains('Ramp').click()
})
Then('the ramptest page should be loaded', () => {
    cy.get('[data-cy="inputX"]').should('be.visible')
})