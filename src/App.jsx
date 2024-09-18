import './App.css'
import HeaderComponent from './Components/HeaderComponent'
import ListEmployeesComponent from './Components/ListEmployeesComponent'
import FooterComponent from './Components/FooterComponent'

import {BrowserRouter, Routes, Route} from 'react-router-dom'
import EmployeeComponent from './Components/EmployeeComponent'


function App() {
  

  return (
    <>
        <HeaderComponent />
        <div className='container'>
          <Routes>
            {/* // http://localhost:3000 */}
            <Route path='/' element ={<ListEmployeesComponent />}></Route>
            {/* // http://localhost:3000/employees */}
            <Route path='/employees' element={<ListEmployeesComponent />}></Route>
            {/* // http://localhost:3000/addEmployee */}
            <Route path='/add-employee' element={<EmployeeComponent/>}></Route>
            {/* // http://localhost:3000/editEmployee/1 */}
            <Route path='/edit-employee/:id' element = {<EmployeeComponent/>}></Route>
          </Routes> 
        </div>
          
        <FooterComponent/>
    </>
  )
}

export default App
