package study.toyProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.toyProject.dto.requestDto.ConsultListRequestDto;
import study.toyProject.dto.requestDto.ConsultSaveRequestDto;
import study.toyProject.entity.consult.ConsultInfo;
import study.toyProject.repository.ConsultRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ConsultService {

    private final ConsultRepository consultRepository;

    public Page getConsultList(ConsultListRequestDto consultListRequestDto, Pageable pageable) {
        return consultRepository.getConsultList(consultListRequestDto, pageable);
    }

    public ConsultInfo consultSave(ConsultSaveRequestDto consultSaveRequestDto) {
        ConsultInfo consultInfo = ConsultInfo.builder(consultSaveRequestDto).build();
        ConsultInfo save = consultRepository.save(consultInfo);

        return save;
    }
}
