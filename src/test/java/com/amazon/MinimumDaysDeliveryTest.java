package com.amazon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class MinimumDaysDeliveryTest {

    @Test
    public void getMinimumDaysTest(){
        MinimumDaysDelivery solution = new MinimumDaysDelivery();
        int[] parcels = {4, 2, 3, 4};
        int result1 = solution.getMinimumDays(parcels);
        assumeTrue(result1 == 3);

        int[] parcels2 = {2, 3, 4, 3, 3};
        int result2 = solution.getMinimumDays(parcels2);
        assumeTrue(result2 == 3);
    }
}
