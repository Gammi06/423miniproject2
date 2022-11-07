package site.metacoding.miniproject2.domain.requests;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.metacoding.miniproject2.dto.RequestsRespDto.RequestsInfoRespDto;

public interface RequestsDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.
    public List<RequestsInfoRespDto> findRequests(@Param("id") Integer id,
            @Param("keyword") String keyword);
}
