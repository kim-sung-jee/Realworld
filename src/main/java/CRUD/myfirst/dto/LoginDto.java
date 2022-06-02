package CRUD.myfirst.dto;


import CRUD.myfirst.domain.Role;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginDto {
    @NotEmpty
    private String name;

    private Role role;
}
