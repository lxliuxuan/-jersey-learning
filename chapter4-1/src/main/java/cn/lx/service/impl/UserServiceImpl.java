package cn.lx.service.impl;

import cn.lx.entity.User;
import cn.lx.service.UserService;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lxliuxuan on 2016/11/18.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private JdbcTemplate jdbcTemplate;
    /**
     * 插入用户
     * @param user
     */
    public void insert(User user) {

        try {
            String sql = "insert into user(id,name,age) values(?,?,?)";
            Object[] params = new Object[]{user.getId(),user.getName(),user.getAge()};
            jdbcTemplate.update(sql,params);

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
            String sql = "update user set name = ?,age = ? where id = ?";
            Object[] params = new Object[]{
                    user.getName(),user.getAge(),user.getId()
            };
            jdbcTemplate.update(sql,params);
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
            String sql = "delete from user where id =?";
            Object[] params = new Object[]{id};
            jdbcTemplate.update(sql,params);
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
            String sql = "select * from user where id =?" ;
            final User user = new User();
            final Object[] params = new Object[]{id};
            jdbcTemplate.query(sql, params, new RowCallbackHandler() {
                public void processRow(ResultSet resultSet) throws SQLException {
                    user.setId(resultSet.getString("id"));
                    user.setName(resultSet.getString("name"));
                    user.setAge(resultSet.getInt("age"));
                }
            });
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
            String sql = "select * from user " ;
            List<User> lists;
            lists = jdbcTemplate.query(sql, new RowMapper<User>() {

                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User user = new User();
                    user.setId(resultSet.getString("id"));
                    user.setName(resultSet.getString("name"));
                    user.setAge(resultSet.getInt("age"));
                    return user;
                }
            });
            return lists;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
