package com.wangshidai.eshopFront.dao;

import com.wangshidai.eshopFront.entity.PwdQuestion;
import com.wangshidai.eshopFront.pojo.UserInfo;

import java.util.List;

public interface UserDao {

    /**
     * 根据用户名和密码查询用户
     *
     * @param userInfo
     * @return
     */
    UserInfo findUser(UserInfo userInfo);

    /**
     * 查询密保问题
     *
     * @return
     */
    List<PwdQuestion> findPwdQuestion();

    /**
     * 注册用户
     *
     * @param user_name
     * @param user_email
     * @param user_pwd
     * @param user_head
     * @param user_sex
     * @param province_id
     * @param city_id
     * @param area_id
     * @param user_address
     * @param question_id
     * @param question_answer
     * @param user_phone
     * @return
     */
    int Register(String user_name, String user_email, String user_pwd, String user_head, String user_sex, String province_id, String city_id, String area_id, String user_address, String question_id, String question_answer, String user_phone);

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
