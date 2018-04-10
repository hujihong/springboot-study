package com.boot.study.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/***
 * 由于Spring Boot的starter模块提供了自动化配置，
 * 所以在引入了spring-boot-starter-mail依赖之后，
 * 会根据配置文件中的内容去创建JavaMailSender实例，
 * 因此我们可以直接在需要使用的地方直接@Autowired来引入邮件发送对象。
 进阶使用：
 我们通过使用SimpleMailMessage实现了简单的邮件发送，但是实际使用过程中，
 我们还可能会带上附件、或是使用邮件模块等。
 这个时候我们就需要使用MimeMessage来设置复杂一些的邮件内容，下面我们就来依次实现一下。
 */

@Component
public class SendMailer {

    @Autowired
    private JavaMailSender mailSender;

    public void send() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jhhu_deng@163.com");//发送者.
        message.setTo("jhhu_deng@163.com");//接收者.
        message.setSubject("测试邮件（邮件主题）");//邮件主题.
        message.setText("这是邮件内容");//邮件内容.
        mailSender.send(message);//发送邮件
    }


    public void sendAttachmentsEmail() throws MessagingException {

        //这个是javax.mail.internet.MimeMessage下的，不要搞错了。
        MimeMessage mimeMessage =  mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //基本设置.
        helper.setFrom("jhhu_deng@163.com");//发送者.
        helper.setTo("jhhu_deng@163.com");//接收者.
        helper.setSubject("测试附件（邮件主题）");//邮件主题.
        helper.setText("这是邮件内容（有附件哦.）");//邮件内容.

        //org.springframework.core.io.FileSystemResource下的:
        //附件1,获取文件对象.
        FileSystemResource file1 = new FileSystemResource(new File("/Users/hujh/Downloads/工作方法论.pptx"));
        //添加附件，这里第一个参数是在邮件中显示的名称，也可以直接是head.jpg，但是一定要有文件后缀，不然就无法显示图片了。
        helper.addAttachment("方法论1", file1);
        //附件2
        FileSystemResource file2 = new FileSystemResource(new File("/Users/hujh/Downloads/工作方法论.pptx"));
        helper.addAttachment("方法论2", file2);
        mailSender.send(mimeMessage);

    }


    public void sendInlineMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //基本设置.
        helper.setFrom("jhhu_deng@163.com");//发送者.
        helper.setTo("jhhu_deng@163.com");//接收者.
        helper.setSubject("测试静态资源（邮件主题）");//邮件主题.
        // 邮件内容，第二个参数指定发送的是HTML格式
        //说明：嵌入图片<img src='cid:head'/>，其中cid:是固定的写法，而aaa是一个contentId。
        helper.setText("<body>这是图片：<img src='cid:head' /></body>", true);
        FileSystemResource file = new FileSystemResource(new File("/Users/hujh/Downloads/工作方法论.pptx"));
        helper.addInline("head", file);
        mailSender.send(mimeMessage);

    }

}
