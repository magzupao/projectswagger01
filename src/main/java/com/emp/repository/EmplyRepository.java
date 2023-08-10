package com.emp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.emp.entity.Empl;

public interface EmplyRepository extends JpaRepository<Empl, Integer> {

}
