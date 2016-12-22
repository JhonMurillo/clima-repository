//package com.app.app.infraestruct.config;
//
////import com.zabud.filtro.config.WebConfig;
//import javax.jms.ConnectionFactory;
//import org.apache.activemq.command.ActiveMQTopic;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.embedded.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
//import org.springframework.jms.connection.CachingConnectionFactory;
//
//@EnableJms
//@Configuration
//public class JMSConfig {
//
//    @Value("${jms.clientid.queue}")
//    private String clientidQueue;
//
//    @Value("${jms.clientid.topic}")
//    private String clientidTopic;
//
//    @Value("${jms.cache.size}")
//    private int jmsCacheSize;
//
////    @Value("${mensajes.queue.eventosnf}")
////    private String topicEventoNF;
////
////    @Value("${mensajes.queue.eventosfacultad}")
////    private String topicEventoFacultad;
////
////    @Value("${mensajes.queue.eventosrequisito}")
////    private String topicEventoRequisito;
////
////    @Value("${mensajes.queue.eventostipoconvenio}")
////    private String topicEventoTipoConvenio;
//
////    @Bean
////    public ActiveMQTopic topicEventoNF() {
////        return new ActiveMQTopic(topicEventoNF);
////    }
////
////    @Bean
////    public ActiveMQTopic topicEventoFacultad() {
////        return new ActiveMQTopic(topicEventoFacultad);
////    }
////
////    @Bean
////    public ActiveMQTopic topicEventoRequisito() {
////        return new ActiveMQTopic(topicEventoRequisito);
////    }
////
////    @Bean
////    public ActiveMQTopic topicEventoTipoConvenio() {
////        return new ActiveMQTopic(topicEventoTipoConvenio);
////    }
//
//    
//    @Bean
//    public DefaultJmsListenerContainerFactory jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory) {
//        CachingConnectionFactory ccf = new CachingConnectionFactory(connectionFactory);
//        ccf.setClientId(clientidTopic);
//        ccf.setSessionCacheSize(jmsCacheSize);
//        DefaultJmsListenerContainerFactory dmlc = new DefaultJmsListenerContainerFactory();
//        dmlc.setPubSubDomain(true);
//        dmlc.setConnectionFactory(ccf);
//        return dmlc;
//    }
//
//    @Bean
//    public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory(ConnectionFactory connectionFactory) {
//        CachingConnectionFactory ccf = new CachingConnectionFactory(connectionFactory);
//        ccf.setClientId(clientidQueue);
//        ccf.setSessionCacheSize(jmsCacheSize);
//        DefaultJmsListenerContainerFactory dmlc = new DefaultJmsListenerContainerFactory();
//        dmlc.setConnectionFactory(ccf);
//        return dmlc;
//    }
//
////    @Bean
////    public FilterRegistrationBean shallowEtagHeaderFilter() {
////        return new WebConfig().shallowEtagHeaderFilter();
////    }
//}
