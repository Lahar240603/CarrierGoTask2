package com.task2.carriergot2.configs;

import com.task2.carriergot2.listeners.CustomAuditEventListenerPostInsert;
import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class EnversConfig {

    @Autowired
    private HibernateEntityManagerFactory hibernateEntityManagerFactory;

    @PostConstruct
    public void registerEnversListeners() {
        EnversService enversService = hibernateEntityManagerFactory.getSessionFactory().getServiceRegistry().getService(EnversService.class);
        EventListenerRegistry listenerRegistry = hibernateEntityManagerFactory.getSessionFactory().getServiceRegistry().getService(EventListenerRegistry.class);

        listenerRegistry.setListeners(EventType.POST_INSERT, new CustomAuditEventListenerPostInsert(enversService));
    }
}
