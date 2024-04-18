import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String s : completion) {
            
            map.put(s, (map.getOrDefault(s, 0) + 1));
        }
        
        List<String> list = Arrays.asList(participant);
        
        Iterator<String> it = list.iterator();
        
        while (it.hasNext()) {
            String value = it.next();
            int person = map.getOrDefault(value, 0);
            if (person == 0) {
                answer = value;
                break;
            } else {
                map.put(value, map.get(value) - 1);
            }
        }
        
        return answer;
    }
    
    private void print(String v) {
        System.out.println(v);
    }
    
    private void print(int v) {
        System.out.println(v);
    }
}