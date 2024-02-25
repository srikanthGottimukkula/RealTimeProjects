package com.srikanth.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srikanth.app.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
