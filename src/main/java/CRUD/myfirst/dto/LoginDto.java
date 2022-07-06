package CRUD.myfirst.dto;


import CRUD.myfirst.domain.Role;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginDto {
    @NotEmpty
    private String name;

    private Role role;
}
