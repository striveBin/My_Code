package com.fc;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class ServiceImplTests {
    @Autowired
    private UserService userService;
    public void testGetBaseMapper(){
        BaseMapper<User> baseMapper = userService.getBaseMapper();
    }
}
