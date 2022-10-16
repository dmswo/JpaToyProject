package study.toyProject.dto.requestDto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ConsultListRequestDto {

    private LocalDate searchStartDate;
    private LocalDate searchEndDate;
    private String consultType;
    private String status;
}
