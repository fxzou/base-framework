package demo.fxzou.baseframework.domain.core.common.excpetions;

public abstract class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
