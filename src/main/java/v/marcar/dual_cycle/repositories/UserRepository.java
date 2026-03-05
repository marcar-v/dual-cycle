package v.marcar.dual_cycle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import v.marcar.dual_cycle.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,String> {
}
