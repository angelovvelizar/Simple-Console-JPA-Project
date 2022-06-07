package bg.softuni.web.superMarket.services.impl;

import bg.softuni.web.superMarket.models.dtos.SellerAddDto;
import bg.softuni.web.superMarket.models.entities.Seller;
import bg.softuni.web.superMarket.repositories.SellerRepository;
import bg.softuni.web.superMarket.repositories.ShopRepository;
import bg.softuni.web.superMarket.services.SellerService;
import bg.softuni.web.superMarket.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;
    private final ShopRepository shopRepository;

    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper, ValidationUtil validator, ShopRepository shopRepository) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.shopRepository = shopRepository;
    }

    @Override
    public String addSeller(SellerAddDto sellerAddDto) {
        if(!this.validator.isValidEntity(sellerAddDto)){
            return "Invalid seller!";
        }

        if(this.sellerRepository.findSellerByFirstNameAndLastName(sellerAddDto.getFirstName(),sellerAddDto.getLastName()).isPresent()){
            return "The seller is already added";
        }

        Seller seller = this.modelMapper.map(sellerAddDto, Seller.class);
        seller.setShop(this.shopRepository.findShopByName(sellerAddDto.getShop()).orElse(null));
        this.sellerRepository.save(seller);

        return "Successfully added seller!";
    }
}
