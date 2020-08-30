package com.crolling.myapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sun.mail.util.BASE64DecoderStream;

import junit.framework.TestCase;

public class pop3{
	
	public static List<popDto> con(String id, String psw) throws MessagingException, IOException {
			
		List<popDto> list = new ArrayList<popDto>();
		String host = "pop.naver.com";
		final String user = id;
		final String pw = psw;
		MimeUtility mime = null;
		System.out.println("1");
		
	    Properties props = System.getProperties();
	    props.put("mail.pop3.host", host);
	    props.put("mail.pop3.port", 995);
        props.put("mail.pop3.auth", "true");
        props.put("mail.pop3.ssl.enable", "true");
        props.put("mail.pop3.ssl.trust", host);

        // 연결 관리
	    Session session = Session.getDefaultInstance(props,null);
	    
	    // 메일의 읽기, 쓰기, 검색등을 관리
		Store store = session.getStore("pop3");
	
		store.connect(host,user,pw);
	
		Folder folder = store.getFolder("INBOX"); 
	
		folder.open(Folder.READ_ONLY);
	
		Message[] message = folder.getMessages();
	
		for(Message m : message) {
			popDto pd = new popDto(mime.decodeText(m.getFrom()[0].toString()),
					mime.decodeText(m.getRecipients(Message.RecipientType.TO)[0].toString()),m.getSubject(),
					new SimpleDateFormat().format(m.getSentDate()),
					Math.round((m.getSize()*10)/10.0/1000),
					printMessage(m));
			
			list.add(pd);
		}
		
		folder.close(false);
		store.close();

		return list;
		
		
	}
	
	public static String printMessage(Message message) throws IOException, MessagingException {
		
		String result="";
		if(message.isMimeType("multipart/*")){
			
			MimeMultipart mul = (MimeMultipart) message.getContent();
			
				BodyPart body = mul.getBodyPart(0);
				if(body.isMimeType("text/plain")) {
					result =result+"\n"+body.getContent();
					System.out.println("내용 " + result);
			
				}
				else if (body.isMimeType("text/html")){
	                String html = (String) body.getContent();
	                result = result + "\n" + Jsoup.parse(html).text();
	            	System.out.println("내용 " + result);
	            
	            }
			
		}
		
		return result;
	
		
	}
	
	
	
}
