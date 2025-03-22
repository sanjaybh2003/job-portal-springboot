package com.sanjay.jobportal.repository;

import com.sanjay.jobportal.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
