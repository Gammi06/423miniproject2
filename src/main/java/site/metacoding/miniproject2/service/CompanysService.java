package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.companys.CompanysDao;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysInsertReqDto;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysTitleReqDto;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysUpdateReqDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.CompanyDetailRespDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.CompanyDetailWithWantedsListRespDto;

@RequiredArgsConstructor
@Service
public class CompanysService {

    private final CompanysDao companysDao;

    public void Companyinsert(CompanysInsertReqDto companysInsertReqDto) {
        companysDao.insert(companysInsertReqDto);
    }

    public void Companyupdate(Integer id, CompanysUpdateReqDto companysUpdateReqDto) {
        // 1. 영속화
        CompanysTitleReqDto companysTitleReqDtoPS = companysDao.findByIdCompanyId(id);

        if (companysTitleReqDtoPS == null) {
            throw new RuntimeException(id + "의 게시글을 찾을 수 없습니다.");
        }
        companysTitleReqDtoPS.updateCompanys(companysUpdateReqDto);// 변경
        companysDao.updateChangeCompanys(companysTitleReqDtoPS);// 수행

    }

    public void deleteCompanys(Integer id) {
        companysDao.deleteCompanys(id);
    }

    public CompanyDetailWithWantedsListRespDto findByIdToDetailWithWantedsList(Integer id) {
        if (findByIdToDetail(id) == null)
            return null;
        CompanyDetailWithWantedsListRespDto companyDetailWithWantedsListDtoPS = new CompanyDetailWithWantedsListRespDto();
        companyDetailWithWantedsListDtoPS.setCompanyDetailRespDto(findByIdToDetail(id));
        // companyDetailWithWantedsListDtoPS.setWantedsListDtos(wantedsService.findByIdCompanyId(id));
        // 이부분 물어보기
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

    /* 수현 작업시작 */
    public void updateCompanysPhoto(Integer id) {
        companysDao.updateCompanysPhoto(id); // sessionUser 올라오면 수정
    }
    /* 수현 작업종료 */
}