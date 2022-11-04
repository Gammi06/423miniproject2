package site.metacoding.miniproject2.domain.resumes;

import java.util.List;

/* >>>> 연지 작업함 <<<< */
public interface ResumesDao {

    public int insert(Resumes resumes);

    public List<Resumes> findAll();

    public Resumes findById(Integer id);

    public int updateById(Integer id, Resumes resumes);

    public int deleteById(Integer id);

}
/* >>>> 연지 작업종료 <<<< */