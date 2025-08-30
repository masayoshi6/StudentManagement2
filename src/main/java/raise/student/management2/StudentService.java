package raise.student.management2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

  private StudentRepository re;

  @Autowired
  public StudentService(StudentRepository re) {
    this.re = re;
  }

  public List<Students> searchStudentList() {
    return re.search();
  }

  public StudentDetail searchStudent(String id) {
    Students students = re.searchStudent(id);
    List<StudentCourse> studentCourses = re.searchStudentCourse(students.getId());
    StudentDetail studentDetail = new StudentDetail();
    studentDetail.setStudents(students);
    studentDetail.setStudentCourse(studentCourses);
    return studentDetail;
  }

  public List<StudentDetail> aa() {
    List<Students> k = re.search();
    List<StudentCourse> p = re.p();
    List<StudentDetail> a = new ArrayList<>();

    k.forEach(b -> {
      extracted(b, p, a);
    });
    return a;
  }

  private void extracted(Students b, List<StudentCourse> p, List<StudentDetail> a) {
    StudentDetail e = new StudentDetail();

    List<StudentCourse> d = p.stream().filter(c -> b.getId().equals(c.getStudentId()))
        .collect(Collectors.toList());

    e.setStudentCourse(d);
    e.setStudents(b);
    a.add(e);
  }


  /*public List<StudentDetail> aa() {
    List<Students> k = re.k();
    List<StudentCourse> p = re.p();
    List<StudentDetail> a = new ArrayList<>();

    for (Students b : k) {
      StudentDetail e = new StudentDetail();

      List<StudentCourse> d = new ArrayList<>();
      for (StudentCourse c : p) {
        if (b.getId().equals(c.getStudentId())) {
          d.add(c);
        }
      }

      e.setStudentCourse(d);
      e.setStudents(b);
      a.add(e);
    }
    return a;
  }*/


  public List<StudentDetail> stude() {
    List<StudentDetail> c = new ArrayList<>();
    List<Students> search = re.search();
    List<StudentCourse> p = re.p();
    for (Students d : search) {
      StudentDetail e = new StudentDetail();
      List<StudentCourse> b = new ArrayList<>();
      e.setStudents(d);
      for (StudentCourse f : p) {
        if (d.getId().equals(f.getStudentId())) {
          b.add(f);
        }

      }
      e.setStudentCourse(b);
      c.add(e);
    }
    return c;
  }


  @Transactional
  public void hh(StudentDetail studentDetail) {
    re.h(studentDetail.getStudents());
// TODO:　コース情報の登録も行う

    List<StudentCourse> studentCourseList = studentDetail.getStudentCourse();
    LocalDateTime now = LocalDateTime.now();

    for (StudentCourse studentCourse : studentCourseList) {
      studentCourseInformation(studentDetail, studentCourse, now);
      re.registerStudentCourse(studentCourse);
    }
  }

  private void studentCourseInformation(StudentDetail studentDetail, StudentCourse studentCourse,
      LocalDateTime now) {
    studentCourse.setStudentId(studentDetail.getStudents().getId());
    studentCourse.setCourseStartAt(now);
    studentCourse.setCourseEndAt(now.plusYears(1));
  }

  @Transactional
  public void updateStudent(StudentDetail studentDetail) {
    re.updateStudent(studentDetail.getStudents());

    for (StudentCourse studentCourse : studentDetail.getStudentCourse()) {
      //studentCourse.setStudentId(studentDetail.getStudents().getId());
      re.updateStudentCourse(studentCourse);
    }
  }
}
