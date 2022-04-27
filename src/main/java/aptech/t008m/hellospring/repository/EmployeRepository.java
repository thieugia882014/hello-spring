package aptech.t008m.hellospring.repository;

import aptech.t008m.hellospring.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
    @Query(value = "SELECT * FROM supernews s WHERE   s.name like %:name%",
            nativeQuery= true)
    List<Employe> search(@Param("name") String title);
}
