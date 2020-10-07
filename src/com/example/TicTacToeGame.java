package com.example;

public class TicTacToeGame {
	
	
	private char[] position;
	
	public TicTacToeGame() {
		// TODO Auto-generated constructor stub
		position= new char[10];
		for(int i=0;i<=10;i++) {
			position[i]='\0';
		}
	}		
		public static void main(String[] args) {
			
			TicTacToeGame t=new TicTacToeGame();
			
			System.out.println("Welcome to TicTacToe.");
		}
				
	}
	
