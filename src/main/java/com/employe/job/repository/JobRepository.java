package com.employe.job.repository;

import com.employe.job.entity.JobDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobDAO,Integer> {


}
