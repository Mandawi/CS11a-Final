import java.util.*;
public class MainMenu{
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
		System.out.println("||Enter 2 to Use A Different Map    ||");
		System.out.println("||Enter 3 to Exit Game              ||");
		System.out.println("\\\\__________________________________//");
		System.out.println("  |_________________________________|");
		System.out.println("  |_________________________________|");
		int crrntMp=0;
		System.out.println("Current Map:"+crrntMp);  //shows what's the current map is
		Scanner scn=new Scanner(System.in);
		System.out.print("Input: "); //asks the user for input
		int select=scn.nextInt();
		Selector(select, crrntMp); //uses selector to decide action for input
	}
	public static void Selector(int select, int crrntMp){
		if (select==2){
			if (crrntMp==0||crrntMp==1){
				crrntMp+=1;
			}
			else if (crrntMp==2){
				crrntMp-=2;
			}
			System.out.println("____________________________________");
			System.out.println("Current Map:"+crrntMp);
			Scanner scn=new Scanner(System.in);
			System.out.print("Input: "); //asks the user for input
			select=scn.nextInt();
			Selector(select, crrntMp);
		}
		else if (select==1){
			//... starts game -- StartGame() class or whatever it is called
		}
		else if (select==3){
			System.exit(0);
		}
		else{
			Scanner scn=new Scanner(System.in);
			System.out.print("Re-enter input (Must be from 1-3): ");
			select=scn.nextInt();
			Selector(select, crrntMp); //calls itself
		}

	}
}
