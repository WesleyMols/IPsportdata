const { defineConfig } = require("cypress");

module.exports = defineConfig({
  projectId: 'o23e5z',
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
