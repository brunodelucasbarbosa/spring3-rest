package br.com.course.spring3rest.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountCredentialsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    public AccountCredentialsDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
