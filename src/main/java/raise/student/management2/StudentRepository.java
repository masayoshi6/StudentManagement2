package raise.student.management2;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
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

  @Insert(
      "INSERT INTO students(name, kana_name, nickname, email, area, age, sex, remark, is_deleted)"
          + " values(#{name}, #{kanaName}, #{nickname}, "
          + "#{email}, #{area}, #{age}, #{sex}, #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
    //@OptionsアノテーションはINSERT（挿入）するときにつけるべきもの
  void h(Students students);

  @Update("UPDATE students SET age=#{age}, nickname=#{nickname} WHERE name=#{name}")
  void i(String name, int age, String nickname);

  @Delete("DELETE FROM students WHERE id = #{id}")
  void j(String id);

  @Select("SELECT * FROM students")
  List<Students> search();

  @Insert("INSERT students_courses(student_id, course_name, course_start_at, course_end_at) "
      + "values(#{studentId}, #{courseName}, #{courseStartAt}, #{courseEndAt})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
    //@OptionsアノテーションはINSERT（挿入）するときにつけるべきもの
  void registerStudentCourse(StudentCourse studentCourse);


  @Select("SELECT * FROM students_courses")
  List<StudentCourse> p();

  @Update("UPDATE students SET name=#{name}, kana_name=#{kanaName}, nickname=#{nickname}, "
      + "email=#{email}, area=#{area}, age=#{age}, sex=#{sex}, remark=#{remark}, "
      + "is_deleted=#{isDeleted} WHERE id=#{id}")
  void updateStudent(Students students);

  @Update("UPDATE students_courses SET course_name=#{courseName} WHERE id=#{id}")
  void updateStudentCourse(StudentCourse studentCourse);

  @Select("SELECT * FROM students WHERE id=#{id}")
  Students searchStudent(String id);

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> searchStudentCourseList();

  @Select("SELECT * FROM students_courses WHERE student_id = #{studentId}")
  List<StudentCourse> searchStudentCourse(String studentId);
}
