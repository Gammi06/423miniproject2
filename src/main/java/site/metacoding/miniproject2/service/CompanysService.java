package site.metacoding.miniproject2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.companys.CompanysDao;
import site.metacoding.miniproject2.domain.subcribes.SubcribesDao;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysInsertReqDto;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysTitleReqDto;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysUpdateReqDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.CompanyDetailRespDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.CompanyDetailWithWantedsListRespDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.CompanysInsertRespDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.SubscribesListRespDto;

@RequiredArgsConstructor
@Service
public class CompanysService {

    private final CompanysDao companysDao;
    private final SubcribesDao subcribesDao;
    private final WantedsService wantedsService;

    /* 지원 작업 시작 */
    public CompanysInsertRespDto insertCompany(CompanysInsertReqDto companysinsertReqDto) {
        companysDao.insert(companysinsertReqDto);
        CompanysInsertRespDto companysInsertRespDto = companysDao.findById(companysinsertReqDto.getId());
        return companysInsertRespDto;
    }

    public void CompanyUpdate(Integer id, CompanysUpdateReqDto companysUpdateReqDto) {
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

    public CompanyDetailWithWantedsListRespDto findByIdToDetailWithWantedsList(Integer id) {
        if (findByIdToDetail(id) == null)
            return null;
        CompanyDetailWithWantedsListRespDto companyDetailWithWantedsListDtoPS = new CompanyDetailWithWantedsListRespDto();
        companyDetailWithWantedsListDtoPS.setCompanyDetailRespDto(findByIdToDetail(id));
        companyDetailWithWantedsListDtoPS.setWantedsListRespDtos(wantedsService.findAllByCompanyId(id));
        return companyDetailWithWantedsListDtoPS;
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

    /* 수현 작업시작 */

    public void updateCompanysIntro(Integer id) {
        companysDao.updateCompanysIntro(id); // sessionUser 올라오면 수정
    }

    /* 수현 작업종료 */
}