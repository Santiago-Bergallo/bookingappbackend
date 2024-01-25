package finalProjectBackEnd.finalProjectBackEnd.service;

import finalProjectBackEnd.finalProjectBackEnd.Dao.CategoryDao;
import finalProjectBackEnd.finalProjectBackEnd.Dao.CityDao;
import finalProjectBackEnd.finalProjectBackEnd.Dao.ProductDao;
import finalProjectBackEnd.finalProjectBackEnd.Dto.ProductDto.ProductRegistrationBodyDto;
import finalProjectBackEnd.finalProjectBackEnd.exception.productException.ProductAlreadyExistsException;
import finalProjectBackEnd.finalProjectBackEnd.exception.productException.ProductDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.exception.userException.LocalUserDoesNotExist;
import finalProjectBackEnd.finalProjectBackEnd.model.Category;
import finalProjectBackEnd.finalProjectBackEnd.model.City;
import finalProjectBackEnd.finalProjectBackEnd.model.LocalUser;
import finalProjectBackEnd.finalProjectBackEnd.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    CityDao cityDao;

    @Autowired
    CategoryDao categoryDao;

    public Product createProduct(ProductRegistrationBodyDto productRegistrationBodyDto) throws ProductAlreadyExistsException {

        if (productDao.findByTitleIgnoreCase(productRegistrationBodyDto.getTitle()).isPresent()) {
            throw new ProductAlreadyExistsException();
        }

        Optional<City> city = cityDao.findByNameIgnoreCase(productRegistrationBodyDto.getCityRegistrationDto().getName());
        Optional<Category> category = categoryDao.findByTitleIgnoreCase(productRegistrationBodyDto.getCategoryRegistrationBody().getTitle());
        City found = null;
        Category foundCat = null;
        if (city.isPresent()) {
            found = city.get();
        }
        if (category.isPresent()) {
            foundCat = category.get();
        }

                Product newProduct = new Product();
                newProduct.setTitle(productRegistrationBodyDto.getTitle());
                newProduct.setShortDescription(productRegistrationBodyDto.getShortDescription());
                newProduct.setAddress(productRegistrationBodyDto.getAddress());
                newProduct.setCity(found);
                newProduct.setCategory(foundCat);
                productDao.save(newProduct);
                return newProduct;
    }

    public Optional<Product> findProduct(Long index) throws ProductDoesNotExistException {
        Optional<Product> found = productDao.findById(index);
        if (found.isEmpty()) {
            throw new ProductDoesNotExistException();
        }
        return found;
    }


}
