package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.mySkills.MySkillsDao;
import site.metacoding.miniproject2.dto.MySkillsRespDto.WantedsSkillsRespDto;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MySkillsService {
    private final MySkillsDao mySkillsDao;

    @Transactional
    public void insert(WantedsSkillsRespDto wantedsSkillsRespDto) {
        mySkillsDao.insertMySkills(wantedsSkillsRespDto);
    }

}
