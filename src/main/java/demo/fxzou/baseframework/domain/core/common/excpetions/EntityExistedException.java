package demo.fxzou.baseframework.domain.core.common.excpetions;


import demo.fxzou.baseframework.domain.core.concepts.Entity;

import java.util.UUID;

public class EntityExistedException extends DomainException {
    public EntityExistedException(String message) {
        super(message);
    }

    public <T extends Entity> EntityExistedException(Class<T> entityClass, UUID id) {
        super("the " + entityClass.getSimpleName().toLowerCase() + " with id " + id + " was existed");
    }
}
