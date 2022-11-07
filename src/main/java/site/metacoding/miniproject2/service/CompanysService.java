package site.metacoding.miniproject2.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.companys.Companys;
import site.metacoding.miniproject2.domain.companys.CompanysDao;
import site.metacoding.miniproject2.domain.subcribes.SubcribesDao;
import site.metacoding.miniproject2.domain.wanteds.WantedsDao;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysInsertReqDto;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysTitleReqDto;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysUpdateIntroReqDto;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysUpdateReqDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanyDetailRespDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanyDetailWithWantedsListRespDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanysDeleteRespDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanysInsertRespDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanysNumberCheckRespDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanysUpdateIntroRespDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.SubscribesListRespDto;
import site.metacoding.miniproject2.dto.SubribesReqDto.SubcribesInsertReqDto;
import site.metacoding.miniproject2.dto.SubribesRespDto.SubcribesInsertRespDto;
import site.metacoding.miniproject2.dto.SubribesRespDto.SubribesFindByIdRespDto;
import site.metacoding.miniproject2.handler.MyApiException;

@RequiredArgsConstructor
@Service
public class CompanysService {

    private final SubcribesDao subcribesDao;
    private final CompanysDao companysDao;
    private final WantedsDao wantedsDao;
    private final HttpSession session;

    /* 지원 작업 시작 */
    public CompanysInsertRespDto insertCompany(CompanysInsertReqDto companysinsertReqDto) {
        companysDao.insert(companysinsertReqDto);
        CompanysInsertRespDto companysInsertRespDto = companysDao.findById(companysinsertReqDto.getId());
        return companysInsertRespDto;
    }

    public CompanysTitleReqDto updateCompany(Integer id, CompanysUpdateReqDto companysUpdateReqDto) {

        CompanysTitleReqDto companysTitleReqDtoPS = companysDao.findByIdCompanyId(id);
        if (companysTitleReqDtoPS == null) {
            throw new RuntimeException(id + "의 회사정보를 찾을 수 없습니다.");
        }
        companysDao.updateCompanys(companysUpdateReqDto);// 변경
        companysTitleReqDtoPS = companysDao.findByIdCompanyId(id);
        return companysTitleReqDtoPS;
    }

    public CompanysDeleteRespDto deleteCompanys(Integer id) {
        CompanysDeleteRespDto companysDeleteRespDto = companysDao.findWantedCompanys(id);
        companysDeleteRespDto.setWantedNameListCompany(companysDao.deleteWantedTitleCompanys(id));
        if (companysDeleteRespDto != null) {
            companysDao.deleteWantedCompanys(id);
            companysDao.deleteCompanys(id);
        }
        return companysDeleteRespDto;
    }

    public CompanyDetailRespDto findByIdToDetail(Integer id) {
        CompanyDetailRespDto companyDetailRespDtoPS = companysDao.findByIdToDetail(id);
        if (companyDetailRespDtoPS == null) {
            return null;
        } else {
            return companyDetailRespDtoPS;
        }
    }

    public boolean companyNumberDoubleCheck(String companyNumber) {// 사업자 번호 중복체크
        CompanysNumberCheckRespDto companysNumberCheckRespDto = companysDao.findByIdCompanysNumber(companyNumber);
        if (companysNumberCheckRespDto == null) {
            return false;
        } else {
            return true;
        }
    }

    public List<SubscribesListRespDto> subcribesListPage(Integer userId) {
        List<SubscribesListRespDto> subcribesList = subcribesDao.subcribesListPage(userId);

        List<SubscribesListRespDto> subscribesListRespDto = new ArrayList<>();
        for (SubscribesListRespDto subcribes : subcribesList) {
            subscribesListRespDto.add(new SubscribesListRespDto(subcribes));
        }
        return subcribesList;
    }
    // SubcribesService 삭제후 CompanysService로 옮김
    /* 지원 작업 종료 */

    public CompanyDetailWithWantedsListRespDto findByIdToDetailWithWantedsList(Integer id) {
        if (findByIdToDetail(id) == null)
            return null;
        CompanyDetailWithWantedsListRespDto companyDetailWithWantedsListDtoPS = new CompanyDetailWithWantedsListRespDto();
        companyDetailWithWantedsListDtoPS.setCompanyDetailRespDto(findByIdToDetail(id));
        // companyDetailWithWantedsListDtoPS.setWantedsListRespDtos(wantedsService.findByIdCompanyId(id));
        return companyDetailWithWantedsListDtoPS;
    }

    /* 수현 작업시작 */

    public CompanysUpdateIntroRespDto updateCompanysIntro(CompanysUpdateIntroReqDto companysUpdateIntroReqDto) {
        Companys companys = companysUpdateIntroReqDto.toEntity();
        companysDao.updateCompanysIntro(companysUpdateIntroReqDto);
        return new CompanysUpdateIntroRespDto(companys);
    }

    /* 수현 작업종료 */

    /* 승현 작업 시작 */

    public SubribesFindByIdRespDto findBySubcribesId(Integer id) {
        return subcribesDao.findById(id);
    }

    public SubcribesInsertRespDto insertSubcribes(SubcribesInsertReqDto insertReqDto) {
        if (companysDao.findByIdCompanyId(insertReqDto.getCompanyId()) == null) {
            throw new MyApiException("해당 id(" + insertReqDto.getCompanyId() + ")의 기업이 없습니다.");
        }
        subcribesDao.insert(insertReqDto);
        return SubcribesInsertRespDto.builder().userId(insertReqDto.getUserId()).companyId(insertReqDto.getCompanyId())
                .build();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteSubcribes(Integer id) {
        if (subcribesDao.findById(id) == null) {
            throw new MyApiException("해당 기업을 구독하지 않았습니다.");
        }
        subcribesDao.deleteById(id);
    }

    /* 승현 작업 종료 */
}