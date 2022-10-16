package study.toyProject.dto.responseDto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultListResponseDto {

    private Long seq;
    private String consultType;
    private String title;
    private String userID;
    private String status;
    private LocalDateTime regDate;
    private LocalDateTime endDate;

    @QueryProjection
    public ConsultListResponseDto(Long seq, String consultType, String title, String userID, String status, LocalDateTime regDate, LocalDateTime endDate) {
        this.seq = seq;
        this.consultType = consultType;
        this.title = title;
        this.userID = userID;
        this.status = status;
        this.regDate = regDate;
        this.endDate = endDate;
    }
}
