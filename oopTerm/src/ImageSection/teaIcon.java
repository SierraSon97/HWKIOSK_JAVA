package ImageSection;

import javax.swing.*;
import java.awt.*;

public class teaIcon extends ImageIcon {
	public ImageIcon teaImage;
	public ImageIcon greenTea;
	public ImageIcon blackTea;
	public ImageIcon milkTea;
	//�ٸ� Ŭ�������� ���� �����ϵ��� ImageIcon�� public ó��
	//�� Ŭ������ tea �޴����� ����ϴ� ��� ImageIcon �������� ó����.
	public teaIcon() {
		Image img;
		ImageIcon before = new ImageIcon("images/Tea.png");
		//image ���� ���� �̹������Ͽ� �����ؼ� �ش� ��ü ����
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//Image ��ü�� �ش� �̹��������� �ҷ��ͼ� ũ�� ����
		teaImage = new ImageIcon(img);
		//���� �� �׸� ������ ImageIcon ��ü�� ����
		
		before = new ImageIcon("images/tea/greenTea.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		greenTea = new ImageIcon(img);
		//greenTea ImageIcon ó��
		
		before = new ImageIcon("images/tea/blackTea.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		blackTea = new ImageIcon(img);
		//blackTea ImageIcon ó��
		
		before = new ImageIcon("images/tea/milkTea.png");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		milkTea = new ImageIcon(img);
		//milkTea ImageIcon ó��
		
		//���� ���� �ݺ�. tea �޴��� ��ǰ�� ImageIcon�� �ش� �����ڷ� ó��.
	}
}