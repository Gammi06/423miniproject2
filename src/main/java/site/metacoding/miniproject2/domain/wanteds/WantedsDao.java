package site.metacoding.miniproject2.domain.wanteds;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsSaveReqDto;
import site.metacoding.miniproject2.dto.WantedsReqDto.WantedsUpdateReqDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.SearchDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedDetailRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedLisLikestRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedListRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedsRecruitsManageCareersRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedsRecruitsManagePositionsRespDto;
import site.metacoding.miniproject2.dto.WantedsRespDto.WantedsRecruitsManageRespDto;

public interface WantedsDao {
        // 이름 규칙에 맞는 메서드명으로 생성해주세요.

        public void updateViewCount(Integer id);

        public WantedDetailRespDto findById(Integer id);

        public List<WantedListRespDto> findAll();

        public List<WantedListRespDto> findAllByCompanyId(Integer companyId);

        public List<WantedListRespDto> findAllByPositionCodeId(Integer positionCodeId);

        public List<WantedListRespDto> findAllByLike(Integer userId);

        public List<WantedListRespDto> findAllBySearch(SearchDto searchDto);

        public void save(WantedsSaveReqDto wantedsSaveReqDto);

        public void update(WantedsUpdateReqDto wantedsUpdateReqDto);

        public void deleteById(Integer id);

        public List<WantedsRecruitsManageRespDto> findByCompanysId(Integer companyId);

        public List<WantedsRecruitsManageCareersRespDto> findByCareersId(@Param("companyId") Integer companyId,
                        @Param("careerCodeId") Integer careerCodeId);

        public List<WantedsRecruitsManagePositionsRespDto> findByPositionsId(@Param("companyId") Integer companyId,
                        @Param("positionCodeId") Integer positionCodeId);

        public List<WantedsRecruitsManageRespDto> findByBothIds(@Param("companyId") Integer companyId,
                        @Param("careerCodeId") Integer careerCodeId,
                        @Param("positionCodeId") Integer positionCodeId);

        /* 지원 작업 */
        public List<WantedLisLikestRespDto> findLikeList(Integer userId);
        /* 지원작업종료 */

        /* ///////// 삭제 내역 //////// */
        // public void findAllByPosition();
        // public void findAllHot();

        // public void findBestHot();
}
