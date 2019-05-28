package mokpotetris;

import java.awt.Point;

public abstract class Piece {
	final int DOWN = 0; //방향 지정
	final int LEFT = 1;
	final int RIGHT = 2;
	protected int r[]; //Y축 좌표 배열
	protected int c[]; //X축 좌표 배열
	protected TetrisData data; //테트리스 내부 데이터
	protected Point center; // 조각의 중심 좌표
	
	public Piece(TetrisData Data) {
		r = new int[4];
		c = new int[4];
		this.data = data;
		center = new Point(5,0);
	}
	
	public abstract int getType();
	public abstract int roteType();
	
	public int getX() { return center.x; }
	public int getY() { return center.y; }
	
	public boolean copy() { //값 복사
		boolean value = false;
		int x = getX();
		int y = getY();
		if(getMinY() + y <= 0) {
			value = true;
		}
		
		for(int i = 0; i < 4; i++) {
			data.setAt(y + r[i], x + c[i], getType());
		}
		return value;
	}
	
	public boolean isOverlap(int dir) { //다른 조각과 겹치는지 파악
		int x = getX();
		int y = getY();
		switch(dir) {
		case 0: //아래
			for(int i = 0; i < r.length; i++) {
				if(data.getAt(y+r[i]+1, x+c[i]) != 0) {
					return true;
				}
			}
			break;
		case 1: //왼쪽
			for(int i = 0; i < r.length; i++) {
				if(data.getAt(y+r[i], x+c[i]-1) != 0) {
					return true;
				}
			}
			break;
		case 2: //오른쪽
			for(int i = 0; i < r.length; i++) {
				if(data.getAt(y+r[i], x+c[i]+1) != 0) {
					return true;
				}
			}
			break;
		}
		return false;
	}
	
	public int getMinX() {
		int min = c[0];
		for(int i = 1; i < c.length; i++) {
			if(c[i] < min) {
				min = c[i];
			}
		}
		return min;
	}
	
	public int getMaxX() {
		int max = c[0];
		
		for(int i = 1; i < c.length; i++) {
			if(c[i] > max) {
				max = c[i];
			}
		}
		return max;
	}
	
	public int getMinY() {
		int min = r[0];
		for(int i = 1; i < r.length; i++) {
			if(r[i] < min) {
				min = r[i];
			}
		}
		return min;
	}
	
}
