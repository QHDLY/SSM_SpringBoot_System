package cn.liuy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.liuy.pojo.User;

public interface UserDaoRepository extends JpaRepository<User, Integer> {

	
}
