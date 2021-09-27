package hash;

import java.util.HashMap;

//한 번호가 다른 번호의 접두어인 경우가 있으면 false, 아니면 true
public class PhoneListEx {

	// 1. 배열풀이방법 시간초과, 정확성 83.3 효율성0
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
	  
		for (int i = 0; i < phone_book.length - 1; i++) {
			for (int j = i + 1; j < phone_book.length; j++) { 
				//뒤에 것이 앞에것으로 시작하는 경우
				if(phone_book[j].startsWith(phone_book[i])) answer = false; 
				//앞의 것이 뒤에것으로  시작하는 경우 
				if(phone_book[i].startsWith(phone_book[j])) answer = false; 
				} 
		}
		return answer; 
	  }
	
	//HashMap을 이용한 방법 정확성 83.3 효율성 16.7
	public static boolean solution2(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> hm = new HashMap<>();

		for (String phone : phone_book)
			hm.put(phone, 0);
		
		for (int i = 0; i < phone_book.length; i++) {
			//각 문자의 길이만큼 (찾으려는 문자의 끝앞까지 돌려본다.) 반복시킨다.
			//반복한문자 한톨한톨 비교해보며 포함돼있으면 false를 반환한다.
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
