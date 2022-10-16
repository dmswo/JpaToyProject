package study.toyProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.toyProject.entity.consult.ConsultInfo;

public interface ConsultRepository extends JpaRepository<ConsultInfo, Long>, ConsultCustomRepository{

}
