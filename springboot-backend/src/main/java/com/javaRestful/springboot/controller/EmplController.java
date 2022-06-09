package com.javaRestful.springboot.controller;

import com.javaRestful.springboot.model.empl;
import com.javaRestful.springboot.service.EmplService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmplController {
    private EmplService emplService;

    public EmplController(EmplService emplService) {
        this.emplService = emplService;
    }

    //build create employee REST API
    @PostMapping()
   public ResponseEntity<empl> saveEmploye(@RequestBody empl employe)
   {
       return new ResponseEntity<empl>(emplService.saveEmploye(employe), HttpStatus.CREATED);
   }

   //build get all employees
    @GetMapping
    public List<empl> getAllEmployees()
    {
        return  emplService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<empl> getEmployeeId (@PathVariable("id") long id) {
        return new ResponseEntity<empl>(emplService.getEmployeeId(id), HttpStatus.OK);
    }
    //update

    @PutMapping("{id}")
    public ResponseEntity<empl> updateEmployee (@PathVariable("id") long id, @RequestBody empl employe)
    {
        return new ResponseEntity<empl>(emplService.updateEmploye(employe,id), HttpStatus.OK);

    }
    // delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable("id") long id)
    {
        emplService.deleteEmploye(id);

        return new ResponseEntity<String> ( "Employee deleted seccessfully!", HttpStatus.OK);
    }




}

