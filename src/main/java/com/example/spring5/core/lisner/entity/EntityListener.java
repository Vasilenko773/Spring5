package com.example.spring5.core.lisner.entity;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {

    @EventListener(condition = "#root.args[0].accessType.name() == 'READ'")
    public void acceptEntityRead(EntityEvent entityEvent) {
        System.out.println("");
        System.out.println("############");
        System.out.println("Entity :" + entityEvent);
        System.out.println("############");
        System.out.println("");
    }
}
