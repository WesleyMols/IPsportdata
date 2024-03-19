import { Given, When, Then } from '@badeball/cypress-cucumber-preprocessor'

Given('I am on the home page', () => {
    cy.visit('/')
})

When('I click on about button in navigationbar', () => {
    cy.get('[data-cy="aboutpage"]').contains('About').click()
})

Then('I should be redirected to the about page', () => {
    cy.url().should('include', '/About')
})