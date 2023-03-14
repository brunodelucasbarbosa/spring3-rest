package br.com.course.spring3rest.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TokenDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String authenticated;
    private Date created;
    private Date expiration;
    private String acess_token;
    private String refresh_token;


    public TokenDTO(String username, String authenticated, Date created, Date expiration, String acess_token, String refresh_token) {
        this.username = username;
        this.authenticated = authenticated;
        this.created = created;
        this.expiration = expiration;
        this.acess_token = acess_token;
        this.refresh_token = refresh_token;
    }

    public TokenDTO() {
    }
}
