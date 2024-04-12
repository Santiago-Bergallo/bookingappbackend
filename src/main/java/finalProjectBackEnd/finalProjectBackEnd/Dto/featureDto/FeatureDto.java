package finalProjectBackEnd.finalProjectBackEnd.Dto.featureDto;

import finalProjectBackEnd.finalProjectBackEnd.Dto.ProductDto.ProductRegistrationBodyDto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FeatureDto {

    private Boolean petFriendly;

    private Boolean parkingLot;

    private Integer stars;

    private Boolean swimmingPool;

    private ProductRegistrationBodyDto productRegistrationBodyDto;

}
