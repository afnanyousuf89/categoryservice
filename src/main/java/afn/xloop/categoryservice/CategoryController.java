package afn.xloop.categoryservice;


import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("category")
public class CategoryController {
    
    @Autowired
    private CategoryRepo repo;

    @GetMapping("")
    public Collection<Category> getAll(){
        return repo.findAll().stream().filter(n->n.isIsactive()).collect(Collectors.toList());
    }

    @PostMapping("")
    public String save(@RequestBody Category c){
        //c.setIsactive(false);
        repo.save(c);
        return "Category saved as "+c.getCname();
    }

    @PostMapping("/all")
    public String saveAll(@RequestBody Collection<Category> c){
        repo.saveAll(c);
        return "Category saved";
    }

    



}
