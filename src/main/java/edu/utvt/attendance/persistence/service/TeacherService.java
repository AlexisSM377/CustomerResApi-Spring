package edu.utvt.attendance.persistence.service;

import edu.utvt.attendance.persistence.entities.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Teacher save(Teacher teacher);
    Teacher update(String id, Teacher teacher);
    List<Teacher> getAll();
    Optional<Teacher> findById(String id);
    ResponseEntity<Teacher> deleteById(String id);
    Page<Teacher> get(Integer page, Integer size);
}
