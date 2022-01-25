package com.wangshidai.eshop_front.dao.impl;

import com.wangshidai.eshop_front.dao.UserDao;
import com.wangshidai.eshop_front.pojo.UserInfo;
import com.wangshidai.eshop_front.utils.MyJdbcUtilsV5;

public class UserDaoImpl implements UserDao {

    @Override
    public UserInfo findUser(UserInfo userInfo) {
        return MyJdbcUtilsV5.acquareFileldToBeanOneLine(UserInfo.class,
                "select * from tb_user where (user_name = ? or user_email = ?) and user_pwd = ?",
                userInfo.getUser_name(),userInfo.getUser_email(),userInfo.getUser_pwd());
    }
}
