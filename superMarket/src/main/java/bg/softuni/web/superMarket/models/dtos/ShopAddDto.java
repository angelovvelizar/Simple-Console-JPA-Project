package bg.softuni.web.superMarket.models.dtos;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ShopAddDto {

    @NotBlank
    @Size(min = 2)
    private String name;
    @Size(min = 2)
    private String address;
    private TownAddDto town;

    public ShopAddDto(String name, String address, TownAddDto town) {
        this.name = name;
        this.address = address;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TownAddDto getTown() {
        return town;
    }

    public void setTown(TownAddDto town) {
        this.town = town;
    }
}
