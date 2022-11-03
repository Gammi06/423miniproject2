package site.metacoding.miniproject2.domain.recruits;

import java.util.List;

import site.metacoding.miniproject2.dto.RecruitsRespDto.RecruitsApplyManageRespDto;
import site.metacoding.miniproject2.dto.RecruitsRespDto.RecruitsRecommendRespDto;

public interface RecruitsDao {
    public List<RecruitsApplyManageRespDto> findApplyManage(Integer companysId);

    public List<RecruitsRecommendRespDto> findRecommend(Integer companysId);
}
