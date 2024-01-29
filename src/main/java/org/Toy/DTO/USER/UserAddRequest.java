package org.Toy.DTO.USER;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.Toy.Domain.USER;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserAddRequest {
    private String user_name;
    private String user_email;
    private String password;
    private String user_number;
    private String user_address;

    public USER toEntity(){
        return USER.builder().
                user_name(user_name).
                user_email(user_email).
                password(password).
                user_number(user_number).
                user_address(user_address).
                build();
    }
}
