package hash;

//한 번호가 다른 번호의 접두어인 경우가 있으면 false, 아니면 true
public class PhoneListEx {

	//1. 배열풀이방법
	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		for (int i = 0; i < phone_book.length - 1; i++) {
			for (int j = i + 1; j < phone_book.length; j++) {
				//뒤에 것이 앞에것으로 시작하는 경우
				if(phone_book[j].startsWith(phone_book[i])) answer = false;
				//앞의 것이 뒤에것으로 시작하는 경우 
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
