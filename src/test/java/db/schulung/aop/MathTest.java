package db.schulung.aop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MathTest {
    @Autowired
    Math math;

    @Test
    void fak() {
    }

    private static Stream<Object[]> binomDataProvider() {
        return Stream.of(
                new Object[] { 1, 5, 0 },
                new Object[] { 5, 5, 1 },
                new Object[] { 10, 5, 2 },
                new Object[] {137_846_528_820L, 40, 20 }

        );
    }

    @ParameterizedTest
    @MethodSource("binomDataProvider")
    void binom(long result, long n, long k) {
        assertEquals(result, math.binom(n, k));
    }
}