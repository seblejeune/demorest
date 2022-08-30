package be.ifosup.demorest.ws;

import be.ifosup.demorest.user.model.PatchUserIn;
import be.ifosup.demorest.user.model.UserIn;
import be.ifosup.demorest.user.model.UserOut;
import be.ifosup.demorest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserWSController {

    private final UserService userService;

    @Autowired
    public UserWSController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserOut get(@PathVariable("id") Long id) {
        return userService.get(id);
    }

    @PostMapping()
    public UserOut create(@Valid @RequestBody UserIn userIn) {
        return userService.create(userIn);
    }

    @PatchMapping("/{id}")
    public UserOut update(@PathVariable("id") Long id, @Valid @RequestBody PatchUserIn patchUserIn) {
        return userService.update(id, patchUserIn);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
