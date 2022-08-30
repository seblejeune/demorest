package be.ifosup.demorest.user.model;

import be.ifosup.demorest.validator.email.UniqEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchUserIn {

    private String firstName;

    private String lastName;

    @UniqEmail
    @Email
    private String emailAddress;
}
