package bg.softuni.web.superMarket.services.impl;

import bg.softuni.web.superMarket.models.dtos.ShopAddDto;
import bg.softuni.web.superMarket.models.entities.Shop;
import bg.softuni.web.superMarket.repositories.ShopRepository;
import bg.softuni.web.superMarket.services.ShopService;
import bg.softuni.web.superMarket.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;

    public ShopServiceImpl(ShopRepository shopRepository, ModelMapper modelMapper, ValidationUtil validator) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }


    @Override
    public String addShop(ShopAddDto shopAddDto) {
        if(this.shopRepository.findShopByName(shopAddDto.getName()).isPresent()){
            return "The shop is already added!";
        }

        if(!this.validator.isValidEntity(shopAddDto) || !this.validator.isValidEntity(shopAddDto.getTown())){
            return "Invalid shop!";
        }

        Shop shop = this.modelMapper.map(shopAddDto,Shop.class);
        this.shopRepository.save(shop);


        return "Successfully added shop!";
    }
}
