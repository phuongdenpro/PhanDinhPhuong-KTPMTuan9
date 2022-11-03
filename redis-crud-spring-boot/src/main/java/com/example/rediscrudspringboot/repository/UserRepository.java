package com.example.rediscrudspringboot.repository;


import com.example.rediscrudspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "USER";


    public boolean saveUser(User user) {
        try {
            redisTemplate.opsForHash().put(KEY, user.getId().toString(), user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<User> fetchAllUser() {
        List<User> users;
        users = redisTemplate.opsForHash().values(KEY);
        return  users;
    }


    public User fetchUserById(Long id) {
        User user;
        user = (User) redisTemplate.opsForHash().get(KEY,id.toString());
        return user;
    }


    public boolean deleteUser(Long id) {
        try {
            redisTemplate.opsForHash().delete(KEY,id.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean updateUser(Long id, User user) {
        try {
            redisTemplate.opsForHash().put(KEY, id, user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
