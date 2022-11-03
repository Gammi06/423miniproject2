package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.applys.ApplysDao;
import site.metacoding.miniproject2.dto.ApplyReqDto.ApplyUserReqDto;
import site.metacoding.miniproject2.dto.ApplyRespDto.ApplyFindByIdRespDto;

@RequiredArgsConstructor
@Service
public class ApplyService {

    private final ApplysDao applysDao;

    public ApplyFindByIdRespDto findById(Integer id) {
        return applysDao.findById(id);
    }

    public void insert(ApplyUserReqDto applyUserReqDto) {
        applysDao.insert(applyUserReqDto);

    }

    public void deleteById(Integer id) {
        applysDao.deleteById(id);
    }
}
