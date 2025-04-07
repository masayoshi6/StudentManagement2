package raise.student.management2;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  @Autowired
  private StudentRepository re;

  @GetMapping("/a")
  public List<Student> a() {
    return re.c();

  }


  @PostMapping("/name")
  public void setName(String name, int age) {
    //this.name = name;
    //this.age = age;
    re.e(name, age);
  }

  @PostMapping("/b")     //ここは本来@PatchMapping（部分更新）だった
  //ちなみに、全体更新は@PutMappingを使う
  public void update(String name, int age) {
    re.update(name, age);
    //this.name = name;
  }

  @DeleteMapping("/delete")
  public void delete(String name) {
    re.delete(name);
  }//a

  @GetMapping("/c")
  public List<Student> c() {
    List<Student> g;
    List<Student> d = re.f();
    g = d.stream().filter(student -> student.getAge() > 10 && student.getAge() < 20)
        .collect(Collectors.toList());
    return g;
  }


  @GetMapping("/d")
  public String d(@RequestParam String name) {
    Students d = re.g(name);
    return d.getName() + " " + d.getAge() + " " + d.getId() + " " + d.getKanaName() + " "
        + d.getEmail();
  }

  @PostMapping("/e")
  public void e(String id, String name, String kanaName, String nickname,
      String email, String area, int age, String sex) {
    re.h(id, name, kanaName, nickname, email, area, age, sex);
  }

  @PatchMapping("/f")
  public void f(String name, int age, String nickname) {
    re.i(name, age, nickname);
  }

  @DeleteMapping("/g")
  public void g(String id) {
    re.j(id);
  }


}
