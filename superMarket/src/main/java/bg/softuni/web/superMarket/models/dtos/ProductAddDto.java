package bg.softuni.web.superMarket.models.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductAddDto {

    @NotBlank
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    private String bestBefore;

    private CategoryAddDto category;

    public ProductAddDto() {
    }

    public ProductAddDto(String name, BigDecimal price, String bestBefore, CategoryAddDto category) {
        this.name = name;
        this.price = price;
        this.bestBefore = bestBefore;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(String bestBefore) {
        this.bestBefore = bestBefore;
    }

    public CategoryAddDto getCategory() {
        return category;
    }

    public void setCategory(CategoryAddDto category) {
        this.category = category;
    }
}
