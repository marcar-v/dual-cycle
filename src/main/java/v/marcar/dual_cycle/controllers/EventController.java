package v.marcar.dual_cycle.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import v.marcar.dual_cycle.dtos.EventDTOs.*;
import v.marcar.dual_cycle.services.events.EventService;

import java.util.List;

@RestController
@RequestMapping ("/events")
public class EventController {
    private final EventService service;

    public EventController(EventService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEventResponse create (@Valid @RequestBody CreateEventRequest req){
        return this.service.createEvent(req);
    }

    @GetMapping
    public GetEventsResponse get (@RequestParam String userID){
        //Aquí con el userID se hace una llamada a la BD pa coger la info y tal y tal
    }
}
