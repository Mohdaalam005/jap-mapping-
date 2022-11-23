package com.example.onetoone.mapper;

import com.example.onetoone.entity.UserEntity;
import com.example.onetoone.model.UserRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    UserEntity userRequestToUserEntity(UserRequest userRequest);

    UserRequest userEntityToUserRequest(UserEntity userEntity);
    List<UserRequest> userEntityToUserRequest(List<UserEntity> userEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity updateUserEntityFromUserRequest(UserRequest userRequest, @MappingTarget UserEntity userEntity);
}
