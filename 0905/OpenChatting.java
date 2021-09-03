package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OpenChatting {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(record)));
	}
	
	public static String[] solution(String[] record) {
		List<String> result = new ArrayList<>();
		HashMap<String, String> hashmap = new HashMap<>();
		
		for(int i = 0; i < record.length; i++) {
			String[] info = record[i].split(" ");
			if(info[0].equals("Change")) {
				hashmap.put(info[1], info[2]);
			} else if(info[0].equals("Enter")){
				hashmap.put(info[1], info[2]);
			} else {
				continue;
			}
		}
		
		for(int i = 0; i < record.length; i++) {
			String[] info = record[i].split(" ");
			if(info[0].equals("Enter")) {
				result.add(hashmap.get(info[1]) + "님이 들어왔습니다.");
			} else if(info[0].equals("Leave")) {
				result.add(hashmap.get(info[1]) + "님이 나갔습니다.");
			} else {
				continue;
			}
		}
		
		String[] value = new String[result.size()];
		
		for(int i = 0; i < result.size(); i++) {
			value[i] = result.get(i);
		}
		
		return value;
	}
}
