package com.etnetera.hr.data;


import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(JavaScriptFrameworkRepository repository){

        return args -> {
            log.info("Preloading " + repository.save(new JavaScriptFramework("Angular","1.0", LocalDate.of(1990, Month.JANUARY,1), JavaScriptFramework.HypeLevel.NOBODY_USES_IT)));
            log.info("Preloading " + repository.save(new JavaScriptFramework("React","1.0",LocalDate.of(1990,1,1), JavaScriptFramework.HypeLevel.NOBODY_USES_IT)));
        };
    }

}
