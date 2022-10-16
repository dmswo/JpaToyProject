package study.toyProject.entity.consult;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConsultInfo {

    @Id @GeneratedValue
    private Long seq;
    private String consultType;
    private String title;

    @Column(columnDefinition = "Text")
    private String contents;

    private String phone;
    private String email;
    private String userID;
    private String manageID;
    private String status;
    private String searchPhone;
    private LocalDateTime regDate;
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "consultInfo")
    List<ConsultFile> files = new ArrayList<>();
}
