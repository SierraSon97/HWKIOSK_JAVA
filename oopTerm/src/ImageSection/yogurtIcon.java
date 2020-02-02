package ImageSection;

import javax.swing.*;
import java.awt.*;

public class yogurtIcon extends ImageIcon {
	public ImageIcon yogurtImage;
	public ImageIcon plainYogurt;
	public ImageIcon appleYogurt;
	public ImageIcon strawberryYogurt;
	//�ٸ� Ŭ�������� ���� �����ϵ��� ImageIcon�� public ó��
	//�� Ŭ������ yogurt �޴����� ����ϴ� ��� ImageIcon �������� ó����.
	public yogurtIcon() {
		Image img;
		ImageIcon before = new ImageIcon("images/Yogurt.png");
		//image ���� ���� �̹������Ͽ� �����ؼ� �ش� ��ü ����
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//Image ��ü�� �ش� �̹��������� �ҷ��ͼ� ũ�� ����
		yogurtImage = new ImageIcon(img);
		//���� �� �׸� ������ ImageIcon ��ü�� ����
		
		before = new ImageIcon("images/yogurt/plainYogurt.png");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		plainYogurt = new ImageIcon(img);
		//plainYogurt ImageIcon ó��
	
		before = new ImageIcon("images/yogurt/appleYogurt.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		appleYogurt = new ImageIcon(img);
		//appleYogurt ImageIcon ó��
		
		before = new ImageIcon("images/yogurt/strawberryYogurt.jpg");
		img = before.getImage();
		img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		strawberryYogurt = new ImageIcon(img);
		//strawberryYogurt ImageIcon ó��
		
		//���� ���� �ݺ�. yogurt �޴��� ��ǰ�� ImageIcon�� �ش� �����ڷ� ó��.
	}
}