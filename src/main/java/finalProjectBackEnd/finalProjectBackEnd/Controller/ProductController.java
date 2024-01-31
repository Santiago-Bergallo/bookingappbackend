package finalProjectBackEnd.finalProjectBackEnd.Controller;

import finalProjectBackEnd.finalProjectBackEnd.Dto.ProductDto.ProductRegistrationBodyDto;
import finalProjectBackEnd.finalProjectBackEnd.exception.Categoryexception.CategoryDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.exception.city.CityDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.exception.productException.ProductAlreadyExistsException;
import finalProjectBackEnd.finalProjectBackEnd.exception.productException.ProductDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.model.Product;
import finalProjectBackEnd.finalProjectBackEnd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ResponseEntity createProduct(@RequestBody ProductRegistrationBodyDto productRegistrationBodyDto) {
        try {
            productService.createProduct(productRegistrationBodyDto);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ProductAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (CityDoesNotExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (CategoryDoesNotExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findUser(@PathVariable Long id) {
        try {
            Optional<Product> product = productService.findProduct(id);
            return ResponseEntity.ok(product);
        } catch (ProductDoesNotExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
