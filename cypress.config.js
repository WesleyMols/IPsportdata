const { defineConfig } = require('cypress')

module.exports = defineConfig({
  projectId: '0.1.2',
  e2e: {
    baseUrl: 'http://localhost:5173',
  },
})