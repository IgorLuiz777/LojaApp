
import { Outlet } from "react-router-dom"
import Header from "./components/Header/header"
import Footer from "./components/Footer/footer"


function App() {


  return (
    <main>
      <Header></Header>
      <Outlet></Outlet>
      <Footer></Footer>
    </main>
  )
}

export default App
