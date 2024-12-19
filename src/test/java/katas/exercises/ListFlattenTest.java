package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListFlattenTest {

    @Test
    public void testFlattenList_WithNestedList() {
        List<Object> nestedList = new ArrayList<>();
        nestedList.add(1);
        nestedList.add(List.of(2, 3));
        nestedList.add(List.of(4, List.of(5, 6)));
        nestedList.add(7);

        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> result = ListFlatten.flattenList(nestedList);

        assertEquals(expected, result, "The method should flatten a nested list correctly.");
    }

    @Test
    public void testFlattenList_WithSingleLevelList() {
        List<Object> nestedList = List.of(1, 2, 3, 4);

        List<Integer> expected = List.of(1, 2, 3, 4);
        List<Integer> result = ListFlatten.flattenList(nestedList);

        assertEquals(expected, result, "The method should handle a single-level list correctly.");
    }

    @Test
    public void testFlattenList_WithEmptyList() {
        List<Object> nestedList = new ArrayList<>();

        List<Integer> expected = List.of();
        List<Integer> result = ListFlatten.flattenList(nestedList);

        assertEquals(expected, result, "The method should return an empty list for an empty input.");
    }

    @Test
    public void testFlattenList_WithDeeplyNestedList() {
        List<Object> nestedList = new ArrayList<>();
        nestedList.add(List.of(List.of(1, 2), List.of(3, List.of(4, 5)), 6));
        nestedList.add(7);

        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> result = ListFlatten.flattenList(nestedList);

        assertEquals(expected, result, "The method should handle deeply nested lists correctly.");
    }

    @Test
    public void testFlattenList_WithMixedEmptyLists() {
        List<Object> nestedList = new ArrayList<>();
        nestedList.add(1);
        nestedList.add(new ArrayList<>());
        nestedList.add(List.of(2, new ArrayList<>(), 3));
        nestedList.add(new ArrayList<>());

        List<Integer> expected = List.of(1, 2, 3);
        List<Integer> result = ListFlatten.flattenList(nestedList);

        assertEquals(expected, result, "The method should skip empty lists and flatten non-empty elements.");
    }
}
