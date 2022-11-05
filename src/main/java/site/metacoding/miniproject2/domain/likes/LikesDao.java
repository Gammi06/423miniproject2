package site.metacoding.miniproject2.domain.likes;

import site.metacoding.miniproject2.dto.LikesReqDto.LikesInsertReqDto;
import site.metacoding.miniproject2.dto.LikesRespDto.LikeFindByIdRespDto;

//작업자: 지원, 승현
public interface LikesDao {

    /* 승현 작업함 */

    public LikeFindByIdRespDto findByLike(LikesInsertReqDto likesInsertReqDto);

    public void insert(LikesInsertReqDto likesInsertReqDto);

    public void delete(LikesInsertReqDto likesInsertReqDto);

    /* 승현 작업 종료 */
}
