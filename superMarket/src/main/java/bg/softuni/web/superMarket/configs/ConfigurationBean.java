package bg.softuni.web.superMarket.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBean {


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
