package com.dcjobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DcJobsApplication implements CommandLineRunner {

	@Autowired
	private Bootstrap bootstrap;

	public static void main(String[] args) {
		SpringApplication.run(DcJobsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		bootstrap.saveDemoJob();
	}
}
