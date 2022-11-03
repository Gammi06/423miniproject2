package site.metacoding.miniproject2.domain.users;

public interface UsersDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    public Users findByUserId(Integer usersId); // 로그인

    public void findById(Integer id);

    public void update(); // 계정설정-기본정보 수정

    public void updatePassword(String password); // 비밀번호 변경

    public void deleteById(Integer id); // 회원탈퇴

    public void insert(); // 회원가입

    public void updateProfile();// 프로필 수정
}
