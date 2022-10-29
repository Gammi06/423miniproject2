package site.metacoding.miniproject2.domain.users;

public interface UsersDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    public void findByUserId();

    public void findById();

    public void update();

    public void updateByPassword();

    public void deleteById();
}
