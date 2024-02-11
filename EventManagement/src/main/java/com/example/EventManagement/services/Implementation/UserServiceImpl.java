package com.example.EventManagement.services.Implementation;

import com.example.EventManagement.dto.UserDto;
import com.example.EventManagement.models.Events;
import com.example.EventManagement.models.Roles;
import com.example.EventManagement.models.Users;
import com.example.EventManagement.repository.RoleRepository;
import com.example.EventManagement.repository.UserRepository;
import com.example.EventManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<Users> users = userRepository.findAll();
        return users.stream().map(users1 -> mapToUserDto(users1)).collect(Collectors.toList());
    }

    @Override
    public UserDto findUserById(long userId) {
        Users users = userRepository.findById(userId).get();
        return mapToUserDto(users);
    }

//    @Override
//    public Users saveUser(UserDto userDto) {
//        Users users = mapToUser(userDto);
//        return userRepository.save(users);
//    }

    @Override
    public void saveUser(UserDto userDto){
        Users users = new Users();
        users.setName(userDto.getName());
        users.setEmail(userDto.getEmail());
        users.setPassword(userDto.getPassword());
        users.setPhone(userDto.getPhone());
        users.setSurname(users.getSurname());
        users.setAge(userDto.getAge());
        Roles roles = roleRepository.findByName("USER");
        users.setRoles(Arrays.asList(roles));
        userRepository.save(users);

    }

    @Override
    public boolean loginUser(String name, String password) {
        return userRepository.findByName(name).isPresent() &&
                userRepository.findByName(name).get().getPassword().equals(password);
    }

    private UserDto mapToUserDto(Users users){
        UserDto userDto = UserDto.builder()
                .id(users.getId())
                .name(users.getName())
                .surname(users.getSurname())
                .age(users.getAge())
                .email(users.getEmail())
                .phone(users.getPhone())
                .password(users.getPassword())
                .build();
        return userDto;
    }

    private Users mapToUser(UserDto userDto){
        Users user = Users.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .age(userDto.getAge())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .password(userDto.getPassword())
                .build();
        return user;
    }


}
