package org.example.taltree.domain.user.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.user.dto.reponse.SendEmailResponseDto;
import org.example.taltree.domain.user.dto.request.EmailDto;
import org.example.taltree.domain.user.usecase.SendEmailUseCase;
import org.example.taltree.global.error.InternationalServerError;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SendEmailServiceImpl implements SendEmailUseCase {

    int number; // 인증용 코드
    private final JavaMailSender javaMailSender;

    private void createNumber () {
        number = (int)(Math.random() * (90000)) + 100000;
    }

    @Override
    public SendEmailResponseDto sendEmail(EmailDto emailDto) {
        createNumber();
        MimeMessage message = createMessage(emailDto.email());
        javaMailSender.send(message);

        return new SendEmailResponseDto(number);
    }

    private MimeMessage createMessage(String email) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom("dhthdwn7920@gmail.com");
            message.setRecipients(MimeMessage.RecipientType.TO, email);
            message.setSubject("Taltree 이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "페이지로 돌아가 인증을 완료해주세요." + "</h3>";
            message.setText(body,"UTF-8", "html");
        } catch (RuntimeException | MessagingException e) {
            throw InternationalServerError.Exception;
        }

        return message;
    }
}
