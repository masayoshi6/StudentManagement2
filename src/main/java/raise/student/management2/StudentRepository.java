package raise.student.management2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM student WHERE name=#{name}")
  Student c(String name);

  @Insert("INSERT student values(#{name},#{age})")
  void e(String name, int age);


}
