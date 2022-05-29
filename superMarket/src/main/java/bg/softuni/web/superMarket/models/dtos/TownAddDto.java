package bg.softuni.web.superMarket.models.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TownAddDto {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
