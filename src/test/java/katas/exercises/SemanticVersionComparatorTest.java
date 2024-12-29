package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SemanticVersionComparatorTest {

    @Test
    public void testCompareVersions() {
        // Test case 1: First version is smaller
        assertEquals(-1, SemanticVersionComparator.compareVersions("1.0.0", "1.0.1"),
                "Expected -1 when version1 is smaller than version2");

        // Test case 2: First version is larger
        assertEquals(1, SemanticVersionComparator.compareVersions("2.1.0", "1.9.9"),
                "Expected 1 when version1 is greater than version2");

        // Test case 3: Versions are equal
        assertEquals(0, SemanticVersionComparator.compareVersions("1.2.3", "1.2.3"),
                "Expected 0 when versions are equal");

        // Test case 4: Version1 has fewer components but is equivalent
        assertEquals(0, SemanticVersionComparator.compareVersions("1.0.0", "1.0.0"),
                "Expected 0 when version1 has fewer components but is equivalent to version2");

        // Test case 5: Version2 has fewer components but is equivalent
        assertEquals(0, SemanticVersionComparator.compareVersions("1.0.0", "1.0.0"),
                "Expected 0 when version2 has fewer components but is equivalent to version1");




        // Test case 8: Major version difference
        assertEquals(1, SemanticVersionComparator.compareVersions("2.0.0", "1.9.9"),
                "Expected 1 when version1 has a larger major version");

        assertEquals(-1, SemanticVersionComparator.compareVersions("1.9.9", "2.0.0"),
                "Expected -1 when version2 has a larger major version");

        // Test case 9: Edge case - empty strings
        assertEquals(0, SemanticVersionComparator.compareVersions("", ""),
                "Expected 0 when both versions are empty");
    }
}
