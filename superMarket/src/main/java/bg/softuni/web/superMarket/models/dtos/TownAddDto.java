package bg.softuni.web.superMarket.models.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TownAddDto {

    @NotBlank
    @Size(min = 2)
    private String name;

    public TownAddDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
