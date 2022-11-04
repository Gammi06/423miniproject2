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
    @PostMapping("/api/resume/write")
    public int insert(@RequestBody Resumes resumes) {
        int resumeWrite = resumesDao.insert(resumes);
        return resumeWrite;
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

    // [Update] Update
    @PutMapping("/api/resume/{id}/update")
    public int updateById(@PathVariable Integer id, @RequestBody Resumes resumes) {
        Resumes resumesPS = resumesDao.findById(resumes.getId());
        if (resumesPS == null) {
            throw new RuntimeException("해당 아이디 없음");
        }
        int resumeUpdate = resumesDao.updateById(id, resumes);
        return resumeUpdate;
    }

    // [Delete] Delete
    @DeleteMapping("/api/resume/{id}/delete")
    public int deleteById(@PathVariable Integer id) {
        Resumes resumesPS = resumesDao.findById(id);
        if (resumesPS == null) {
            throw new RuntimeException("해당 아이디 없음");
        }
        int resumeDelete = resumesDao.deleteById(id);
        return resumeDelete;
    }
}
/* >>>> 연지 작업종료 <<<< */