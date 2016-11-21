package cn.lx.service.impl;

import cn.lx.mongo.entity.User;
import cn.lx.service.UserService;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by lxliuxuan on 2016/11/18.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private MongoTemplate mongoTemplate;
    /**
     * 插入用户
     * @param user
     */
    public void insert(User user) {

        try {
            mongoTemplate.insert(user);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 更新用户
     * @param user
     */
    public void update(User user) {
        try {
            Query query = new Query();
            query.addCriteria(new Criteria("_id").is(user.getId()));
            Update update = new Update();
            update.set("age",user.getAge());
            update.set("name",user.getName());
            mongoTemplate.updateFirst(query,update,User.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据id删除用户
     * @param id
     */
    public void delete(String id) {
        try {
            Query query = new Query();
            query.addCriteria(new Criteria("_id").is(id));
            mongoTemplate.remove(query,User.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 通过id 查询用户
     * @param id
     * @return
     */
    public User selectById(String id) {
        try {
            Query query = new Query();
            query.addCriteria(new Criteria("_id").is(id));
           User user = (User)mongoTemplate.findOne(query,User.class);
            return  user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<User> selectAll() {
        try {
         return  mongoTemplate.findAll(User.class);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
