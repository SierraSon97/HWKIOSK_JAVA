package ImageSection;

import javax.swing.*;
import java.awt.*;

public class musicPlayerImage extends ImageIcon {
	public ImageIcon musicPlayerIcon;//�����÷��̾� ImageIcon
	public musicPlayerImage() {
		Image img;
		ImageIcon before = new ImageIcon("images/MusicPlayer.png");
		//image ���� ���� �̹������Ͽ� �����ؼ� �ش� ��ü ����
		img = before.getImage();
		img.getScaledInstance(180, 270, Image.SCALE_SMOOTH);
		//Image ��ü�� �ش� �̹��������� �ҷ��ͼ� ũ�� ����
		musicPlayerIcon = new ImageIcon(img);
		//���� �� �׸� ������ ImageIcon ��ü�� ����
	}
}
