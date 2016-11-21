package cn.lx.service;

import cn.lx.mongo.entity.User;

import java.util.List;

/**
 * Created by lxliuxuan on 2016/11/18.
 */
public interface UserService {

    public void insert(User user);
    public void update(User user);
    public void delete(String id);
    public User selectById(String id);
    public List<User> selectAll();
}
