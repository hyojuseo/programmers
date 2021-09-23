package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//�������� participant ���ּ��� completion 
//�������� ���Ѽ��� �̸� return

//���������� 1���̻� 10��������
//���ּ��� ���̴� �������� ���̺��� 1 �۴�.
//������ �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ���
//�����ڴ� �������� ���� �� �ִ�.
public class Maraton {

	public static List<String> solution() {
		List<String> participant = new ArrayList<>();
		List<String> completion = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			participant.add(sc.next());
		}
		int check = (int)(Math.random()*participant.size());
		completion.add(participant.remove(check));
		return completion;
	}
	
	public static String solution2(String[] participant,String[] completion) {
		String answer=null;
		HashMap<String, Integer> hm =new HashMap<>();
		//�������� ������ +1�� ����� ���������� +1�� ���� ������ �߰��ȴ�.
		for(String player : participant) hm.put(player,hm.getOrDefault(player,0)+1);
		//-1�� �������μ� �����ڵ��� Ű���� 0���� ���´�. 
		for(String player : completion) hm.put(player,hm.get(player)-1);
		
		//�����ڵ��� Ű���� 0�� �ƴϸ� �̿������̴�.
		
		//���1. �̹���� �ݺ����� ����ϱ⶧���� ȿ���� ��������.
		for(String player : participant) {	
			if(hm.get(player) != 0)
				answer = player;
		}
		
		//���2. get�޼ҵ庸�ٴ� ȣ������ �����ȴ�.
		for(Map.Entry<String,Integer> entry : hm.entrySet()) {
			if(entry.getValue() != 0)
				answer = entry.getKey();
		}
		
		return answer;
	}
	public static void main(String[] args) {
	}

}
