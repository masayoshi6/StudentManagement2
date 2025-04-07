package raise.student.management2;

import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM student")
  List<Student> c();

  @Insert("INSERT student values(#{name},#{age})")
  void e(String name, int age);

  @Update("UPDATE student SET age=#{age} WHERE name=#{name}")
  void update(String name, int age);

  @Delete("DELETE FROM student WHERE name = #{name}")
  void delete(String name);

  @Select("SELECT * FROM student")
  List<Student> f();


  @Select("SELECT * FROM students WHERE name=#{name}")
  Students g(String name);

  @Insert("INSERT students values(#{id}, #{name}, #{kanaName}, #{nickname}, "
      + "#{email}, #{area}, #{age}, #{sex})")
  void h(String id, String name, String kanaName, String nickname, String email,
      String area, int age, String sex);

  @Update("UPDATE students SET age=#{age}, nickname=#{nickname} WHERE name=#{name}")
  void i(String name, int age, String nickname);

  @Delete("DELETE FROM students WHERE id = #{id}")
  void j(String id);

  @Select("SELECT * FROM students")
  List<Students> k();


  @Select("SELECT * FROM students_courses WHERE id=#{id}")
  StudentCourse l(String id);

  @Insert("INSERT students_courses values(#{id}, #{studentId}, #{courseName}, "
      + "#{courseStartAt}, #{courseEndAt})")
  void m(String id, String studentId, String courseName,
      LocalDateTime courseStartAt, LocalDateTime courseEndAt);

  @Update("UPDATE students_courses SET courseName=#{courseName} WHERE id=#{id}")
  void n(String id, String courseName);

  @Delete("DELETE FROM students_courses WHERE id = #{id}")
  void o(String id);

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> p();

}
