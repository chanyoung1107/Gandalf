package with_god.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import with_god.view.YJ_FindPage;
import with_god.view.YJ_SignupPage;

public class YJ_Email {
      public static String emailAddress;
      public static String[] returnNum = new String[4];     
   public void getEmailAddress(String email) {
      String[] args1 = {" "};
      emailAddress = email;
   }
   
   public static void main(String[] args){
      YJ_FindPage sl = new YJ_FindPage();
      YJ_SignupPage sg = new YJ_SignupPage();
  
      String host = "smtp.naver.com";
      final String user = "tkznfk1402";
      final String password = "tkznfk1402!";
      int port=465;

      String to = emailAddress;

      // Get the session object
      Properties props = new Properties();
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.port", port);
      props.put("mail.smtp.ssl.enable", "true");
      props.put("mail.smtp.ssl.trust", host);

      Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password);
         }
      });
      
      
      // Compose the message
      try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(user));
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
         
         // Subject
         message.setSubject("[�̸��� ������ȣ �Դϴ�.]");
         
         message.setText("�ӽú�й�ȣ : ");
         
         int[] arr1 = new int[4];
         arr1[0] = (int)(Math.random() * 10);
         arr1[1] = (int)(Math.random() * 10);
         arr1[2] = (int)(Math.random() * 10);
         arr1[3] = (int)(Math.random() * 10);
         String[] arr2 = new String[4];
         for(int i = 0; i < arr1.length; i++) {
            arr2[i] = String.valueOf(arr1[i]);
            returnNum[i] = arr2[i];
            System.out.print(returnNum[i]);
         }
         
         // Text
         message.setText("�ӽ� ��й�ȣ �Դϴ�. ���� 4�ڸ��� �Է��ϼ���. \n" + arr2[0] + arr2[1] + arr2[2] + arr2[3]);
         
         // send the message
         Transport.send(message);
         System.out.println("�޼����� ���������� ���۵Ǿ����ϴ�.");

      } catch (MessagingException e) {
         e.printStackTrace();
      }
    	  
      
      
   }

public static String[] getReturnNum() {
	return returnNum;
}

public static void setReturnNum(String[] returnNum) {
	YJ_Email.returnNum = returnNum;
}
}