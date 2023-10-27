package com.example.test.folder.vo;

import jakarta.validation.ValidationException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Date;

public class User {
    @NotEmpty(message = "ID cannot be blank")

    private String name;

    @NotEmpty(message = "ID cannot be blank")
    @Pattern(regexp ="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$\n", message = "Invalid password format. Passwords must be eight or more, including the sum of upper and lower case letters, numbers and special characters.")
    private String password;

    @NotEmpty(message = "Confirm Password cannot be blank")
    private String confirmPassword;

    @NotEmpty(message = "Date Of Birth cannot be blank")
    private LocalDateTime dateOfBirth;

    @NotEmpty(message = "Affiliation cannot be blank")
    private String affiliation; //내부적인 그룹?

    @NotEmpty(message = "Position cannot be blank")
    private String position;

    @NotEmpty(message = "Email cannot be blank")
    @Email(message = "Invalid email address")
    private String email;

    @NotEmpty(message = "Department cannot be blank")
    private String department;

    @NotEmpty(message = "Phone Number cannot be blank")
    @Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}", message = "Invalid phone number format (e.g., 010-1234-5678)")
    private String phoneNumber;

    public User(){

    }
    public User(final String name, final String password, final String confirmPassword, final LocalDateTime dateOfBirth,final String affiliation, final String position, final String email,final String  department, final String phoneNumber ) {

        if(!password.equals(confirmPassword)){throw new ValidationException("비밀번호 및 비밀번호 확인이 일치하지 않습니다.");}

        this.name = name;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.dateOfBirth = dateOfBirth;
        this.affiliation = affiliation;
        this.position = position;
        this.email = email;
        this.department = department;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {

        return null;
    }

    public Object getPassword() {

        return null;
    }

    public void setPassword(Object password) {
    }



    // Constructors, getters, and setters
}
