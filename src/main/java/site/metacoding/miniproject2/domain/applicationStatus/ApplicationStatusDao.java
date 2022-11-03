package site.metacoding.miniproject2.domain.applicationStatus;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusAllCountRespDto;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusAllInfoRespDto;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusFinalCountRespDto;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusFinalInfoRespDto;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusWaitingCountRespDto;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusWaitingInfoRespDto;

public interface ApplicationStatusDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    public List<ApplicationStatusAllCountRespDto> findAllCounts(Integer id);

    public List<ApplicationStatusAllInfoRespDto> findAllInfos(@Param("id") Integer id,
            @Param("keyword") String keyword);

    public List<ApplicationStatusWaitingCountRespDto> findWaitingCounts(Integer id);

    public List<ApplicationStatusWaitingInfoRespDto> findWaitingInfos(@Param("id") Integer id,
            @Param("keyword") String keyword);

    public List<ApplicationStatusFinalCountRespDto> findFinalCounts(Integer id);

    public List<ApplicationStatusFinalInfoRespDto> findFinalInfos(@Param("id") Integer id,
            @Param("keyword") String keyword);
}
