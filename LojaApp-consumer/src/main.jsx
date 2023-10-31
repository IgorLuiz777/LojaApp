import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'

import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import Home from './routes/Home/index.jsx'
import ListaProdutos from './routes/ListaProdutos/index.jsx'
import Error from './routes/Error/index.jsx'
import FormProduto from './routes/FormProduto/index.jsx'

const router = createBrowserRouter([
  {
    path: "/",
    element: <App/>,
    errorElement: <Error/>,
    children:[
      {
        path: "/",
        element: <Home/>
      },
      {
        path: "/produtos",
        element: <ListaProdutos/>
      },
      {
        path: "/produtos/editar/:id",
        element: <FormProduto/>
      },
      {
        path: "/inserir",
        element: <FormProduto/>
      }
    ]
  }
])

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
