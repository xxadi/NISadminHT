package me.zhengjie;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import lombok.RequiredArgsConstructor;
import me.zhengjie.modules.security.service.UserDetailsServiceImpl;
import me.zhengjie.utils.SpringContextHolder;
import me.zhengjie.yuangan.test.Dog;
import me.zhengjie.yuangan.test.SpringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.File;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class test {

    @Resource(name = "dog")
    Dog dog;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private JavaMailSender mailSender;
    @Test
    public void contextLoads() throws MessagingException {
//        String sql = "select * from NOA_GROUP_MANAG";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        System.out.println(maps);
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setSubject("通知-高老师好");
//        message.setText("今晚7:30开会");
//
//        message.setTo("yaoshengyu@conlin360.com");
//        message.setFrom("476877476@qq.com");
//        mailSender.send(message);
        //复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
        messageHelper.setFrom("476877476@qq.com");
        messageHelper.setTo("812343497@qq.com");
        messageHelper.setSubject("Happy New Year");
        messageHelper.setText("新年快乐！");
        messageHelper.addInline("doge.png", new File("D:\\eladmin\\file\\图片\\1.png"));
        messageHelper.addAttachment("work.png", new File("D:\\eladmin\\file\\图片\\1.png"));
        mailSender.send(mimeMessage);
    }
}
