package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//�������� participant ���ּ��� completion 
//�������� ���Ѽ��� �̸� return

//���������� 1���̻� 10��������
//���ּ��� ���̴� �������� ���̺��� 1 �۴�.
//������ �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ���
//�����ڴ� �������� ���� �� �ִ�.
public class Maraton {

	//��Ȯ��50 ȿ��50
	public static String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
        Arrays.sort(completion);
	    
        int i;
        for(i=0; i<participant.length-1; i++)
        	//�����ڸ�ܰ� �����ڸ���� ���� ��������, �ش� �����ڰ� �̿�����
            if(!participant[i].equals(completion[i])) return participant[i];    
        
        //�����������ڰ� �̿�����
		return participant[i];
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
		
		//���2. get�޼ҵ庸�ٴ� ȣ������ �����ȴ�.	��Ȯ��50 ȿ����50
		for(Map.Entry<String,Integer> entry : hm.entrySet()) {
			if(entry.getValue() != 0)
				answer = entry.getKey();
		}
		
		return answer;
	}
	public static void main(String[] args) {
	}

}
