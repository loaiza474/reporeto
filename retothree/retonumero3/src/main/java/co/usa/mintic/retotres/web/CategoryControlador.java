package co.usa.mintic.retotres.web;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.mintic.retotres.model.Category;
import co.usa.mintic.retotres.service.CategoryServicio;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class CategoryControlador {
    
    @Autowired
    private CategoryServicio categoryServicio;

    @GetMapping("/all")
    public List<Category>getall(){
        return categoryServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category>getCategory(@PathVariable("id") int id){
        return categoryServicio.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category categoria){
        return categoryServicio.save(categoria);
    }

    @DeleteMapping("/{id}")
    
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public boolean deleteCategory(@PathVariable("id")int numId){

        return categoryServicio.deleteCategory(numId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category categoria) {
        return categoryServicio.update(categoria);
    }
}
