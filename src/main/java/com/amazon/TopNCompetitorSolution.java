package com.amazon;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
class TopNCompetitorSolution
{
    public static void main(String[] args) {
        int numCompetitors = 5;
        int topNCompetitors = 2;
        List<String> competitors = Arrays.asList("huawei","zte","baidu","ali","xiaomi");
        int numReviews = 20;
        List<String> reviews = Arrays.asList("huawei zte ali ali ali ali huawei huawei zte","zte zte zte zte zte");

        TopNCompetitorSolution topNCompetitorSolution = new TopNCompetitorSolution();
        System.out.println(topNCompetitorSolution.topNCompetitors(numCompetitors,topNCompetitors,competitors,numReviews,reviews));
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews)
    {
        ArrayList<String> results = new ArrayList<>();
        // WRITE YOUR CODE HERE
        if ( topNCompetitors > numCompetitors )
        {
            for( String competitor: competitors  ){
                if ( isDiscussedInReviews(competitor,reviews) ){
                    results.add(competitor);
                }
            }

            return results;
        }

        Map<String,Integer> resultMap = computeResultMap(competitors,reviews);

        List<Map.Entry<String, Integer>> sortedList = sortByValue(resultMap);

        int tmp = 0;
        for( int i=0;i<topNCompetitors;i++ ){
            Map.Entry<String,Integer> entry = sortedList.get(i);
            if ((tmp += entry.getValue()) <= numReviews){
                results.add(entry.getKey());
            }
        }

        return results;
    }

    private Map<String,Integer> computeResultMap(List<String> competitors,List<String> reviews){
        Map<String,Integer> resultMap = new HashMap<>();
        for(String competitor:competitors){
            resultMap.put(competitor,0);
        }

        for( String competitor : competitors ){
                int cnt = getDiscussedCount(competitor,reviews);
                resultMap.put(competitor,cnt);
        }

        return resultMap;
    }

    private List<Map.Entry<String, Integer>> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        return list;
    }

    private boolean isDiscussedInReviews(String competitor,List<String> reviews)
    {
        boolean flag = false;
        String[] contents;
        for( String review :  reviews)
        {
            contents = review.split(" ");
            for( String content : contents )
            {
                if ( competitor.equals(content) )
                {
                    flag = true;
                    return flag;
                }
            }
        }

        return flag;
    }
    // METHOD SIGNATURE ENDS
    private int getDiscussedCount(String competitor,List<String> reviews)
    {
        int cnt = 0;
        String[] contents;
        for( String review :  reviews)
        {
            contents = review.split(" ");
            for( String content : contents )
            {
                if ( competitor.equals(content) )
                {
                    cnt++;
                }
            }
        }

        return cnt;
    }

}

