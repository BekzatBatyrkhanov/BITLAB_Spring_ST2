package com.example.BITLAB.SprintTask2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="app_request")
@Getter
@Setter
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    String userName;
    @Column(name = "coursename")
    String courseName;
    @Column(name = "comment")
    String commentary;
    @Column(name = "phone")
    String phone;
    @Column(name = "handled")
    boolean handled;

}
