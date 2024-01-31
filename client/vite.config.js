import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'


// vite.config.js
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      "/sogyo": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false
      }
    }
  }
})