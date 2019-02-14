package com.example.course.coursebuild.reposatory;

        import com.example.course.coursebuild.Course.CourseDb;
        import com.example.course.coursebuild.Course.UserDb;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface UserDbRepo extends JpaRepository <UserDb, String> {



    UserDb findByName(String name);
    List<UserDb> findByEmailAndYear(String email , int year);

}

