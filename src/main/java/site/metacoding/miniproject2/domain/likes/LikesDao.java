package site.metacoding.miniproject2.domain.likes;

import site.metacoding.miniproject2.dto.LikesRespDto.LikeRespDto;

public interface LikesDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    /* >>>> 승현 작업함 <<<< */
    public void findLikes();

    public LikeRespDto findById(Integer id);

    public void insert();

    public void deleteById(Integer id);

    /* >>>> 승현 작업 종료 <<<< */
}
