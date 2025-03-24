package dev.jwall64.plib;

import java.util.Optional;

public interface PlaceholderSupplier<T, P> {

    Optional<T> get(ResolveContext<T, P> context);


    static <T> PlaceholderSupplier<T, Void> of(T value) {
        return context -> Optional.of(value);
    }

}
