package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.mySkills.MySkillsDao;

@RequiredArgsConstructor
@Service
public class MySkillsService {
    private final MySkillsDao mySkillsDao;

    public void insert() {
        mySkillsDao.insertMySkills();
    }
}
