package org.Toy.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.Toy.DTO.USER.UserAddRequest;
import org.Toy.Domain.USER;
import org.Toy.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public USER save(UserAddRequest request){
        return userRepository.save(request.toEntity());
    }
    public USER findByUser_Id(Long id){
        USER user = userRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("not found : "+ id));
        return user;
    }
}
