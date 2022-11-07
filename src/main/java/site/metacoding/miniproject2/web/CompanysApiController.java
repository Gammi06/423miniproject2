package site.metacoding.miniproject2.web;

import java.util.List;

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
import lombok.extern.slf4j.Slf4j;
import site.metacoding.miniproject2.dto.CMRespDto;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysInsertReqDto;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysUpdateIntroReqDto;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysUpdateReqDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanysInsertRespDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.SubscribesListRespDto;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.SubribesReqDto.SubcribesInsertReqDto;
import site.metacoding.miniproject2.dto.SubribesRespDto.SubcribesInsertRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.AuthRespDto;
import site.metacoding.miniproject2.service.CompanysService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CompanysApiController {

    private final CompanysService companysService;
    private final HttpSession session;

    /* 지원 작업 */
    // 회사가입
    @PostMapping("/s/api/companys/{id}/add")
    public CMRespDto<?> insert(@PathVariable Integer id, @RequestBody CompanysInsertReqDto companysInsertReqDto) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        companysInsertReqDto.setUsersId(id);
        CompanysInsertRespDto companysInsertRespDto = companysService.insertCompany(companysInsertReqDto);
        return new CMRespDto<>(1, "회사정보등록성공", companysInsertRespDto);
    }

    // 사업자 번호 중복체크
    @GetMapping("/companys/companyNumberSameCheck")
    public @ResponseBody CMRespDto<Boolean> companyNumberSameCheck(String companyNumber) {
        boolean isSame = companysService.companyNumberDoubleCheck(companyNumber);
        return new CMRespDto<>(1, "사업자 번호 중복 체크 성공", isSame);
    }// 마지막 테스트 / ajax -> 쿼리스트림으로 테스트 완료

    // 회사정보 수정/인증 필요
    @PutMapping("/s/api/companys/{id}")
    public @ResponseBody CMRespDto<?> updateCompanyId(@PathVariable Integer id,
            @RequestBody CompanysUpdateReqDto companysUpdateReqDto) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        return new CMRespDto<>(1, "회사정보수정성공", companysService.updateCompany(id, companysUpdateReqDto));
    }

    // 회사 정보 삭제 /인증 필요. -> 공고 삭제
    @DeleteMapping("/s/api/companys/{id}/delete")
    public @ResponseBody CMRespDto<?> deleteCompanysId(@PathVariable Integer id) {
        SessionUsers sessionUsers = (SessionUsers) session.getAttribute("sessionUsers");
        return new CMRespDto<>(1, "회사정보삭제", companysService.deleteCompanys(id));
    }

    /* 구독페이지 */
    @GetMapping("/s/mypage/{userId}/subscribes")
    public @ResponseBody CMRespDto<?> subscribesform(@PathVariable Integer userId) {// userId는 테스트할려고 넣음
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        List<SubscribesListRespDto> subcribesList = companysService.subcribesListPage(userId);
        return new CMRespDto<>(1, "구독페이지 보기", subcribesList);
    }// 로그인 해서 테스트 돌리기

    /* 지원 작업 완료 **/

    /* 수현 작업 시작 */
    @PutMapping("/s/api/companys/{id}/edit/intro")
    public CMRespDto<?> updateCompanysIntro(@PathVariable Integer id,
            @RequestBody CompanysUpdateIntroReqDto companysUpdateIntroReqDto) {
        AuthRespDto sessionUsers = (AuthRespDto) session.getAttribute("principal");
        if (sessionUsers.getCompanyId().equals(id)) {
            companysUpdateIntroReqDto.setId(sessionUsers.getCompanyId());
            return new CMRespDto<>(1, "성공", companysService.updateCompanysIntro(companysUpdateIntroReqDto));
        } else {
            return new CMRespDto<>(-1, "수정에 실패했습니다", null);
        }

    }
    /* 수현 작업 완료 */

    /* 승현 작업 시작 */

    @GetMapping("/companys/info/{id}")
    public CMRespDto<?> findByCompanyIdInfo(@PathVariable Integer id) {
        return new CMRespDto<>(1, "성공", companysService.findByCompanyIdInfo(id));
    }

    @PostMapping("/s/api/companys/{id}/subscribes/add")
    public SubcribesInsertRespDto insertSubcribes(@PathVariable Integer id) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        return companysService.insertSubcribes(new SubcribesInsertReqDto(principal.getId(), id));
    }

    @DeleteMapping("/s/api/companys/{id}/subscribes")
    public CMRespDto<?> deleteSubcribes(@PathVariable Integer id) {
        companysService.deleteSubcribes(id);
        return new CMRespDto<>(1, "성공", null);
    }

    /* 승현 작업 종료 */

}