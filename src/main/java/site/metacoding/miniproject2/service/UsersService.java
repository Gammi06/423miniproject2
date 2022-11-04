package site.metacoding.miniproject2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.users.Users;
import site.metacoding.miniproject2.domain.users.UsersDao;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.UsersReqDto.JoinReqDto;
import site.metacoding.miniproject2.dto.UsersReqDto.LoginReqDto;
import site.metacoding.miniproject2.dto.UsersRespDto.InfoAllRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.InfoCountRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.InfoRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.JoinRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.RecommendByPositionRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.StatusCountRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.UsersInfoRespDto;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersDao usersDao;

    public JoinRespDto insert(JoinReqDto joinReqDto) {
        Users users = joinReqDto.toEntity();
        usersDao.insert(users);
        return new JoinRespDto(users);
    }

    // public JoinRespDto insert(JoinReqDto joinReqDto) {
    // Optional<AuthReqDto> usersPS =
    // usersDao.findAllUserId(joinReqDto.getUserId());
    // if (usersPS.isPresent()) {
    // throw new RuntimeException("중복된 아이디 입니다.");
    // }
    // Users users = joinReqDto.toEntity();
    // usersDao.insert(users);
    // return new JoinRespDto(users);
    // }

    public SessionUsers findByUserId(LoginReqDto loginReqDto) {
        Users usersPS = usersDao.findByUserId(loginReqDto.getId());
        if (usersPS.getUserPassword().equals(loginReqDto.getUserPassword())) {
            return null;
        } else {
            throw new RuntimeException("아이디 혹은 패스워드가 잘못 입력되었습니다.");
        }
    }

    public List<UsersInfoRespDto> findById(Integer id) {
        return usersDao.findById(id);
    }

    public void update() {
        usersDao.update();
    }

    public void updateByPassword() {
        usersDao.updateByPassword(null);
    }

    @Transactional
    public void deleteById(Integer id) {
        List<UsersInfoRespDto> usersPS = usersDao.findById(id);
        if (usersPS == null) {
            throw new RuntimeException("아이디 값이 잘못 됐습니다.");
        }
        usersDao.deleteById(id);
    }

    public void updateProfile() {
        usersDao.updateProfile();
    }

    // 서현 작업
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