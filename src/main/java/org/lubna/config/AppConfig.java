package org.lubna.config;

import org.lubna.dao.AccountDao;
import org.lubna.dao.impl.AccountDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.lubna")
public class AppConfig {

    @Bean
    public AccountDao accountDao() {
        return new AccountDaoImpl();
    }

}
