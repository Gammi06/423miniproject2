package site.metacoding.miniproject2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.wanteds.WantedsDao;
import site.metacoding.miniproject2.dto.WantedsRespDto.SearchDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedDetailRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;

@RequiredArgsConstructor
@Service
public class WantedsService {

    private final WantedsDao wantedsDao;

    public void insert() {
        wantedsDao.insert();
    }

    public List<WantedListRespDto> findAll(SearchDto searchDto) {
        if (searchDto == null) {
            List<WantedListRespDto> wantedList = wantedsDao.findAll();
            return wantedList;
        }
        List<WantedListRespDto> wantedList = wantedsDao.findAllOrdered(searchDto);
        return wantedList;
    }

    public WantedDetailRespDto findById(Integer id) {
        WantedDetailRespDto wantedPS = wantedsDao.findById(id);
        return wantedPS;
    }

    public List<WantedListRespDto> findAllByCompanyId(Integer companyId) {
        // company의 findById 추가하기
        List<WantedListRespDto> wantedList = wantedsDao.findAllByCompanyId(companyId);
        return wantedList;
    }

    public List<WantedListRespDto> findAllByPosition(Integer positionCodeId) {
        // position의 findById 추가하기
        // id를 string으로 바꾸는 코드 추가하기
        String positionCodeName = null;
        List<WantedListRespDto> wantedList = wantedsDao.findAllByPositionCodeName(positionCodeName);
        return wantedList;
    }
}
