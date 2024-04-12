package finalProjectBackEnd.finalProjectBackEnd.service;

import finalProjectBackEnd.finalProjectBackEnd.Dao.*;
import finalProjectBackEnd.finalProjectBackEnd.Dto.ProductDto.ProductRegistrationBodyDto;
import finalProjectBackEnd.finalProjectBackEnd.Dto.image.ImageDto;
import finalProjectBackEnd.finalProjectBackEnd.exception.Categoryexception.CategoryDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.exception.city.CityDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.exception.productException.ProductAlreadyExistsException;
import finalProjectBackEnd.finalProjectBackEnd.exception.productException.ProductDoesNotExistException;
import finalProjectBackEnd.finalProjectBackEnd.model.Feature;
import finalProjectBackEnd.finalProjectBackEnd.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    CityDao cityDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ImageDao imageDao;

    @Autowired
    FeatureDao featureDao;



    public Product createProduct(ProductRegistrationBodyDto productRegistrationBodyDto) throws ProductAlreadyExistsException, CityDoesNotExistException, CategoryDoesNotExistException {

        if (productDao.findByTitleIgnoreCase(productRegistrationBodyDto.getTitle()).isPresent()) {
            throw new ProductAlreadyExistsException();
        }
        if (cityDao.findByNameIgnoreCase(productRegistrationBodyDto.getCityRegistrationDto().getName()).isPresent() && categoryDao.findByTitleIgnoreCase(productRegistrationBodyDto.getCategoryRegistrationBody().getTitle()).isPresent()) {


            Product newProduct = new Product();
            List<ImageDto> imagesDto = productRegistrationBodyDto.getImageDtoList();
            List<ImageModel> image = new ArrayList<>();
            City city = cityDao.findByNameIgnoreCase(productRegistrationBodyDto.getCityRegistrationDto().getName()).get();
            Category category = categoryDao.findByTitleIgnoreCase(productRegistrationBodyDto.getCategoryRegistrationBody().getTitle()).get();

            newProduct.setTitle(productRegistrationBodyDto.getTitle());
            newProduct.setShortDescription(productRegistrationBodyDto.getShortDescription());
            newProduct.setAddress(productRegistrationBodyDto.getAddress());
            newProduct.setCity(city);
            newProduct.setCategory(category);

            Feature newFeature = new Feature();
            newFeature.setStars(productRegistrationBodyDto.getFeatureDto().getStars());
            newFeature.setPetFriendly(productRegistrationBodyDto.getFeatureDto().getPetFriendly());
            newFeature.setParkingLot(productRegistrationBodyDto.getFeatureDto().getParkingLot());
            newFeature.setSwimmingPool(productRegistrationBodyDto.getFeatureDto().getSwimmingPool());
            newFeature.setProduct(newProduct);

            newProduct.setFeature(newFeature);

            for (ImageDto imageDto : imagesDto) {
                ImageModel model = new ImageModel();
                model.setImageUrl(imageDto.getImageUrl());
                model.setProduct(newProduct);
//                imageDao.save(model);
                image.add(model);
            }

            newProduct.setImages(image);
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

