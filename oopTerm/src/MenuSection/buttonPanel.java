package MenuSection;

import javax.swing.*;
import java.awt.*;


public class buttonPanel extends JPanel {
	/*
	 * kiosk�� �� ���� �޴��� �����ϴ� ��ư���� ���ִ� �г� Ŭ����
	 * */
	public JButton coffeeButton = new JButton("Coffee");
	public JButton teaButton = new JButton("Tea");
	public JButton yogurtButton = new JButton("Yogurt");
	public JButton juiceButton = new JButton("Juice");
	//�޴� �����ϴµ� ���� JButton��ü��. �ٸ� Ŭ�������� ���� �����ϵ��� Public ó��
	public buttonPanel() {
		coffeeButton.setBackground(Color.WHITE);
		coffeeButton.setFont(new Font("Arial", Font.BOLD, 20));
		teaButton.setBackground(Color.WHITE);
		teaButton.setFont(new Font("Arial", Font.BOLD, 20));
		yogurtButton.setBackground(Color.WHITE);
		yogurtButton.setFont(new Font("Arial", Font.BOLD, 20));
		juiceButton.setBackground(Color.WHITE);
		juiceButton.setFont(new Font("Arial", Font.BOLD, 20));
		//���� ��ư���� ��� �� ����
		
		setLayout(new GridLayout(1,4,5,5)); //��ư���� ���ִ� �����̹Ƿ� ���ϰ� GridLayout ���
		setBackground(Color.LIGHT_GRAY);
		//buttonPanel ��� �� ����
		add(coffeeButton);
		add(teaButton);
		add(yogurtButton);
		add(juiceButton);
		//�ְ���� ������� �� ��ư�� �ش� �гο� �߰�
	}
}
