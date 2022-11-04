package site.metacoding.miniproject2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.companys.CompanysDao;
import site.metacoding.miniproject2.domain.subcribes.SubcribesDao;
import site.metacoding.miniproject2.domain.wanteds.WantedsDao;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysInsertReqDto;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysTitleReqDto;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysUpdateReqDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.CompanyDetailRespDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.CompanyDetailWithWantedsListRespDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.CompanysInsertRespDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.SubscribesListRespDto;
import site.metacoding.miniproject2.dto.SubribesReqDto.SubcribesInsertReqDto;
import site.metacoding.miniproject2.dto.SubribesRespDto.SubribesFindByIdRespDto;

@RequiredArgsConstructor
@Service
public class CompanysService {

    private final SubcribesDao subcribesDao;
    private final CompanysDao companysDao;
    private final WantedsDao wantedsDao;
    private final WantedsService wantedsService; // 쌤이 서비스에서 서비스 쓰지 말랬다고 알려주기

    /* 지원 작업 시작 */
    public CompanysInsertRespDto insertCompany(CompanysInsertReqDto companysinsertReqDto) {
        companysDao.insert(companysinsertReqDto);
        CompanysInsertRespDto companysInsertRespDto = companysDao.findById(companysinsertReqDto.getId());
        return companysInsertRespDto;
    }

    public void updateCompany(Integer id, CompanysUpdateReqDto companysUpdateReqDto) {
        CompanysTitleReqDto companysTitleReqDtoPS = companysDao.findByIdCompanyId(id);

        if (companysTitleReqDtoPS == null) {
            throw new RuntimeException(id + "의 회사정보를 찾을 수 없습니다.");
        }
        companysDao.updateCompanys(companysUpdateReqDto);// 변경
        companysDao.updateChangeCompanys(companysTitleReqDtoPS);// 수행.
    }

    public void deleteCompanys(Integer id) {
        CompanysTitleReqDto companysTitleReqDtoPS = companysDao.findByIdCompanyId(id);
        if (companysTitleReqDtoPS == null) {
            companysDao.deleteCompanys(id);
        }
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
        CompanysTitleReqDto companysTitleReqDtoPS = companysDao.findByIdCompanysNumber(companyNumber);
        if (companysTitleReqDtoPS == null) {
            return false;
        } else {
            return true;
        }
    }

    public List<SubscribesListRespDto> subcribesListPage(Integer id) {
        List<SubscribesListRespDto> subcribesList = subcribesDao.subcribesListPage(id);

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

    public void updateCompanysIntro(Integer id) {
        companysDao.updateCompanysIntro(id); // sessionUser 올라오면 수정
    }

    /* 수현 작업종료 */

    /* 승현 작업 시작 */

    public SubribesFindByIdRespDto findBySubcribesId(Integer id) {
        return subcribesDao.findById(id);
    }

    public void insertSubcribes(SubcribesInsertReqDto insertReqDto) {
        // if 파인드 어쩌고해서 있는지 체크하기
        subcribesDao.insert(insertReqDto);
    }

    public void deleteSubcribes(Integer id) {
        subcribesDao.deleteById(id);
    }

    /* 승현 작업 종료 */
}