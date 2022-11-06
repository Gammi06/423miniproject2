package site.metacoding.miniproject2.domain.myCareers;

import java.util.List;

import site.metacoding.miniproject2.dto.MyCareersRespDto.MyCareersResumeRespDto;

public interface MyCareersDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    public void findAll();

    public void findById(Integer id);

    public void insert();

    /* 연지 작업 시작함 */

    public List<MyCareersResumeRespDto> findAllByResumeId(Integer resumeId);

    /* 연지 작업 종료 */
}
