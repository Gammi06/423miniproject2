package site.metacoding.miniproject2.domain.companys;

import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysInsertReqDto;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysTitleReqDto;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysUpdateReqDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.CompanyDetailRespDto;

public interface CompanysDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.
    public CompanyDetailRespDto findByIdToDetail(Integer id);

    public void insert(CompanysInsertReqDto companysInsertReqDto);

    public void updateChangeCompanys(CompanysTitleReqDto companysTitleReqDtoPS);// 변경

    public void updateCompanys(CompanysUpdateReqDto companysUpdateReqDto);// 수행

    public void deleteCompanys(Integer id);

    public CompanysTitleReqDto findByIdCompanyId(Integer id);

    public void findAllByCompanyId(Integer id);

    public CompanysTitleReqDto findByIdCompanysNumber(String companyNumber);

    public void updateCompanysPhoto(Integer id);

}
