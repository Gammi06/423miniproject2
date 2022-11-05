package site.metacoding.miniproject2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.likes.LikesDao;
import site.metacoding.miniproject2.domain.wanteds.WantedsDao;
import site.metacoding.miniproject2.dto.LikesReqDto.LikesInsertReqDto;
import site.metacoding.miniproject2.dto.LikesRespDto.LikeFindByIdRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;

@RequiredArgsConstructor
@Service
public class LikesService {

    private final LikesDao likesDao;
    private final WantedsDao wantedsDao;

    /* 지원 작업 */
    public List<WantedListRespDto> findById(Integer userId) {
        return wantedsDao.findAllByLike(userId);
    }
    /* 지원 작업종료 */

    public void insert(LikesInsertReqDto likesInsertReqDto) {
        if (likesInsertReqDto.getUserId() == null) {
            throw new RuntimeException("로그인을 해주세요.");
        }
        if (likesDao.findByLike(likesInsertReqDto) == null) {
            throw new RuntimeException("해당 공고에는 이미 좋아요를 했습니다.");
        }
        likesDao.insert(likesInsertReqDto);
    }

    public void delete(LikesInsertReqDto likesInsertReqDto) {
        if (likesInsertReqDto.getUserId() == null) {
            throw new RuntimeException("로그인을 해주세요.");
        }
        if (likesDao.findByLike(likesInsertReqDto) == null) {
            throw new RuntimeException("해당 공고에는 좋아요를 하지 않았습니다.");
        }
        likesDao.delete(likesInsertReqDto);
    }

    public List<WantedListRespDto> findAllByLike(Integer id) {
        return null;
    }

}
