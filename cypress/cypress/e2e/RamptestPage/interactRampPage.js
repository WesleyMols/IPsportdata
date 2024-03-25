import { Given, When, Then } from "@badeball/cypress-cucumber-preprocessor";

Given('Jack is on the ramptest page', () => {
    cy.visit("/Ramptest")
})
When('Jack submits his data {int}, {int}', (x,y) => {
    cy.get('[data-cy="inputX"]').type(x)
    cy.get('[data-cy="inputY"]').type(y)
   
})
Then('the data should be stored', () => {
    cy.get('[data-cy="submitbutton"]').click()
   
})


When('a plot is generated', () => {
    cy.get('[data-cy="plotbutton"]').click()
})
Then('it is shown in desktop', () => {
    
   
})