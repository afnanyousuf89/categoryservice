package afn.xloop.categoryservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tblproduct")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private String pname;
    @Column(columnDefinition = "TEXT")
    private String pdesc;
    @Column(columnDefinition = "TEXT")
    private String pimg;
    private double pprice;
    private Integer cid;
    private boolean isactive;
    private boolean isdeleted;
}
