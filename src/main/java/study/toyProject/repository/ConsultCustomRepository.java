package study.toyProject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.toyProject.dto.requestDto.ConsultListRequestDto;

public interface ConsultCustomRepository {

    public Page getConsultList(ConsultListRequestDto consultListRequestDto, Pageable pageable);
}
