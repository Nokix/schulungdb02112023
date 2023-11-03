package db.schulung.aop;

import org.springframework.stereotype.Component;

@Component
public class Math {

    public long fak(long n) {
        return n <= 1 ? 1 : fak(n - 1) * n;
    }

    @SafeResults
    public long binom(long n, long k) {
        return k >= n || k <= 0 ? 1
                : binom(n - 1, k) + binom(n - 1, k - 1);
    }
}
