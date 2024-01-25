package finalProjectBackEnd.finalProjectBackEnd.Controller;

import finalProjectBackEnd.finalProjectBackEnd.Dto.ProductDto.ProductRegistrationBodyDto;
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
        }
    }

    @GetMapping("/find/{id}")
    public Optional<Product> findUser(@PathVariable Long id) {
        try {
            return productService.findProduct(id);
        } catch (ProductDoesNotExistException e) {
            throw new RuntimeException(e);
        }
    }


}
