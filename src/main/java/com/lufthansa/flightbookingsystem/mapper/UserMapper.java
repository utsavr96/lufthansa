package com.lufthansa.flightbookingsystem.mapper;

import com.lufthansa.flightbookingsystem.dto.UserRequestDto;
import com.lufthansa.flightbookingsystem.dto.UserResponseDto;
import com.lufthansa.flightbookingsystem.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User map(UserRequestDto userRequestDto);

    UserResponseDto mapToDto(User user);

    List<UserResponseDto> mapListToDto(List<User> userList);
}
