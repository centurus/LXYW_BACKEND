package com.lxyw.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


@Service("sendMailService")
public class SendMailServiceImpl implements SendMailService {
    @Autowired
    private JavaMailSender mailSender;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendMail(){
        try
        {
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setFrom("1198966503@qq.com");
            message.setTo("kencheng@foxmail.com");
            message.setSubject("乐享御味OMS系统");
            message.setText("您的账户已开启，初始密码为：11223344");
            mailSender.send(mimeMessage);
            System.out.print("邮件发送成功");
        }
        catch(Exception ex)
        {
            logger.error("邮件发送失败"+ex);
            System.out.print("邮件发送失败"+ex);
        }
    }
}
