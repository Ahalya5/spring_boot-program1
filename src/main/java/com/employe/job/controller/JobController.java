package com.employe.job.controller;

import com.employe.job.dto.JobDTO;
import com.employe.job.entity.JobDAO;
import com.employe.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("/post")
    public String post(@RequestBody JobDTO jobDTO) {
        jobService.createJob(jobDTO);
        return "Job create successfully";
    }

    @GetMapping("/get/{id}")
    public Optional<JobDAO> get(@PathVariable("id") Integer id) {
        return jobService.getById(id);

    }

    @GetMapping("/get")
    public ArrayList<JobDTO> getAllJob() {

       return jobService.getAllJob();
    }
    @PutMapping("/updateJob/{id}")
    public void updateJob(@PathVariable("id") Integer id,@RequestBody JobDTO jobDTO){
     jobService.updateJob(id, jobDTO);
    }
    @DeleteMapping("/deleteJob/{id}")
    public void deleteJob(@PathVariable("id") Integer id){
        jobService.deleteJob(id);
    }
}


