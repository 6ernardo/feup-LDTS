package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    List<Integer> list;

    @BeforeEach
    public void helper(){
        list = Arrays.asList(1,2,4,2,5);
    }

    @Test
    public void deduplicate() {
        class StubListSorter implements GenericListSorter{
            @Override public List<Integer> sort(List<Integer> list){
                return Arrays.asList(1,2,2,4,5);
            }
        }
        List<Integer> expected = Arrays.asList(1,2,4,5);

        StubListSorter sorter = new StubListSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_bug_8726(){
        List<Integer> list = Arrays.asList(1,2,4,2);
        List<Integer> expected = Arrays.asList(1,2,4);

        class StubListSorter implements GenericListSorter{
            @Override public List<Integer> sort(List<Integer> list){
                return Arrays.asList(1,2,2,4);
            }
        }

        StubListSorter sorter = new StubListSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }
}
