package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TicTacToeGame {

	private char[] position;
	private Scanner sc;
	private char playerOp;
	private char compOp;
	private Random r;

	List<List<Integer>> winningHorizontal = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
			Arrays.asList(7, 8, 9));
	List<List<Integer>> winningVertical = Arrays.asList(Arrays.asList(1, 4, 7), Arrays.asList(2, 5, 8),
			Arrays.asList(3, 6, 9));
	List<List<Integer>> winningDiagonal = Arrays.asList(Arrays.asList(1, 5, 9), Arrays.asList(3, 5, 7));

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

		int move = r.nextInt(9)+1;
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
		int toss = r.nextInt(2);
		if (toss == 1)
			return true;
		else
			return false;

	}

	public int winOrNot(TicTacToeGame t, char c) {
		// for winning

		List<Integer> positions = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			if (position[i] == c) {
				positions.add(i);
			}
		}
		System.out.println(positions);

		// horizontal
		for (List<Integer> l : winningHorizontal) {
			if (positions.containsAll(l))
				return 1;
		}
		for (List<Integer> l : winningVertical) {
			if (positions.containsAll(l))
				return 1;
		}
		for (List<Integer> l : winningDiagonal) {
			if (positions.containsAll(l))
				return 1;
		}
		// for tie and change turn
		boolean b = false;
		for (int i1 = 1; i1 < 10; i1++) {
			if (position[i1] == '\0') {
				b = true;
				break;
			}
		}
		if (b)
			return 3;// change turn
		else
			return 2;// tie

	}

	public List<Integer> cheats(char c) {
		List<List<Integer>> willWinHori = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(1, 3),
				Arrays.asList(4, 5), Arrays.asList(5, 6), Arrays.asList(4, 6), Arrays.asList(7, 8), Arrays.asList(8, 9),
				Arrays.asList(7, 9));
		List<List<Integer>> willWinVerti = Arrays.asList(Arrays.asList(1, 4), Arrays.asList(4, 7), Arrays.asList(1, 7),
				Arrays.asList(2, 5), Arrays.asList(5, 8), Arrays.asList(2, 8), Arrays.asList(3, 6), Arrays.asList(6, 9),
				Arrays.asList(3, 9));
		List<List<Integer>> willWinDiagonal = Arrays.asList(Arrays.asList(1, 5), Arrays.asList(5, 9),
				Arrays.asList(1, 9), Arrays.asList(3, 5), Arrays.asList(5, 7), Arrays.asList(3, 7));
		List<Integer> positions = new ArrayList<Integer>();
		List<Integer> reqPos = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			if (position[i] == c) {
				positions.add(i);
			}
		}
		for (List<Integer> l : willWinHori) {
			for (List<Integer> l1 : winningHorizontal) {

				if (positions.containsAll(l) && l1.containsAll(l))
					reqPos.add(l1.stream().reduce(0, (n1, n2) -> n1 + n2)
							- positions.stream().reduce(0, (n1, n2) -> n1 + n2));
			}
		}
		for (List<Integer> l : willWinVerti) {
			for (List<Integer> l1 : winningVertical) {

				if (positions.containsAll(l) && l1.containsAll(l))
					reqPos.add(l1.stream().reduce(0, (n1, n2) -> n1 + n2)
							- positions.stream().reduce(0, (n1, n2) -> n1 + n2));
			}
		}
		for (List<Integer> l : willWinDiagonal) {
			for (List<Integer> l1 : winningDiagonal) {

				if (positions.containsAll(l) && l1.containsAll(l))
					reqPos.add(l1.stream().reduce(0, (n1, n2) -> n1 + n2)
							- positions.stream().reduce(0, (n1, n2) -> n1 + n2));
			}
		}
		return reqPos.stream().filter(n -> this.isEmpty(n)).collect(Collectors.toList());

	}

	public List<Integer> takingCorners() {
		List<Integer> corners = new ArrayList<Integer>();

		if (position[1] == '\0')
			corners.add(1);
		if (position[3] == '\0')
			corners.add(3);
		if (position[7] == '\0')
			corners.add(7);
		if (position[9] == '\0')
			corners.add(9);
		return corners;
	}

	public int takingCentre() {
		if (position[5] == '\0')
			return 5;
		else
			return 0;
	}

	public List<Integer> takingSides() {
		List<Integer> sides = new ArrayList<Integer>();
		if (position[2] == '\0')
			sides.add(2);
		if (position[4] == '\0')
			sides.add(4);
		if (position[6] == '\0')
			sides.add(6);
		if (position[8] == '\0')
			sides.add(8);
		return sides;

	}

	public void movingLogic(TicTacToeGame t, char c) {
		if (!t.cheats(c).isEmpty())
			System.out.println("Take these positions immediatly: " + t.cheats(c));
		else {
			if (!t.takingCorners().isEmpty())
				System.out.println("Choose corners: " + t.takingCorners());
			else {
				if (t.takingCentre() == 5)
					System.out.println("Take centre.");
				else {
					if (!t.takingSides().isEmpty())
						System.out.println("Take sides: " + t.takingSides());
					else
						System.out.println("Move Anywhere. Be offensive!!!");
				}
			}
		}
	}

	public boolean isEmpty(int pos) {
		if (position[pos] == '\0')
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
		boolean playerTurnDone;
		if (playerStart) {
			char op = t.chooseOption();
			if (op != '\0')
				t.playerOp = op;
			t.compOp = t.playerOp == 'O' ? 'X' : 'O';
			t.movePlayer(t);
			t.showBoard();
			playerTurnDone = true;
		} else {
			t.compOp = 'X';
			t.playerOp = 'O';
			t.moveComp(t);
			t.showBoard();
			playerTurnDone = false;
		}
		boolean continueGame = true;
		while (continueGame) {//condition for continuing game till win or tie 
			if (playerTurnDone) {
				switch (t.winOrNot(t, t.playerOp)) {
				case 1:
					System.out.println("Player Wins!");
					continueGame = false;
					break;
				case 2:
					System.out.println("Tie");
					continueGame = false;
					break;
				case 3:
					t.moveComp(t);
					playerTurnDone = false;
					t.showBoard();
					break;
				}
			} else {
				switch (t.winOrNot(t, t.compOp)) {
				case 1:
					System.out.println("Computer Wins!");
					continueGame = false;
					break;
				case 2:
					System.out.println("Tie");
					continueGame = false;
					break;
				case 3:
					t.movingLogic(t, t.compOp);
					t.movePlayer(t);
					playerTurnDone = true;
					t.showBoard();
					break;
				}
			}
		}
	}
}
