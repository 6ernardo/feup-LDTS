package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DivisibleByFilterTest {
    @Test
    public void accept2(){
        DivisibleByFilter d = new DivisibleByFilter(2);

        List<Integer> dividible = Arrays.asList(0, 2,4,6,10,50,100,1000);
        List<Integer> nondividible = Arrays.asList(1,3,5,25,125,333,999);

        for(Integer n : dividible){
            Assertions.assertEquals(true, d.accept(n));
        }
        for(Integer n : nondividible){
            Assertions.assertEquals(false, d.accept(n));
        }
    }

    @Test
    public void accept3(){
        DivisibleByFilter d = new DivisibleByFilter(3);

        List<Integer> dividible = Arrays.asList(3, 6, 9, 27, 81, 333, 666, 999);
        List<Integer> nondividible = Arrays.asList(2, 4, 8, 23, 50, 301, 604, 1000);

        for(Integer n : dividible){
            Assertions.assertEquals(true, d.accept(n));
        }
        for(Integer n : nondividible){
            Assertions.assertEquals(false, d.accept(n));
        }
    }
}
