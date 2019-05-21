package com.isoft.dao.impl;

import com.isoft.dao.IUserDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("userDAO")
public class UserDAOImpl implements IUserDAO {
    @Autowired
    SqlSessionFactory sessionFactoryBean;
    @Override
    public String login(String uname, String upwd) {
        SqlSession sqlSession = sessionFactoryBean.openSession(true);
        String statment = "com.isoft.mapping.userMapper.login";
        Map map = new HashMap();
        map.put("uname",uname);
        map.put("upwd",upwd);
        List<Map<String,Object>> list = sqlSession.selectList(statment,map);
        if(list.size()>0)
            return "success";
        else
            return "fault";
    }

    @Override
    public boolean register(String uname, String upwd, String email) {
        SqlSession sqlSession = sessionFactoryBean.openSession(true);
        String statment = "com.isoft.mapping.userMapper.register";
        Map map = new HashMap();
        map.put("uname",uname);
        map.put("upwd",upwd);
        map.put("email",email);
        int i = sqlSession.insert(statment,map);
        if(i>0)
            return true;
        else
            return false;
    }
}