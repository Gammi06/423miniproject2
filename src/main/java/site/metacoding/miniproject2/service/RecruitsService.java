package site.metacoding.miniproject2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.recruits.RecruitsDao;
import site.metacoding.miniproject2.dto.RecruitsRespDto.RecruitsApplyManageRespDto;
import site.metacoding.miniproject2.dto.RecruitsRespDto.RecruitsRecommendByPositionRespDto;
import site.metacoding.miniproject2.dto.RecruitsRespDto.RecruitsRecommendRespDto;

@RequiredArgsConstructor
@Service
public class RecruitsService {

    private final RecruitsDao recruitsDao;

    public List<RecruitsApplyManageRespDto> findApplyManage(Integer companysId) {
        List<RecruitsApplyManageRespDto> recruitsApplyManageList = recruitsDao.findApplyManage(companysId);
        return recruitsApplyManageList;
    }

    public List<RecruitsRecommendRespDto> findRecommend(Integer companysId) {
        List<RecruitsRecommendRespDto> recruitsRecommendList = recruitsDao.findRecommend(companysId);
        return recruitsRecommendList;
    }

    public List<RecruitsRecommendByPositionRespDto> findRecommendByPosition(Integer companysId,
            Integer positionsCodeId) {
        List<RecruitsRecommendByPositionRespDto> recruitsRecommendByPositionList = recruitsDao
                .findRecommendByPosition(companysId, positionsCodeId);
        return recruitsRecommendByPositionList;
    }
}
