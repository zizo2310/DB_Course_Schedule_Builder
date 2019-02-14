package com.example.course.coursebuild;

import com.example.course.coursebuild.Course.CourseDb;
import com.example.course.coursebuild.Course.UserDb;
import com.example.course.coursebuild.reposatory.CourseDbRepo;
import com.example.course.coursebuild.reposatory.UserDbRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class CoursebuildApplication implements CommandLineRunner {

    private CourseDbRepo  courseRepo;
    private UserDbRepo userRepo;

    private Logger LOG = LoggerFactory.getLogger(CoursebuildApplication.class);

    @Autowired
    public void setCourseRepo(CourseDbRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Autowired
    public void setUserRepo (UserDbRepo userRepo){
        this.userRepo =userRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(CoursebuildApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CourseDb course1 = new CourseDb();
        course1.setName("SOen 341");
        course1.setCredit(3);
        course1.setPreReq("comp346");
        course1.setCoReq("ENGR 301");

        courseRepo.save(course1);

        CourseDb course2 = new CourseDb();
        course2.setName("ENGR 233");
        course2.setCredit(3);
        course2.setPreReq("MATH 205");
        course2.setCoReq("ENGR 213");

        courseRepo.save(course2);

       List<CourseDb> courseData = courseRepo.findAll();

       for(CourseDb courseDb : courseData) {
           LOG.info("Course found :"+courseDb.toString());

       }

       CourseDb resultCourse = courseRepo.findByName("ENGR 233");
       LOG.info("course found by name : "+resultCourse.toString());

       List<CourseDb> result =  courseRepo.findByCreditAndPreReq(4 , "MATH 205");

        for(CourseDb courseDb : result) {
            LOG.info("Matching results are "+courseDb.toString());
        }


        UserDb user1 = new UserDb();
        user1.setName("Moataz");
        user1.setYear(3);
        user1.setEmail("moataz_fawzy@live.com");


        userRepo.save(user1);

        UserDb user2 = new UserDb();
        user2.setName("SuperMan");
        user2.setYear(3);
        user2.setEmail("SuperMan@live.com");


        userRepo.save(user2);

       List<UserDb> userData = userRepo.findAll();

       for(UserDb userDb : userData) {
           LOG.info("Course found :"+userDb.toString());

       }

       UserDb resultUser = userRepo.findByName("Moataz");
       LOG.info("User found by name : "+resultUser.toString());

       List<UserDb> results =  userRepo.findByEmailAndYear("SuperMan@live.com" , 3);

        for(UserDb userDb : results) {
            LOG.info("Matching results are : "+userDb.toString());
        }
    }
}

