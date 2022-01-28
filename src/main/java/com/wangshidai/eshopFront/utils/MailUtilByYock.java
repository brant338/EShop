package com.wangshidai.eshopFront.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;

public class MailUtilByYock {
	
	// 这里是SMTP发送服务器的协议
	public static final String HOST_NAME = "smtp.126.com";
	// 登陆邮件服务器的用户名、密码、昵称
	public static final String USERNAME = "yunhejava@126.com";
	public static final String PASSWORD = "GRYQPVTNCHFUVHBF";
	public static final String NICKNAME = "EShop商城";

	
	/**
	 * 发送邮件（成功true、失败false）
	 * @param receiveEmail	收件人邮箱
	 * @param receiveNick	收件人昵称（随便取）
	 * @param subject		邮件主题
	 * @param contents		邮件内容
	 * @return
	 */
	public static final boolean sendMail(String receiveEmail,String receiveNick,String subject,String contents){
		HtmlEmail email = new HtmlEmail ();
		try {
			//smtp host 
			email.setHostName(HOST_NAME);
			//登陆邮件服务器的用户名和密码
			email.setAuthentication(USERNAME,PASSWORD);
			//接收人
			email.addTo(receiveEmail, receiveNick);
			//发送人
			email.setFrom(USERNAME, NICKNAME);
			//标题
			email.setSubject(subject);
			//邮件内容
			email.setCharset("utf-8");
			email.setHtmlMsg(contents);
			//发送
			email.send();
			return true;
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
//		MultiPartEmail email = new MultiPartEmail();
//		try {
//			//smtp host 
//			email.setHostName(HOST_NAME);
//			//登陆邮件服务器的用户名和密码
//			email.setAuthentication(USERNAME,PASSWORD);
//			//接收人
//			email.addTo(receiveEmail, receiveNick);
//			//发送人
//			email.setFrom(USERNAME, NICKNAME);
//			//标题
//			email.setSubject(subject);
//			//邮件内容
//			email.setMsg(contents);
//			//发送
//			email.send();
//			return true;
//			
//		} catch (EmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
		
	}
	
	
	public static void main(String[] args) {
		
		String msg="<h1 style='color:red;'>邮件内容</h1>";
		
		boolean result=sendMail("dengyukun@126.com", "老司机带带我", "请完成EShop用户注册（测试）", msg);
		System.out.println(result);
	}
	
	
}
