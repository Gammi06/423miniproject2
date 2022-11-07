package site.metacoding.miniproject2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.users.UsersDao;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.UsersReqDto.EditReqDto;
import site.metacoding.miniproject2.dto.UsersReqDto.JoinReqDto;
import site.metacoding.miniproject2.dto.UsersReqDto.LoginReqDto;
import site.metacoding.miniproject2.dto.UsersReqDto.PasswordEditReqDto;
import site.metacoding.miniproject2.dto.UsersRespDto.AuthRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.EditRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.InfoAllRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.InfoCountRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.InfoRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.JoinRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.PasswordEditRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.RecommendByPositionRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.SessionCompanyRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.StatusCountRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.UsersInfoRespDto;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersDao usersDao;

    public JoinRespDto insert(JoinReqDto joinReqDto) {
        usersDao.insert(joinReqDto);
        JoinRespDto joinRespDto = usersDao.findAllId(joinReqDto.getId());
        return joinRespDto;
    }

    public SessionUsers findByUserId(LoginReqDto loginReqDto) {
        AuthRespDto userPS = usersDao.findByUserId(loginReqDto.getUserId());
        if (userPS.getUserPassword().equals(loginReqDto.getUserPassword())) {
            if (userPS.getRole().equals("회사")) {
                SessionCompanyRespDto sessionCompanyRespDto = usersDao.findByCompanyId(userPS.getId());
                sessionCompanyRespDto.setId(userPS.getId());
                userPS.setCompanyId(sessionCompanyRespDto.getCompanyId());
                return new SessionUsers(userPS);
            } else {
                return new SessionUsers(userPS);
            }

        } else {
            throw new RuntimeException("아이디 혹은 패스워드가 잘못 입력되었습니다.");
        }
    }

    public UsersInfoRespDto findById(Integer id) {
        return usersDao.findById(id);
    }

    public EditRespDto update(EditReqDto editReqDto) {
        UsersInfoRespDto usersPS = usersDao.findById(editReqDto.getId());
        if (usersPS == null) {
            throw new RuntimeException("잘못된 아이디값입니다.");
        }
        usersDao.update(editReqDto);
        return new EditRespDto(usersPS);
    }

    public PasswordEditRespDto updatePassword(PasswordEditReqDto passwordEditReqDto) {
        UsersInfoRespDto usersPS = usersDao.findById(passwordEditReqDto.getId());
        if (usersPS == null) {
            throw new RuntimeException("잘못된 아이디값입니다.");
        }
        usersDao.updatePassword(passwordEditReqDto);
        return new PasswordEditRespDto(usersPS);
    }

    @Transactional
    public void deleteById(Integer id) {
        UsersInfoRespDto usersPS = usersDao.findById(id);
        if (usersPS == null) {
            throw new RuntimeException("아이디 값이 잘못 됐습니다.");
        }
        usersDao.deleteById(id);
    }

    public void updateProfile() {
        usersDao.updateProfile();
    }

    // 서현 작업
    public Optional<AuthRespDto> findByUserIdOP(LoginReqDto loginReqDto) {
        try {
            Optional<AuthRespDto> usersOP = Optional.of(
                    usersDao.findByUserId(loginReqDto.getUserId()));
            return usersOP;
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public InfoAllRespDto findAllInfo(Integer id) {
        List<InfoRespDto> infoRespDtos = usersDao.findInfo(id);
        List<InfoCountRespDto> infoCountRespDtos = usersDao.findInfoCounts(id);
        List<RecommendByPositionRespDto> recommendByPositionRespDtos = usersDao.findByPosition(id);
        if (recommendByPositionRespDtos.size() == 0) {
            recommendByPositionRespDtos = usersDao.findByPositionIfNull();
        }
        List<StatusCountRespDto> statusCountRespDtos = usersDao.findStatusCounts(id);
        InfoAllRespDto InfoAllRespDto = new InfoAllRespDto(infoRespDtos, infoCountRespDtos, recommendByPositionRespDtos,
                statusCountRespDtos);
        return InfoAllRespDto;
    }
    // 서현 작업 종료
}