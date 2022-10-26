package study.toyProject.dto.requestDto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ConsultListRequestDto {

    private String searchStartDate;
    private String searchEndDate;
    private String consultType;
    private String status;
}
