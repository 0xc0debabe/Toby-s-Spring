package org.example;

import org.example.company.n;
import org.example.dao.ConnectionMaker;
import org.example.dao.DConnectionMaker;
import org.example.dao.DaoFactory;
import org.example.dao.UserDao;
import org.example.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class userTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);
        User user = new User();

        user.setId("kong");
        user.setName("홍민우");
        user.setPassword("secret");

        dao.add(user);
        System.out.println(user.getId() + "등록 성공");

        User user1 = dao.get(user.getId());
        System.out.println(user1.getName());
        System.out.println(user1.getPassword());

        System.out.println(user1.getId() + "등록 성공");
    }
}
