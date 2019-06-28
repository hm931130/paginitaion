package com.hm.pagination.dao.impl;

import com.hm.pagination.dao.BaseDao;
import com.hm.pagination.dao.UserDao;
import com.hm.pagination.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @program: Paginitaion
 * @Date: 2019/6/28 16:28
 * @Author: Mr.Han
 * @Description:
 */
public class UserDaoImpl extends BaseDao implements UserDao {

 QueryRunner queryRunner = new QueryRunner();

 @Override
 public List<User> getAllUsers(int startIndex, int pageSize) throws Exception {

  String sql = "select * from t_user limit ?,?";
  List<User> users = null;
  users = queryRunner.query(getConnection(), sql, new BeanListHandler<User>(User.class), new Object[]{startIndex, pageSize});
  return users;
 }

 @Override
 public int getTotalRecords() throws Exception {
  int result = 0;
  PreparedStatement preparedStatement = null;
  String sql = "select count(*) count from t_user";

  ResultSet resultSet = null;
  preparedStatement = getConnection().prepareStatement(sql);
  resultSet = preparedStatement.executeQuery();
  if (resultSet.next()) {
   result = resultSet.getInt("count");
  }
  return result;
 }
}
