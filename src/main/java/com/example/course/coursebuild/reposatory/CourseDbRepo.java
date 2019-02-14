package com.example.course.coursebuild.reposatory;

import com.example.course.coursebuild.Course.CourseDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDbRepo extends JpaRepository <CourseDb, String> {



    CourseDb findByName(String name);
    List<CourseDb> findByCreditAndPreReq(int x , String preReq);

}

