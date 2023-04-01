package com.example.spring5.core.lisner.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EntityListener {

    @EventListener(condition = "#root.args[0].accessType.name() == 'READ'")
    public void acceptEntityRead(EntityEvent entityEvent) {
        log.info("");
        log.info("############");
        log.info("Entity :" + entityEvent);
        log.info("############");
        log.info("");
    }
}
