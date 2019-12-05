package cn.liuy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.liuy.pojo.User;

public interface UserJpaSpecificationExecutor extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {

}
