package demo.fxzou.baseframework.adapters.outbound.persistence;

import java.io.Serializable;

public interface PersistenceObject<T> extends Serializable {
    T toDomainModel();
}
