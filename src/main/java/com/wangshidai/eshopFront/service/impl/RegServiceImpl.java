package com.wangshidai.eshopFront.service.impl;

import com.wangshidai.eshopFront.dao.RegDao;
import com.wangshidai.eshopFront.dao.UserDao;
import com.wangshidai.eshopFront.entity.PwdQuestion;
import com.wangshidai.eshopFront.pojo.UserInfo;
import com.wangshidai.eshopFront.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegServiceImpl implements RegService {

    @Autowired
    private RegDao regDao;

    @Override
    public List<PwdQuestion> findPwdQuestion() {
        return regDao.findPwdQuestion();
    }

    @Override
    public int register(UserInfo userInfo) {
        int count = regDao.register(userInfo);
        return userInfo.getUser_id() ;
    }

    @Override
    public void updateActivated(int uuid) {
        regDao.updateActivated(uuid);
    }

    @Override
    public UserInfo selectUserById(UserInfo userInfo) {
        return regDao.selectUserById(userInfo);
    }

}
