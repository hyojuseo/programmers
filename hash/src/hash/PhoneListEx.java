package hash;

import java.util.HashMap;

//�� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false, �ƴϸ� true
public class PhoneListEx {

	// 1. �迭Ǯ�̹�� �ð��ʰ�, ��Ȯ�� 83.3 ȿ����0
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
	  
		for (int i = 0; i < phone_book.length - 1; i++) {
			for (int j = i + 1; j < phone_book.length; j++) { 
				//�ڿ� ���� �տ������� �����ϴ� ���
				if(phone_book[j].startsWith(phone_book[i])) answer = false; 
				//���� ���� �ڿ�������  �����ϴ� ��� 
				if(phone_book[i].startsWith(phone_book[j])) answer = false; 
				} 
		}
		return answer; 
	  }
	
	//HashMap�� �̿��� ��� ��Ȯ�� 83.3 ȿ���� 16.7
	public static boolean solution2(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> hm = new HashMap<>();

		for (String phone : phone_book)
			hm.put(phone, 0);
		
		for (int i = 0; i < phone_book.length; i++) {
			//�� ������ ���̸�ŭ (ã������ ������ ���ձ��� ��������.) �ݺ���Ų��.
			//�ݺ��ѹ��� �������� ���غ��� ���Ե������� false�� ��ȯ�Ѵ�.
			for(int j=0; j<phone_book[i].length(); j++) {
				if(hm.containsKey(phone_book[i].substring(0,j))) answer = false;
			}
		}

		return answer;

	}

	public static void main(String[] args) {
		String[] phone_book = { "12", "567", "88" };
		System.out.println(solution(phone_book));
	}

}
