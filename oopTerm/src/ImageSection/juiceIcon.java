package ImageSection;

import javax.swing.*;
import java.awt.*;

public class juiceIcon extends ImageIcon {
	public ImageIcon juiceImage;
	public ImageIcon appleJuice;
	public ImageIcon grapeJuice;
	public ImageIcon kiwiJuice;
	public ImageIcon orangeJuice;
	public ImageIcon strawberryJuice;
	//�ٸ� Ŭ�������� ���� �����ϵ��� ImageIcon�� public ó��
	//�� Ŭ������ Juice �޴����� ����ϴ� ��� ImageIcon �������� ó����.
	public juiceIcon() {
		Image img;
		ImageIcon before = new ImageIcon("images/Juice.png");
		//image ���� ���� �̹������Ͽ� �����ؼ� �ش� ��ü ����
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//Image ��ü�� �ش� �̹��������� �ҷ��ͼ� ũ�� ����
		juiceImage = new ImageIcon(img);
		//���� �� �׸� ������ ImageIcon ��ü�� ����
		
		before = new ImageIcon("images/juice/appleJuice.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		appleJuice = new ImageIcon(img);
		//appleJuice ImageIcon ó��
		
		before = new ImageIcon("images/juice/grapeJuice.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		grapeJuice = new ImageIcon(img);
		//grapeJuice ImageIcon ó��
		
		before = new ImageIcon("images/juice/kiwiJuice.png");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		kiwiJuice = new ImageIcon(img);
		//kiwiJuice ImageIcon ó��
		
		before = new ImageIcon("images/juice/orangeJuice.png");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		orangeJuice = new ImageIcon(img);
		//orangeJuice ImageIcon ó��
		
		before = new ImageIcon("images/juice/strawberryJuice.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		strawberryJuice = new ImageIcon(img);
		//strawberryJuice ImageIcon ó��
		
		//���� ���� �ݺ�. juice �޴��� ��ǰ�� ImageIcon�� �ش� �����ڷ� ó��.
	}
}