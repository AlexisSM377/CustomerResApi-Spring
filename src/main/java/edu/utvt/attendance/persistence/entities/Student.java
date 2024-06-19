package edu.utvt.attendance.persistence.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.utvt.attendance.persistence.common.StudentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "te_students")
public class Student {

    @Id
    @Column(length = 255)
    private String id;

    @Column(length = 50, nullable = false)
    private String firstname;

    @Column(length = 100, nullable = false)
    private String lastname;

    @Column(length = 50, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StudentType type;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false, columnDefinition = "DATE")
    private Date birthDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private Date createdOn;

}
