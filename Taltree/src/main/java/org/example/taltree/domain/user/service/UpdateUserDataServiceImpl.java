package org.example.taltree.domain.user.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.user.dto.request.UpdateUserDataRequestDto;
import org.example.taltree.domain.user.exception.UserNotExistException;
import org.example.taltree.domain.user.model.User;
import org.example.taltree.domain.user.repository.UserRepository;
import org.example.taltree.domain.user.usecase.UpdateUserDataUseCase;
import org.example.taltree.global.error.InternationalServerError;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateUserDataServiceImpl implements UpdateUserDataUseCase {

    private final UserRepository userRepository;
    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Override
    public void updateUserData(Authentication authentication, UpdateUserDataRequestDto updateUserDataRequestDto) {
        User user = userRepository.findUserByUserId(Long.parseLong(authentication.getName())).orElseThrow(
                () -> UserNotExistException.Exception
        );

        // 유저 닉네임 수정
        updateUserDataRequestDto.username().ifPresent(user::setUsername);

        // 유저 프로필 수정
        if (updateUserDataRequestDto.userProfile().isPresent()) {
            try {
                // 사진에서 필요 데이터 추출
                MultipartFile file = updateUserDataRequestDto.userProfile().orElseThrow();
                String fileName = file.getOriginalFilename();
                String fileUrl = "https://" + bucket + ".s3.ap-northeast-2.amazonaws.com/" + fileName; // 사진 URL

                // metadata 설정
                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentType(file.getContentType());
                metadata.setContentLength(file.getSize());

                // S3에 저장
                amazonS3Client.putObject(bucket, fileName, file.getInputStream(), metadata);

                // 변경사항 반영
                user.setProfile(fileUrl);
            } catch (RuntimeException | IOException e) {
                throw InternationalServerError.Exception;
            }
        }

        userRepository.save(user);
    }
}
