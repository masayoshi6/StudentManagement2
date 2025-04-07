package raise.student.management2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private StudentRepository re;

  @Autowired
  public StudentService(StudentRepository re) {
    this.re = re;
  }

  public List<Students> searchStudentList() {
    //本来はここに何かしらの処理をかく
    List<Students> a;
    List<Students> b = re.k();
    a = b.stream().filter(c -> c.getSex().equals("男")).collect(Collectors.toList());
    return a;
  }


  public List<StudentDetail> aa() {
    List<Students> k = re.k();
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

    k.forEach(b -> {
      StudentDetail e = new StudentDetail();

      List<StudentCourse> d = p.stream().filter(c -> b.getId().equals(c.getStudentId()))
          .collect(Collectors.toList());

      e.setStudentCourse(d);
      e.setStudents(b);
      a.add(e);
    });
    return a;
  }*/
}
