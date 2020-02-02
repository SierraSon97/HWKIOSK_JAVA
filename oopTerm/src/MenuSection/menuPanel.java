package MenuSection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class menuPanel extends JPanel{
	public buttonPanel buttonPanel = new buttonPanel();//��ǰ���� ��ȯ�� �� ����� buttonPanel ��ü ����
	public itemPanel itemPanel = new itemPanel();//��ǰ���� �����Ǿ��ִ� itemPanel ��ü ����
	//���߿� �̺�Ʈó�� ���� ���� public ó��

	public menuPanel() {
		setLayout(new BorderLayout());
		JPanel nameTag = new JPanel();//kiosk �� ���� ī�� �̸��� �Է��ϱ����� ������ �г�
		JLabel name = new JLabel("SonStar Coffee");//nameTag �гο� �Է� �� ī�� �̸� ���̺�
		name.setHorizontalAlignment(JLabel.CENTER);//�ش� ���̺��� ���ڿ� �߾�����
		nameTag.setBackground(Color.LIGHT_GRAY);
		nameTag.setForeground(Color.BLACK);
		//nameTag �г��� ���� ���� �� ����
		nameTag.add(name);
		
		JPanel button_item = new JPanel();//buttonPanel�� itemPanel�� ���� �г� ��ü ����
		button_item.setLayout(new BorderLayout());
		button_item.add(buttonPanel, BorderLayout.NORTH);
		button_item.add(itemPanel, BorderLayout.CENTER);
		//�ش� �гο� buttonPanel�� itemPanel�� �߰������ν� �ϳ��� �гη� ó��
		buttonPanel.coffeeButton.addActionListener(new menuButtonAction());
		buttonPanel.teaButton.addActionListener(new menuButtonAction());
		buttonPanel.yogurtButton.addActionListener(new menuButtonAction());
		buttonPanel.juiceButton.addActionListener(new menuButtonAction());
		//���� ��ư�� �׼Ǹ����� �߰�.
		add(nameTag, BorderLayout.NORTH);
		add(button_item, BorderLayout.CENTER);
		//���������� menuPanel�� nameTag, button_item �г� �߰�
	}
	class menuButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton Button = (JButton)e.getSource();
			if(Button.equals(buttonPanel.coffeeButton)) {
				itemPanel.card.show(itemPanel,"Coffee");
			}
			else if(Button.equals(buttonPanel.teaButton)) {
				itemPanel.card.show(itemPanel,"Tea");
			}
			else if(Button.equals(buttonPanel.yogurtButton)) {
				itemPanel.card.show(itemPanel,"Yogurt");
			}
			else if(Button.equals(buttonPanel.juiceButton)){
				itemPanel.card.show(itemPanel,"Juice");
			}
			/*��ǰ���� ��Ÿ���� �г��� ī�巹�̾ƿ� ó�� �ؼ�
			 * buttonPanel�� ��ư���� ������ ��, � ��ư�� ���������Ŀ� ����
			 * �гο� ����� ī��(�г�)�� ��Ÿ������ ���α׷��� �� �׼Ǹ����� 
			 * */
			//�������� : ������ ��ư�� String�� �޾ƿ����� �̹��� Object ��ü�� �޾ƿ�.
			//�׸��� ���� Ŭ������ ���������� �ʵ��� menuPanel���� �ٷ� �׼Ǹ����ʸ� ó��.
		}
	}
}
