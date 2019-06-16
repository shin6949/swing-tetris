package mokpotetris;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TetrisPreview extends JPanel {
	
	protected TetrisData data; //��Ʈ���� ���� ������
	protected Piece current;
	protected Color colors[];
	static int block[] = {1,2};
	
	public TetrisPreview() {
		
		colors = new Color[8]; // ��Ʈ���� ��� �� ���� ��
		colors[0] = new Color(80, 80, 80); // ����(����ȸ��)
		colors[1] = new Color(255, 0, 0); //������
		colors[2] = new Color(0, 255, 0); //���
		colors[3] = new Color(0, 200, 255); //�ϴû�
		colors[4] = new Color(255, 255, 0); //�����
		colors[5] = new Color(255, 150, 0); //Ȳ���
		colors[6] = new Color(210, 0, 240); //�����
		colors[7] = new Color(40, 0, 240); //�Ķ���
		
		System.out.println("TetrisPreView");
		repaint();
	} 
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("TetrisPreView.paint");
		System.out.println(block[0]);
		System.out.println(current);
		
		switch(block[0]){
		case 0:
			current = new Bar(data);
			break;
		case 1:
			current = new Tee(data);
			break;
		case 2:
			current = new El(data);
			break;
		case 3:
			current = new Z(data);
			break;
		case 4:
			current = new O(data);
			break;
		case 5:
			current = new S(data);
			break;
		case 6:
			current = new J(data);
			break;
		default:
			if(block[0] % 2 == 0)
				current = new Tee(data);
			else current = new El(data);
		}
		
		for(int i = 0; i < 4; i++) {
			System.out.println("for" + i);
			System.out.println("color: " + colors[current.getType()]);
				g.setColor(colors[current.getType()]);
				System.out.println("g.fill3DRect( " + 20/2+ "+ 25 *" + (current.getX()+current.c[i]) + ", "  + 20/2 + " + 25 *" + (current.getY()+current.r[i]) + ", ");
				g.fill3DRect(20/2 + 25 * (current.getX()+current.c[i]), 20/2 + 25 * (current.getY()+current.r[i]), 25, 25, true);
				}
			}
		
		public static void input_next_blocks(int next1, int next2) {
			block[0] = next1;
			block[1] = next2;
		}
}
