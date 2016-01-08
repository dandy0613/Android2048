package org.dandy.game;

import java.util.Random;

import org.dandy.base.GameResolver;

public class FourGameResolver extends GameResolver {
	@Override
	public int[][] start() {
		int a = new Random().nextInt(16);
		int b = new Random().nextInt(15);
		int[][] board = new int[4][4];
		if(b>=a)b++;
		if(new Random().nextInt(3)==1)
			board[a/4][a%4] = 4;
		else board[a/4][a%4] = 2;
		if(new Random().nextInt(3)==1)
			board[b/4][b%4] = 4;
		else board[b/4][b%4] = 2;
		return board;
	}
}
