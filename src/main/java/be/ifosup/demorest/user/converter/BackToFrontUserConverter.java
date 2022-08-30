package be.ifosup.demorest.user.converter;

import be.ifosup.demorest.user.entity.User;
import be.ifosup.demorest.user.model.UserOut;
import org.springframework.stereotype.Component;

@Component
public class BackToFrontUserConverter {
    public UserOut convert(User user) {
        return UserOut.builder()
                .id(user.getId())
                .emailAddress(user.getEmailAddress())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
