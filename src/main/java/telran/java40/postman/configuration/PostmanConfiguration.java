package telran.java40.postman.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostmanConfiguration {
	
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper= new ModelMapper();
		modelMapper.getConfiguration()
		.setFieldMatchingEnabled(true)
		.setFieldAccessLevel(AccessLevel.PRIVATE)
		.setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
		}

}
