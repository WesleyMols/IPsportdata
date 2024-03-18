import { createBrowserRouter } from "react-router-dom";
import { ErrorPage } from "./pages/ErrorPage";
import  {Results}  from "./pages/Results.jsx";
import {About} from "./pages/About.jsx";
import Ramptest from "./pages/Ramptest.jsx"; // default imports: no {}
import App from './App.jsx';

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
            },
            {
                path: "About",
                element: <About />
            },
            {
                path: "Ramptest",
                element: <Ramptest/>
            }
        ]
    }
]);
