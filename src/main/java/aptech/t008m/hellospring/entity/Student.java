package aptech.t008m.hellospring.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Student {
    @Id
    private String rollNumber;
    private String name;
    private int status;
}
