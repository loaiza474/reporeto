package co.usa.mintic.retotres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.mintic.retotres.model.Category;
import co.usa.mintic.retotres.repository.CategoryRepositorio;

@Service
public class CategoryServicio {
    @Autowired
    private CategoryRepositorio categoryRepositorio;

    public List<Category>getAll(){
        return categoryRepositorio.getAll();
    }
    

    public Optional<Category>getCategory(int id){
        return categoryRepositorio.getCategory(id);
    }
    

    public Category save(Category categoria){
        if(categoria.getId()==null){
            return categoryRepositorio.save(categoria);
        }else{
            Optional<Category> consulta= categoryRepositorio.getCategory(categoria.getId());
            if(consulta.isEmpty()){
                return categoryRepositorio.save(categoria);
            }else{
                return categoria;
            }
        }
    }

    public boolean deleteCategory(int numId){

        Optional<Category> consulta=categoryRepositorio.getCategory(numId);

        if(!consulta.isEmpty()){

            categoryRepositorio.delete(consulta.get());

            return true;
        }
        return false;
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> consulta=categoryRepositorio.getCategory(category.getId());
            if(!consulta.isEmpty()){
                if(category.getName()!=null){
                    consulta.get().setName(category.getName());
                }
            if(category.getDescription()!=null){
                consulta.get().setDescription(category.getDescription());
            }
            return categoryRepositorio.save(consulta.get());
            }
        }
        return category;
    }

    // private Integer id;
    // private String name;
    // private String description;
}
