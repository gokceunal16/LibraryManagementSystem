import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import IndexRoutes from "./routes";
import {BrowserRouter} from "react-router-dom";
import {AuthProvider} from "./utils/hooks/useAuth";


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <BrowserRouter>
            <AuthProvider>
                <IndexRoutes/>
            </AuthProvider>

        </BrowserRouter>
    </React.StrictMode>
);
