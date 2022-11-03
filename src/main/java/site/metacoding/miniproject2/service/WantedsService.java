package site.metacoding.miniproject2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.wanteds.WantedsDao;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedsListRespDto;

@RequiredArgsConstructor
@Service
public class WantedsService {

    private final WantedsDao wantedsDao;

    public void insert() {
        wantedsDao.insert();
    }

    public List<WantedsListRespDto> findByIdCompanyId(Integer id) {
        return null;
    }

}
