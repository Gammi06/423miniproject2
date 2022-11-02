package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.recruits.RecruitsDao;

@RequiredArgsConstructor
@Service
public class RecruitsService {

    private final RecruitsDao recruitsDao;

    public void insert() {
        recruitsDao.insert();
    }

    public void findAll() {
        recruitsDao.findAll();
    }

    public void findById() {
        recruitsDao.findById();
    }

    public void updateById() {
        recruitsDao.updateById();
    }

    public void deleteById() {
        recruitsDao.deleteById();
    }
}
