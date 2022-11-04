package site.metacoding.miniproject2.domain.companys;

import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysInsertReqDto;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysTitleReqDto;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysUpdateIntroReqDto;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysUpdateReqDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanyDetailRespDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanysInsertRespDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanysNumberCheckRespDto;

public interface CompanysDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.
    public CompanyDetailRespDto findByIdToDetail(Integer id);

    public void insert(CompanysInsertReqDto companysInsertReqDto);

    public void updateChangeCompanys(CompanysTitleReqDto companysTitleReqDtoPS);// 변경

    public void updateCompanys(CompanysUpdateReqDto companysUpdateReqDto);// 수행

    public void deleteCompanys(Integer id);

    public CompanysTitleReqDto findByIdCompanyId(Integer id);

    public void findAllByCompanyId(Integer id);

    public CompanysNumberCheckRespDto findByIdCompanysNumber(String companyNumber);

    public CompanysInsertRespDto findById(Integer id);

    public void updateCompanysIntro(CompanysUpdateIntroReqDto companysUpdateIntroReqDto);
}
