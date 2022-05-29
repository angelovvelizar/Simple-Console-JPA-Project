package bg.softuni.web.superMarket.services.impl;

import bg.softuni.web.superMarket.models.dtos.CategoryAddDto;
import bg.softuni.web.superMarket.models.entities.Category;
import bg.softuni.web.superMarket.repositories.CategoryRepository;
import bg.softuni.web.superMarket.services.CategoryService;
import bg.softuni.web.superMarket.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validator) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }


    @Override
    public String addCategory(String categoryName) {

        CategoryAddDto categoryAddDto = new CategoryAddDto();
        categoryAddDto.setName(categoryName);

        Set<ConstraintViolation<CategoryAddDto>> violations = this.validator.isValid(categoryAddDto);
        if(!violations.isEmpty()){
            for (ConstraintViolation<CategoryAddDto> violation : violations) {
                return violation.getMessage();
            }
        }

        if(categoryRepository.findCategoryByName(categoryName).isPresent()){
            return "The category is already added";
        }

        Category category = this.modelMapper.map(categoryAddDto, Category.class);
        this.categoryRepository.save(category);

        return "Successfully added category!";
    }
}
