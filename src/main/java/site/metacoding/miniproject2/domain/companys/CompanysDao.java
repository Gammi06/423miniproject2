package site.metacoding.miniproject2.domain.companys;

import java.util.List;

import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysInsertReqDto;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysTitleReqDto;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysUpdateIntroReqDto;
import site.metacoding.miniproject2.dto.CompanysReqDto.CompanysUpdateReqDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanyDetailRespDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanysDeleteRespDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanysInsertRespDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanysNumberCheckRespDto;

public interface CompanysDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.
    public CompanyDetailRespDto findByIdToDetail(Integer id);

    public void insert(CompanysInsertReqDto companysInsertReqDto);

    public void updateChangeCompanys(CompanysTitleReqDto companysTitleReqDtoPS);// 변경

    public void updateCompanys(CompanysUpdateReqDto companysUpdateReqDto);// 수행

    public void deleteCompanys(Integer usersId);

    public void deleteWantedCompanys(Integer id);// 회사할때 공고 같이 삭제

    public CompanysDeleteRespDto findWantedCompanys(Integer id);// 회사할때 공고 같이 삭제

    public List<String> deleteWantedTitleCompanys(Integer companyId);// 회사할때 공고 같이 삭제

    public CompanysTitleReqDto findByIdCompanyId(Integer id);

    public void findAllByCompanyId(Integer id);

    public CompanysNumberCheckRespDto findByIdCompanysNumber(String companyNumber);

    public CompanysInsertRespDto findById(Integer id);

    public void updateCompanysIntro(CompanysUpdateIntroReqDto companysUpdateIntroReqDto);

    // 승현 작업 시작
    public CompanyDetailRespDto findByCompanyIdInfo(Integer id);
    // 승현 작업 종료
}
