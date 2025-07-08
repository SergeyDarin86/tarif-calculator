package ru.fastdelivery.domain.common.dimension;

import ru.fastdelivery.domain.common.weight.Weight;

import java.math.BigDecimal;
import java.math.BigInteger;

public record Dimension(BigDecimal length, BigDecimal width, BigDecimal height) {

    public Dimension {
        if (isLessThanZero(length, width, height)) {
            throw new IllegalArgumentException("Dimension cannot be below Zero!");
        }
    }

    private static boolean isLessThanZero(BigDecimal length, BigDecimal width, BigDecimal height) {
        return BigDecimal.ZERO.compareTo(length) > 0
                || BigDecimal.ZERO.compareTo(width) > 0
                || BigDecimal.ZERO.compareTo(height) > 0;
    }

    public static Dimension zero() {
        return new Dimension(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }

}
