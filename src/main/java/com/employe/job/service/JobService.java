package com.employe.job.service;

import com.employe.job.dto.JobDTO;
import com.employe.job.entity.JobDAO;
import com.employe.job.repository.JobRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public JobDTO convertDAOtoDTO(JobDAO jobDAO){
        return modelMapper.map(jobDAO, JobDTO.class);
    }

    public JobDAO convertDTOtoDAO(JobDTO jobDTO){
        return modelMapper.map(jobDTO, JobDAO.class);
    }


    public String createJob(JobDTO jobDTO){
        JobDAO jobDAO=modelMapper.map(jobDTO,JobDAO.class);
        jobRepository.save(jobDAO);
        return "success";
    }
    public Optional<JobDAO> getById(Integer id){
       return jobRepository.findById(id);

    }
    public JobDTO updateJob(Integer id,JobDTO jobDTO){
        JobDAO jobDAO = this.convertDTOtoDAO(jobDTO);
        jobDAO.setId(id);
        jobDAO = jobRepository.save(jobDAO);
        return modelMapper.map(jobDAO, JobDTO.class);
    }
public ArrayList<JobDTO> getAllJob(){
    List<JobDAO> jobdAOS = jobRepository.findAll();
    ArrayList<JobDTO> jobDTOArrayList = new ArrayList<JobDTO>();
    for (JobDAO jobDAo: jobdAOS) {
        jobDTOArrayList.add(modelMapper.map(jobDAo, JobDTO.class));
    }
    return jobDTOArrayList;
    }
    public void deleteJob(Integer id){
        jobRepository.deleteById(id);
    }
}
