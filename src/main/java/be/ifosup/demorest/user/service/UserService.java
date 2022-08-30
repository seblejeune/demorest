package be.ifosup.demorest.user.service;

import be.ifosup.demorest.user.model.PatchUserIn;
import be.ifosup.demorest.user.model.UserIn;
import be.ifosup.demorest.user.model.UserOut;

public interface UserService {
    UserOut get(Long id);
    UserOut create(UserIn userIn);
    UserOut update(Long id, PatchUserIn userIn);
    void delete(Long id);
}
