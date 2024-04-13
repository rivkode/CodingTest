import java.util.*;

class Solution {
    static Integer count;
    
    public int solution(int[] priorities, int location) {
        ArrayList<Process> list = new ArrayList<>();
        count = 0;
        
        char c = 'A';
        for (int i=0; i<priorities.length; i++) {
            int x = priorities[i];
            Process p = new Process(c, x);
            list.add(p);
            if (i == location) {
                p.setTarget(true);
            }
            c++;
            
        }
        
        while (!list.isEmpty()) {
            // int max = Collections.max(list);
            Process maxProcess = Collections.max(list);
            int max = maxProcess.getPriority();
            Process p = list.remove(0);
            
            // 우선순위가 최대보다 낮은 경우
            if (max > p.getPriority()) {
                list.add(p);
            // 우선순위가 최대보다 높은 경우
                // 출력 !!
            } else {
                // 그 출력한 값이 타겟인지 아닌지 체크
                count += 1;
                if (p.getTarget()) {
                    break;
                }

            }
            
            
        }
        
        System.out.println(count);
        int answer = count;
        return answer;
    }
    
    public static class Process implements Comparable<Process> {
        Integer priority;
        Character name;
        Boolean target;
        
        public Process(Character name, Integer priority) {
            this.priority = priority;
            this.name = name;
            this.target = false;
        }
        
        public void setTarget(Boolean b) {
            this.target = b;
        }
        
        public Integer getPriority() {
            return priority;
        }
        
        public Character getName() {
            return name;
        }
        
        public Boolean getTarget() {
            return target;
        }
        
        @Override
        public int compareTo(Process other) {
            return Integer.compare(this.priority, other.priority);
        }
    }
}