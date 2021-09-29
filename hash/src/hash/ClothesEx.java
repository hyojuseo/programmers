package hash;

import java.util.*;
import static java.util.stream.Collectors.*;
//스파이들은 매일 다른 옷을 조합하여 입어 위장한다.
//예를 들어 
//		얼굴 - 동그란안경, 검정 선글라스
//		상의 - 파란색 티셔츠
//		하의 - 청바지
//		겉옷 - 긴코트
//가 있다고 한다면 오늘 스파이는 동그란 안경, 긴코트, 파란색 티셔츠를 입었다면
//다음날은 청바지를 추가로 입거나 동그란 안경 대신 선글라스를 착용하거나 해야 된다.
public class ClothesEx {

	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> hm = new HashMap<>();
		
		//같은 부위의 옷끼리 수량을 센다.
		for(int i=0; i<clothes.length; i++) {
			hm.put(clothes[i][1],hm.getOrDefault(clothes[i][1],0)+1);
		}
		
		//1.
		for(Map.Entry<String, Integer> entry : hm.entrySet()) {
			//각 부위별 옷들을 안입을 경우 1을 더하여 모든 부위를 곱한다.
			answer *= entry.getValue() +1;
		}
		//모든 부위별로 안입을 경우가 들어있기 때문에 모두 안입는 경우가 발생할 경우인 1을 빼준다.
		
		
		//2.
		/*Iterator<Integer> it = hm.values().iterator();
		
		while(it.hasNext())
			answer *= it.next().intValue() +1 ;*/
		
		return answer-1;
	}
	
	public static int solution2(String[][] clothes) {
		return Arrays.stream(clothes)
				.collect(groupingBy(p->p[1], mapping(p->p[0], counting())))
				.values()
				.stream()
				.collect(reducing(1L, (x,y)->x*(y+1))).intValue() - 1;
	}
	
	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat","headgear"},{"bluesunglasses","eyewear"},
							{"green_turban","headgear"}};	//return 5
		System.out.println(solution(clothes));

	}

}
