package site.metacoding.miniproject2.domain.recruits;

import java.util.List;

import site.metacoding.miniproject2.dto.RecruitsRespDto.RecruitsApplyManageRespDto;
import site.metacoding.miniproject2.dto.RecruitsRespDto.RecruitsRecommendRespDto;

public interface RecruitsDao {
    public void insert();

    public void findAll();

    public void findById();

    public void updateById();

    public void deleteById();

    public List<RecruitsApplyManageRespDto> findApplyManage();

    public List<RecruitsRecommendRespDto> findRecommend();
}
