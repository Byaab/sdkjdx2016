package com.isoft.dao.impl;

import com.isoft.dao.IUserDAO;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
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
    public String login(String uname, String upwd){

        SqlSession sqlSession = sessionFactoryBean.openSession(true);//true  开启事务
        String statment = "com.isoft.mapping.userMapper.login";
        Map map = new HashMap();
        map.put("uname", uname);
        map.put("upwd", upwd);
        List list = sqlSession.selectList(statment, map);
        if (list.size()>0)
            return "success";
        else
            return "fault";
    }

    @Override
    public boolean register(String uname, String upwd, String email) {
        SqlSession sqlSession = sessionFactoryBean.openSession(true);
        String statement = "com.isoft.mapping.userMapper.register";
        Map map = new HashMap();
        map.put("uname", uname);
        map.put("upwd", upwd);
        map.put("email", email);
        int i = sqlSession.insert(statement, map);
        if (i > 0)
            return true;
        else
            return false;
    }

    @Override
    public List<Map<String, Object>> findAllUser(int page, int pageSize) {
        SqlSession sqlSession = sessionFactoryBean.openSession(true);
        String statement ="com.isoft.mapping.userMapper.findAllUser";
        Map map=new HashMap();
        map.put("page",(page-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Map<String, Object>> list=  sqlSession.selectList(statement,map);
        return list;
    }

    @Override
    public Map<String, Object> findUserCount() {
        try{
            SqlSession sqlSession = sessionFactoryBean.openSession(true);
            String statement = "com.isoft.mapping.userMapper.findUserCount";
            Map map = sqlSession.selectOne(statement);
            return map;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
