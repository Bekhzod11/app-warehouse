package uz.pdp.appwarehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false)
   private String firstName;

    @Column(nullable = false)
   private String  lastName;

   @Column(unique = true,nullable = false)
   private String phoneNumber;

@Column(nullable = false)
   private String code;

   @Column(nullable = false)
   private String password;

   private boolean active=true;

@ManyToMany
    private Set<Warehouse> warehouses;
}
