package co.usa.mintic.retotres.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

import co.usa.mintic.retotres.model.Category;
import co.usa.mintic.retotres.repository.crud.CategoryCrudRepositorio;

@Repository
public class CategoryRepositorio {
    @Autowired
    private CategoryCrudRepositorio categoryCrudRepositorio;

    public List<Category> getAll(){
        return (List<Category>)categoryCrudRepositorio.findAll();
    }
    
    public Optional<Category>getCategory(int id){
        return categoryCrudRepositorio.findById(id);
    }

    public Category save(Category categoria){
        return categoryCrudRepositorio.save(categoria);
    }

    public void delete(Category audi){
        categoryCrudRepositorio.delete(audi);
    }

}
