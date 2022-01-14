package com.cesi.ressourcesrelationnelles.infrastructure;

import com.cesi.ressourcesrelationnelles.domain.User;

public class UserMapper {
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }
}
