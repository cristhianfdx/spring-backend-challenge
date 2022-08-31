package com.backend.challenge.domain.services.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.challenge.app.api.UserApi;
import com.backend.challenge.domain.models.User;
import com.backend.challenge.domain.repository.UserRepository;
import com.backend.challenge.domain.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserApi getByDocumentNumber(String documentNumber) throws Exception {
        User user = userRepository.findByDocumentNumber(documentNumber);

        if (Objects.isNull(user)) {
            throw new Exception("User not found.");
        }
        return UserApi.newBuilder()
                .documentNumber(user.getDocumentNumber())
                .phoneNumber(user.getPhoneNumber())
                .fullName(user.getFullName())
                .id(user.getId())
                .build();
    }

}
