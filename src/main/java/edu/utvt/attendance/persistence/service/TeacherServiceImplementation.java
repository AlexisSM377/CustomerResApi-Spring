package edu.utvt.attendance.persistence.service;

import edu.utvt.attendance.persistence.entities.Teacher;
import edu.utvt.attendance.persistence.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImplementation implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher save(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(String id, Teacher teacher) {
        Optional<Teacher> teacherOptional = this.teacherRepository.findById(id);

        if (teacherOptional.isPresent()) {
            Teacher existingTeacher = teacherOptional.get();

            existingTeacher.setFirstName(teacher.getFirstName());
            existingTeacher.setLastName(teacher.getLastName());
            existingTeacher.setEmail(teacher.getEmail());
            existingTeacher.setStatus(teacher.getStatus());
            existingTeacher.setBirthDate(teacher.getBirthDate());

            return this.teacherRepository.save(existingTeacher);
        }
        return teacherOptional.orElseThrow();
    }

    @Override
    public List<Teacher> getAll() {
        return this.teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findById(String id) {
        return this.teacherRepository.findById(id);
    }

    @Override
    public ResponseEntity<Teacher> deleteById(String id) {

        Optional<Teacher> teacherOptional = this.teacherRepository.findById(id);

        if (teacherOptional.isPresent()) {
            this.teacherRepository.delete(teacherOptional.get());
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public Page<Teacher> get(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("lastname"));
        return this.teacherRepository.findAll(pageRequest);
    }
}
