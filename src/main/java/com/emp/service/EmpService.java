package com.emp.service;
import java.util.List;
import com.emp.entity.Empl;

public interface EmpService {
    Empl save(Empl empl);
    List<Empl> getAll();
    Empl getEmpById(Integer empId);
    void delete(Empl empl);
}
