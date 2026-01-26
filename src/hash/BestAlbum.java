package hash;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {
    public static void main(String[] args) {
        String[] a = {"classic", "pop", "classic", "classic", "pop"};
        int[] b = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(a, b)));

    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String,Map<Integer,Integer>> map = new HashMap<>();

        for(int i=0;i<genres.length;i++){
            if(!map.containsKey(genres[i])){
                map.put(genres[i], new HashMap<>());
            }
            map.get(genres[i]).put(i,plays[i]);
        }

        List<String> keyList = new ArrayList<>(map.keySet());

        keyList.sort((key1,key2)->{
           int sum1 = map.get(key1).values().stream().mapToInt(Integer::intValue).sum();
           int sum2 = map.get(key2).values().stream().mapToInt(Integer::intValue).sum();
           return sum2-sum1;
        });

        List<Integer> result = new ArrayList<>();

        for(String key : keyList){
            Map<Integer,Integer> sortedMap = map.get(key).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1,e2) ->e1 ,
                            LinkedHashMap::new
                    ));
            int count = 0;
            for (var ans : sortedMap.keySet()) {
                if(count>=2)
                    break;
                result.add(ans);
                count ++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
