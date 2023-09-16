package br.com.gabrielalmir.emailservice.controllers;

import br.com.gabrielalmir.emailservice.application.EmailSenderService;
import br.com.gabrielalmir.emailservice.core.EmailRequest;
import br.com.gabrielalmir.emailservice.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {
    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            this.emailSenderService.sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.body());
        } catch (EmailServiceException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getLocalizedMessage());
        }

        return ResponseEntity.ok("Email send successfully");
    }
}
