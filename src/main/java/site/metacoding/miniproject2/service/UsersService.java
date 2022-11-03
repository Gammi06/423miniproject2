package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.users.Users;
import site.metacoding.miniproject2.domain.users.UsersDao;
import site.metacoding.miniproject2.dto.SessionUsers;
import site.metacoding.miniproject2.dto.UsersReqDto.LoginReqDto;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersDao usersDao;

    @Transactional
    public SessionUsers findByUserId(LoginReqDto loginReqDto) {
        Users usersPS = usersDao.findByUserId(loginReqDto.getId());
        if (usersPS.getUserPassword().equals(loginReqDto.getUserPassword())) {
            return new SessionUsers(usersPS);
        } else {
            throw new RuntimeException("아이디 혹은 패스워드가 잘못 입력되었습니다.");
        }
    }

    public void findById() {
        usersDao.findById(null);
    }

    public void update() {
        usersDao.update();
    }

    public void updatePassword() {
        usersDao.updatePassword(null);
    }

    public void deleteById() {
        usersDao.deleteById(null);
    }

    public void insert() {
        usersDao.insert();
    }

    public void updateProfile() {
        usersDao.updateProfile();
    }

}
