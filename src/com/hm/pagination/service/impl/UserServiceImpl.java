package com.hm.pagination.service.impl;

import com.hm.pagination.dao.UserDao;
import com.hm.pagination.dao.impl.UserDaoImpl;
import com.hm.pagination.entity.User;
import com.hm.pagination.service.UserService;
import com.hm.pagination.util.PageUtil;

import java.util.List;

/**
 * @program: Paginitaion
 * @Date: 2019/6/28 16:41
 * @Author: Mr.Han
 * @Description:
 */
public class UserServiceImpl implements UserService {


 private UserDao userDao = new UserDaoImpl();

 @Override
 public PageUtil getPageUtil(String num) throws Exception {

  int currentPageNum = 1;

  if (num != null && !num.trim().equals("")) {
   currentPageNum = Integer.parseInt(num);
  }

  int total = userDao.getTotalRecords();

  PageUtil pageUtil = new PageUtil(currentPageNum, total);

  List<User> users = userDao.getAllUsers(pageUtil.getStartIndex(), pageUtil.getPageSize());
  pageUtil.setRecords(users);
  return pageUtil;
 }

}
