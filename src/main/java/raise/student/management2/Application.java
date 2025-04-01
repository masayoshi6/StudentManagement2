package raise.student.management2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  @Autowired
  private StudentRepository re;

  private String name = "kodomori";
  private int age = 20;


  public static void main(String[] args) {

    SpringApplication.run(Application.class, args);

  }

  @GetMapping("/a")
  public String a(@RequestParam String name) {
    //return name + " " + age + "歳";
    Student d = re.c(name);
    return d.getName() + " " + d.getAge() + "歳";
  }


  @PostMapping("/name")
  public void setName(String name, int age) {
    //this.name = name;
    //this.age = age;
    re.e(name, age);
  }

  @PostMapping("/b")
  public void b(String name) {
    this.name = name;
  }
}
