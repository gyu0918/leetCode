import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력: 공백 기준으로 문자열 배열 받기
        String[] strs = br.readLine().split(" ");
        
        List<List<String>> result = groupAnagrams(strs);
        
        
        // 출력
        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    //시간 복잡도 O(n.klogk)
    //공간 복잡도 O(n⋅k)
    public static List<List<String>> groupAnagrams(String[] strs) {
         
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();  //O(k)
            Arrays.sort(chars); // 핵심: 정렬   //O(klogk)
            
            String key = new String(chars);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}