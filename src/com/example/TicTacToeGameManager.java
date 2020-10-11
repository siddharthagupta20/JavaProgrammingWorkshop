package com.example;

import java.util.Scanner;

public class TicTacToeGameManager {


	public static void main(String[] args) {
		TicTacToeGame.main(null);
		boolean play=true;
		Scanner sc=new Scanner(System.in);
		while(play) {
		System.out.println("Want to play again ?(Y/N)");
		char c=sc.next().charAt(0);
		if(c=='n'||c=='N')
			play=false;
		}
		sc.close();
	}
	
}
