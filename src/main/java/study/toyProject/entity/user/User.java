package study.toyProject.entity.user;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import study.toyProject.entity.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private Long seq;

    @Column(nullable = false, length = 30)
    private String userID;
    @Column(nullable = false, length = 30)
    private String password;

    private String email;
    private String phone;
    private String gender;
    private int age;
}
