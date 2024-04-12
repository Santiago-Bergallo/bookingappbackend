package finalProjectBackEnd.finalProjectBackEnd.Dto.ProductDto;

import finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.CategoryRegistrationBody;
import finalProjectBackEnd.finalProjectBackEnd.Dto.featureDto.FeatureDto;
import finalProjectBackEnd.finalProjectBackEnd.Dto.image.ImageDto;
import finalProjectBackEnd.finalProjectBackEnd.Dto.user.CityRegistrationDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class ProductRegistrationBodyDto {

    private String title;

    private String address;

    private String shortDescription;

    private CategoryRegistrationBody categoryRegistrationBody;

    private CityRegistrationDto cityRegistrationDto;

    private List<ImageDto> imageDtoList;

    private FeatureDto featureDto;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public CategoryRegistrationBody getCategoryRegistrationBody() {
        return categoryRegistrationBody;
    }

    public void setCategoryRegistrationBody(CategoryRegistrationBody categoryRegistrationBody) {
        this.categoryRegistrationBody = categoryRegistrationBody;
    }

    public CityRegistrationDto getCityRegistrationDto() {
        return cityRegistrationDto;
    }

    public void setCityRegistrationDto(CityRegistrationDto cityRegistrationDto) {
        this.cityRegistrationDto = cityRegistrationDto;
    }

    public List<ImageDto> getImageDtoList() {
        return imageDtoList;
    }

    public void setImageDtoList(List<ImageDto> imageDtoList) {
        this.imageDtoList = imageDtoList;
    }

    public FeatureDto getFeatureDto() {
        return featureDto;
    }

    public void setFeatureDto(FeatureDto featureDto) {
        this.featureDto = featureDto;
    }
}
