package cn.liuy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.liuy.pojo.Student;

public interface StudentJpaRepository extends JpaRepository<Student, Integer > {

}
