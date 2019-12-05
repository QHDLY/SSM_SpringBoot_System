package cn.liuy.dao;

import org.springframework.data.repository.CrudRepository;

import cn.liuy.pojo.User;

public interface UserCrudRespository extends CrudRepository<User, Integer> {

}
