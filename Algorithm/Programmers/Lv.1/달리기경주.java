import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> rank = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            rank.put(players[i], i);
        }
        
        for(String player : callings){
            //이름 불린 선수
            int now = rank.get(player);
            
            //앞 등수 선수
            String front = players[now-1];
            
            players[now-1] = player;
            players[now] = front;
            
            rank.put(player, now-1);
            rank.put(front, now);
        }
        
        return players;
    }
}
