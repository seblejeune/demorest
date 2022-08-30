package be.ifosup.demorest.user.service.impl;

import be.ifosup.demorest.user.converter.BackToFrontUserConverter;
import be.ifosup.demorest.user.converter.FrontToBackUserConverter;
import be.ifosup.demorest.user.entity.User;
import be.ifosup.demorest.user.model.PatchUserIn;
import be.ifosup.demorest.user.model.UserIn;
import be.ifosup.demorest.user.model.UserOut;
import be.ifosup.demorest.user.repository.UserRepository;
import be.ifosup.demorest.user.service.UserService;
import be.ifosup.demorest.ws.error.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BackToFrontUserConverter backToFrontUserConverter;
    private final FrontToBackUserConverter frontToBackUserConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BackToFrontUserConverter backToFrontUserConverter,
                           FrontToBackUserConverter frontToBackUserConverter) {
        this.userRepository = userRepository;
        this.backToFrontUserConverter = backToFrontUserConverter;
        this.frontToBackUserConverter = frontToBackUserConverter;
    }

    @Override
    public UserOut get(Long id) {
        try {
            Optional<User> userEntity = userRepository.findById(id);

            User user = userEntity.get();
            return backToFrontUserConverter.convert(user);
        } catch(NoSuchElementException e) {
            throw new EntityNotFoundException(User.class, "id", id.toString());
        }
    }

    @Override
    public UserOut create(UserIn userIn) {
        User user = frontToBackUserConverter.convertForCreate(userIn);

        User userEntity = userRepository.save(user);
        return backToFrontUserConverter.convert(userEntity);
    }

    @Override
    public UserOut update(Long id, PatchUserIn userIn) {
        User userEntityToUpdate = userRepository.findById(id).orElse(null);

        User user = frontToBackUserConverter.impactCurrentUserWithNewValue(userEntityToUpdate, userIn);

        User userEntityUpdated = userRepository.save(user);

        return backToFrontUserConverter.convert(userEntityUpdated);
    }

    @Override
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(User.class, "id", id.toString());
        }
    }
}
