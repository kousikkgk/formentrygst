package com.kousik.formentrygst.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kousik.formentrygst.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
