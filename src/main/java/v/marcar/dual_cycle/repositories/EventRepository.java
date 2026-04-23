package v.marcar.dual_cycle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import v.marcar.dual_cycle.entities.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, String> {
}
