package study.toyProject.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import study.toyProject.entity.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
