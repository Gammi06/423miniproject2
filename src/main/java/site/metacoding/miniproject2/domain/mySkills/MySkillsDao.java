package site.metacoding.miniproject2.domain.mySkills;

import java.util.List;

import site.metacoding.miniproject2.dto.MySkillsRespDto.MySkillsResumeRespDto;
import site.metacoding.miniproject2.dto.MySkillsRespDto.WantedGetSkillRespDto;
import site.metacoding.miniproject2.dto.MySkillsRespDto.WantedsSkillsRespDto;

public interface MySkillsDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.
    /* 지원작업 */
    public void insertMySkills(WantedsSkillsRespDto wantedsSkillsRespDto);
    /* 지원작업 완료 */

    /* 연지 작업 시작함 */
    public List<MySkillsResumeRespDto> findAllByResumeId(Integer resumeId);
    /* 연지 작업 종료 */

    /* 승현 작업 시작 */
    public List<WantedGetSkillRespDto> findAll(Integer wantedId);
    /* 승현 작업 종료 */
}
