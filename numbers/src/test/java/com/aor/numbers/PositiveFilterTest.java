package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PositiveFilterTest {
    @Test
    public void accept(){
        PositiveFilter p = new PositiveFilter();

        List<Integer> positives = Arrays.asList(1,2,3,10,50,100,500,1000, Integer.MAX_VALUE);
        List<Integer> negatives = Arrays.asList(0, -1, -2, -3, -10, -50, -100, -500, -1000, Integer.MIN_VALUE);

        for(int n : positives){
            Assertions.assertEquals(true, p.accept(n));
        }

        for(int n : negatives){
            Assertions.assertEquals(false, p.accept(n));
        }
    }
}
