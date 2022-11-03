package site.metacoding.miniproject2.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysInsertReqDto;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysUpdateReqDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.service.CompanysService;

@RequiredArgsConstructor
@RestController
public class CompanysController {
    private final CompanysService companysService;
    private final HttpSession session;;

    // 회사가입
    @PostMapping("s/api/companys")
    public @ResponseBody CMRespDto<?> insert(@RequestBody CompanysInsertReqDto companysInsertReqDto) {
        SessionUsers sessionUsers = (SessionUsers) session.getAttribute("sessionUsers");
        companysInsertReqDto.setSessionUsers(sessionUsers);
        CompanysInsertReqDto companysInsertRespDto = companysService.Companyinsert(companysInsertReqDto);
        return new CMRespDto<>(1, "회사정보등록성공", null);
    }

    // 사업자 번호 중복체크
    @GetMapping("s/companys/companyNumberSameCheck")
    public @ResponseBody CMRespDto<Boolean> companyNumberSameCheck(String companyNumber) {
        boolean isSame = companysService.companyNumberDoubleCheck(companyNumber);
        return new CMRespDto<>(1, "사업자 번호 중복 체크 성공", isSame);
    }

    // 회사정보 수정/인증 필요
    @PutMapping("s/api/companys/{id}")
    public @ResponseBody CMRespDto<?> CompanyupdateId(@PathVariable Integer id,
            @RequestBody CompanysUpdateReqDto companysUpdateReqDto) {
        SessionUsers sessionUsers = (SessionUsers) session.getAttribute("sessionUsers");
        CompanysUpdateReqDto.setId(id);
        return new CMRespDto<>(1, "회사정보수정성공", null);
    }

    // 회사 정보 삭제 /인증 필요
    @DeleteMapping("s/api/companys/{id}")
    public @ResponseBody CMRespDto<?> deleteCompanysId(@PathVariable Integer id) {
        companysService.deleteCompanys(id);
        return new CMRespDto<>(1, "회사정보삭제", null);
    }

}