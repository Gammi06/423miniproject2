package site.metacoding.miniproject2.domain.users;

import java.util.List;

import site.metacoding.miniproject2.dto.UsersReqDto.EditReqDto;
import site.metacoding.miniproject2.dto.UsersReqDto.JoinReqDto;
import site.metacoding.miniproject2.dto.UsersReqDto.PasswordEditReqDto;
import site.metacoding.miniproject2.dto.UsersRespDto.AuthRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.InfoCountRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.InfoRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.JoinRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.RecommendByPositionRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.SessionCompanyRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.StatusCountRespDto;
import site.metacoding.miniproject2.dto.UsersRespDto.UsersInfoRespDto;

public interface UsersDao {
    // 이름 규칙에 맞는 메서드명으로 생성해주세요.

    // 성유 작업 시작
    public AuthRespDto findByUserId(String usersId); // 로그인

    public SessionCompanyRespDto findByCompanyId(Integer id);

    public JoinRespDto findAllId(Integer id);

    public UsersInfoRespDto findById(Integer id);

    public void update(EditReqDto editReqDto); // 계정설정-기본정보 수정

    public void updatePassword(PasswordEditReqDto passwordEditReqDto); // 비밀번호 변경

    public void deleteById(Integer id); // 회원탈퇴

    public void updateProfile();// 프로필 수정

    public void insert(JoinReqDto joinReqDto);
    // 성유 작업 종료

    // 서현 작업 시작

    public List<InfoRespDto> findInfo(Integer id);

    public List<InfoCountRespDto> findInfoCounts(Integer id);

    public List<RecommendByPositionRespDto> findByPosition(Integer id);

    public List<RecommendByPositionRespDto> findByPositionIfNull();

    public List<StatusCountRespDto> findStatusCounts(Integer id);

    // 서현 작업 종료
}
