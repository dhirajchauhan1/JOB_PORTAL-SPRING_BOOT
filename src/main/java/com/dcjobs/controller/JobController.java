package com.dcjobs.controller;

import com.dcjobs.model.Job;
import com.dcjobs.model.ResponseDto;
import com.dcjobs.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    ResponseEntity<ResponseDto> saveJob(@RequestBody Job job){
        ResponseDto responseDto = jobService.createJob(job);
        return new ResponseEntity<>(responseDto, HttpStatus.valueOf(responseDto.getHttpStatus()));
    }

    @GetMapping
    ResponseEntity<ResponseDto> getAll(){
        ResponseDto responseDto =jobService.getAllJobs();
        return new ResponseEntity<>(responseDto, HttpStatus.valueOf(responseDto.getHttpStatus()));
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseDto> getById(@PathVariable Long id){
        ResponseDto responseDto = jobService.getJobById(id);
        return new ResponseEntity<>(responseDto, HttpStatus.valueOf(responseDto.getHttpStatus()));
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseDto> updateJob(@PathVariable  Long id, @RequestBody Job job){
        ResponseDto responseDto = jobService.updateJob(id, job);
        return new ResponseEntity<>(responseDto, HttpStatus.valueOf(responseDto.getHttpStatus()));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseDto> deleteById(@PathVariable Long id){
        ResponseDto responseDto = jobService.deleteJob(id);
        return new ResponseEntity<>(responseDto, HttpStatus.valueOf(responseDto.getHttpStatus()));
    }

}
