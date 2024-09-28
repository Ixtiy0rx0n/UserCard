package org.example.service;

import org.example.dto.UserDto;
import org.example.exp.AppBadException;
import org.example.model.UserEntity;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDto create(UserDto userDto) {
        if (get(userDto.getPhone())){
            throw new AppBadException("Phone number already in use");
        }
        else {
            UserEntity userEntity = new UserEntity();
            userEntity.setPhone(userDto.getPhone());
            userEntity.setFirstName(userDto.getFirstName());
            userEntity.setLastName(userDto.getLastName());
            userEntity.setCreatedAt(LocalDateTime.now());
            userRepository.save(userEntity);
            userDto.setCreatedAt(LocalDateTime.now());
            userDto.setId(userEntity.getId());
            return userDto;
        }
    }
    public UserDto update(UserDto userDto) {
        userRepository.update(userDto.getId(), userDto.getFirstName(),userDto.getLastName(),userDto.getPhone());
        return userDto;
    }
    public Boolean deleteById(Integer id) {
        userRepository.delete(id, LocalDateTime.now());
        return true;
    }



    public Boolean get(String phone) {
        Optional<UserEntity> optional = userRepository.findByPhoneNumber(phone);
        if (optional.isPresent()) {
            return true;
        }
        else {
            throw new AppBadException("User not found");
        }
    }
}
