package edu.utvt.attendance.persistence.repositories;

import edu.utvt.attendance.persistence.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

}
