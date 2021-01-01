package demo.fxzou.baseframework.domain.core.common.excpetions;


import demo.fxzou.baseframework.domain.core.concepts.Entity;

import java.io.Serializable;

public class EntityNotFoundException extends DomainException {
    public EntityNotFoundException(String message) {
        super(message);
    }

    public <T extends Entity> EntityNotFoundException(Class<T> entityClass, Serializable id) {
        super("cannot find the " + entityClass.getSimpleName().toLowerCase() + " with id " + id);
    }
}
