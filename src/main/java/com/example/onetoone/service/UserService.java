package com.example.onetoone.service;

import com.example.onetoone.entity.AddressEntity;
import com.example.onetoone.entity.UserEntity;
import com.example.onetoone.mapper.UserMapper;
import com.example.onetoone.model.UserRequest;
import com.example.onetoone.model.UserResponse;
import com.example.onetoone.repository.AddressRepository;
import com.example.onetoone.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.userMapper = userMapper;
    }

    public UserResponse create(UserRequest userRequest) {
        UserEntity userEntity = userMapper.userRequestToUserEntity(userRequest);
        UserEntity save = userRepository.save(userEntity);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        return userResponse;
    }


    public UserRequest getUser(Long userId) {
        UserEntity addressEntity = userRepository.findById(userId).get();
        if (addressEntity == null) {
            new ResponseStatusException(HttpStatus.NOT_FOUND, "user is not found by id");
        }
        return userMapper.userEntityToUserRequest(addressEntity);
    }

    public List<UserRequest> getAllUsers() {
        List<UserEntity> all = userRepository.findAll();
        return userMapper.userEntityToUserRequest(all);
    }

    public UserRequest updateUser(Long userId, UserRequest userRequest) {
        UserEntity userEntity = userRepository.findById(userId).get();
        AddressEntity addressEntity = addressRepository.findById(userEntity.getAddress().getId()).get();
        userRequest.setId(userEntity.getId());
        userRequest.getAddress().setId(addressEntity.getId());
        UserEntity userEntity1 = userMapper.userRequestToUserEntity(userRequest);
        UserEntity save = userRepository.save(userEntity1);
        return userMapper.userEntityToUserRequest(save);
    }

    public void deleteUser(Long userId){
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isPresent()){
            userRepository.deleteById(userId);
        }
    }


}
