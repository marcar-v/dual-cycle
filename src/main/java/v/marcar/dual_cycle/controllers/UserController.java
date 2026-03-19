package v.marcar.dual_cycle.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import v.marcar.dual_cycle.dtos.UserDTOs.*;
import v.marcar.dual_cycle.entities.UserEntity;
import v.marcar.dual_cycle.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse create(@Valid @RequestBody CreateUserRequest req) {
        return this.service.createUser(req);
    }

    //All users list
    @GetMapping
    public List<UserEntity> getUsers(){
        return service.getUsers();
    }

    //User by ID
    @GetMapping("/{userId}")
    public GetUserResponse get(@PathVariable("userId") String userId) {
        return service.getUser(userId);
    }

    //Update user info
    @PutMapping("/{userId}")
    public UpdateUserResponse updateUser (@PathVariable String userId, @RequestBody UpdateUserRequest request){
        return service.updateUser(userId, request);
    }

    //Delete user by ID
    @DeleteMapping("/{userId}")
    public void delete(@PathVariable String userId){
        service.deleteUser(userId);
    }
}
