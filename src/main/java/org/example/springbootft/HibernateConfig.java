package org.example.springbootft;


import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import java.util.Properties;



public class HibernateConfig {
private Logger log = Logger.getLogger(this.getClass());




public SessionFactory getSessionFactory() {
    org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
    Properties properties = new Properties();
    try {
        properties.load(HibernateConfig.class.getResourceAsStream("/hibernate.properties"));
        configuration.setProperties(properties);
    }catch (Exception e) {
        log.error(e);
    }
    configuration.addAnnotatedClass(Apple.class);
    return configuration.buildSessionFactory();

}





}
