package be.ifosup.demorest.user.model;

import be.ifosup.demorest.validator.email.UniqEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserIn {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @UniqEmail
    @NotBlank
    @Email
    private String emailAddress;
}
