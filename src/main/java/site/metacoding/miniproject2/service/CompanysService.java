package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.companys.CompanysDao;

@RequiredArgsConstructor
@Service
public class CompanysService {

    private final CompanysDao companysDao;

    public void insert() {
        companysDao.insert();
    }

    public void findByIdCompanysNumber(String companyNumber) {
        companysDao.findByIdCompanysNumber(companyNumber);
    }

    public void findByIdToDetail(Integer id) {
        companysDao.findByIdToDetail(id);
    }
}