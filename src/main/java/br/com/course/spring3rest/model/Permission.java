package br.com.course.spring3rest.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;


@Data
@Entity
@Table(name = "permission")
public class Permission implements Serializable, GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String description;

    public Permission(){}

    @Override
    public String getAuthority() {
        return this.description;
    }
}
