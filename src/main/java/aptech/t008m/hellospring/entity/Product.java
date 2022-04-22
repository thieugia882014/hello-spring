package aptech.t008m.hellospring.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @Column(name = "name", columnDefinition = "varchar(250)") chỉ khi cần
    private String name;
    private String description;
    private Double price;
    private int status;
}
