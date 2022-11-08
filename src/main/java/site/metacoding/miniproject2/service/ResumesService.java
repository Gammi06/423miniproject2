package site.metacoding.miniproject2.service;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.educations.EducationsDao;
import site.metacoding.miniproject2.domain.myCareers.MyCareersDao;
import site.metacoding.miniproject2.domain.mySkills.MySkillsDao;
import site.metacoding.miniproject2.domain.resumes.ResumesDao;
import site.metacoding.miniproject2.dto.EducationsRespDto.EducationsResumeRespDto;
import site.metacoding.miniproject2.dto.MyCareersRespDto.MyCareersResumeRespDto;
import site.metacoding.miniproject2.dto.MySkillsRespDto.MySkillsResumeRespDto;
import site.metacoding.miniproject2.dto.ResumesReqDto.ResumeUpdateReqDto;
import site.metacoding.miniproject2.dto.ResumesReqDto.ResumeWriteReqDto;
import site.metacoding.miniproject2.dto.ResumesRespDto.ResumeDetailRespDto;
import site.metacoding.miniproject2.dto.ResumesRespDto.ResumeListRespDto;

/* >>>> 연지 작업함 <<<< */
@RequiredArgsConstructor
@Service
public class ResumesService {

    private final ResumesDao resumesDao;
    private final MyCareersDao myCareersDao;
    private final EducationsDao educationsDao;
    private final MySkillsDao mySkillsDao;

    /* 연지 작업 시작 */
    public ResumeDetailRespDto findById(Integer id) {

        // 1. Dao(기능)에서 resume아이디를 찾는다
        // 2. List들을 제외한 값들을 Dto에 담아온다(쿼리)
        ResumeDetailRespDto resumeDetailRespDto = resumesDao.findById(id);

        // 3. ListDto값 채워넣기
        // 3-1. 경력 채워넣기
        // 3-1-1. 경력 Dao에 메소드 선언하기
        // 3-1-2. mapper 생성하기
        // 3-1-3. ResumeService에서 경력 dao에 만든 메서드 호출하기
        // 3-1-4. 호출한 값을 resumeDetailRespDto에 넣기
        // 3-1-5. 포스트맨으로 테스트하기
        List<MyCareersResumeRespDto> myCareers = myCareersDao.findAllByResumeId(id);
        resumeDetailRespDto.setMyCareers(myCareers);

        // 4. ListDto값 채워넣기
        // 4-1. 교육 채워넣기
        // 4-1-1. 교육 Dao에 메소드 선언하기
        // 4-1-2. mapper 생성하기
        // 4-1-3. ResumeService에서 교육 dao에 만든 메서드 호출하기
        // 4-1-4. 호출한 값을 resumeDetailRespDto에 넣기
        // 4-1-5. 포스트맨으로 테스트하기
        List<EducationsResumeRespDto> myEducations = educationsDao.findAllByResumeId(id);
        resumeDetailRespDto.setMyEducations(myEducations);

        // 5. ListDto값 채워넣기
        // 5-1. 스킬 채워넣기
        // 5-1-1. 스킬 Dao에 메소드 선언하기
        // 5-1-2. mapper 생성하기
        // 5-1-3. ResumeService에서 스킬 dao에 만든 메서드 호출하기
        // 5-1-4. 호출한 값을 resumeDetailRespDto에 넣기
        // 5-1-5. 포스트맨으로 테스트하기
        List<MySkillsResumeRespDto> mySkills = mySkillsDao.findAllByResumeId(id);
        resumeDetailRespDto.setMySkills(mySkills);

        return resumeDetailRespDto;
    }
    /* 연지 작업 종료 */

    public void insert(ResumeWriteReqDto resumeWriteReqDto) {

        resumesDao.insert(resumeWriteReqDto);
        myCareersDao.insertByResumeId();
        // educationsDao.insertByResumeId();

    }

    public ResumeListRespDto findByUserId(Integer userId) {
        return resumesDao.findByUserId(userId);
    }

    public List<ResumeListRespDto> findAllByUserId(Integer userId) {

        // 1. 값을 리턴받을 DTO를 만든다
        // 2. Dao에 메서드를 등록한다
        // 3. 매퍼 + 쿼리를 짠다.
        // 4. 서비스 구현 << List 어쩌구~
        // 5. 컨트롤러에서 값을 받아 포스트맨에서 호출한다.
        List<ResumeListRespDto> resumeListRespDto = resumesDao.findAllByUserId(userId);

        return resumeListRespDto;
    }

    public void updateById(ResumeUpdateReqDto resumeUpdateReqDto) {
        // 1. 이력서 수정하기 (제목, 자기소개)
        resumesDao.updateById(resumeUpdateReqDto);
        // 2. 경력
        // 3. 학력
        // 4. 스킬

        resumesDao.updateById(resumeUpdateReqDto);
    }

    public void deleteById(Integer id) {
        resumesDao.deleteById(id);
    }

}
/* >>>> 연지 작업종료 <<<< */