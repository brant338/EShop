package com.wangshidai.eshopFront.dao;

import com.wangshidai.eshopFront.entity.PwdQuestion;
import com.wangshidai.eshopFront.pojo.UserInfo;
import org.springframework.stereotype.Repository;


import java.util.List;


public interface RegDao {

    /**
     * 查询密保问题
     *
     * @return
     */
    List<PwdQuestion> findPwdQuestion();

    /**
     * 注册用户
     *
     * userInfo
     * @return
     */
    int Register(UserInfo userInfo);

    /**
     * 更改指定用户的激活状态
     *
     * @param uuid
     */
    void updateActivated(int uuid);

    /**
     * 根据指定id查询用户
     *
     * @param userInfo
     * @return
     */
    UserInfo selectUserById(UserInfo userInfo);

}
