package site.metacoding.miniproject2.domain.applicationStatus;

public interface ApplicationStatusDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    public void findUser();

    public void findCompany();

    public void findCompanyIfNull();

    public void findInfoCounts();

    public void findAll();

    public void findCounts();

    public void findWaiting();

    public void findFinal();

    public void findRequest();
}
