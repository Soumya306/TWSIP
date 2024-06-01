package internship;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Guess number Game");
		Random random=new Random();
		Scanner sc=new Scanner(System.in);
		int ranum=random.nextInt(101)+1;
		int marking=0;
		System.out.println("You have maximum 5 attempt left");
		for(int m=1;m<=5;m++) {
			System.out.println("Enter a guess number between 1 to 100");
			int gnum=sc.nextInt();
			if(ranum<gnum) {
				System.out.println("Your guess Number is greater");
			}
			else if(ranum>gnum){
				System.out.println("Your guess Number is Smaller");
			}
			else {
				System.out.println("OOhhOO!, Your Number is Correct.You Win the Game");
				marking++;
				break;
			}	
		}
		if(marking==0) {
			System.out.println("Guessed number : "+ranum);
			System.out.println("SORRY! You lost the game");
		}
	}
}
