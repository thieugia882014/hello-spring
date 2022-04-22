package aptech.t008m.hellospring.restapi;

import aptech.t008m.hellospring.entity.SuperNew;
import aptech.t008m.hellospring.service.SuperNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/supernews")
public class SuperNewApi {

    @Autowired
    SuperNewService superNewService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SuperNew>> getList() {
        return ResponseEntity.ok(superNewService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable Long id) {
        Optional<SuperNew> optionalAccount = superNewService.findById(id);
        if (!optionalAccount.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalAccount.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuperNew> create(@RequestBody SuperNew superNew) {
        return ResponseEntity.ok(superNewService.save(superNew));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<SuperNew> update(@PathVariable Long id, @RequestBody SuperNew superNew) {
        Optional<SuperNew> optionalAccount = superNewService.findById(id);
        if (!optionalAccount.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        SuperNew existSuperNew = optionalAccount.get();
        // map object
        existSuperNew.setTitle(superNew.getTitle());
        existSuperNew.setDescription(superNew.getDescription());
        existSuperNew.setThumbnail(superNew.getThumbnail());
        existSuperNew.setContent(superNew.getContent());
        existSuperNew.setCategory(superNew.getCategory());
        return ResponseEntity.ok(superNewService.save(existSuperNew));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!superNewService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        superNewService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}


