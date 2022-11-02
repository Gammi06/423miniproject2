package site.metacoding.miniproject2.domain.companys;

import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysInsertReqDto;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysUpdateReqDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.CompanyDetailRespDto;

public interface CompanysDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.
    public CompanyDetailRespDto findByIdToDetail(Integer id);

    public void insert(CompanysInsertReqDto companysInsertReqDto);

    public void updateCompanys(CompanysUpdateReqDto CompanysUpdateReqDto);

    public void deleteCompanys(Integer id);

    public Companys findByIdCompanysNumber(String companyNumber);

}
