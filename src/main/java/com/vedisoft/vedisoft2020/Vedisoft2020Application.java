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
//		BatchDetailsDao b = new BatchDetailsDao();
//		List<Batch> batch = b.getAllBatches();
//		System.out.println(batch.size());
//		CourseDetailsDao c = new CourseDetailsDao();
//		List<Course> course = c.getAllCourse();
//		System.out.println(course.size());
//		Batch batch = new Batch();
//		
//		batch.setCourse(new CourseDetailsDao().getCourseById((long)55));
//		batch.setBranchId((long) 1);
//		batch.setCode("rtyu");
//		Session session = new Session();
//		session.setSessionId((long)1);
//		batch.setSession(session);
//		context.getBean(BatchDetailsDao.class).createBatch(batch);
//		List<Course> course = context.getBean(CourseDetailsDao.class).getAllCourse();
//		System.out.println(course.size());
//		
	}

}
