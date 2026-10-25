package _01_Spies_On_A_Train;

import java.awt.MenuComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    	Node<TrainCar> temp = train.getHead();
    	
    	ArrayList<String> suspects = new ArrayList<>();
    	String temp1 = "";
    	Node<TrainCar> next = temp.getNext();
   		temp1 = temp.getValue().questionPassenger();
		for(int i = 0; i<clues.length; i++) {
			if(temp1.contains(clues[i])) {
				suspects.add(parseName(temp1));
			}
		}
    	while(next != null) {
    		temp1 = next.getValue().questionPassenger();
    		for(int i = 0; i<clues.length; i++) {
    			if(temp1.contains(clues[i])) {
    				suspects.add(parseName(temp1));
    			}
    		}
    		next = next.getNext();
    	}
    	HashMap<String, Integer> map = new HashMap<>();
    
    	for(int i = 0; i<suspects.size(); i++) {
    		if(map.containsKey(suspects.get(i))!=true) {
        		map.put(suspects.get(i), 1);

    		}
    		else {
    			map.put(suspects.get(i), map.get(suspects.get(i))+1);
    		}
    	}
    	return suspects.get(0);
    	

    }
    public static String parseName(String n) {
    	Pattern pattern = Pattern.compile("I saw (\\w*)");
    	Matcher match = pattern.matcher(n);
    	if(match.find()) {
        	String h = match.group(1);
        	return h;
        
    	}
    	return null;
    }

}
