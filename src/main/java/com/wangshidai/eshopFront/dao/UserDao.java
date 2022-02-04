package com.wangshidai.eshopFront.dao;


import com.wangshidai.eshopFront.pojo.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserDao {

    /**
     * 根据用户名和密码查询用户
     *
     * @param userInfo
     * @return
     */
    UserInfo findUser(UserInfo userInfo);

    /**
     * 修改用户的在线状态
     *
     * @param map
     */
    void updateOnlineStatus(Map map);

    /**
     * 根据指定id查询用户
     *
     * @param user_id 用户ID
     * @return
     */
    UserInfo findUserById(int user_id);
}
