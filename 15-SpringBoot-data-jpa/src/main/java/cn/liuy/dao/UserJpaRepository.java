package cn.liuy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.liuy.pojo.Subordinate;

public interface UserJpaRepository extends JpaRepository<Subordinate, Integer> {

}
