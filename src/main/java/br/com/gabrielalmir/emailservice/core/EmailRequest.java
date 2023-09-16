package br.com.gabrielalmir.emailservice.core;

public record EmailRequest(
    String to,
    String subject,
    String body
){
}
