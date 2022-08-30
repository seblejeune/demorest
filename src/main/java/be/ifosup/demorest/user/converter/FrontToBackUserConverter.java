package be.ifosup.demorest.user.converter;

import be.ifosup.demorest.user.entity.User;
import be.ifosup.demorest.user.model.PatchUserIn;
import be.ifosup.demorest.user.model.UserIn;
import org.springframework.stereotype.Component;

import javax.transaction.UserTransaction;

@Component
public class FrontToBackUserConverter {
    public User convertForCreate(UserIn userIn) {
        return User.builder()
                .emailAddress(userIn.getEmailAddress())
                .firstName(userIn.getFirstName())
                .lastName(userIn.getLastName())
                .build();
    }

    public User impactCurrentUserWithNewValue(User userEntityToUpdate, PatchUserIn patchUserIn) {

        if(patchUserIn.getEmailAddress() != null) {
            userEntityToUpdate.setEmailAddress(patchUserIn.getEmailAddress());
        }

        if(patchUserIn.getFirstName() != null) {
            userEntityToUpdate.setFirstName(patchUserIn.getFirstName());
        }

        if(patchUserIn.getLastName() != null) {
            userEntityToUpdate.setLastName(patchUserIn.getLastName());
        }

        return userEntityToUpdate;
    }
}
