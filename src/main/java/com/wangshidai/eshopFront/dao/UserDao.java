package com.wangshidai.eshopFront.dao;


import com.wangshidai.eshopFront.pojo.UserInfo;
import org.springframework.stereotype.Repository;



public interface UserDao {

    /**
     * 根据用户名和密码查询用户
     *
     * @param userInfo
     * @return
     */
    UserInfo findUser(UserInfo userInfo);


}
