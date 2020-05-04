package com.vedisoft.vedisoft2020;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vedisoft.vedisoft2020.daos.BatchDetailsDao;
import com.vedisoft.vedisoft2020.daos.CourseDetailsDao;
import com.vedisoft.vedisoft2020.pojos.Batch;
import com.vedisoft.vedisoft2020.pojos.Course;
import com.vedisoft.vedisoft2020.pojos.Session;

@SpringBootApplication
public class Vedisoft2020Application {

	public static void main(String[] args) {
//	ConfigurableApplicationContext context = 		
		SpringApplication.run(Vedisoft2020Application.class, args);
	}

}
