package site.metacoding.miniproject2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.applicationStatus.ApplicationStatusDao;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusAllCountRespDto;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusAllInfoRespDto;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusAllListRespDto;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusFinalCountRespDto;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusFinalInfoRespDto;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusFinalListRespDto;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusWaitingCountRespDto;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusWaitingInfoRespDto;
import site.metacoding.miniproject2.dto.ApplicationStatusRespDto.ApplicationStatusWaitingListRespDto;

@RequiredArgsConstructor
@Service
public class ApplicationStatusService {

    private final ApplicationStatusDao applicationStatusDao;

    public ApplicationStatusAllListRespDto findAllList(Integer id, String keyword) {
        List<ApplicationStatusAllCountRespDto> applicationStatusAllCountRespDtos = applicationStatusDao
                .findAllCounts(id);
        List<ApplicationStatusAllInfoRespDto> applicationStatusAllInfoRespDtos = applicationStatusDao.findAllInfos(id,
                keyword);
        ApplicationStatusAllListRespDto applicationsStatusAllListRespDto = new ApplicationStatusAllListRespDto(
                applicationStatusAllCountRespDtos, applicationStatusAllInfoRespDtos);
        applicationsStatusAllListRespDto.setKeyword(keyword);
        return applicationsStatusAllListRespDto;
    }

    public ApplicationStatusWaitingListRespDto findWaitingList(Integer id, String keyword) {
        List<ApplicationStatusWaitingCountRespDto> applicationStatusWaitingCountRespDtos = applicationStatusDao
                .findWaitingCounts(id);
        List<ApplicationStatusWaitingInfoRespDto> applicationStatusAllInfoRespDtos = applicationStatusDao
                .findWaitingInfos(id, keyword);
        ApplicationStatusWaitingListRespDto applicationStautsWaitingListRespDto = new ApplicationStatusWaitingListRespDto(
                applicationStatusWaitingCountRespDtos, applicationStatusAllInfoRespDtos);
        applicationStautsWaitingListRespDto.setKeyword(keyword);
        return applicationStautsWaitingListRespDto;
    }

    public ApplicationStatusFinalListRespDto findFinalList(Integer id, String keyword) {
        List<ApplicationStatusFinalCountRespDto> applicationStatusFinalCountRespDtos = applicationStatusDao
                .findFinalCounts(id);
        List<ApplicationStatusFinalInfoRespDto> applicationStatusFinalInfoRespDtos = applicationStatusDao
                .findFinalInfos(id, keyword);
        ApplicationStatusFinalListRespDto applicationStautsFinalListRespDto = new ApplicationStatusFinalListRespDto(
                applicationStatusFinalCountRespDtos, applicationStatusFinalInfoRespDtos);
        applicationStautsFinalListRespDto.setKeyword(keyword);
        return applicationStautsFinalListRespDto;
    }

}
