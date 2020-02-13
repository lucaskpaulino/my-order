package com.example.myorder.services;

import com.example.myorder.api.dtos.CreateUserDto;
import com.example.myorder.api.dtos.UserResponseDto;
import com.example.myorder.api.exceptions.NotFoundException;
import com.example.myorder.api.mappers.UserMapper;
import com.example.myorder.entities.User;
import com.example.myorder.repositories.UserRepository;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    //TODO SOMETHING
    public UserResponseDto create(CreateUserDto createUserDto){

    }
    public void validaUserEmail(String email){
        validaUserEmail(CreateUserDto.getEmail());

        User user = userRepository.save(createUser((createUserDto)));
    }
    public List<UserResponseDto> listAll(){
        List<User> user = userRepository.findAll();
        for (User user : users){
            userResponseDtp userResponseDto
        }

    }


    private User createUser(CreateUserDto createUserDto){
        return new User()
                .setName(createUserDto.getName())
                .setEmail(createUserDto.getEmail())
                .setAddress(createUserDto.getAddress())
                .setPassword(createUserDto.getPassword())
                .setPhone(createUserDto.getPhone());
    }


    private UserResponseDto findById(Integer id) throws NotFoundException {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new NotFoundException("Não existe esse contato");
        }

        return UserMapper.toResponseDto(user.get())
    }


    private User saveUser(User user){
        return userRepository.save(user);
    }
}
