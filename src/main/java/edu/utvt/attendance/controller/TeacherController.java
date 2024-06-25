package edu.utvt.attendance.controller;


import edu.utvt.attendance.persistence.entities.Teacher;
import edu.utvt.attendance.persistence.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public List<Teacher> get() {
        return teacherService.getAll();
    }

    @GetMapping
    public Page<Teacher> getMethodName(@RequestParam(value = "page", defaultValue = "1") Integer page, Integer size) {
        return this.teacherService.get(page, size);
    }

    @PostMapping
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher) {
        return ResponseEntity.created(null).body(this.teacherService.save(teacher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> update(@PathVariable("id") String id, @RequestBody Teacher teacher) {
        return ResponseEntity.ok(this.teacherService.update(id, teacher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        this.teacherService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable("id") String id) {
        return ResponseEntity.of(this.teacherService.findById(id));
    }


}
