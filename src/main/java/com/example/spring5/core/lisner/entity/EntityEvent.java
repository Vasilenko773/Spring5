package com.example.spring5.core.lisner.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.EventObject;

@Getter
@Setter
public class EntityEvent extends EventObject  {

    private final AccessType accessType;


    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public EntityEvent(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }
}
