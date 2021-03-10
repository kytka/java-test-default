package com.etnetera.hr.data;


import com.etnetera.hr.repository.FrameworkVersionRepository;
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
    CommandLineRunner initDatabase(JavaScriptFrameworkRepository frameworkRepository, FrameworkVersionRepository versionRepository){

        return args -> {

            JavaScriptFramework framework1 = new JavaScriptFramework("Angular");
            JavaScriptFramework framework2 = new JavaScriptFramework("React");
            JavaScriptFramework framework3 = new JavaScriptFramework("Vue");

            FrameworkVersion version1A = new FrameworkVersion("1.0", LocalDate.of(1991, Month.JANUARY,1), FrameworkVersion.HypeLevel.NOBODY_USES_IT);
            FrameworkVersion version2A = new FrameworkVersion("2.0", LocalDate.of(1992, Month.JANUARY,1), FrameworkVersion.HypeLevel.SOMEBODY_USES_IT);
            FrameworkVersion version1R = new FrameworkVersion("1.0", LocalDate.of(1991, Month.JANUARY,1), FrameworkVersion.HypeLevel.NOBODY_USES_IT);
            FrameworkVersion version2R = new FrameworkVersion("2.0", LocalDate.of(1992, Month.JANUARY,1), FrameworkVersion.HypeLevel.SOMEBODY_USES_IT);
            FrameworkVersion version3R = new FrameworkVersion("3.0", LocalDate.of(1993, Month.JANUARY,1), FrameworkVersion.HypeLevel.EVERYBODY_USES_IT);




            log.info("Preloading frameworks " + frameworkRepository.save(framework1));
            log.info("Preloading frameworks " + frameworkRepository.save(framework2));
            log.info("Preloading frameworks " + frameworkRepository.save(framework3));

            log.info("Preloading versions " + versionRepository.save(version1A));
            log.info("Preloading versions " + versionRepository.save(version2A));
            log.info("Preloading versions " + versionRepository.save(version1R));
            log.info("Preloading versions " + versionRepository.save(version2R));
            log.info("Preloading versions " + versionRepository.save(version3R));

            log.info("Adding versions to frameworks");
            framework1.addVersion(version1A);
            framework1.addVersion(version2A);
            framework2.addVersion(version1R);
            framework2.addVersion(version2R);
            framework3.addVersion(version3R);

        };
    }

}
