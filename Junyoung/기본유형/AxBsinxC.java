// https://www.acmicpc.net/problem/13705

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    MathContext mthctx = new MathContext(100, RoundingMode.HALF_EVEN);
    BigDecimal PI2 = new BigDecimal(
            "6.2831853071795864769252867665590057683943387" +
                    "98750211641949889184615632812572417997256069650684234136");

    public BigDecimal sin(BigDecimal x) {
        x = x.remainder(PI2, mthctx);
        BigDecimal acc = BigDecimal.ZERO;
        BigDecimal coeff = x;
        for (int i = 0; i < 50; ++i) {
            acc = acc.add(coeff, mthctx);
            coeff = coeff.multiply(x.pow(2, mthctx), mthctx)
                    .divide(BigDecimal.valueOf(-(2 * i + 2) * (2 * i + 3)), mthctx);
        }
        return acc;
    }
    public Solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        BigDecimal A = new BigDecimal(st.nextToken());
        BigDecimal B = new BigDecimal(st.nextToken());
        BigDecimal C = new BigDecimal(st.nextToken());

        DecimalFormat df = new DecimalFormat("0.000000");
        df.setRoundingMode(RoundingMode.HALF_UP);
        BigDecimal low = new BigDecimal(-400000), high = new BigDecimal(400000);
        BigDecimal m = BigDecimal.ZERO;
        for (int i = 0; i < 1000; i++) {
            m = low.add(high, mthctx).divide(new BigDecimal(2), mthctx);
            BigDecimal v = A.multiply(m, mthctx)
                    .add(B.multiply(sin(m), mthctx), mthctx)
                    .subtract(C, mthctx);
            int cmp = v.compareTo(BigDecimal.ZERO);
            if (cmp < 0) low = m;
            else high = m;
        }
        bw.write(df.format(m));
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution();
    }
}