package aptech.t008m.hellospring.service;

import aptech.t008m.hellospring.entity.SuperNew;
import aptech.t008m.hellospring.repository.SuperNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperNewService {
    @Autowired
    private SuperNewRepository superNewRepository;

    public List<SuperNew> findAll(){return superNewRepository.findAll();}

    public Optional<SuperNew> findById(long id) {
        return superNewRepository.findById((id));
    }

    public SuperNew save(SuperNew supernew) {
        return superNewRepository.save(supernew);
    }

    public void deleteById(long id) {
        superNewRepository.deleteById((id));
    }

}
