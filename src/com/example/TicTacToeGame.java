package com.example;

import java.util.Random;
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

	public void movePlayer(TicTacToeGame t) {
		System.out.println("Enter the position(1-9): ");
		int move = sc.nextInt();
		for (int i = 1; i < 10; i++)
			if (move == i) {

				boolean b = true;
				while (b) {

					
					if (position[move] == '\0') {
						position[move] = t.playerOp;
						b = false;
					}
					else {
						System.out.println("Enter the position(1-9): ");
						move = sc.nextInt();
					}
				}
			}
	}

	public void moveComp(TicTacToeGame t) {
		Random r = new Random();
		int move = r.nextInt(10);
		for (int i = 1; i < 10; i++)
			if (move == i) {
				boolean b = true;
				while (b)
					if (position[move] == '\0') {
						position[move] = t.compOp;
						b = false;
					}
					else
						move = r.nextInt(10);

			}
	}

	public static void main(String[] args) {

		TicTacToeGame t = new TicTacToeGame();

		System.out.println("Welcome to TicTacToe.");

		t.showBoard();
		System.out.println("Want to play first?(Y/N)");
		char first = t.sc.next().charAt(0);
		if (first == 'Y' || first == 'y') {
			t.playerOp = t.chooseOption();
			t.movePlayer(t);
			t.compOp = t.playerOp == 'O' ? 'X' : 'O';
			t.moveComp(t);
			t.showBoard();

		}

	}

}
