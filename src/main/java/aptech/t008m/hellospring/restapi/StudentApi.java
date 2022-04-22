package aptech.t008m.hellospring.restapi;

import aptech.t008m.hellospring.entity.Student;
import aptech.t008m.hellospring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("api/v1/students")
public class StudentApi {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {
        return studentRepository.findAll();
    }


    @RequestMapping(method = RequestMethod.GET, path = "{rollNumber}")
    public Student findById(@PathVariable String rollNumber) {
        return studentRepository.findById(rollNumber).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {
        studentRepository.save(student);
        return student;
    }


    @RequestMapping(method = RequestMethod.PUT, path = "{rollNumber}")
    public Student update(@PathVariable String rollNumber, @RequestBody Student updateStudent) {
        Student exsting = studentRepository.findById(rollNumber).get();
        exsting.setName(updateStudent.getName());
        exsting.setStatus(updateStudent.getStatus());

        return studentRepository.save(exsting);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{rollNumber}")
    public Boolean delete(@PathVariable String rollNumber) {
        studentRepository.deleteById(rollNumber);
        return true;
    }
}

