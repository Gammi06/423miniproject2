package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.companys.Companys;
import site.metacoding.miniproject2.domain.companys.CompanysDao;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysInsertReqDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.CompanyDetailRespDto;

@RequiredArgsConstructor
@Service
public class CompanysService {

    private final CompanysDao companysDao;

    public void insert(CompanysInsertReqDto companysInsertReqDto) {
        companysDao.insert(companysInsertReqDto.toEntity());
    }

    public CompanyDetailRespDto findByIdToDetail(Integer id) {
        CompanyDetailRespDto companyDetailRespDtoPS = companysDao.findByIdToDetail(id);
        if (companyDetailRespDtoPS == null) {
            return null;
        } else {
            return companyDetailRespDtoPS;
        }
    }

    // 사업자번호 중복확인은 후에 수정예정
    public boolean 사업자번호중복확인(String companyNumber) {
        Companys CompanysPS = companysDao.findByIdCompanysNumber(companyNumber);
        if (CompanysPS == null) {
            return false;
        } else {
            return true;
        }
    }
}
