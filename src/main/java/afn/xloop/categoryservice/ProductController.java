package afn.xloop.categoryservice;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("product")
public class ProductController {
    
    @Autowired
    private ProductRepo repo;


    @GetMapping("")
    public Collection<Product> getAll(){
        return repo.findAll();
    }

    @PostMapping("")
    public String save(@RequestBody Product c){
        //c.setIsactive(false);
        repo.save(c);
        return "Product saved as "+c.getPname();
    }

    @PostMapping("/all")
    public String saveAll(@RequestBody Collection<Product> c){
        repo.saveAll(c);
        return "Products saved";
    }
}
