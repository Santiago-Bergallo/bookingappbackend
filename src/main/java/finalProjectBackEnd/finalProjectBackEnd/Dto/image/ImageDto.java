package finalProjectBackEnd.finalProjectBackEnd.Dto.image;

import finalProjectBackEnd.finalProjectBackEnd.Dto.ProductDto.ProductRegistrationBodyDto;

public class ImageDto {

    private String imageUrl;

    private ProductRegistrationBodyDto productRegistrationBodyDto;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductRegistrationBodyDto getProductRegistrationBodyDto() {
        return productRegistrationBodyDto;
    }

    public void setProductRegistrationBodyDto(ProductRegistrationBodyDto productRegistrationBodyDto) {
        this.productRegistrationBodyDto = productRegistrationBodyDto;
    }
}
