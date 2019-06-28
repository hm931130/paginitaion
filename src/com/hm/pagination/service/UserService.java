package com.hm.pagination.service;

import com.hm.pagination.util.PageUtil;

/**
 * @program: Paginitaion
 * @Date: 2019/6/28 16:40
 * @Author: Mr.Han
 * @Description:
 */
public interface UserService {


 PageUtil getPageUtil(String num) throws Exception;

}
