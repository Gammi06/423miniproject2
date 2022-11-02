package site.metacoding.miniproject2.domain.companys;

import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysInsertReqDto;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysTitleReqDto;
import site.metacoding.miniproject2.dto.CompaysReqDto.CompanysUpdateReqDto;
import site.metacoding.miniproject2.dto.CompaysRespDto.CompanyDetailRespDto;

public interface CompanysDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.
    public CompanyDetailRespDto findByIdToDetail(Integer id);

    public void insert(CompanysInsertReqDto companysInsertReqDto);

<<<<<<< HEAD
    public void updateChangeCompanys(CompanysTitleReqDto companysTitleReqDtoPS);// 변경

    public void updateCompanys(CompanysUpdateReqDto companysUpdateReqDto);// 수행

    public void deleteCompanys(Integer id);

    public CompanysTitleReqDto findByIdCompanyId(Integer id);

    public void findAllByCompanyId(Integer id);

=======
    public void updateCompanys(CompanysUpdateReqDto CompanysUpdateReqDto);

    public void deleteCompanys(Integer id);

>>>>>>> dc3cf471786d0be5da0f302f681cc8b5d85ab078
    public CompanysTitleReqDto findByIdCompanysNumber(String companyNumber);

}
