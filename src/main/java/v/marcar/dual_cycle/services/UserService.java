package v.marcar.dual_cycle.services;

import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import v.marcar.dual_cycle.dtos.UserDTOs.*;
import v.marcar.dual_cycle.entities.UserEntity;
import v.marcar.dual_cycle.repositories.UserRepository;

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
        // Generar un identificador unico para el usuario
        String id = UUID.randomUUID().toString();
        // Hashear la contraseña
        String passHash = this.passEncoder.encode(req.password());
        // Guardar el usuario en la base de datos (usando la entidad)
        UserEntity newUser = new UserEntity(id, req.name(), req.email(), passHash);
        UserEntity savedUser = this.repo.save(newUser);
        // Devolver el resultado
        return new CreateUserResponse(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    //Get all users
    public List<UserEntity> getUsers() {
        return this.repo.findAll();
    }

    //Get user info by ID
    public GetUserResponse getUser(String userId){
        UserEntity user = this.repo.getReferenceById(userId);
        UserEntity userFound = this.repo.save(user);
        return new GetUserResponse(userFound.getId(), userFound.getName(), userFound.getEmail(), userFound.getGenre(), userFound.getYear());
    }

    //Update user
    public UpdateUserResponse updateUser(String userId, UpdateUserRequest request){
        UserEntity user = this.repo.findById(userId)
                        .orElseThrow();
        user.setGenre(request.genre());
        user.setYear(request.year());

        this.repo.save(user);

        return new UpdateUserResponse(user.getName(), user.getGenre(), user.getYear());
    }

    //Delete user by ID
    public void deleteUser(String userId){
        repo.deleteById(userId);
    }
}
