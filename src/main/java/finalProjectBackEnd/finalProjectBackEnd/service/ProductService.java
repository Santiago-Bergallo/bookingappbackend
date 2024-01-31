package finalProjectBackEnd.finalProjectBackEnd.service;

import finalProjectBackEnd.finalProjectBackEnd.Dao.CategoryDao;
import finalProjectBackEnd.finalProjectBackEnd.Dao.CityDao;
import finalProjectBackEnd.finalProjectBackEnd.Dao.CountryDao;
import finalProjectBackEnd.finalProjectBackEnd.Dao.ProductDao;
import finalProjectBackEnd.finalProjectBackEnd.Dto.ProductDto.ProductRegistrationBodyDto;
import finalProjectBackEnd.finalProjectBackEnd.exception.Categoryexception.CategoryDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.exception.city.CityDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.exception.productException.ProductAlreadyExistsException;
import finalProjectBackEnd.finalProjectBackEnd.exception.productException.ProductDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.model.*;
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


    public Product createProduct(ProductRegistrationBodyDto productRegistrationBodyDto) throws ProductAlreadyExistsException, CityDoesNotExistException, CategoryDoesNotExistException {

        if (productDao.findByTitleIgnoreCase(productRegistrationBodyDto.getTitle()).isPresent()) {
            throw new ProductAlreadyExistsException();
        }
        if (cityDao.findByNameIgnoreCase(productRegistrationBodyDto.getCityRegistrationDto().getName()).isPresent() && categoryDao.findByTitleIgnoreCase(productRegistrationBodyDto.getCategoryRegistrationBody().getTitle()).isPresent()) {


            Product newProduct = new Product();
            City city = cityDao.findByNameIgnoreCase(productRegistrationBodyDto.getCityRegistrationDto().getName()).get();
            Category category = categoryDao.findByTitleIgnoreCase(productRegistrationBodyDto.getCategoryRegistrationBody().getTitle()).get();

            newProduct.setTitle(productRegistrationBodyDto.getTitle());
            newProduct.setShortDescription(productRegistrationBodyDto.getShortDescription());
            newProduct.setAddress(productRegistrationBodyDto.getAddress());
            newProduct.setCity(city);
            newProduct.setCategory(category);
            productDao.save(newProduct);
            return newProduct;
        } else {
            if (cityDao.findByNameIgnoreCase(productRegistrationBodyDto.getCityRegistrationDto().getName()).isEmpty()) {
                throw new CityDoesNotExistException();
            } else throw new CategoryDoesNotExistException();
        }
    }

    public Optional<Product> findProduct(Long index) throws ProductDoesNotExistException {
        Optional<Product> found = productDao.findById(index);
        if (found.isEmpty()) {
            throw new ProductDoesNotExistException();
        }
        return found;
    }


    }

