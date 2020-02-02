package MenuSection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class itemPanel extends JPanel{
	public static CardLayout card;/*
	��ǰ���� ��ȯ�� �� ī�巹�̾ƿ��� ����� ���̱� ������, �׸���
	�׼Ǹ����ʸ� kiosk Ŭ�������� ����Ұ��̱� ������ public ó��
	*/
	public coffeePanel coffeePanel = new coffeePanel();
	public teaPanel teaPanel = new teaPanel();
	public yogurtPanel yogurtPanel = new yogurtPanel();
	public juicePanel juicePanel = new juicePanel();
	//���� ��ǰ �гε� ��ü ����
	public itemPanel() {
		card = new CardLayout(5,5);
		setLayout(card);//ī�巹�̾ƿ� ó��
		add("Coffee",coffeePanel);
		add("Tea",teaPanel);
		add("Yogurt",yogurtPanel);
		add("Juice",juicePanel);
		//show �Լ��� ����ϱ� ���� �� �г��� �߰��ϸ鼭 �г��� �߰�.
		coffeePanel.latteButton.setToolTipText("������ ������������ ����! �ε巯���� �����ص帳�ϴ�!");
		coffeePanel.americanoButton.setToolTipText("���� �ν����� Ŀ�Ƿ� ������ �ż��� ���������� ������ ���Դϴ�!");
		coffeePanel.mochaButton.setToolTipText("���� Ŀ�ǿ� ���ݸ��� ������ �߰��������! �� ������ ���������� ������ �п��� ��õ�մϴ�!");
		coffeePanel.einspannerButton.setToolTipText("�ٴ��ѵ� �ƴѵ� �� ũ���� ���� Ŀ���� ����! ��§�� �ƴ� �ܾ� ������ �ƴ� �е��� Ŀ�Ǹ� �� �ƽŴٴ� ���̰�����!");
		//coffeePanel ��ư�� ���� �߰� (�߰���������)
		teaPanel.blackteaButton.setToolTipText("���� ���Ϲ����ص� ȫ����! ���� �� ���� ���Ͻô� �� �� ��õ�մϴ�!");
		teaPanel.greenteaButton.setToolTipText("����ϰ� �ѱ����� �Ը��� ��! ����� ���� ��ġ�� �����ǰ̴ϴ�!");
		teaPanel.milkteaButton.setToolTipText("� õ�簡 ȫ���� ������ ������ �߰��س������?? �ε巯���� ������ �������� �ʴ��մϴ�!");
		//teaPanel ��ư�� ���� �߰� (�߰���������)
		yogurtPanel.appleYogurtButton.setToolTipText("����� ���Ʈ�� ����! ��ħ�� ������ �׳� �Ϸ簡 �̱׷�������?");
		yogurtPanel.plainButton.setToolTipText("�⺻�� ����� ���Ʈ�� ��! �� ��ü�ε� �Ϻ��մϴ�!");
		yogurtPanel.strawberryYogurtButton.setToolTipText("�̱׷��� ����� ���Ʈ�� ����! ��� �̰� ��ߵ�!!");
		//yogurtPanel ��ư�� ���� �߰� (�߰���������)
		juicePanel.applejuiceButton.setToolTipText("�̱׷��� ������� �� ��ü�Դϴ�. ��ħ�� ���ô°� ��õ�մϴ�. �׷��� �Ϸ����� �̱׷���.");
		juicePanel.grapejuiceButton.setToolTipText("�������� ���� �ٷ� �� �Դ� ������ ���Դϴ�. ������ �԰������ �ñ� �ȴ�? �׷� �̰� ��弼��!");
		juicePanel.kiwijuiceButton.setToolTipText("Ű���� ������ ���̶�� ����. �̱׷��� Ű�� ��� �Բ� �Ϸ縦 ����������!");
		juicePanel.orangejuiceButton.setToolTipText("�ֽ� �ϸ� �������ֽ�! ��������� ������ ���� ��!");
		juicePanel.strawberryjuiceButton.setToolTipText("���� ���� �ƽô� ���! ������ ������ ���� �����ص帳�ϴ�!");
		//juicePanel ��ư�� ���� �߰� (�߰���������)
		
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);
		m.setDismissDelay(300000);	
	}
	public class coffeePanel extends JPanel{
		private static final long serialVersionUID = 1L;
		public itemButton latteButton;
		public itemButton americanoButton;
		public itemButton mochaButton;
		public itemButton einspannerButton;
		//�ٸ� Ŭ�������� ���� �����ϵ��� �ʵ忡 ���� �� Public ó��	
		public coffeePanel() {
			setLayout(new GridLayout(2,4,10,10));//�԰�ȭ�� ��ǰ ������ ���� GridLayout ó��
			
			latteButton = new itemButton("Latte",2500, "Latte");
			americanoButton = new itemButton("Americano", 2000, "Americano");
			mochaButton = new itemButton("Mocha", 2500, "Mocha");
			einspannerButton = new itemButton("Einspanner", 3000, "Einspanner");
			//�ش� �гο� �߰��ϰ���� ��ǰ�� itemButton ��ü�� ����
			
			add(latteButton);
			add(americanoButton);
			add(mochaButton);
			add(einspannerButton);
			//������ itemButton ��ü�� �ش� �гο� �߰�
			for(int i = 0; i < 4; i++) add(new JPanel());//���� �߰����� ���� ��ǰ���� ��� �� �гη� ó��
		}
	}

	public static class teaPanel extends JPanel{
		public itemButton greenteaButton;
		public itemButton blackteaButton;
		public itemButton milkteaButton;
		//�ٸ� Ŭ�������� ���� �����ϵ��� �ʵ忡 ���� �� Public ó��
		public teaPanel() {
			setLayout(new GridLayout(2,4,10,10));//�԰�ȭ�� ��ǰ ������ ���� GridLayout ó��
			
			greenteaButton = new itemButton("GreenTea", 2000,"GreenTea");
			blackteaButton = new itemButton("BlackTea", 2500,"BlackTea");
			milkteaButton = new itemButton("MilkTea", 2800,"MilkTea");
			//�ش� �гο� �߰��ϰ���� ��ǰ�� itemButton ��ü�� ����
			
			add(greenteaButton);
			add(blackteaButton);
			add(milkteaButton);
			//������ itemButton ��ü�� �ش� �гο� �߰�
			for(int i = 0; i < 5; i++) add(new JPanel());//���� �߰����� ���� ��ǰ���� ��� �� �гη� ó��
		}
	}
	public static class yogurtPanel extends JPanel{
		public itemButton plainButton;
		public itemButton appleYogurtButton;
		public itemButton strawberryYogurtButton;
		//�ٸ� Ŭ�������� ���� �����ϵ��� �ʵ忡 ���� �� Public ó��
		public yogurtPanel() {
			setLayout(new GridLayout(2,4,10,10));//�԰�ȭ�� ��ǰ ������ ���� GridLayout ó��
			
			plainButton = new itemButton("PlainYogurt", 2000,"PlainYogurt");
			appleYogurtButton = new itemButton("AppleYogurt", 2500,"AppleYogurt");
			strawberryYogurtButton = new itemButton("StrawBerryYogurt", 2700,"StrawBerryYogurt");
			//�ش� �гο� �߰��ϰ���� ��ǰ�� itemButton ��ü�� ����
			
			add(plainButton);
			add(appleYogurtButton);
			add(strawberryYogurtButton);
			//������ itemButton ��ü�� �ش� �гο� �߰�
			for(int i = 0; i < 5; i++) add(new JPanel());//���� �߰����� ���� ��ǰ���� ��� �� �гη� ó��
		}
	}
	public static class juicePanel extends JPanel{
		public itemButton applejuiceButton;
		public itemButton orangejuiceButton;
		public itemButton grapejuiceButton;
		public itemButton kiwijuiceButton;
		public itemButton strawberryjuiceButton;
		//�ٸ� Ŭ�������� ���� �����ϵ��� �ʵ忡 ���� �� Public ó��
		public juicePanel() {
			setLayout(new GridLayout(2,4,10,10));//�԰�ȭ�� ��ǰ ������ ���� GridLayout ó��

			applejuiceButton = new itemButton("AppleJuice", 2500,"AppleJuice");
			orangejuiceButton = new itemButton("OrangeJuice", 2300,"OrangeJuice");
			grapejuiceButton = new itemButton("GrapeJuice", 2500,"GrapeJuice");
			kiwijuiceButton = new itemButton("KiwiJuice", 2500,"KiwiJuice");
			strawberryjuiceButton = new itemButton("StrawBerryJuice", 2500,"StrawBerryJuice");
			//�ش� �гο� �߰��ϰ���� ��ǰ�� itemButton ��ü�� ����
			
			add(applejuiceButton);
			add(orangejuiceButton);
			add(grapejuiceButton);
			add(kiwijuiceButton);
			add(strawberryjuiceButton);
			//������ itemButton ��ü�� �ش� �гο� �߰�
			for(int i = 0; i < 3; i++) add(new JPanel());//���� �߰����� ���� ��ǰ���� ��� �� �гη� ó��
		}
	}
	//��ǰ���� �����Ǵ� �гε� Ŭ������
}

