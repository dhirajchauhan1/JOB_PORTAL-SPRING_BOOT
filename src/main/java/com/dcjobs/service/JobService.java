package com.dcjobs.service;

import com.dcjobs.model.Job;
import com.dcjobs.model.ResponseDto;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface JobService {

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    ResponseDto createJob(Job job);

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    ResponseDto getAllJobs();

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    ResponseDto getJobById(Long id);

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    ResponseDto updateJob(Long id, Job job);

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    ResponseDto deleteJob(Long id);

   /* @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    ResponseDto partialUpdateJob(Job job);*/

}
