package hash;

import java.util.*;
import static java.util.stream.Collectors.*;
//�����̵��� ���� �ٸ� ���� �����Ͽ� �Ծ� �����Ѵ�.
//���� ��� 
//		�� - ���׶��Ȱ�, ���� ���۶�
//		���� - �Ķ��� Ƽ����
//		���� - û����
//		�ѿ� - ����Ʈ
//�� �ִٰ� �Ѵٸ� ���� �����̴� ���׶� �Ȱ�, ����Ʈ, �Ķ��� Ƽ������ �Ծ��ٸ�
//�������� û������ �߰��� �԰ų� ���׶� �Ȱ� ��� ���۶󽺸� �����ϰų� �ؾ� �ȴ�.
public class ClothesEx {

	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> hm = new HashMap<>();
		
		//���� ������ �ʳ��� ������ ����.
		for(int i=0; i<clothes.length; i++) {
			hm.put(clothes[i][1],hm.getOrDefault(clothes[i][1],0)+1);
		}
		
		//1.
		for(Map.Entry<String, Integer> entry : hm.entrySet()) {
			//�� ������ �ʵ��� ������ ��� 1�� ���Ͽ� ��� ������ ���Ѵ�.
			answer *= entry.getValue() +1;
		}
		//��� �������� ������ ��찡 ����ֱ� ������ ��� ���Դ� ��찡 �߻��� ����� 1�� ���ش�.
		
		
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
