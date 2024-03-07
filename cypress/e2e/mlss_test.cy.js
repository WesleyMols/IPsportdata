describe("multiple inputs followed by analysis", () => {
    beforeEach(() => {
        cy.visit('/')
    })
    it("first input", () => {
        cy.get('[data-cy="username"]').type('wes')
        cy.get('[data-cy="weigth"]').type('60')
        cy.get('[data-cy="power"]').type(200)
        cy.get('[data-cy="lactateone"]').type(2.2)
        cy.get('[data-cy="lactatetwo"]').type(3)
        cy.get('[data-cy="heartrate"]').type(155)
        cy.get('button').click()
    
        cy.get('[type="text"]').clear()
        cy.get('[type="number"]').clear()
        cy.get('[data-cy="power"]').clear()
        cy.get('[data-cy="lactateone"]').clear()
        cy.get('[data-cy="lactatetwo"]').clear()
        cy.get('[data-cy="heartrate"]').clear()


        cy.get('[data-cy="username"]').type('wes') // Cypress deletes previous inputs in contrast with the browser
        cy.get('[data-cy="weigth"]').type('60')
        cy.get('[data-cy="power"]').type(250)
        cy.get('[data-cy="lactateone"]').type(3.2)
        cy.get('[data-cy="lactatetwo"]').type(3.9)
        cy.get('[data-cy="heartrate"]').type(165)
        cy.get('button').click()

        cy.get('[type="text"]').clear()
        cy.get('[type="number"]').clear()
        cy.get('[data-cy="power"]').clear()
        cy.get('[data-cy="lactateone"]').clear()
        cy.get('[data-cy="lactatetwo"]').clear()
        cy.get('[data-cy="heartrate"]').clear()
   
        cy.get('[data-cy="username"]').type('wes')
        cy.get('[data-cy="weigth"]').type('60')
        cy.get('[data-cy="power"]').type(300)
        cy.get('[data-cy="lactateone"]').type(4)
        cy.get('[data-cy="lactatetwo"]').type(7.5)
        cy.get('[data-cy="heartrate"]').type(185)
        cy.get('button').click()
        cy.get('[data-cy="table"]').cy.get('[data-cy="aerobepower"]').contains("198")
    })
})