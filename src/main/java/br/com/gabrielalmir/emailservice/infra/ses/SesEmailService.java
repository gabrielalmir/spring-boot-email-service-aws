package br.com.gabrielalmir.emailservice.infra.ses;

import br.com.gabrielalmir.emailservice.adapters.EmailSenderGateway;
import br.com.gabrielalmir.emailservice.core.exceptions.EmailServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SesEmailService implements EmailSenderGateway {
    private final AmazonSimpleEmailService amazonSimpleEmailService;
    private final String emailSource;

    @Autowired
    public SesEmailService(AmazonSimpleEmailService amazonSimpleEmailService, @Value("${api.email.source}") String emailSource) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
        this.emailSource = emailSource;
    }

    @Override
    public void sendMail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource(emailSource)
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(
                    new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );

        try {
            this.amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonSimpleEmailServiceException exception) {
            throw new EmailServiceException("Failed while sending email", exception);
        }
    }
}
