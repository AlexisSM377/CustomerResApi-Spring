package edu.utvt.attendance;

import com.github.javafaker.Faker;
import edu.utvt.attendance.persistence.common.StudentType;
import edu.utvt.attendance.persistence.entities.Student;
import edu.utvt.attendance.persistence.repositories.StudentRepository;
import edu.utvt.attendance.persistence.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
public class CustomerResApiAApplication implements CommandLineRunner  {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private TeacherRepository teacherRepository;

    public static void main(String[] args) {
        SpringApplication.run(CustomerResApiAApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        int startElements = 0;
        int totalElements = 100;
        Faker faker = new Faker();

        List<Student> students = new ArrayList<>();

        startElements = (int) this.repository.count();
        for (int i = startElements; i < totalElements; i++) {
            Student student = null;

            student = new Student(faker.idNumber().ssnValid(), faker.name().firstName(), faker.name().lastName(),
                    faker.name().username() + "@gmail.com",
                    StudentType.FULL_TIME, new Date(ThreadLocalRandom.current().nextInt() * i), null);
            students.add(student);
        }
        this.repository.saveAll(students);
    }


}
