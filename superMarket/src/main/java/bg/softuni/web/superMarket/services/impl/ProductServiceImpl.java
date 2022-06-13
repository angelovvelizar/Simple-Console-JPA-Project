package bg.softuni.web.superMarket.services.impl;

import bg.softuni.web.superMarket.models.dtos.ProductAddDto;
import bg.softuni.web.superMarket.models.entities.Product;
import bg.softuni.web.superMarket.repositories.CategoryRepository;
import bg.softuni.web.superMarket.repositories.ProductRepository;
import bg.softuni.web.superMarket.services.ProductService;
import bg.softuni.web.superMarket.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validator, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public String addProduct(ProductAddDto productAddDto) {
        if(!this.validator.isValidEntity(productAddDto) || !this.validator.isValidEntity(productAddDto.getCategory())){
            return "Invalid product!";
        }

        if(this.categoryRepository.findCategoryByName(productAddDto.getCategory().getName()).isEmpty()){
            return "There is no such category!";
        }

        Product product = this.modelMapper.map(productAddDto, Product.class);
        product.setBestBefore(LocalDate.parse(productAddDto.getBestBefore(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        product.setCategory(this.categoryRepository.findCategoryByName(productAddDto.getCategory().getName()).orElse(null));

        this.productRepository.save(product);

        return "Successfully added product!";
    }
}
