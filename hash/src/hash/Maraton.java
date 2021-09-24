package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//참가선수 participant 완주선수 completion 
//완주하지 못한선수 이름 return

//참가선수는 1명이상 10만명이하
//완주선수 길이는 참가선수 길이보다 1 작다.
//참가자 이름은 1개 이상 20개 이하의 알파벳 소문자
//참가자는 동명이인 있을 수 있다.
public class Maraton {

	//정확성50 효율50
	public static String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
        Arrays.sort(completion);
	    
        int i;
        for(i=0; i<participant.length-1; i++)
        	//참가자명단과 완주자명단이 같지 않을때의, 해당 참가자가 미완주자
            if(!participant[i].equals(completion[i])) return participant[i];    
        
        //마지막참가자가 미완주자
		return participant[i];
	}
	
	public static String solution2(String[] participant,String[] completion) {
		String answer=null;
		HashMap<String, Integer> hm =new HashMap<>();
		//동명이인 때문에 +1을 해줘야 기존값에서 +1을 해준 값으로 추가된다.
		for(String player : participant) hm.put(player,hm.getOrDefault(player,0)+1);
		//-1을 해줌으로서 완주자들은 키값을 0으로 갖는다. 
		for(String player : completion) hm.put(player,hm.get(player)-1);
		
		//참가자들의 키값이 0이 아니면 미완주자이다.
		
		//방법1. 이방법은 반복문을 사용하기때문에 효율이 떨어진다.
		for(String player : participant) {	
			if(hm.get(player) != 0)
				answer = player;
		}
		
		//방법2. get메소드보다는 호출비용이 절감된다.	정확성50 효율성50
		for(Map.Entry<String,Integer> entry : hm.entrySet()) {
			if(entry.getValue() != 0)
				answer = entry.getKey();
		}
		
		return answer;
	}
	public static void main(String[] args) {
	}

}
