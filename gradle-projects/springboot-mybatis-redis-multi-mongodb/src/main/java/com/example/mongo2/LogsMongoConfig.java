package com.example.mongo2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb.logs")
public class LogsMongoConfig extends AbstractMongoConfig {
//	@Primary
//	@Override
//	public @Bean(name = "logsMongoTemplate") MongoTemplate getMongoTemplate() throws Exception {
//		MongoDbFactory mf = mongoDbFactory();
//		MappingMongoConverter converter = new MappingMongoConverter(mf, new MongoMappingContext());
//		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//		return new MongoTemplate(mf, converter);
//	}

    @Primary
    @Override
    @Bean(name = "logsMongoTemplate")
    public MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

}
