package org.myBlog.project;

import org.junit.jupiter.api.Test;
import org.myBlog.project.entity.Account;
import org.myBlog.project.mapper.AccountMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@SpringBootTest
class MyBlogApplicationTests {
    @Resource
    private AccountMapper accountMapper;

    @Test
    void contextLoads() {
        String md5Password = DigestUtils.md5DigestAsHex("123123".getBytes());
        Account account = accountMapper.queryAccount("1144502582@qq.com");
        System.out.println(md5Password);
        System.out.println(md5Password.equals(account.getUserPwd()));
    }
}
