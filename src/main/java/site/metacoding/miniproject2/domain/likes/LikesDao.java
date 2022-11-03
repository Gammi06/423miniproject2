package site.metacoding.miniproject2.domain.likes;

import site.metacoding.miniproject2.dto.LikesReqDto.LikesInsertReqDto;
import site.metacoding.miniproject2.dto.LikesRespDto.LikeFindByIdRespDto;

//작업자: 지원, 승현
public interface LikesDao {

    /* 승현 작업함 */

    public LikeFindByIdRespDto findById(Integer id);

    public void insert(LikesInsertReqDto likesInsertReqDto);

    public void deleteById(Integer id);

    /* 승현 작업 종료 */
}
