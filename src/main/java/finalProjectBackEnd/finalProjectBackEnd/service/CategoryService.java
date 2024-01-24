package finalProjectBackEnd.finalProjectBackEnd.service;

import finalProjectBackEnd.finalProjectBackEnd.Dao.CategoryDao;
import finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.CategoryEditBody;
import finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.CategoryRegistrationBody;
import finalProjectBackEnd.finalProjectBackEnd.exception.Categoryexception.CategoryAlreadyExistsException;
import finalProjectBackEnd.finalProjectBackEnd.exception.Categoryexception.CategoryDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public Category createCategory(CategoryRegistrationBody categoryRegistrationBody) throws CategoryAlreadyExistsException {

        if (categoryDao.findByTitleIgnoreCase(categoryRegistrationBody.getTitle()).isPresent()) {
            throw new CategoryAlreadyExistsException();
        }

        Category newCategory = new Category();
        newCategory.setTitle(categoryRegistrationBody.getTitle());
        newCategory.setDescription(categoryRegistrationBody.getDescription());
        categoryDao.save(newCategory);
        return newCategory;

    }

    public Category editCategory(CategoryEditBody categoryEditBody) throws CategoryDoesNotExistException {
        if (categoryDao.findByTitleIgnoreCase(categoryEditBody.getTitle()).isEmpty()) {
            throw new CategoryDoesNotExistException();
        }

        Category edit = categoryDao.findByTitleIgnoreCase(categoryEditBody.getTitle()).get();
        edit.setTitle(categoryEditBody.getTitle());
        edit.setDescription(categoryEditBody.getDescription());
        categoryDao.save(edit);
        return edit;

    }

    public Optional<Category> findCat (Long index) throws CategoryDoesNotExistException {
        Optional<Category> found = categoryDao.findById(index);
        if (found.isEmpty()) {
            throw new CategoryDoesNotExistException();
        }
        return found;
    }


}
