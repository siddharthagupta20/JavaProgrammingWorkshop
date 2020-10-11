package com.example;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

	private char[] position;
	private Scanner sc;
	private char playerOp;
	private char compOp;
	private Random r;

	public TicTacToeGame() {
		// TODO Auto-generated constructor stub
		position = new char[10];
		for (int i = 1; i < 10; i++) {
			position[i] = '\0';
		}
		sc = new Scanner(System.in);
		playerOp = '\0';
		compOp = '\0';
		r = new Random();
	}

	public char chooseOption() {
		char option;
		System.out.println("Enter X or O.");
		option = sc.next().charAt(0);
		boolean b = true;
		while (b)

			if (option == 'X' || option == 'x' || option == 'O' || option == 'o') {
				if (option == 'x')
					option = 'X';
				else if (option == 'o')
					option = 'O';
				return option;
			} else {
				System.out.println("Enter X or O.");
				option = sc.next().charAt(0);
				b = false;
			}
		return '\0';
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

				while (true) {
					if (position[move] == '\0') {
						position[move] = t.playerOp;
						break;

					} else {
						System.out.println("Enter the position(1-9): ");
						move = sc.nextInt();
						continue;
					}
				}
			}
		System.out.println("Player moved to position: " + move);
	}

	public void moveComp(TicTacToeGame t) {

		int move = r.nextInt(10);
		for (int i = 1; i < 10; i++) {
			while (move == 0)
				move = r.nextInt(10);
			if (move == i) {
				boolean b = true;
				while (b)
					if (position[move] == '\0') {
						position[move] = t.compOp;
						b = false;
					} else
						move = r.nextInt(10);
			}
		}
		System.out.println("Computer moved to position:" + move);
	}

	public boolean tossCoin(TicTacToeGame t) {
		int toss = r.nextInt(1);
		if (toss == 1)
			return true;
		else
			return false;

	}

	public int winOrNot(TicTacToeGame t) {
		// for winning
		// horizontal
		for (int i = 1; i <= 7; i = i + 3) {
			if (position[i] == position[i + 1] && position[i] == position[i + 2] && position[i] != '\0')
				return 1;
		}
		// vertical
		for (int i = 1; i < 4; i++) {
			if (position[i] == position[i + 3] && position[i] == position[i + 6] && position[i] != '\0')
				return 1;
		}
		// diagonal
		if (position[1] == position[5] && position[1] == position[9] && position[1] != '\0')
			return 1;
		if (position[3] == position[5] && position[3] == position[7] && position[3] != '\0')
			return 1;
		// for tie and change turn
		boolean b = false;
		for (int i = 1; i < 10; i++) {
			if (position[i] == '\0') {
				b = true;
				break;
			}
		}
		if (b)
			return 3;// change turn
		else
			return 2;// tie

	}

	public static void main(String[] args) {

		TicTacToeGame t = new TicTacToeGame();

		System.out.println("Welcome to TicTacToe.");

		t.showBoard();

		System.out.println("1.Want to play first?(Y/N)");
		System.out.println("2.Want to toss?");
		int chances = t.sc.nextInt();
		boolean playerStart = true;
		switch (chances) {
		case 1:
			System.out.println("Enter(Y/N):");
			char first = t.sc.next().charAt(0);
			if (first == 'Y' || first == 'y')
				playerStart = true;
			else if (first == 'n' || first == 'N')
				playerStart = false;

			break;
		case 2:
			playerStart = t.tossCoin(t);
			break;
		default:
			System.out.println("No option");
		}
		boolean playerTurn;
		if (playerStart) {
			char op = t.chooseOption();
			if (op != '\0')
				t.playerOp = op;

			t.compOp = t.playerOp == 'O' ? 'X' : 'O';
			t.movePlayer(t);
			t.showBoard();
			playerTurn = true;
		} else {
			t.compOp = 'X';
			t.playerOp = 'O';
			t.moveComp(t);
			t.showBoard();
			playerTurn = false;
		}
		while (t.winOrNot(t) == 3) {
			if (playerTurn) {
				t.moveComp(t);
				playerTurn = false;
				t.showBoard();
				if (t.winOrNot(t) == 2) {
					System.out.println("Tie");
				} else if (t.winOrNot(t) == 1)
					System.out.println("Player Wins.");
			} else {
				t.movePlayer(t);
				playerTurn = true;
				t.showBoard();
				if (t.winOrNot(t) == 2) {
					System.out.println("Tie");
				} else if (t.winOrNot(t) == 1)
					System.out.println("Computer Wins.");
			}
		}
	}
}
