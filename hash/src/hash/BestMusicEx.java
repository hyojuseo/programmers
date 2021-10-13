package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//�帣���� ���� ���� ����� �뷡�� �� �� �� ��� ����Ʈ �ٹ��� ���
//�뷡�� ���� ��ȣ�� ����
//1. ���� �뷡�� ���� ����� �帣�� ���� ����
//2. �帣 ������ ���� ����� �뷡�� ���� ����
//3. �帣 ������ ��� Ƚ���� ���� �뷡�߿����� ���� ��ȣ�� ���� �뷡�� ���� ����

//class Music{}

public class BestMusicEx {

	public static int[] solution(String[] genres, int[] plays) {	
		//���� ����� �帣
		ArrayList<String> max_genres = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<genres.length; i++) {
			map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			max_genres.add(entry.getKey());
		}
		
		
		//�帣������ ���� ����� �뷡 ����
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
		
		
		//������ȣ answer�� �ִ´�
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
