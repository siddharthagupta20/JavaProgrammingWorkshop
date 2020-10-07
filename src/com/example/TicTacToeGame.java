package com.example;

import java.util.Scanner;

public class TicTacToeGame {

	private char[] position;
	private Scanner sc;
	private char playerOp;
	private char compOp;

	public TicTacToeGame() {
		// TODO Auto-generated constructor stub
		position = new char[10];
		for (int i = 0; i <= 10; i++) {
			position[i] = '\0';
		}
		sc = new Scanner(System.in);
		playerOp = '\0';
		compOp = '\0';
	}

	public char chooseOption() {
		char option;
		System.out.println("Enter X or O.");
		option = sc.next().charAt(0);
		return option;
	}

	public static void main(String[] args) {

		TicTacToeGame t = new TicTacToeGame();

		System.out.println("Welcome to TicTacToe.");

		System.out.println("Want to play first?(Y/N)");
		if ((t.sc.next().charAt(0)) == 'Y' || (t.sc.next().charAt(0)) == 'y') {
			t.playerOp = t.chooseOption();
			t.compOp = t.playerOp == 'O' ? 'X' : 'O';
		}

	}

}
