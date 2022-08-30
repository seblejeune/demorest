package be.ifosup.demorest.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOut {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
}
