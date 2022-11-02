package site.metacoding.miniproject2.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.miniproject2.domain.users.UsersDao;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersDao usersDao;

    public void findByUserId() {
        usersDao.findByUserId(null);
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
