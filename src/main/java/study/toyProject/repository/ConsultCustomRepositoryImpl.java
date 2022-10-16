package study.toyProject.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import study.toyProject.dto.requestDto.ConsultListRequestDto;
import study.toyProject.dto.responseDto.QConsultListResponseDto;
import study.toyProject.entity.consult.ConsultInfo;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static study.toyProject.entity.consult.QConsultInfo.consultInfo;

public class ConsultCustomRepositoryImpl implements ConsultCustomRepository{

    private final JPAQueryFactory queryFactory;

    public ConsultCustomRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<?> getConsultList(ConsultListRequestDto consultListRequestDto, Pageable pageable) {

        List contents = queryFactory
                .select(new QConsultListResponseDto(consultInfo.seq,
                        consultInfo.consultType,
                        consultInfo.title,
                        consultInfo.userID,
                        consultInfo.status,
                        consultInfo.regDate,
                        consultInfo.endDate))
                .from(consultInfo)
                .where(betweenDate(consultListRequestDto.getSearchStartDate(), consultListRequestDto.getSearchEndDate())
                        , consultTypeEq(consultListRequestDto.getConsultType())
                        , statusEq(consultListRequestDto.getStatus()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<ConsultInfo> count = queryFactory
                .selectFrom(consultInfo)
                .where(betweenDate(consultListRequestDto.getSearchStartDate(), consultListRequestDto.getSearchEndDate())
                        , consultTypeEq(consultListRequestDto.getConsultType())
                        , statusEq(consultListRequestDto.getStatus()));

        return PageableExecutionUtils.getPage(contents, pageable, count::fetchCount);
    }

    private Predicate statusEq(String status) {
        if (status == null) {
            return null;
        }
        return consultInfo.status.eq(status);
    }

    private Predicate consultTypeEq(String consultType) {
        if (consultType == null) {
            return null;
        }
        return consultInfo.consultType.eq(consultType);
    }

    private Predicate betweenDate(LocalDate searchStartDate, LocalDate searchEndDate) {
        if (searchStartDate == null || searchEndDate == null) {
            return null;
        }
        LocalDateTime startDate = LocalDateTime.of(searchStartDate, LocalTime.MIN);
        LocalDateTime endDate = LocalDateTime.of(searchStartDate, LocalTime.MAX);
        return consultInfo.regDate.between(startDate, endDate);
    }
}
