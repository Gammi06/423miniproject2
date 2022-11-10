package site.metacoding.miniproject2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.recruits.RecruitsDao;
import site.metacoding.miniproject2.dto.RecruitsRespDto.RecruitsApplyManageRespDto;
import site.metacoding.miniproject2.dto.RecruitsRespDto.RecruitsRecommendByPositionRespDto;
import site.metacoding.miniproject2.dto.RecruitsRespDto.RecruitsRecommendRespDto;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class RecruitsService {

    private final RecruitsDao recruitsDao;

    public List<RecruitsApplyManageRespDto> findApplyManage(Integer companysId) {
        List<RecruitsApplyManageRespDto> recruitsApplyManageList = recruitsDao.findApplyManage(companysId);
        return recruitsApplyManageList;
    }

    public List<RecruitsRecommendRespDto> findRecommend() {
        List<RecruitsRecommendRespDto> recruitsRecommendList = recruitsDao.findRecommend();
        return recruitsRecommendList;
    }

    public List<RecruitsRecommendByPositionRespDto> findRecommendByPosition(Integer companysId,
            Integer positionsCodeId) {
        List<RecruitsRecommendByPositionRespDto> recruitsRecommendByPositionList = recruitsDao
                .findRecommendByPosition(companysId, positionsCodeId);
        return recruitsRecommendByPositionList;
    }
}
