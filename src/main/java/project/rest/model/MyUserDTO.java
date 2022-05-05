package project.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.entity.Role;

import javax.persistence.Column;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class MyUserDTO {

    private Long id;

    private String username;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean accountNonExpired;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean accountNonLocked;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean credentialsNonExpired;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean enabled = false;

    private String fullName;

    @Column(unique = true)
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<Role> roles = new HashSet<>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String passwordConfirm;

    public MyUserDTO(Long id, String username, String fullName, String email) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
    }
}
