package com.task2.carriergot2.listeners;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostInsertEventListenerImpl;
import org.hibernate.event.spi.PostInsertEvent;

public class CustomAuditEventListenerPostInsert extends EnversPostInsertEventListenerImpl {
    public CustomAuditEventListenerPostInsert(EnversService enversService) {
        super(enversService);
    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
//        super.onPostInsert(event);
    }
}
