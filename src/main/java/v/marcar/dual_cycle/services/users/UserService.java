package v.marcar.dual_cycle.services.users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import v.marcar.dual_cycle.dtos.UserDTOs.*;
import v.marcar.dual_cycle.entities.UserEntity;
import v.marcar.dual_cycle.repositories.UserRepository;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;
    private final BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public CreateUserResponse createUser(CreateUserRequest req) {
        // Guardar el usuario en la base de datos (usando la entidad)
        UserEntity newUser = new UserEntity(req.name(), req.email());
        UserEntity savedUser = this.repo.save(newUser);
        // Devolver el resultado
        return new CreateUserResponse(savedUser.getName(), savedUser.getEmail());
    }

    //Get all users
    public List<GetUserResponse> getUsers() {
        List<UserEntity> usersList = this.repo.findAll();
        List<GetUserResponse> users = new ArrayList<>();
        usersList.forEach(dbUser -> {
            users.add(new GetUserResponse(dbUser.getName(), dbUser.getEmail(), dbUser.getGenre(), dbUser.getYear()));
        });
        return users;
    }

    //Get user info by ID
    public GetUserResponse getUser(String email){
        UserEntity user = this.repo.getReferenceById(email);
        UserEntity userFound = this.repo.save(user);
        return new GetUserResponse(userFound.getName(), userFound.getEmail(), userFound.getGenre(), userFound.getYear());
    }

    //Update user
    public UpdateUserResponse updateUser(String email, UpdateUserRequest request){
        UserEntity user = this.repo.findById(email)
                        .orElseThrow();
        user.setGenre(request.genre());
        user.setYear(request.year());

        this.repo.save(user);

        return new UpdateUserResponse(user.getName(), user.getGenre(), user.getYear());
    }
}
