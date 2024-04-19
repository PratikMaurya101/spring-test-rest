package com.orangotan.springtestrest.dao;

import com.orangotan.springtestrest.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends CrudRepository<Course,Long> {
}
