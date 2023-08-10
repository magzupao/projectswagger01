package com.emp.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.entity.Empl;
import com.emp.repository.EmplyRepository;

@Service
public class EmpServiceImp implements EmpService {
    @Autowired
    EmplyRepository emplyRepository;

    @Override
    public Empl save(Empl emy) {
        return emplyRepository.save(emy);

    }

    @Override
    public List<Empl> getAll() {
        return emplyRepository.findAll();
    }

    @Override
    public Empl getEmpById(Integer emyId) {
        Optional<Empl> empl=emplyRepository.findById(emyId);
        Empl empy=null;
        if(empl.isPresent()) {
            empy=empl.get();
        }else {
            throw new RuntimeException("Empy is not Found"+emyId);
        }
        return empy;
    }

    @Override
    public void delete(Empl emy) {
        emplyRepository.delete(emy);
    }
}