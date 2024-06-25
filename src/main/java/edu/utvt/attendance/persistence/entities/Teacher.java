package edu.utvt.attendance.persistence.entities;

import java.util.Date;

import edu.utvt.attendance.persistence.common.StatusTeacherType;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "te_teachers")
public class Teacher {

    @Id
    @Column(length = 5)
    private String id;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 100, nullable = false)
    private String lastName;

    @Column(length = 50, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTeacherType status;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false, columnDefinition = "DATE")
    private Date birthDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private Date createdOn;
}
