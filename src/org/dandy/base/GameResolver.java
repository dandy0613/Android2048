package org.dandy.base;

import android.content.SharedPreferences;

public abstract class GameResolver {
	private int currentScore;
	private int bestScore;
	private int biggestSquare;
	private boolean isNewBest;
	private SharedPreferences prefs;
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	
	public int getCurrentScore() {
		return currentScore;
	}
	public int getBestScore() {
		return bestScore;
	}
	public int getBiggestSquare() {
		return biggestSquare;
	}
	public boolean isNewBest() {
		return isNewBest;
	}
	public abstract int[][] start();
	public int[][] process(int[][] board, int direction){
		int temp = 0, to;
		int length = board.length;
		int[][] res = new int[length][length];
		switch(direction){
		case LEFT: 
			to = 0;
			for(int i = 0; i < length; i++){
				for(int j = 0; j < length; j++){
					if(board[i][j]!=0){
						if(temp==0)temp=board[i][j];
						else{
							if(temp==board[i][j]){
								res[i][to]=temp*2;
								temp = 0;
							}else{
								res[i][to] = temp;
								temp = board[i][j];
							}
							to++;
						}
					}
				}
				res[i][to] = temp;
			}
			break;
		case RIGHT:
			to = length-1;
			for(int i = 0; i < length; i++){
				for(int j = length-1; j >= 0; j--){
					if(board[i][j]!=0){
						if(temp==0)temp=board[i][j];
						else{
							if(temp==board[i][j]){
								res[i][to]=temp*2;
								temp = 0;
							}else{
								res[i][to] = temp;
								temp = board[i][j];
							}
							to--;
						}
					}
				}
				res[i][to] = temp;
			}
			break;
			case UP:
				to = 0;
				for(int i = 0; i < length; i++){
					for(int j = 0; j < length; j++){
						if(board[j][i]!=0){
							if(temp==0)temp=board[j][i];
							else{
								if(temp==board[j][i]){
									res[to][i]=temp*2;
									temp = 0;
								}else{
									res[to][i] = temp;
									temp = board[j][i];
								}
								to++;
							}
						}
					}
					res[to][i] = temp;
				}
				break;case DOWN:
					to = 0;
					for(int i = 0; i < length; i++){
						for(int j = 0; j < length; j++){
							if(board[j][i]!=0){
								if(temp==0)temp=board[j][i];
								else{
									if(temp==board[j][i]){
										res[to][i]=temp*2;
										temp = 0;
									}else{
										res[to][i] = temp;
										temp = board[j][i];
									}
									to--;
								}
							}
						}
						res[to][i] = temp;
					}
					break;
		}
		return board;
	}
	public boolean isTerminated(int [][] checkboard){
		int rows = checkboard.length;
		for(int i = 0; i < rows-1; i++){
			for(int j = 0; j < rows-1; j++){
				if(checkboard[i][j]==0 || checkboard[i][j]==checkboard[i+1][j]
						|| checkboard[i][j]==checkboard[i][j+1]){
					return false;
				}
			}
			if(checkboard[i][rows-1]==0 || checkboard[i][rows-1]
					==checkboard[i+1][rows-1] || checkboard[rows-1][i]==0
					|| checkboard[rows-1][i]==checkboard[rows-1][i+1])
				return false;
		}
		if(checkboard[rows-1][rows-1]==0)return false;
		return true;
	}
}
