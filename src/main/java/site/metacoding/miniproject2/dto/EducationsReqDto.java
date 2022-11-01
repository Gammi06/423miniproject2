package site.metacoding.miniproject2.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.miniproject2.domain.educations.Educations;

/* >>>> 연지 작업함 <<<< */
public class EducationsReqDto {

    @Setter
    @Getter
    public static class EducationsAddReqDto {
        private Timestamp startDate;
        private Timestamp endDate;
        private String instruction;
        private String state;

        public Educations toEntity() {
            return Educations.builder()
                    .startdate(startDate)
                    .enddate(endDate)
                    .instruction(instruction)
                    .state(state)
                    .build();
        }
    }

}
/* >>>> 연지 작업종료 <<<< */