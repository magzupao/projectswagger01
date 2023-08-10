package com.emp.controller;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emp.entity.Empl;
import com.emp.service.EmpService;

@RestController
@RequestMapping("/api/emp")
public class EmpController {
    @Autowired
    EmpService empService;
    @GetMapping("/list")
    public List<Empl> empList(){
        return empService.getAll();

    }
    @PostMapping("/save")
    public Empl save(@RequestBody Empl emp) {
        return empService.save(emp);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmpById(@PathVariable Integer id) {
        return ResponseEntity.ok(empService.getEmpById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmp(@PathVariable Integer id,@RequestBody Empl emp){
        Empl updateEmp=empService.getEmpById(id);
        updateEmp.setFirstName(emp.getFirstName());
        updateEmp.setLastName(emp.getLastName());
        updateEmp.setEmailId(emp.getEmailId());
        return  ResponseEntity.ok(empService.save(updateEmp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmp(@PathVariable Integer id){
        Map<String,Boolean> map=new LinkedHashMap<String,Boolean>();
        Empl deleteEmp=empService.getEmpById(id);
        empService.delete(deleteEmp);
        map.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(map);
    }
}