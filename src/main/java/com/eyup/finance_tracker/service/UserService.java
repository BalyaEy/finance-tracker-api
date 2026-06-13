package com.eyup.finance_tracker.service;

import com.eyup.finance_tracker.dto.UserRegisterRequestDto;
import com.eyup.finance_tracker.dto.UserResponseDto;
import com.eyup.finance_tracker.entity.User;
import com.eyup.finance_tracker.exception.BusinessException;
import com.eyup.finance_tracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
        private final UserRepository userRepository;

        public UserResponseDto registerUser(UserRegisterRequestDto request){
            if (userRepository.existsByEmail((request.getEmail()))){
                throw new BusinessException("This email is already in use!", HttpStatus.BAD_REQUEST);

            }

            User user = new User();
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());

            User savedUser = userRepository.save(user);

            UserResponseDto response = new UserResponseDto();
            response.setId(savedUser.getId());
            response.setEmail(savedUser.getEmail());
            response.setFirstName(savedUser.getFirstName());
            response.setLastName(savedUser.getLastName());
            response.setCreatedAt(savedUser.getCreatedAt());

            return response;
        }
}
