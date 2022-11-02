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
public class notWantedService {

    private final WantedsDao wantedsDao;

    public List<WantedListRespDto> findAll(SearchDto searchDto) {
        if (searchDto.getSortType().equals(null) ||
                searchDto.getSortType().equals(0))
            searchDto.setSortType(1);

        List<WantedListRespDto> wantedList = wantedsDao.findAll(searchDto);
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

    public List<WantedListRespDto> findAllByPositionCodeId(Integer positionCodeId) {
        // position의 findById 추가하기
        List<WantedListRespDto> wantedList = wantedsDao.findAllByPositionCodeId(positionCodeId);
        return wantedList;
    }

}
