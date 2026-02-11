package com.user.mapper;

import com.user.dto.UserRequest;
import com.user.dto.UserResponse;
import com.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequest request);

    UserResponse toResponse(User user);

    void updateEntityFromRequest(UserRequest request,
                                 @MappingTarget User user);

}
