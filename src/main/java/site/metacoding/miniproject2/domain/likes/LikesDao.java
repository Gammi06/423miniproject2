package site.metacoding.miniproject2.domain.likes;

import site.metacoding.miniproject2.dto.LikesReqDto.LikesInsertReqDto;
import site.metacoding.miniproject2.dto.LikesRespDto.LikeFindByIdRespDto;

//작업자: 지원, 승현ㄴ
public interface LikesDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    // 공고 관련인 거 같은데 왜 여기 있지? => 지원이한테 물어보기
    public void findLikes();

    /* >>>> 승현 작업함 <<<< */

    public LikeFindByIdRespDto findById(Integer id);

    public void insert(LikesInsertReqDto likesInsertReqDto);

    public void deleteById(Integer id);

    /* >>>> 승현 작업 종료 <<<< */
}
