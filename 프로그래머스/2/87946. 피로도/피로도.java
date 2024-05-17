import java.util.*;

class Solution {
    static boolean[] visited;
    static int count = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return count;
    }
    
    
    public void dfs(int depth, int fatigue, int[][] dungeons) {
        
        for (int i=0; i<dungeons.length; i++ ){
            if (visited[i] || dungeons[i][0] > fatigue) {
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        count = Math.max(count, depth);
    }
    
    
//     public int solution(int k, int[][] dungeons) {
//         List<Psystem> list = new ArrayList<>();
        
//         for (int i=0; i<dungeons.length; i++) {
//             int minimunP = dungeons[i][0];
//             int consumeP = dungeons[i][1];
//             Psystem p = new Psystem(minimunP, consumeP);
//             list.add(p);
//         }
        
//         int count = 0;
        
//         while (true) {
//             List<Psystem> pSystemList = possiblePsystemFromList(k, list);
//             if (pSystemList.isEmpty()) {
//                 print("No more dungeons can be entered");
//                 break; // No more dungeons can be entered
//             }
//             Psystem p = getPossiblePsystem(pSystemList);
//             print("p mini "+ p.getMinimunP());
//             print("p cons "+ p.getConsumeP());
//             int idx = list.indexOf(p);
//             list.remove(idx);
//             print("list size" + list.size());
//             count += 1;
            
//             k = k - p.getConsumeP();
//             print(k);
            
//             if (list.size() == 0) {
//                 print("size 0");
//                 break;
//             }
            
//             if (!isPossibleToEnter(k, list)) {
//                 print("not possible");
//                 break;
//             }
            
//             print("list size --" + list.size());
//         }
        
//         print(count);
        
//         return count;
//     }
    
    public List<Psystem> possiblePsystemFromList(int k, List<Psystem> pList) {
        List<Psystem> ppList = new ArrayList<>();
        for (Psystem p : pList) {
            // k 피로도 / minimunP : 최소 피로도
            if (k >= p.getMinimunP()) {
                ppList.add(p);
            }
        }
        print("ppList size " + ppList.size());
        
        return ppList;
    }
    
    public Psystem getPossiblePsystem(List<Psystem> pList) {
        List<Integer> nList = new ArrayList<>();
        
        // 가능한 던전 중
        // 가장 높은 최소 피로도를 가진 던전을 선택해야 함 - 아님
        // 가장 높은 최소 피로도를 가진 던전이 여러개라면 그 중 가장 낮은 
        // 가장 작은  
        for (int i=0; i<pList.size(); i++) {
            nList.add(pList.get(i).getConsumeP());
        }
        
        int minimun = Collections.min(nList);
        
        for (Psystem p : pList) {
            if (p.getConsumeP() == minimun) {
                // 정상 리턴
                return p;
            }
        }
        // 에러
        Psystem p = new Psystem(0, 0);
        
        return p;
    }
    
    public Boolean isPossibleToEnter(int k, List<Psystem> pList) {
        for (Psystem p : pList) {
            if (k >= p.getMinimunP()) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void print(int x) {
        System.out.println(x);
    }
    
    public static void print(String x) {
        System.out.println(x);
    }
    
    public class Psystem {
        private int minimunP;
        private int consumeP;
        
        public Psystem(int minimunP, int consumeP) {
            this.minimunP = minimunP;
            this.consumeP = consumeP;
        }
        
        public int getMinimunP() {
            return this.minimunP;
        }
        
        public int getConsumeP() {
            return this.consumeP;
        }
    }
}