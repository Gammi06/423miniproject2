package site.metacoding.miniproject2.domain.companys;

import site.metacoding.miniproject2.dto.CompaysRespDto.CompanyDetailRespDto;

public interface CompanysDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.
    public CompanyDetailRespDto findByIdToDetail(Integer id);

    public void Companyinsert(Companys companys);

    public void Companyupdate(Integer id);

    public void Companydelete(Integer id);

    public Companys findByIdCompanysNumber(String companyNumber);

    public void Companyupdate(Companys entity);
}
