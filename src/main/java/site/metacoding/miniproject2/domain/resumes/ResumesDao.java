package site.metacoding.miniproject2.domain.resumes;

import java.util.List;

/* >>>> 연지 작업함 <<<< */
public interface ResumesDao {

    public void insert();

    public List<Resumes> findAll();

    public Resumes findById(Integer id);

    public void updateById(Integer id, Resumes resumes);

    public void deleteById(Integer id);

}
/* >>>> 연지 작업종료 <<<< */