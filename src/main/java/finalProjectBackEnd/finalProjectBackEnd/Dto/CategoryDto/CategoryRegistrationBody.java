package finalProjectBackEnd.finalProjectBackEnd.Dto.CategoryDto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter @Setter
public class CategoryRegistrationBody {

    @NonNull
    String title;

    String description;
}
