package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.wanteds.WantedsDao;

@RequiredArgsConstructor
@Service
public class WantedsService {

    private final WantedsDao wantedsDao;

    public void insert() {
        wantedsDao.insert();
    }

    public Object findByIdCompanyId(Integer id) {
        return null;
    }

}
