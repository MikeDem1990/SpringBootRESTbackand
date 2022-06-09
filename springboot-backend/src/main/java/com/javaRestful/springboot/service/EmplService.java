package com.javaRestful.springboot.service;

import com.javaRestful.springboot.model.empl;

import java.util.List;

public interface EmplService {

    empl saveEmploye(empl employe);
    List<empl> getAllEmployees();
    empl getEmployeeId(long id);
    empl updateEmploye(empl enploye, long id);
    void deleteEmploye(long id);


}
