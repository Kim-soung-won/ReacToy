package org.Toy.Controller;

import lombok.RequiredArgsConstructor;
import org.Toy.Domain.USER;
import org.Toy.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    final private UserService userService;

    @PostMapping("/saveUser")
    public void saveUser(){
//            userService.save(user);

    }
}
