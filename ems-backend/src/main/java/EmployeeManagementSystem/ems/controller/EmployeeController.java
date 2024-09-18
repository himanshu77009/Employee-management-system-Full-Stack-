package EmployeeManagementSystem.ems.controller;

import EmployeeManagementSystem.ems.dto.EmployeeDTO;
import EmployeeManagementSystem.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){

        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);

        return ResponseEntity.ok(employeeDTO);
    }

    //Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();

        return ResponseEntity.ok(allEmployees);
    }

    //Build Update Employees REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDTO updatedEmployee){
        EmployeeDTO employeeDTO = employeeService.updateEmployee(employeeId, updatedEmployee);

        return ResponseEntity.ok(employeeDTO);
    }

    //Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);

        return ResponseEntity.ok("Employee deleted succesfully!!!");
    }
}
