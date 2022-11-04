package site.metacoding.miniproject2.web;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.resumes.Resumes;
import site.metacoding.miniproject2.domain.resumes.ResumesDao;
import site.metacoding.miniproject2.domain.users.UsersDao;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.ResumesReqDto.ResumeUpdateReqDto;
import site.metacoding.miniproject2.dto.ResumesRespDto.ResumeListRespDto;
import site.metacoding.miniproject2.service.ResumesService;

/* >>>> 연지 작업함 <<<< */
@RequiredArgsConstructor
@RestController
public class ResumesApiController {

    private final ResumesService resumesService;
    private final ResumesDao resumesDao;
    private final UsersDao usersDao;

    @GetMapping("/resume")
    public String 이력서메인페이지() {
        return "/resume/resume_main";
    }

    // [Create] Insert
    @PostMapping("/s/api/resume/write")
    public int insert(@RequestBody Resumes resumes) {
        int resumeWrite = resumesDao.insert(resumes);
        return resumeWrite;
    }

    // [Read] Selcet (findAll)
    @GetMapping("/s/resume/list")
    public String 이력서관리페이지() {
        return "/resume/resume_list";
    }

    // [Read] Selcet (findById)
    @GetMapping("/s/resume/{id}/list")
    public String 이력서관리(@PathVariable Integer id, Model model) {
        List<ResumeListRespDto> resumeListRespDtoPS = resumesService.findById(id);
        model.addAttribute("resumeList", resumeListRespDtoPS);
        return "/resume/resume_list";
    }

    // [Update] Update
    @PutMapping("/s/api/resume/{id}/update")
    public CMRespDto<?> updateById(@PathVariable Integer id, @RequestBody ResumeUpdateReqDto resumeUpdateReqDto) {
        resumesService.updateById(resumeUpdateReqDto);
        return new CMRespDto<>(1, "성공", null);
    }

    // [Delete] Delete
    @DeleteMapping("/s/api/resume/{id}/delete")
    public CMRespDto<?> deleteById(@PathVariable Integer id) {
        resumesService.deleteById(id);
        return new CMRespDto<>(1, "성공", null);
    }
}
/* >>>> 연지 작업종료 <<<< */