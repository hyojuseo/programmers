package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//장르별로 가장 많이 재생된 노래를 두 개 씩 모아 베스트 앨범을 출시
//노래는 고유 번호로 구분
//1. 속한 노래가 많이 재생된 장르를 먼저 수록
//2. 장르 내에서 많이 재생된 노래를 먼저 수록
//3. 장르 내에서 재생 횟수가 같은 노래중에서는 고유 번호가 낮은 노래를 먼저 수록

//class Music{}

public class BestMusicEx {

	public static int[] solution(String[] genres, int[] plays) {	
		//많이 재생된 장르
		ArrayList<String> max_genres = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<genres.length; i++) {
			map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			max_genres.add(entry.getKey());
		}
		
		
		//장르내에서 많이 재생된 노래 수록
		ArrayList<Integer> num = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0; i<map.size() ;i++) {
			
			for(int j=0; j<plays.length; j++) {
				if(max_genres.get(i).equals(genres[j])) {
					list.add(plays[j]);
					num.add(j);
				}
			}
			Collections.sort(list, Comparator.reverseOrder());
			
			for(int k =0; k<2; k++) {
				result.add(list.get(k));
			}
			list.clear();
			
//			for(int j=0; j<plays.length; j++) {
//				if(result.get(i) == plays[j]) list.add(j);
//			}
		}
		
		
		//고유번호 answer에 넣는다
		int[] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
	
		return answer;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		String[] genres = {"classic","pop","classic","classic","pop"};
		int[] plays = {500,600,150,800,2500};
		
		
		System.out.print("[");
		for(int i =0; i<solution(genres,plays).length; i++) {
			System.out.print(solution(genres,plays)[i]);
			if(i!=solution(genres,plays).length-1) System.out.print(", ");
		}
		System.out.print("]");
	}

}
