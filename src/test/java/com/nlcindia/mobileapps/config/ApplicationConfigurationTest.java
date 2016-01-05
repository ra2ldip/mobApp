package com.nlcindia.mobileapps.config;

import com.nlcindia.oss.mobileapp.userinformation.dao.OssAppUserRepo;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author muthu vairavan
 */
@Configuration
@ComponentScan(basePackages = "com.nlcindia.oss.mobileapp", excludeFilters = {
    @Filter(Controller.class),
    @Filter(Configuration.class)})
//@EnableCaching
//@ImportResource(value = {"classpath:eprocTemplates.xml","classpath:messaingTempletes.xml"})
@EnableTransactionManagement
@EnableJpaRepositories()
public class ApplicationConfigurationTest {
    
    public ApplicationConfigurationTest() {
        System.out.println("Hey there");
    }
    
  
    /**
     * Test of propertyConfigurer method, of class ApplicationConfiguration.
     */
      @Bean(name = "oradataSource")
    public DataSource oradataSource() {
        // change this when needed
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@172.16.25.94:1521:orcl12c");
        dataSource.setUsername("oss");
        dataSource.setPassword("wk11oss");
        return dataSource;

    }
       @Bean
    public EntityManagerFactory entityManagerFactory() throws Exception {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);
        //vendorAdapter.setDatabase(Database.ORACLE);
        //vendorAdapter.setDatabase(Database.DERBY);
//        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.DerbyTenSevenDialect");
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
        vendorAdapter.setDatabase(Database.ORACLE);
        vendorAdapter.setShowSql(true);
           System.out.println("I am here");
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.nlcindia.oss.mobileapp");
        factory.setDataSource(oradataSource());

        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public org.springframework.orm.hibernate4.HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new org.springframework.orm.hibernate4.HibernateExceptionTranslator();
    }
    @Autowired
    OssAppUserRepo oaur;
    @Test
    public void done(){
//        System.out.println("Working fine");
        System.out.println("OK ::"+oaur.findOne(6019l));
    }
}
