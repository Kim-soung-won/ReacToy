package org.Toy.Domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name ="user")
@NoArgsConstructor
public class USER {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(nullable = false)
    private String user_name;
    @Column(nullable = false)
    private String user_email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String user_number;
    @Column(nullable = false)
    private String user_address;

    @Builder
    public USER(String user_name, String user_email, String password, String user_number, String user_address){
        this.user_name=user_name;
        this.user_email=user_email;
        this.password=password;
        this.user_number = user_number;
        this.user_address = user_address;
    }
}
