1.MinimumDaysDelivery
    Amazon Delivery Centers dispath parcels every day.There are n delivery centers.each having parcels[i] parcels to be delivered.
On each day,an equal number of parcels are to be dispatched from each delivery center that has at least one parcel remaining.

Find the minimum number of days needed to deliver all the parcels.
Example
parcels = [2, 3, 4, 3, 3] output 3

2.Count possible Segments
    Amazon warehouse has a group of n item of various weights lined up in a row.A segment of contiguously placed items can be shipped
together,if and only if the difference between the weights of the heaviest and lightest item differs by at most k to avoid load
imbalance.

Given the weights of the n items and an integer k,find the numbers of segments of items that can be shipped together.

Note:A segment(l,r) is a subarray starting at index l and ending at index r where l <= r

Example
k = 3
weights = [1, 3, 6]

return 5

Example
k = 3
weights = [1, 5, 4]

return 4