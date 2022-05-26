package com.amazon;

public class MinimumDaysDelivery {

    public int getMinimumDays(int[] parcels){
        int days = 0;
        int curParcels = Integer.MAX_VALUE;
        int total = getTotalParcels(parcels);

        while(total != 0){
            for(int i = 0;i < parcels.length; i++){
                if (parcels[i] > 0 && parcels[i] < curParcels){
                    curParcels = parcels[i];
                }
            }

            for(int i = 0;i < parcels.length; i++){
                if (parcels[i] >= curParcels)
                    parcels[i] = parcels[i] - curParcels;
            }

            total = getTotalParcels(parcels);
            days++;
        }

        return days;
    }

    private int getTotalParcels(int[] parcels){
        int sum = 0;
        for(int parcel : parcels)
            sum += parcel;

        return sum;
    }
}
