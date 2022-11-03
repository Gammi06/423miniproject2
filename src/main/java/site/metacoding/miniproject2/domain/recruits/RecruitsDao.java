package site.metacoding.miniproject2.domain.recruits;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.metacoding.miniproject2.dto.RecruitsRespDto.RecruitsApplyManageRespDto;
import site.metacoding.miniproject2.dto.RecruitsRespDto.RecruitsRecommendByPositionRespDto;
import site.metacoding.miniproject2.dto.RecruitsRespDto.RecruitsRecommendRespDto;

public interface RecruitsDao {
    public List<RecruitsApplyManageRespDto> findApplyManage(Integer companysId);

    public List<RecruitsRecommendRespDto> findRecommend(Integer companysId);

    public List<RecruitsRecommendByPositionRespDto> findRecommendByPosition(@Param("companysId") Integer companysId,
            @Param("positionsCodeId") Integer positionsCodeId);
}
