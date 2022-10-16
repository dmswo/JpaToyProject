package study.toyProject.entity.consult;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConsultFile {

    @Id @GeneratedValue
    private Long seq;

    private String userID;
    private String fileURL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="consultSeq")
    private ConsultInfo consultInfo;
}
