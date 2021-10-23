package com.flexport;

import java.util.*;

/**
 * Generate a random sentence of length N from a given text. Logic:
 *
 * Randomly select a word
 * The next word will be the subsequent contagious word from the previously selected word. If the next word occurs multiple times in the sentence, select randomly.
 * Continue until length fulfill required length
 * Special case: If the chosen word has no next word (last word in the sentence, use first word as the "next word" - assume circular)
 *
 * Example
 * text = "hello this is a flexport interview and this is a hello and that was cool"
 * n = 4
 *
 * say first word randomly selected is "flexport"
 * next word after "flexport" in the text is "interview". "interview" only occurs once.
 * next word after "interview" in the text is "and". "and" occurs twice at index 6 & 11. Randomly select one of the indices. Say we select the one at index 6
 * next word after "and" at index 6 is "this". "this" occurs at twice at index 1 & 7. Randomly selected at 7.
 * Output: "flexport interview and this"
 */

public class RandomWriter {
    public static void main(String[] args) {
        String content = "this is a sentence it is not a good one and it is also bad";
        String searchStr = "sentence";
        StringBuilder result = new StringBuilder();
        String[] datas = content.split(" ");
        Map<String, List<String>> nextMap = new HashMap<>();

        RandomWriter randomWriter = new RandomWriter();
        randomWriter.solution(datas,searchStr,result,nextMap);
        System.out.println(result.toString());
    }

    public String solution(String[] datas,String searchStr,StringBuilder result,Map<String, List<String>> nextMap){

        int count = 0;

        for( int i=0; i<datas.length ; i++ ){
            if ( searchStr.equals(datas[i]) ){
                result.append(datas[i]);
                result.append(" ");
                count++;
                if ( count == 5 ){
                    return result.toString();
                }

                if ( !nextMap.containsKey(searchStr) ){
                    List<String> nextList = new ArrayList<>();
                    nextList.add(datas[(i+1)%datas.length]);
                    nextMap.put(datas[i],nextList);
                }
                else{
                    List<String> nextTmpList = nextMap.get(searchStr);
                    if ( !nextTmpList.contains(datas[(i+1)%datas.length]) ){
                        nextTmpList.add(datas[(i+1)%datas.length]);
                    }
                }

                searchStr = datas[(i+1)%datas.length];
            }
        }

        if ( nextMap.get(searchStr).size() ==1 ){
            solution(datas,nextMap.get(searchStr).get(0),result,nextMap);
        }
        else{
            Random random = new Random();
            int index = random.nextInt(nextMap.get(searchStr).size());
            solution(datas,nextMap.get(searchStr).get(index),result,nextMap);
        }

        return result.toString();
    }
}
