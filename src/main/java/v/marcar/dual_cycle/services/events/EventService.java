package v.marcar.dual_cycle.services.events;

import org.springframework.stereotype.Service;
import v.marcar.dual_cycle.dtos.EventDTOs.*;
import v.marcar.dual_cycle.dtos.UserDTOs.*;
import v.marcar.dual_cycle.entities.EventEntity;
import v.marcar.dual_cycle.entities.UserEntity;
import v.marcar.dual_cycle.repositories.EventRepository;
import v.marcar.dual_cycle.repositories.UserRepository;
import v.marcar.dual_cycle.services.users.UserExceptions;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {
    private final EventRepository eventRepo;
    private final UserRepository userRepo;

    public EventService(EventRepository eventRepo, UserRepository userRepo) {
        this.eventRepo = eventRepo;
        this.userRepo = userRepo;
    }

    public CreateEventResponse createEvent(CreateEventRequest req) {
        //Esto es el ID del evento
        String id = UUID.randomUUID().toString();

        if (!userRepo.existsById(req.userID())) {
            throw new UserExceptions.UserNotFoundException(req.userID());
        }
        UserEntity user = this.userRepo.getReferenceById(req.userID());
        EventEntity newEvent = new EventEntity(id, req.type(), req.date(), user /*Este usuario debería ser el author*/, user);
        EventEntity savedEvent = this.eventRepo.save(newEvent);


        UserEntity savedUser = savedEvent.getUser();
        UserEntity savedAuthor = savedEvent.getAuthor();
        GetUserResponse userResponse = new GetUserResponse(savedUser.getId(), savedUser.getName(), savedUser.getEmail(), savedUser.getGenre(), savedUser.getYear());
        GetUserResponse authorResponse = new GetUserResponse(savedAuthor.getId(), savedAuthor.getName(), savedAuthor.getEmail(), savedAuthor.getGenre(), savedAuthor.getYear());
        return new CreateEventResponse(savedEvent.getId(), savedEvent.getType(), savedEvent.getDate(), authorResponse, userResponse);
    }
}
