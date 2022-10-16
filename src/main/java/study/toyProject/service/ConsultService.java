package study.toyProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import study.toyProject.dto.requestDto.ConsultListRequestDto;
import study.toyProject.repository.ConsultRepository;

@Service
@RequiredArgsConstructor
public class ConsultService {

    private final ConsultRepository consultRepository;

    public Page getConsultList(ConsultListRequestDto consultListRequestDto, Pageable pageable) {
        return consultRepository.getConsultList(consultListRequestDto, pageable);
    }
}
