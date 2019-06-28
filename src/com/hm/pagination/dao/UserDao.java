package com.hm.pagination.dao;

import com.hm.pagination.entity.User;

import java.util.List;

/**
 * @program: Paginitaion
 * @Date: 2019/6/28 16:26
 * @Author: Mr.Han
 * @Description:
 */
public interface UserDao {

 List<User> getAllUsers(int startIndex, int pageSize) throws Exception;

 int getTotalRecords() throws Exception;

}
