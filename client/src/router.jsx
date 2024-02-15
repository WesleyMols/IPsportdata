import { createBrowserRouter } from "react-router-dom";
import { ErrorPage } from "./pages/ErrorPage";
import  {Results}  from "./pages/Results.jsx";
import App from './App.jsx'

export const router = createBrowserRouter([
    {
        path: "/",
        
        errorElement: <ErrorPage />,
        children: [
            {
                index: true,
                element: <App />
            },
            {
                path: "results",
                element: <Results />
            }
        ]
    }
]);