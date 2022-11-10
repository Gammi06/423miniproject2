package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.likes.LikesDao;
import site.metacoding.miniproject2.domain.wanteds.WantedsDao;
import site.metacoding.miniproject2.dto.LikesReqDto.LikesInsertReqDto;
import site.metacoding.miniproject2.dto.LikesRespDto.LikeFindByIdRespDto;
import site.metacoding.miniproject2.dto.LikesRespDto.LikeInsertRespDto;
import site.metacoding.miniproject2.handler.MyApiException;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class LikesService {

    private final WantedsDao wantedsDao;
    private final LikesDao likesDao;

    /* 승현 작업 시작 */
    public LikeFindByIdRespDto findById(LikesInsertReqDto likesInsertReqDto) {
        return likesDao.findByLike(likesInsertReqDto);
    }
    /* 지원 작업종료 */

    @Transactional
    public LikeInsertRespDto insert(LikesInsertReqDto likesInsertReqDto) {

        // 중복 체크
        if (wantedsDao.findById(likesInsertReqDto.getWantedId()) == null) {
            throw new MyApiException("공고가 없습니다.");
        }
        if (likesDao.findByLike(likesInsertReqDto) != null) {
            throw new MyApiException("해당 공고에 이미 좋아요를 했습니다.");
        }

        likesDao.insert(likesInsertReqDto);
        return new LikeInsertRespDto(likesInsertReqDto);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(LikesInsertReqDto likesInsertReqDto) {

        // 중복 체크
        if (likesDao.findByLike(likesInsertReqDto) == null) {
            throw new MyApiException("좋아요를 취소할 수 없습니다.");
        }
        likesDao.delete(likesInsertReqDto);
    }
    /* 승현 작업 종료 */

}
