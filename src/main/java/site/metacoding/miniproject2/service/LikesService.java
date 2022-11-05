package site.metacoding.miniproject2.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import site.metacoding.miniproject2.domain.likes.LikesDao;
import site.metacoding.miniproject2.domain.wanteds.WantedsDao;
import site.metacoding.miniproject2.dto.LikesReqDto.LikesInsertReqDto;
import site.metacoding.miniproject2.dto.LikesRespDto.LikeFindByIdRespDto;
import site.metacoding.miniproject2.dto.LikesRespDto.LikeInsertRespDto;
import site.metacoding.miniproject2.dto.SessionUsers;

@Slf4j
@RequiredArgsConstructor
@Service
public class LikesService {

    private final WantedsDao wantedsDao;
    private final LikesDao likesDao;
    private final HttpSession session;

    public LikeFindByIdRespDto findById(LikesInsertReqDto likesInsertReqDto) {
        return likesDao.findByLike(likesInsertReqDto);
    }

    public LikeInsertRespDto insert(LikesInsertReqDto likesInsertReqDto) {
        // 중복 체크
        if (likesDao.findByLike(likesInsertReqDto) == null) {
            throw new RuntimeException("해당 공고에 이미 좋아요를 했습니다.");
        }

        likesDao.insert(likesInsertReqDto);
        return LikeInsertRespDto.builder()
                .userId(likesInsertReqDto
                        .getUserId())
                .wantedId(likesInsertReqDto.getWantedId())
                .build();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(LikesInsertReqDto likesInsertReqDto) {
        SessionUsers principal = (SessionUsers) session.getAttribute("principal");
        // if (likesDao.findByLike(likesInsertReqDto) != null) {
        // throw new RuntimeException("잘못된 접근입니다. 1");
        // }
        // if (likesDao.findByLike(likesInsertReqDto).getUserId() != principal.getId())
        // {
        // throw new RuntimeException("잘못된 접근입니다.");
        // }
        // if (likesDao.findByLike(likesInsertReqDto) == null) {
        // throw new RuntimeException("이미 취소되었습니다.");
        // }
        likesDao.delete(likesInsertReqDto);
    }

}
