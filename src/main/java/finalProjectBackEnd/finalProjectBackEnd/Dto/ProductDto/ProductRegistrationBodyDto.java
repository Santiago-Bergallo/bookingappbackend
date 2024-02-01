package finalProjectBackEnd.finalProjectBackEnd.Dto.ProductDto;

import finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto.CategoryRegistrationBody;
import finalProjectBackEnd.finalProjectBackEnd.Dto.user.CityRegistrationDto;
import lombok.Getter;
import lombok.Setter;


public class ProductRegistrationBodyDto {

    private String title;

    private String address;

    private String shortDescription;

    private CategoryRegistrationBody categoryRegistrationBody;

    private CityRegistrationDto cityRegistrationDto;

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
}
