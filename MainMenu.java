import java.util.*;
import java.time.Instant;
import java.lang.*;

public class MainMenu{
	private static int crrntMp = 1;
	public int getMap() {
	     return crrntMp;
	}
	public void setMap(int x) {
		this.crrntMp = x;
	}
	public static void main(String[] args) {
		System.out.println("  ._________________________________."); //prints the menu
		System.out.println("  |_________________________________|");
		System.out.println("//__________________________________\\\\");
		System.out.println("\\\\'''''''''''\\\\''''''''//'''''''''''//");
    System.out.println("||             GameName             ||");
    System.out.println("//''''''''''''*''''''''*''''''''''''\\\\");
		System.out.println("\\\\__________________________________//");
		System.out.println("//__________________________________\\\\");
		System.out.println("||Enter 1 to Start Game             ||");
		System.out.println("||Enter 2 to See Instructions       ||");
		System.out.println("||Enter 3 to Use A Different Map    ||");
		System.out.println("||Enter 4 to See Credits            ||");
		System.out.println("||Enter 5 to Exit Game              ||");
		System.out.println("\\\\__________________________________//");
		System.out.println("  |_________________________________|");
		System.out.println("  |_________________________________|");
		System.out.println("Current Map:"+crrntMp);  //shows what's the current map is
		Scanner scn=new Scanner(System.in);
		System.out.print("Input: "); //asks the user for input
		int select=scn.nextInt();
		Selector(select, crrntMp); //uses selector to decide action for input
	}
	public static void Instructions(){
		String[] empty=new String[1];
		System.out.println("You are controlling a ship indicated with an \"O\" using WASD.\nThe water body, which you can move through, is indicated with a \"-\".\nThe land, which you canNOT move through, is indicated with an \"X\".\nThe enemies, which you must chase and bump with to win, are indicated with an \"E\".\nHave fun!\nEnter 2 again to return to the main menu");
		Scanner scn=new Scanner(System.in);
		int in=scn.nextInt();
		while (in!=2){
			System.out.println("Enter 2");
			in=scn.nextInt();
		}
		main(empty);
	}
	public static void Selector(int select, int crrntMp){
		MainMenu menuObject = new MainMenu();
		crrntMp=menuObject.getMap();
		if (select==3){
			if (crrntMp==1||crrntMp==2){
				crrntMp+=1;
				menuObject.setMap(crrntMp);
			}
			else if (crrntMp==3){
				crrntMp-=2;
				menuObject.setMap(crrntMp);
			}
			System.out.println("____________________________________");
			System.out.println("Current Map:"+crrntMp);
			Scanner scn=new Scanner(System.in);
			System.out.print("Input: "); //asks the user for input
			select=scn.nextInt();
			Selector(select, crrntMp);
		}
		else if (select==1){
			String[] empty=new String[1];
			Main mainObject = new Main();
			mainObject.main(empty);
		}
		else if (select==2){
			Instructions();
		}
		else if (select==5){
			System.out.println("Thank you for playing.");
			System.exit(0);
		}
		else if (select==4){
			System.out.println("\n\nCreated by Jacob, Osamah, Spencer, and Mark!\n\n");
			String[] empty=new String[1];
			main(empty);
		}
		else{
			Scanner scn=new Scanner(System.in);
			System.out.print("Re-enter input (Must be from 1-5): ");
			select=scn.nextInt();
			Selector(select, crrntMp); //calls itself
		}
	}
}
