package site.metacoding.miniproject2.domain.subscribes;

import site.metacoding.miniproject2.dto.SubribesReqDto.SubcribesInsertReqDto;
import site.metacoding.miniproject2.dto.SubribesRespDto.SubribesFindByIdRespDto;

public interface subscribesDao {
    /* 승현 작업함 */

    public SubribesFindByIdRespDto findById(Integer id);

    public SubribesFindByIdRespDto findBySub(SubcribesInsertReqDto subcribesInsertReqDto);

    public void insertSub(SubcribesInsertReqDto subcribesInsertReqDto);

    public void deleteById(Integer id);

    /* 승현 작업 종료 */
}
