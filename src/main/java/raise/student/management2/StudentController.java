package raise.student.management2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//@RestController
@Controller
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
  public String i(Model model) {
    model.addAttribute("studentList", service.aa());
    return "studentList";
  }

  /*@GetMapping("/i")
  public List<StudentDetail> i() {
    return service.aa();
  }*/

  @GetMapping("/stude")
  public List<StudentDetail> stude() {
    return service.stude();
  }

  @GetMapping("/newStudent")
  public String newStudent(Model model) {
    StudentDetail s = new StudentDetail();
    //StudentCourse a = new StudentCourse();
    //StudentCourse b = new StudentCourse();
    s.setStudentCourse(new ArrayList<>(Arrays.asList(new StudentCourse())));
    // 上は　s.setStudentCourse(Arrays.asList(new StudentCourse()));　でもOK
    // もし、aとbをasListの引数に入れて、Arrays.asList(a, b)としてwebブラウザ上で
    //http://localhost:8080/newStudent と入力すると、「受講コース名」のテキストボックスが２つ表示されることになる
    model.addAttribute("studentDetail", s);
    return "registerStudent";
  }

  @PostMapping("/registerStudent")
  public String registerStudent(@ModelAttribute StudentDetail studentDetail) {
    //System.out.println(studentDetail.getStudents().getName() + "さんが新規登録されました");
    //TODO: ①新規受講生情報を登録する処理を実装する。
    service.hh(studentDetail);
    //TODO: ②コース情報も一緒に登録できるように実装する。
    return "redirect:/i";
  }

  @GetMapping("/student/{id}")
  public String getStudent(@PathVariable String id, Model model) {
    StudentDetail studentDetail = service.searchStudent(id);
    model.addAttribute("studentDetail", studentDetail);
    return "updateStudent";
  }

  @PostMapping("updateStudent")
  public String updateStudent(@ModelAttribute StudentDetail studentDetail) {
    service.updateStudent(studentDetail);
    return "redirect:/i";
  }
}
