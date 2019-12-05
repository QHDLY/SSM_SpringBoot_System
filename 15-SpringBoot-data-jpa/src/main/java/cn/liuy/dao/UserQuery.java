package cn.liuy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import cn.liuy.pojo.User;

public interface UserQuery extends Repository<User, Integer> {

	@Query("from User where name = ?")
	public List<User> queryByNameHQL(String name);
	
	@Query(value="select * from user where name = ?",nativeQuery=true)
	public List<User> queryByNameSQL(String name);
	
	@Query("update User set name = ? where id = ?")
	@Modifying
	public void updateByIdName(String name,Integer id);
}
