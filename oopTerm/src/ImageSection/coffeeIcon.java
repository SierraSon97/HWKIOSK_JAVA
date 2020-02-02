package ImageSection;

import javax.swing.*;
import java.awt.*;

public class coffeeIcon extends ImageIcon {
	public ImageIcon coffeeImage;
	public ImageIcon americano;
	public ImageIcon latte;
	public ImageIcon mocha;
	public ImageIcon einspanner;
	
	//�ٸ� Ŭ�������� ���� �����ϵ��� ImageIcon�� public ó��
	//�� Ŭ������ coffee �޴����� ����ϴ� ��� ImageIcon �������� ó����.
	public coffeeIcon() {
		Image img;
		ImageIcon before = new ImageIcon("images/Coffee.png");
		//image ���� ���� �̹������Ͽ� �����ؼ� �ش� ��ü ����
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//Image ��ü�� �ش� �̹��������� �ҷ��ͼ� ũ�� ����
		coffeeImage = new ImageIcon(img);
		//���� �� �׸� ������ ImageIcon ��ü�� ����
		
		before = new ImageIcon("images/coffee/americano.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		americano = new ImageIcon(img);
		//americano ImageIcon ó��
		
		before = new ImageIcon("images/coffee/latte.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		latte = new ImageIcon(img);
		//latte ImageIcon ó��
		
		before = new ImageIcon("images/coffee/mocha.png");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		mocha = new ImageIcon(img);
		//mocha ImageIcon ó��
		
		before = new ImageIcon("images/coffee/einspanner.png");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		einspanner = new ImageIcon(img);
		//einspanner ImageIcon ó��
		
		//���� ���� �ݺ�. coffee �޴��� ��ǰ�� ImageIcon�� �ش� �����ڷ� ó��.
	}
}
