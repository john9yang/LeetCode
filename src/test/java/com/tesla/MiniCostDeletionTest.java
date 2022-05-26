package com.tesla;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class MiniCostDeletionTest {

    @Test
    public void solutionTest(){
        MiniCostDeletion deletion = new MiniCostDeletion();
        String s = "abccbd";
        int[] c = new int[]{0, 1, 2, 3, 4, 5};
        int result = deletion.solution(s, c);
        assumeTrue(result == 2);
    }
}
