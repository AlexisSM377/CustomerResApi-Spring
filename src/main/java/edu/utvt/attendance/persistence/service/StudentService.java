package edu.utvt.attendance.persistence.service;

import edu.utvt.attendance.persistence.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student save (Student student);
    Student update(String id, Student student);
    List<Student> getAll();
    Optional<Student> findById(String id);
    ResponseEntity<Student> deleteById(String id);
    Page<Student> get(Integer page, Integer size);

}
