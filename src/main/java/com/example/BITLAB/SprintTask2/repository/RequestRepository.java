package com.example.BITLAB.SprintTask2.repository;

import com.example.BITLAB.SprintTask2.model.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<ApplicationRequest,Long> {
    List<ApplicationRequest> findAllByHandledIsFalse();
    List<ApplicationRequest> findAllByHandledIsTrue();
}
