package site.metacoding.miniproject2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import site.metacoding.miniproject2.domain.codes.PositionsCodeDao;
import site.metacoding.miniproject2.domain.companys.CompanysDao;
import site.metacoding.miniproject2.domain.mySkills.MySkillsDao;
import site.metacoding.miniproject2.domain.wanteds.WantedsDao;
import site.metacoding.miniproject2.dto.CompanysRespDto.CompanyDetailRespDto;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsSaveReqDto;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsUpdateReqDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.SearchDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedDetailRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedsRecruitsManageCareersRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedsRecruitsManagePositionsRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedsRecruitsManageRespDto;

@Slf4j
@RequiredArgsConstructor
@Service
public class WantedsService {

    private final PositionsCodeDao positionsCodeDao;
    private final MySkillsDao mySkillsDao;
    private final CompanysDao companysDao;
    private final WantedsDao wantedsDao;

    /* 수현 작업 시작 */
    public void save(WantedsSaveReqDto wantedsSaveReqDto) {
        // SessionUser에서 companysId 가져올것
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

    public List<WantedListRespDto> findAll() {
        return wantedsDao.findAll();
    }

    public WantedDetailRespDto findById(Integer id) {
        WantedDetailRespDto wantedPS = wantedsDao.findById(id);
        if (wantedPS == null) {
            throw new RuntimeException("해당 아이디의 공고가 없습니다.");
        }
        wantedsDao.updateViewCount(id);
        wantedPS.setMySkills(mySkillsDao.findAll(id));
        return wantedPS;
    }

    public List<WantedListRespDto> findAllByCompanyId(Integer companyId) {
        if (companysDao.findByIdToDetail(companyId) == null) {
            throw new RuntimeException("해당 아이디의 기업(" + companyId + ")이 존재하지 않습니다.");
        }
        List<WantedListRespDto> wantedList = wantedsDao.findAllByCompanyId(companyId);
        return wantedList;
    }

    public CompanyDetailRespDto findByIdCompanyId(Integer id) {
        return companysDao.findByIdToDetail(id);
    }

    public List<WantedListRespDto> findAllByPositionCodeId(Integer id) {
        if (positionsCodeDao.findById(id) == null) {
            throw new RuntimeException("해당 포지션(" + id + ")이 존재하지 않습니다.");
        }
        List<WantedListRespDto> wantedList = wantedsDao.findAllByPositionCodeId(id);
        return wantedList;
    }

    public List<WantedListRespDto> findAllBySearch(SearchDto searchDto) {
        return wantedsDao.findAllBySearch(searchDto);
    }

    public List<WantedListRespDto> findAllByLike(Integer userId) {
        return wantedsDao.findAllByLike(userId);
    }

    /* 승현 작업 종료 */
}
