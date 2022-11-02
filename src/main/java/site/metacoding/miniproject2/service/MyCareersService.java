package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.myCareers.MyCareersDao;

@RequiredArgsConstructor
@Service
public class MyCareersService {
    private final MyCareersDao myCareersDao;

    public void findAll() {
        myCareersDao.findAll();
    }

    public void findById() {
        myCareersDao.findById(null);
    }

    public void insert() {
        myCareersDao.insert();
    }

}
