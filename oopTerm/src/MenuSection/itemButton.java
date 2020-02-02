 package MenuSection;

import CartSection.*;
import ImageSection.*;
import PaymentSection.billPanel;

import javax.swing.*;
import ImageSection.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class itemButton extends JButton{
	/*
	 * itemPanel�� �� itemButton Ŭ����
	 * �ش� Ŭ������ ��ǰ�� �̸��� ���� ����, ��ǰ ���� ���̺��� ���ִ�.
	 * */
	public String name;//��ǰ�� �̸�
	public int price;//��ǰ�� ����
	//�Ŀ� ��ٱ���, ���� ��� ������ �� ����ϱ� ���� public ó��
	
	JLabel ImageLabel;
	//��ǰ ������ ���� �� ���̺�
	
	coffeeIcon coffeeIcon = new coffeeIcon();
	teaIcon teaIcon = new teaIcon();
	yogurtIcon yogurtIcon = new yogurtIcon();
	juiceIcon juiceIcon = new juiceIcon();
	//ImageSection ��Ű������ ������ ������ imageicon ��ü��. �Ŀ� �� �߰� ����.
	
	public itemButton(String name, int price, String menuName) {
		this.name = name;//��ü�� ������ ��, �̸��� ����, ��ǰ�̸��� �Է¹޴´�.
		this.price = price;
		
		if(menuName.equals("Coffee")) ImageLabel = new JLabel(coffeeIcon.coffeeImage);
		else if(menuName.equals("Americano")) ImageLabel = new JLabel(coffeeIcon.americano);
		else if(menuName.equals("Latte")) ImageLabel = new JLabel(coffeeIcon.latte);
		else if(menuName.equals("Mocha")) ImageLabel = new JLabel(coffeeIcon.mocha);
		else if(menuName.equals("Einspanner")) ImageLabel = new JLabel(coffeeIcon.einspanner);
		//coffee�޴��� ��ǰ���� ImageLabel�� ó�� �ϴ� ���ǹ�
		else if(menuName.equals("Tea")) ImageLabel = new JLabel(teaIcon.teaImage);
		else if(menuName.equals("GreenTea")) ImageLabel = new JLabel(teaIcon.greenTea);
		else if(menuName.equals("BlackTea")) ImageLabel = new JLabel(teaIcon.blackTea);
		else if(menuName.equals("MilkTea")) ImageLabel = new JLabel(teaIcon.milkTea);
		//tea�޴��� ��ǰ���� ImageLabel�� ó�� �ϴ� ���ǹ�
		else if(menuName.equals("Yogurt")) ImageLabel = new JLabel(yogurtIcon.yogurtImage);
		else if(menuName.equals("PlainYogurt")) ImageLabel = new JLabel(yogurtIcon.plainYogurt);
		else if(menuName.equals("AppleYogurt")) ImageLabel = new JLabel(yogurtIcon.appleYogurt);
		else if(menuName.equals("StrawBerryYogurt")) ImageLabel = new JLabel(yogurtIcon.strawberryYogurt);
		//yogurt�޴��� ��ǰ���� ImageLabel�� ó�� �ϴ� ���ǹ�
		else if(menuName.equals("Juice")) ImageLabel = new JLabel(juiceIcon.juiceImage);
		else if(menuName.equals("AppleJuice")) ImageLabel = new JLabel(juiceIcon.appleJuice);
		else if(menuName.equals("GrapeJuice")) ImageLabel = new JLabel(juiceIcon.grapeJuice);
		else if(menuName.equals("KiwiJuice")) ImageLabel = new JLabel(juiceIcon.kiwiJuice);
		else if(menuName.equals("OrangeJuice")) ImageLabel = new JLabel(juiceIcon.orangeJuice);
		else if(menuName.equals("StrawBerryJuice")) ImageLabel = new JLabel(juiceIcon.strawberryJuice);
		//juice�޴��� ��ǰ���� ImageLabel�� ó�� �ϴ� ���ǹ�
		else ImageLabel = new JLabel();
		//menuName�� �Է¿� ���� ImageLabel�� �˸��� Imageicon�� �߰�. �Ŀ� �� ���� �������� �߰��� ���� 
		//���� �ش� �κп� ���ǿ� ���� ���ڿ��� ���� ���, �׳� �� ���̺� ��ü ����
		
		JLabel textLabel = new JLabel(name);//��ǰ �̸��� �Էµ� ���̺�
		textLabel.setHorizontalAlignment(JLabel.CENTER);//�߾� ����
		
		JLabel priceLabel = new JLabel(Integer.toString(price));//��ǰ ������ �Էµ� ���̺�
		priceLabel.setHorizontalAlignment(JLabel.CENTER);//�߾� ����
		
		setBackground(Color.WHITE);//��ư ��� �� ����
		JPanel Base = new JPanel();//ItemButton ���� �÷��� �г� ����
		Base.setLayout(new BorderLayout());
		Base.setBackground(Color.WHITE);//Base�г� ��� �� ����
		Base.add(textLabel,BorderLayout.NORTH);//BorderLayout ���ʿ� ��ǰ �̸�
		Base.add(ImageLabel,BorderLayout.CENTER);//BorderLayout �߾ӿ� ��ǰ ����
		Base.add(priceLabel,BorderLayout.SOUTH);//BorderLayout ���ʿ� ��ǰ ����
		add(Base);
		//���������� �ϼ��� Base �г��� �߰�
		addActionListener(new itemButtonAction());
		//��ü�� �����Ǹ鼭 �ڵ����� �׼Ǹ����� �߰��ǰ� ó����.
	}
	class itemButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			itemButton b = (itemButton)e.getSource();
			//itemButton ��ü�� ������ �޾ƿ´�.
			int result = JOptionPane.showConfirmDialog(null,b.name+" �� �����Ͻðڽ��ϱ�?","Confirm",JOptionPane.YES_NO_OPTION);
			//�ش� ��ư�� ������ �ش� ��ư�� ��ǰ �̸��� �����鼭 ���� ���� ������ Yes or No�� ���� �� �� �ִ�.
			if(result == JOptionPane.YES_OPTION) {//Yes�� �����ϸ�
				cartPanel.selectItem(b);//cartPanel�� selectItem �޼ҵ带 ����Ͽ� �ش� ��ư�� ������ itemList�� �߰���.
				billPanel.renewBill(cartPanel.totalPrice);//��ǰ�� �ϳ� ���������� ��ǰ ���ݸ�ŭ �� ���ݵ� ���������״� ����
			}
			else if(result == JOptionPane.NO_OPTION) {//No�� �����ϸ�
				JOptionPane.showMessageDialog(null, "��ҵǾ����ϴ�.");
				//�˾�â �߸鼭 ��
			}
		}
	}
	//��ư�� ������ �ش� itemButton Class ���� ��ǰ �������� cartPanel�� itemList�� ����Ǵ� ���.
}

