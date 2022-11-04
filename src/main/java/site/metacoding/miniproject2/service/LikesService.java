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
    
    public LikeFindByIdRespDto findById(Integer id) {
        return likesDao.findById(id);
    }

    public void insert(LikesInsertReqDto likesInsertReqDto) {
        likesDao.insert(likesInsertReqDto);
    }

    public void deleteById(Integer id) {
        likesDao.deleteById(id);
    }

}
