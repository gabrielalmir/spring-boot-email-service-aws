package br.com.gabrielalmir.emailservice.adapters;

public interface EmailSenderGateway {
    void sendMail(String to, String subject, String body);
}
