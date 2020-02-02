package CartSection;

import MenuSection.*;
import PaymentSection.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;


public class cartPanel extends JPanel{
	public static JPanel cartList;//��ٱ��� ������ ���������� �� �г�
	public JScrollPane cartlistPanel;//��ǰ�� �������� ��ũ���� �־�� �� ��ǰ���� �� ���� �� �ֱ⶧���� scrollpane ����
	public static ArrayList<selectedItem> itemList;//���ù��� Item���� List. ������ ������ Panel class�� ������
	public static int cartListHeight;//�⺻�� 8. 8������ �� ���� ��ǰ�� ��ٱ��Ͽ� �Էµ� ���, �� �߰��ϱ� ���� ��������.
	public static int totalPrice;//��ٱ��� ���� ��� ��ǰ���� ������ ��ģ ��
	public static int indexNum;//���� ��ٱ��� ���� ��ǰ�� � ���ִ°�?
	
	//�ٸ� class���� ���� �����ϵ��� public, staticó��
	public cartPanel() {
		
		setLayout(new BorderLayout());//North�� ��ǰ��, ����, ������ ǥ���ϰ� Center�� ScrollPane�� �ֱ� ���� BorderLayout ����
		
		totalPrice = 0;//ó���� ������ ��, ��� ��ǰ�� ���� ������ 0�� �Ǿ�� �ϹǷ� 0���� �ʱ�ȭ.
		itemList = new ArrayList<>();//itemList��� selectedItem class�� Element�� ������ ArrayList ��ü ����		
		cartList = new JPanel();//cartList Panel����
		cartListHeight = 8;//��ٱ����� ó�� �뷮. ó���� 8������ �Է� �����ϰ� ArrayList�ϱ� ������ 2�辿 �þ���̴�.
		indexNum = 0;
		
		JPanel infor = new JPanel();
		infor.setLayout(new GridLayout(1,3));
		infor.setBorder(new LineBorder(Color.BLACK));
		infor.setBackground(Color.WHITE);
		//��ǰ�� �̸�, ����, ���� ������ �� ������� ��Ÿ���ٰ� �����ִ� Panel. ��Ʈ������ ������̱� ������ �̷��� ó����.
		//�ٸ� �гε�� �����ϱ� ���Ͽ� Border�� ����������, Background�� ������� ó��.
		
		JLabel itemName = new JLabel("��ǰ��");
		itemName.setHorizontalAlignment(JLabel.CENTER);
		JLabel itemAmount = new JLabel("����");
		itemAmount.setHorizontalAlignment(JLabel.CENTER);
		JLabel itemPrice = new JLabel("����");
		itemPrice.setHorizontalAlignment(JLabel.CENTER);
		//��ǰ �̸�, ���� ���� Label ����� �߾�����
		
		infor.add(itemName);
		infor.add(itemAmount);
		infor.add(itemPrice);
		//�� Label�� infor Panel�� �߰�.
		
		add(infor,BorderLayout.NORTH);//infor Panel�� �ش� �г� NORTH�� �߰�. 
		
		cartList.setLayout(new GridLayout(cartListHeight, 3,2,2));
		//cartList���̾ƿ��� ���� cartListHeight��ŭ, ���� ��ǰ��, ����, ���� ������� �����ϹǷ�3
		//�ּ��� selectedItem���� ������ �Ǿ� �ϹǷ� 2�� ������ ����. ó�� ���ϴϱ� ��輱�� ���ļ� �̻��ϰ� ����.
		cartlistPanel = new JScrollPane(cartList);
		//��ǰ�� ���� �������� ������ Panel���� �þ ��ǰ���� ó���ؾ� �ϹǷ� JScrollPane ���� �� �߰�.
		
		add(cartlistPanel, BorderLayout.CENTER);		
		//������ ���� cartlistPanel�� �ش��г� CENTER�� �߰�.
	}
	public static void syncronizeCartList() {
		//cartList�� �����ϴ� �޼���. 
		//cartList �г��� �ٽ� �׷��� �� ���� �����ٵ� �׷� �� itemList ���� ����Ǿ��ִ� �������� �ٽ� cartList�� �Է�������Ѵ�.
		cartList.invalidate();
		//�������.
		cartList.removeAll();
		//������ ������ ��� �����.
		for(Iterator<selectedItem> tmp = itemList.iterator() ; tmp.hasNext(); ) {
			//Iterator ó���� �ϴ� ������ ArrayList ���� Element�� �����ϰų� �߰��� �� �̷��� ���ϸ� ������ ��.
			selectedItem p = tmp.next();
			cartList.add(p);
			//itemList������ ��� Element���� cartList�� �߰�.
		}
		cartList.validate();
		//�ٽ� ��װ�
		cartList.repaint();
		//�ش� �г��� �ٽ� �׸���.
	}
	public static void selectItem(itemButton A) {
		selectedItem selected = new selectedItem(A.name,A.price,indexNum);
		//selectedItem ��ü�� �ϳ� ����.
		totalPrice += A.price;//��ü ���ݿ� �ش� ��ü�� ���ݸ�ŭ �����ش�.
		indexNum += 1;
		itemList.add(selected);
		//�ش� ��ü�� itemList�� �Էµȴ�.
		if(itemList.size() <= cartListHeight) {
			cartList.add(selected);
			//cartListHeight ũ�⺸�� itemList�� element ������ �۰ų� ���ٸ� �׳� cartList�� �ٷ� add�Ѵ�.
		}
		else {//���࿡ ũ�ٸ�?
			cartListHeight += 1;//cartListHeight�� 1��ŭ �� ������Ų��.
			cartList.setLayout(new GridLayout(cartListHeight, 3, 2, 2));
			for(int i = 0; i < itemList.size(); i++) cartList.add(itemList.get(i));
			//���� �� cartListHeight�� �������� cartList�� �ٽ� �����Ѵ�.
		}
	}
	public static void initalize() {
		//�ֹ��� �������� ��� ���� �ʱ�ȭ������� �Ѵ�.
		totalPrice = 0;//�� ������ 0���� �ʱ�ȭ��Ű��
		indexNum = 0;//index�� ���� 0���� �ʱ�ȭ��Ű��
		billPanel.renewBill(totalPrice);//�ʱ�ȭ�� totalPrice�� �������� billPanel�� �����ϰ�
		itemList.clear();
		cartList.invalidate();
		cartList.removeAll();
		cartList.validate();
		cartList.repaint();
		//cartList�� �ʱ� ���·� �ʱ�ȭ��Ų��.
	}

}
