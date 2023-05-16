package com.example.digitaldesignstudio.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    public static void sendEmail() {
        String from = "your-email@example.com";
        String to = "your-email@example.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Замените на адрес почтового сервера
        properties.put("mail.smtp.port", "465"); // Замените на порт почтового сервера
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "password");
            }
        });

        try {
            // Создание объекта сообщения
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from)); // Замените на ваш адрес электронной почты
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); // Замените на адрес получателя
            message.setSubject("Тестовое сообщение"); // Замените на тему вашего сообщения
            message.setText("Привет, это тестовое сообщение!"); // Замените на текст вашего сообщения

            // Отправка сообщения
            Transport.send(message);

            System.out.println("Сообщение отправлено успешно.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
