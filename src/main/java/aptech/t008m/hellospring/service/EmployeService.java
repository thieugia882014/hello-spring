package aptech.t008m.hellospring.service;

import aptech.t008m.hellospring.entity.Employe;
import aptech.t008m.hellospring.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepository;

    public List<Employe> findAll(){return employeRepository.findAll();}

    public Optional<Employe> findById(long id) {
        return employeRepository.findById((id));
    }

    public Employe save(Employe employe) {
        return employeRepository.save(employe);
    }

    public void deleteById(long id) {
        employeRepository.deleteById((id));
    }
}
