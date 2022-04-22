package aptech.t008m.hellospring.repository;

import aptech.t008m.hellospring.entity.SuperNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperNewRepository extends JpaRepository<SuperNew, Long> {

}
