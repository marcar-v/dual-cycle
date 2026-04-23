package v.marcar.dual_cycle.services;

import org.springframework.stereotype.Service;
import v.marcar.dual_cycle.entities.EventEntity;
import v.marcar.dual_cycle.dtos.EventDTO;
import v.marcar.dual_cycle.repositories.EventRepository;
import v.marcar.dual_cycle.repositories.UserRepository;

import java.util.UUID;

@Service
public class EventService {
    private final EventRepository eventRepo;
    private final UserRepository userRepo;

    public EventService(EventRepository eventRepo, UserRepository userRepo){
        this.eventRepo = eventRepo;
        this.userRepo = userRepo;
    }

    public CreateEventResponse createEvent(CreateEventRequest req){
        String id = UUID.randomUUID().toString();
        String type;
        //Aquí he petado. Ya no entiendo nada.
        return new CreateEventResponse();
    }
}
