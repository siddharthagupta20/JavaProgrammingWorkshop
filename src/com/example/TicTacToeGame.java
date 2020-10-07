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
						System.out.println("Running");
						break;

					} else {
						System.out.println("Enter the position(1-9): ");
						move = sc.nextInt();
						System.out.println("not");
						continue;
					}
				}
			}
	}

	public void moveComp(TicTacToeGame t) {

		int move = r.nextInt(10);
		for (int i = 1; i < 10; i++)
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

	public boolean tossCoin(TicTacToeGame t) {
		int toss = r.nextInt(1);
		if (toss == 1)
			return true;
		else
			return false;

	}

	public static void main(String[] args) {

		TicTacToeGame t = new TicTacToeGame();

		System.out.println("Welcome to TicTacToe.");
		t.showBoard();
		System.out.println("1.Want to play first?(Y/N)");
		System.out.println("2.Want to toss?");
		int chances = t.sc.nextInt();
		boolean b = true;
		switch (chances) {
		case 1:
			System.out.println("Enter(Y/N):");
			char first = t.sc.next().charAt(0);
			if (first == 'Y' || first == 'y') {
				
				b = true;
			} else if (first == 'n' || first == 'N') 
				b = false;
			
			break;
		case 2:
			b = t.tossCoin(t);
			break;
		default:
			System.out.println("No option");
		}

		if (b) {
			char op = t.chooseOption();
			if (op != '\0')
				t.playerOp = op;
			t.compOp = t.playerOp == 'O' ? 'X' : 'O';
			t.movePlayer(t);
			t.moveComp(t);
			t.showBoard();
		} else {
			t.compOp = 'X';
			while (t.playerOp == t.compOp) {
				t.playerOp = t.chooseOption();
				t.moveComp(t);
				t.movePlayer(t);
				t.showBoard();
			}

		}
	}
}
