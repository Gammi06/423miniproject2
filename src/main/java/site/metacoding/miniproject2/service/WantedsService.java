package site.metacoding.miniproject2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.applys.ApplysDao;
import site.metacoding.miniproject2.domain.companys.CompanysDao;
import site.metacoding.miniproject2.domain.likes.LikesDao;
import site.metacoding.miniproject2.domain.wanteds.WantedsDao;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.ApplyRespDto.ApplyFindByIdRespDto;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanyDetailRespDto;
import site.metacoding.miniproject2.dto.SubribesReqDto.SubcribesInsertReqDto;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsSaveReqDto;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsUpdateReqDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.SearchDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedDetailRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedsRecruitsManageCareersRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedsRecruitsManagePositionsRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedsRecruitsManageRespDto;

@RequiredArgsConstructor
@Service
public class WantedsService {

    private final CompanysDao companysDao;
    private final WantedsDao wantedsDao;
    private final ApplysDao applysDao;
    private final LikesDao likesDao;

    /* 수현 작업 시작 */
    public void save(WantedsSaveReqDto wantedsSaveReqDto) {
        wantedsDao.save(wantedsSaveReqDto);
    }

    public void update(WantedsUpdateReqDto wantedsUpdateReqDto) {
        wantedsDao.update(wantedsUpdateReqDto);
    }

    public void deleteById(Integer id) {
        wantedsDao.deleteById(id);
    }

    public List<WantedsRecruitsManageRespDto> findByCompanysId(Integer companyId) {
        List<WantedsRecruitsManageRespDto> wantedsRecruitsManageList = wantedsDao.findByCompanysId(companyId);
        return wantedsRecruitsManageList;
    }

    public List<WantedsRecruitsManageCareersRespDto> findByCareersId(Integer companyId, Integer careerCodeId) {
        List<WantedsRecruitsManageCareersRespDto> wantedsRecruitsManageCareersList = wantedsDao
                .findByCareersId(companyId, careerCodeId);
        return wantedsRecruitsManageCareersList;
    }

    public List<WantedsRecruitsManagePositionsRespDto> findByPositionsId(Integer companyId, Integer positionCodeId) {
        List<WantedsRecruitsManagePositionsRespDto> wantedsRecruitsManagePositionsList = wantedsDao
                .findByPositionsId(companyId, positionCodeId);
        return wantedsRecruitsManagePositionsList;
    }

    public List<WantedsRecruitsManageRespDto> findByBothIds(Integer companyId, Integer careerCodeId,
            Integer positionCodeId) {
        List<WantedsRecruitsManageRespDto> wantedsRecruitsManageList = wantedsDao.findByBothIds(companyId, careerCodeId,
                positionCodeId);
        return wantedsRecruitsManageList;
    }

    /* 수현 작업 종료 */

    /* 승현 작업 시작 */
    public List<WantedListRespDto> findAll(SearchDto searchDto) {
        if (searchDto == null) {
            List<WantedListRespDto> wantedList = wantedsDao.findAll();
            return wantedList;
        }
        List<WantedListRespDto> wantedList = wantedsDao.findAllOrdered(searchDto);
        return wantedList;
    }

    public WantedDetailRespDto findById(Integer id) {
        WantedDetailRespDto wantedPS = wantedsDao.findById(id);
        return wantedPS;
    }

    public List<WantedListRespDto> findAllByCompanyId(Integer companyId) {
        // company의 findById 추가하기
        List<WantedListRespDto> wantedList = wantedsDao.findAllByCompanyId(companyId);
        return wantedList;
    }

    public CompanyDetailRespDto findByIdCompanyId(Integer id) {
        return companysDao.findByIdToDetail(id);
    }

    public List<WantedListRespDto> findAllByPositionCodeName(String positionCodeId) {
        // position의 findById 추가하기
        // id를 string으로 바꾸는 코드 추가하기
        String positionCodeName = null;
        List<WantedListRespDto> wantedList = wantedsDao.findAllByPositionCodeName(positionCodeName);
        return wantedList;
    }

    public List<WantedListRespDto> findAllByLike(Integer userId) {
        // 유저있는지 확인
        // SessionUsers principal =
        List<WantedListRespDto> wantedList = wantedsDao.findAllByLike(userId);
        return wantedList;
    }

    public ApplyFindByIdRespDto findByApplyId(Integer id) {
        return applysDao.findById(id);
    }

    /* 승현 작업 종료 */
}
