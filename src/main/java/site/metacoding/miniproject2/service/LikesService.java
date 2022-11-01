package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.likes.LikesDao;
import site.metacoding.miniproject2.dto.LikesReqDto.LikesInsertReqDto;

@RequiredArgsConstructor
@Service
public class LikesService {

    private final LikesDao likesDao;

    public void findLikes() {

    }

    public LikesInsertReqDto findById(Integer id) {
        return null;
    }

    public LikesInsertReqDto insertLike() {
        return null;
    }

    public void deleteById(Integer id) {
        likesDao.deleteById(id);
    }

}
