package com.examportal.classes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AnswerChecker {

	private Map<Integer, String> finalAnsMap = new HashMap<Integer, String>();
	private Map<Integer, String> selectedAnsMap = new HashMap<Integer, String>();
	private Map<Integer, String> map = null;
	private List<Integer> pickedQtons = null;
	private List<String> checkedAns = null;

	public AnswerChecker(Map<Integer, String> map, List<Integer> pickedQtons, List<String> checkedAns) {
		this.map = map;
		this.pickedQtons = pickedQtons;
		this.checkedAns = checkedAns;
	}

	public void getPickedQtonCorrectAnswers() {

		for (int i : pickedQtons) {
			finalAnsMap.put(i,map.get(i)); 
		}
		
		for (Map.Entry<Integer, String> entrySet : finalAnsMap.entrySet()) {
			System.out.println("Qton No : "+entrySet.getKey()+" Answer : "+entrySet.getValue()); 
		}

	}
	public void getPickedQtonSelectedAnswers() {
		System.out.println("------------------Selected Start--------------------------");
		
		Iterator<Integer> it1 = pickedQtons.iterator();
		Iterator<String> it2 = checkedAns.iterator();
		
		while (it1.hasNext() && it2.hasNext()) {
			selectedAnsMap.put(it1.next(), it2.next());
		}
		
		for (Map.Entry<Integer, String> entrySet : selectedAnsMap.entrySet()) {
			System.out.println("Qton No : "+entrySet.getKey()+" Answer : "+entrySet.getValue()); 
		}
		System.out.println("------------------Selected End------------------------");
	}
	
	public int getTotalMarks(){
		int count = 0;
		for (int i : pickedQtons) {
			if(finalAnsMap.containsKey(i) && (selectedAnsMap.containsKey(i))){
				if(finalAnsMap.get(i).equals(selectedAnsMap.get(i))){
					count++;
				}
			}
		}
		return count;
	}
	
	

}
