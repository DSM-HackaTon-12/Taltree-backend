package org.example.taltree.domain.user.usecase;

import org.example.taltree.domain.user.dto.reponse.SendEmailResponseDto;
import org.example.taltree.domain.user.dto.request.EmailDto;

public interface SendEmailUseCase {
    SendEmailResponseDto sendEmail (EmailDto emailDto);
}
