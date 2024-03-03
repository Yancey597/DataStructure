package leetcode.Koko_eating_bananas_LC875;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private int[] piles={};
    private int h;
    private Solution solution = new Solution();

    @BeforeEach
    void setUp() {
        piles = new int[]{3, 6, 7, 11};
        h = 8;

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void minEatingSpeed() {

        assertEquals(4,solution.minEatingSpeed(piles, h));
    }
}