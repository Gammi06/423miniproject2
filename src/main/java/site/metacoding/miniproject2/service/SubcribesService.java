package site.metacoding.miniproject2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.subcribes.SubcribesDao;
import site.metacoding.miniproject2.dto.SubribesRespDto.SubscribesListRespDto;

@RequiredArgsConstructor
@Service
public class SubcribesService {
    private final SubcribesDao subcribesDao;

    public List<SubscribesListRespDto> subcribesListPage(Integer id) {
        List<SubscribesListRespDto> subcribesList = subcribesDao.subcribesListPage(id);

        List<SubscribesListRespDto> subscribesListRespDto = new ArrayList<>();
        for (SubscribesListRespDto subcribes : subcribesList) {
            subscribesListRespDto.add(new SubscribesListRespDto(subcribes));
        }
        return subcribesList;
    }

}
