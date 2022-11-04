package site.metacoding.miniproject2.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
public class ResumesController {

    private final ResumesService resumesService;
    private final ResumesDao resumesDao;
    private final UsersDao usersDao;

    @GetMapping("/resume")
    public String 이력서메인페이지() {
        return "/resume/resume_main";
    }

    // [Create] Insert Form
    @GetMapping("/resume/write")
    public String 이력서작성페이지() {
        return "/resume/resume_write";
    }

    // [Create] Insert
    @PostMapping("/resume/write")
    public String 이력서작성(Resumes resumes) {
        resumesDao.insert(resumes);
        return "redirect:/";
    }

    // [Read] Selcet (findAll)
    @GetMapping("/resume/list")
    public String 이력서관리페이지() {
        return "/resume/resume_list";
    }

    // [Read] Selcet (findById)
    @GetMapping("/resume/{id}/list")
    public String 이력서관리(@PathVariable Integer id, Model model) {
        List<ResumeListRespDto> resumeListRespDtoPS = resumesService.findById(id);
        model.addAttribute("resumeList", resumeListRespDtoPS);
        return "/resume/resume_list";
    }

    // [Update] Update Form
    @GetMapping("/resume/{id}/update")
    public String 이력서수정페이지(@PathVariable Integer id, Model model) {
        ResumeUpdateReqDto resumeUpdateReqDtoPS = resumesService.updateById(id, null);
        model.addAttribute("resumeUpdateReqDtoPS", resumeUpdateReqDtoPS);
        return "/resume/resume_update";
    }

    // [Update] Update
    @PostMapping("/resume/{id}/update")
    public String 이력서수정(Resumes resumes, @PathVariable Integer id) {
        resumesDao.updateById(id, resumes); // 수정된 내용 db에 저장
        return "redirect:/";
    }

    // [Delete] Delete
    @DeleteMapping("/resume/{id}/delete")
    public @ResponseBody CMRespDto<?> 이력서삭제(@PathVariable Integer id) {
        resumesDao.deleteById(id);
        return new CMRespDto<>(1, "삭제성공", null);
        // return "/resume/{id}/list";
    }
}
/* >>>> 연지 작업종료 <<<< */