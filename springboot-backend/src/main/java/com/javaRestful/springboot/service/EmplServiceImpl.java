package com.javaRestful.springboot.service;

import com.javaRestful.springboot.exception.NotFoundException;
import com.javaRestful.springboot.model.empl;
import com.javaRestful.springboot.repository.EmplRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmplServiceImpl implements EmplService{

    private EmplRepository employeRepository;


    public EmplServiceImpl(EmplRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    public empl saveEmploye(empl employe) {
        return employeRepository.save(employe);
    }
    @Override
    public List<empl> getAllEmployees()
    {
        return employeRepository.findAll();
    }
    @Override
    public empl getEmployeeId(long id)
    {
//        Optional<empl> employee = employeRepository.findById(id);
//        if (employee.isPresent())
//        {
//            return employee.get();
//        } else
//        {
//            throw   new NotFoundException("Employee" , "id" , id);
//        }
        return employeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee" , "id" , id));
    }

    //update empl
    @Override
    public empl updateEmploye (empl employe, long id)
    {
        //check id
        empl existingEmployee = employeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee" , "id" , id));
        existingEmployee.setFirstName(employe.getFirstName());
        existingEmployee.setLastName(employe.getLastName());
        existingEmployee.setEmail(employe.getEmail());
        //save exist employee to DB
        employeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmploye (long id)
    {
        // check writen id
        employeRepository.findById(id).orElseThrow(() -> new NotFoundException("employee", "id", id));

        employeRepository.deleteById(id);
    }
}
