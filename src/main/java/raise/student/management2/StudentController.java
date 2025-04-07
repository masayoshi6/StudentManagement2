package raise.student.management2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  private StudentService service;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping("/h")
  public List<Students> h() {
    //リクエストの加工処理とか入力チェックとか
    return service.searchStudentList();
  }


  @GetMapping("/i")
  public List<StudentDetail> i() {
    return service.aa();
  }
}
