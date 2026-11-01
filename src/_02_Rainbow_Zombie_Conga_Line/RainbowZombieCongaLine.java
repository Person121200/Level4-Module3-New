package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine = new LinkedList<>();
    private ZombieHatColor[] zombieHats;
    Node<Zombie> head;
    
    public static void main(String args[]) {
    	RainbowZombieCongaLine rainbowConga = new RainbowZombieCongaLine();
    	LinkedList<Zombie> conga = rainbowConga.getCongaLine();
    	rainbowConga.everyoneOut(new Zombie(ZombieHatColor.B));
    }
    public RainbowZombieCongaLine() {
    	for(int i = 0; i < 10; i++) {
    		if(i == 1) {
    			congaLine.add(new Zombie(ZombieHatColor.R));
    		} else {
    			congaLine.add(new Zombie(ZombieHatColor.B));
    		}
    	}
    	head = congaLine.getHead();

    }

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	head.setValue(dancer);
    	congaLine.setHead(head);
    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {
    	head.setValue(dancer);
    	congaLine.setTail(head);
    }

    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
        Node<Zombie> next = head;
    	Node<Zombie> Dancer = new Node<>(dancer);
    	for(int i = 0; i<position-1; i++) {
    		next = next.getNext();
    		}
    	//System.out.print(next.getValue());
    	Node<Zombie> prev = next.getPrev();
    	prev.setNext(Dancer);
    	Dancer.setNext(next);
    	}
    

    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	Node<Zombie> color = new Node<>(dancer);
    	Node<Zombie> prev;
    	Node<Zombie> next = head;
    	for(int i = 0; i<congaLine.size(); i++) {
    		if(next.getValue().getZombieHatColor().equals(dancer.getZombieHatColor())) {
    			if(i==0) {
    				congaLine.remove(0);
    			}

    			else {
    				prev = head.getPrev();
        			congaLine.remove(i);
        			prev.setNext(next.getNext());
        			next = next.getNext();
    			}

    		}
    	}
    }

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {

    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {

    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {

    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
