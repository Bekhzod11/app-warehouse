package uz.pdp.appwarehouse.entity.template;

import lombok.Data;
import uz.pdp.appwarehouse.entity.Category;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private boolean active =true;
}
