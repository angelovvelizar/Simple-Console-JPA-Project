package bg.softuni.web.superMarket.services.impl;

import bg.softuni.web.superMarket.models.dtos.TownAddDto;
import bg.softuni.web.superMarket.models.entities.Town;
import bg.softuni.web.superMarket.repositories.TownRepository;
import bg.softuni.web.superMarket.services.TownService;
import bg.softuni.web.superMarket.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, ValidationUtil validator) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public String addTown(TownAddDto townAddDto) {
        if(!this.validator.isValidEntity(townAddDto)){
            return "Town name is not valid!";
        }

        if(this.townRepository.findTownByName(townAddDto.getName()).isPresent()){
            return "Town is already added!";
        }

        Town town = this.modelMapper.map(townAddDto, Town.class);
        this.townRepository.save(town);

        return "Town is successfully added!";
    }
}
