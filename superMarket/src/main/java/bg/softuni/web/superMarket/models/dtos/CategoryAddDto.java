package bg.softuni.web.superMarket.models.dtos;

import javax.validation.constraints.Size;

public class CategoryAddDto {

    @Size(min = 2,message = "Name must be minimum two characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
