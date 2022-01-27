package com.wangshidai.eshopFront.dao.impl;

import com.wangshidai.eshopFront.dao.UserDao;
import com.wangshidai.eshopFront.entity.PwdQuestion;
import com.wangshidai.eshopFront.pojo.UserInfo;
import com.wangshidai.eshopFront.utils.MyJdbcUtilsV5;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public UserInfo findUser(UserInfo userInfo) {
        return MyJdbcUtilsV5.acquareFileldToBeanOneLine(UserInfo.class,
                "select * from tb_user where (user_name = ? or user_email = ?) and user_pwd = ?",
                userInfo.getUser_name(),userInfo.getUser_email(),userInfo.getUser_pwd());
    }

    @Override
    public List<PwdQuestion> findPwdQuestion() {
        String sql = "select * from tb_question";
        return MyJdbcUtilsV5.acquareFileldToBean(PwdQuestion.class,sql);
    }
}
