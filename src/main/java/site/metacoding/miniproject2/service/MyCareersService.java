package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.myCareers.MyCareersDao;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MyCareersService {
    private final MyCareersDao myCareersDao;

    public void findAll() {
        myCareersDao.findAll();
    }

    public void findById(Integer id) {
        myCareersDao.findById(id);
    }

    @Transactional
    public void insert() {
        myCareersDao.insert();
    }

}
