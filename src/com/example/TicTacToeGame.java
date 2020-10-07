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
		for (int i = 0; i < 10; i++) {
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

	public void showBoard() {
		System.out.println(position[1] + "|" + position[2] + "|" + position[3]);
		System.out.println("-------");
		System.out.println(position[4] + "|" + position[5] + "|" + position[6]);
		System.out.println("-------");
		System.out.println(position[7] + "|" + position[8] + "|" + position[9]);

	}

	public static void main(String[] args) {

		TicTacToeGame t = new TicTacToeGame();

		System.out.println("Welcome to TicTacToe.");

		t.showBoard();
		System.out.println("Want to play first?(Y/N)");
		char first = t.sc.next().charAt(0);
		if (first == 'Y' || first == 'y') {
			t.playerOp = t.chooseOption();
			t.compOp = t.playerOp == 'O' ? 'X' : 'O';

		}

	}

}
