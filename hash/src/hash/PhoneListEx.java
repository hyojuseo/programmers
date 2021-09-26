package hash;

//�� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false, �ƴϸ� true
public class PhoneListEx {

	//1. �迭Ǯ�̹��
	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		for (int i = 0; i < phone_book.length - 1; i++) {
			for (int j = i + 1; j < phone_book.length; j++) {
				//�ڿ� ���� �տ������� �����ϴ� ���
				if(phone_book[j].startsWith(phone_book[i])) answer = false;
				//���� ���� �ڿ������� �����ϴ� ��� 
				if(phone_book[i].startsWith(phone_book[j])) answer = false;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] phone_book = { "12","1234", "567", "88" };
		System.out.println(solution(phone_book));
	}

}
