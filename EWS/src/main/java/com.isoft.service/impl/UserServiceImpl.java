package com.isoft.service.impl;

import com.isoft.dao.IUserDAO;
import com.isoft.dao.impl.UserDAOImpl;
import com.isoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDAO userDAO;
    @Override
    public String login(String uname, String upwd) {
        String str=userDAO.login(uname,upwd);
        return str;
    }

    @Override
    public boolean register(String uname, String upwd, String email) {

        boolean temp=userDAO.register(uname,upwd,email);
        return temp;
    }
    @Override
    public List<Map<String,Object>> findAllUser(int page, int pageSize){
        return userDAO.findAllUser(page,pageSize);
    }

    @Override
    public Map<String, Object> findUserCount() {
        return userDAO.findUserCount();
    }

}

