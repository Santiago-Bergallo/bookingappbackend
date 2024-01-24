package finalProjectBackEnd.finalProjectBackEnd.Controller;

import finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.CategoryEditBody;
import finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.CategoryRegistrationBody;
import finalProjectBackEnd.finalProjectBackEnd.exception.Categoryexception.CategoryAlreadyExistsException;
import finalProjectBackEnd.finalProjectBackEnd.exception.Categoryexception.CategoryDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.model.Category;
import finalProjectBackEnd.finalProjectBackEnd.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity createCategory(@RequestBody @Valid CategoryRegistrationBody categoryRegistrationBody) {
        try {
            Category newCategory = categoryService.createCategory(categoryRegistrationBody);
            return ResponseEntity.ok(newCategory);
        } catch (CategoryAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/edit")
    public ResponseEntity editCategory(@RequestBody @Valid CategoryEditBody categoryEditBody) {
        try {
            Category newCategory = categoryService.editCategory(categoryEditBody);
            return ResponseEntity.ok(newCategory);
        } catch (CategoryDoesNotExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/find/{index}")
    public ResponseEntity find(@PathVariable Long index) {
        Optional<Category> find = null;
        try {
            find = categoryService.findCat(index);
            return ResponseEntity.ok(find);
        } catch (CategoryDoesNotExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

}
