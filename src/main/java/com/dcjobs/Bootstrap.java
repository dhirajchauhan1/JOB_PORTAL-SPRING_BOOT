package com.dcjobs;

import com.dcjobs.model.Job;
import com.dcjobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Bootstrap {

    @Autowired
    private JobRepository jobRepository;

    public void saveDemoJob(){
        Long size = jobRepository.count();
        if (size == 0){

            /*List<String> skillList = new ArrayList<>();
            skillList.add("");

            List<String> locationList = new ArrayList<>();
            locationList.add("");*/

            Job job = new Job();
            jobRepository.save(job);

        }
    }
}
