package cn.liuy.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import cn.liuy.pojo.User;

public interface UserFindByNameRepository extends Repository<User, Integer> {

	public List<User> findByName(String name);
	
	public List<User> findByNameAndAge(String name,Integer age);
	
	public List<User> findByNameLike(String name);
}
