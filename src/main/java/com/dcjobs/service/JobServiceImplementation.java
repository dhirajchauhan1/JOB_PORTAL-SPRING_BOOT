package com.dcjobs.service;


import com.dcjobs.model.Job;
import com.dcjobs.model.ResponseDto;
import com.dcjobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImplementation implements JobService{

    @Autowired
    private JobRepository jobRepository;

    @Override
    public ResponseDto createJob(Job job) {
        Job job1 = jobRepository.save(job);
        if (job1 == null){
            return new ResponseDto(job1, "Job not created!",false, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ResponseDto(null, "Successful!",true, HttpStatus.OK.value());
    }

    @Override
    public ResponseDto getAllJobs() {
        List<Job> jobList = new ArrayList<>();
        jobList.addAll(jobRepository.findAll());
        return new ResponseDto(jobList, "All job fetch successfully!",true, HttpStatus.OK.value());
    }

    @Override
    public ResponseDto getJobById(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        return new ResponseDto(job, "job fetch successfully!",true, HttpStatus.OK.value());
    }

    @Override
    public ResponseDto updateJob(Long id, Job job) {
        Optional<Job> job1 = jobRepository.findById(id);

        if (job1 == null)
            return new ResponseDto(job, "Job not updated!",false, HttpStatus.BAD_REQUEST.value());

        job.setId(id);
        return createJob(job);
    }

    @Override
    public ResponseDto deleteJob(Long id) {
        Optional<Job> job1 = jobRepository.findById(id);
        if (job1 == null)
            return new ResponseDto(null, "Job not present!",false, HttpStatus.BAD_REQUEST.value());
        jobRepository.deleteById(id);
        return new ResponseDto(null, "job deleted successfully!",true, HttpStatus.OK.value());
    }
}
