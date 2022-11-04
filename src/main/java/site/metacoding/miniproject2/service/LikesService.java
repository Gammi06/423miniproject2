package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.likes.LikesDao;
import site.metacoding.miniproject2.dto.LikesReqDto.LikesInsertReqDto;
import site.metacoding.miniproject2.dto.LikesRespDto.LikeFindByIdRespDto;

@RequiredArgsConstructor
@Service
public class LikesService {

    private final LikesDao likesDao;

    public LikeFindByIdRespDto findById(LikesInsertReqDto likesInsertReqDto) {
        return likesDao.findByLike(likesInsertReqDto);
    }

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

}
