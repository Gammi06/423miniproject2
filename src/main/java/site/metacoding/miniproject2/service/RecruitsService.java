package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.recruits.RecruitsDao;

@RequiredArgsConstructor
@Service
public class RecruitsService {

    private final RecruitsDao recruitsDao;
}
