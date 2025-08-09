package com.github.onacit.book.jcip.chapter03;

import jakarta.annotation.Nullable;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

class OneValueCache {

    OneValueCache(final BigInteger lastNumber, final BigInteger[] factors) {
        super();
        this.lastNumber = lastNumber;
        this.factors = Arrays.copyOf(factors, factors.length);
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object
    @Override
    public String toString() {
        return super.toString() + '{' +
                "lastNumber=" + lastNumber +
                ",factors=" + Arrays.toString(factors) +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof OneValueCache that)) {
            return false;
        }
        return Objects.equals(lastNumber, that.lastNumber) &&
                Objects.deepEquals(factors, that.factors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                lastNumber,
                Arrays.hashCode(factors)
        );
    }

    // ------------------------------------------------------------------------------------------------------ lastNumber

    // --------------------------------------------------------------------------------------------------------- factors
    @Nullable
    BigInteger[] getFactors(final BigInteger i) {
        if (lastNumber != null && lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(factors, factors.length);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final BigInteger lastNumber;

    private final BigInteger[] factors;
}
