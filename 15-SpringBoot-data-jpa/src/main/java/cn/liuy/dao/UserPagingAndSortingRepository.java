package cn.liuy.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.liuy.pojo.User;

public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Integer> {

}
