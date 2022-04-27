package aptech.t008m.hellospring.restapi;

import aptech.t008m.hellospring.entity.Employe;
import aptech.t008m.hellospring.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employees")
public class EmployeApi {

    @Autowired
    EmployeService employeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employe>> getList() {
        return ResponseEntity.ok(employeService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable Long id) {
        Optional<Employe> optionalAccount = employeService.findById(id);
        if (!optionalAccount.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalAccount.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Employe> create(@RequestBody Employe employe) {
        return ResponseEntity.ok(employeService.save(employe));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Employe> update(@PathVariable Long id, @RequestBody Employe employe) {
        Optional<Employe> optionalAccount = employeService.findById(id);
        if (!optionalAccount.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Employe existemloye = optionalAccount.get();
        existemloye.setName(existemloye.getName());
        existemloye.setPrice(employe.getPrice());
        return ResponseEntity.ok(employeService.save(existemloye));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!employeService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        employeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
