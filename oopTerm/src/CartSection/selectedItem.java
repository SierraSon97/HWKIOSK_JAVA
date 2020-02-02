package CartSection;

import PaymentSection.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectedItem extends JPanel{
	//���� �� ��ǰ Ŭ����. 
	//��ٱ��Ͽ� ���� ��ǰ �г� Ŭ����.
	public String itemName;//��ǰ �̸�
	public int itemPrice;//��ǰ ����
	public int itemAmount;//��ǰ ����
	public int amountofPrice;//��ǰ �� ����
	public int index;
	//deleteSelectedItem �޼��忡�� �ش� ������ ������ �Ȱ��� itemName�� itemAmount�� ���� ��ü�� itemList�� ���� ��
	//���߿� �߰��� ��ǰ�� �����Ϸ��� �ϸ� itemList�� �� ���� �ִ� ��ü�� �����Ǵ� ���� �߻�. �׷��� ���� ��ǰ�� �߰��� ������ �����ϴ�
	//index ������ �߰�.
	
	public JLabel Amount;//������ ���� JLabel
	public JLabel PriceLabel;//�� ������ ���� JLabel
	public JButton Plus, Minus, delete;
	//��ǰ�� ���� ������Ű�� plus, ���ҽ�Ű�� minus, ��ǰ�� �����ϴ� delete ��ư
	
	public selectedItem(String itemName, int itemPrice, int indexnum) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemAmount = 1;
		this.amountofPrice = itemPrice;
		this.index = indexnum;
		//�����ڰ� ó�� ������ �� itemButton Ŭ�������� itemName�� itemPrice�� �޾ƿ�. 
		//cartPanel�� selectItem �޼ҵ带 Ȱ���� �׼� �����ʸ� ����� itemButton �� �߰�.
		
		setLayout(new GridLayout(1,3));//��ǰ �̸�, ����, �� �������� ��Ʈ�� �������̱� ������ GridLayout���� ó��.
		setBorder(new LineBorder(Color.BLACK));//��輱 ó���� ������ ������ ��ǰ���� ������ �� �ȵǹǷ� ��輱�� ����.
		setBackground(Color.WHITE);
		
		JPanel NamePanel = new JPanel();//�̸��� �� �г�
		JLabel NameLabel = new JLabel(itemName);//NamePanel���� �ö� NameLabel. ���⿡ itemName�� �Է�.
		NameLabel.setHorizontalAlignment(JLabel.CENTER);//NameLabel �������
		NameLabel.setFont(new Font("Arial",Font.BOLD, 20));//NameLabel ����ó��, ��Ʈ ũ�⸦ ũ��ó��.
		NamePanel.setBackground(Color.WHITE);//���� �����Ǿ��ϹǷ� ������ ������� ó��.
		NamePanel.setBorder(new LineBorder(Color.BLACK));//selectedItem ���ο� �� �гγ��� �����Ǿ� �ϹǷ� ��輱�� ����.
		NamePanel.add(NameLabel);//NamePanel�� NameLabel�� �߰��մϴ�.
		
		JPanel PricePanel = new JPanel();//�� ������ �� �г�
		PricePanel.setBackground(Color.WHITE);//���� �����Ǿ��ϹǷ� ������ ������� ó��.
		PricePanel.setBorder(new LineBorder(Color.BLACK));//selectedItem ���ο� �� �гγ��� �����Ǿ� �ϹǷ� ��輱�� ����.
		PriceLabel = new JLabel(Integer.toString(amountofPrice));//�� ������ �� PriceLabel
		PriceLabel.setHorizontalAlignment(JLabel.CENTER);//PriceLabel �������
		PriceLabel.setFont(new Font("Arial",Font.BOLD, 20));//PriceLabel ����ó��, ��Ʈ ũ�⸦ ũ��ó��.
		PricePanel.add(PriceLabel);//PricePanel�� PriceLabel�� �߰�.
		
		JPanel AmountPanel = new JPanel();//��ǰ�� �� ������ ��Ÿ���� �г�
		JPanel buttonPanel = new JPanel();//plus,minus,delete ��ư�� �� �г�
		
		AmountPanel.setLayout(new BorderLayout());//�� ������ ��Ÿ���� AmountLabel, ��ư���� ���� buttonPanel�� ������ ��ġ�� �־�� �ϹǷ� BorderLayoutó��.
		AmountPanel.setBackground(Color.WHITE);//���� �����Ǿ��ϹǷ� ������ ������� ó���մϴ�.
		AmountPanel.setBorder(new LineBorder(Color.BLACK));//selectedItem ���ο� �� �гγ��� �����Ǿ� �ϹǷ� ��輱�� ����.
		buttonPanel.setLayout(new GridLayout(3,1));//plus, minus, delete ��ư�� ������ ������� ���� �ϹǷ� GridLayout
		
		Amount = new JLabel(""+itemAmount);//itemAmout, �� ��ǰ�� �� ���� �Է�
		Plus = new JButton("+");//Plus ��ư JButton��ü ����
		Minus = new JButton("-");//Minus ��ư JButton��ü ����
		delete = new JButton("X");//Delete ��ư JButton��ü ����
		
		Plus.setBackground(Color.LIGHT_GRAY);
		Minus.setBackground(Color.LIGHT_GRAY);
		delete.setBackground(Color.LIGHT_GRAY);
		
		Amount.setFont(new Font("Arial",Font.BOLD,20));//Amount ����ó��, ��Ʈ ũ�⸦ ũ��ó��.
		Amount.setHorizontalAlignment(JLabel.CENTER);//Amount �߾�����
		Plus.addActionListener(new plus_minus_delete());
		Minus.addActionListener(new plus_minus_delete());
		delete.addActionListener(new plus_minus_delete());
		//plus, minus, delete ��ư�� plus_minus_delete �׼Ǹ����ʸ� �߰��մϴ�.
		
		buttonPanel.add(Plus);
		buttonPanel.add(Minus);
		buttonPanel.add(delete);
		
		AmountPanel.add(Amount, BorderLayout.CENTER);
		AmountPanel.add(buttonPanel, BorderLayout.EAST);
		
		add(NamePanel);
		add(AmountPanel);
		add(PricePanel);
	}
	public static void deleteSelectedItem(String Name, int Amount, int index) {
		int flag = 0;
		for(Iterator<selectedItem> tmp = cartPanel.itemList.iterator() ; tmp.hasNext(); ) {
			//Iterator�� itemList�� ��ü�� �� üũ�غ���.
			selectedItem p = tmp.next();
			if(p.itemName == Name && p.itemAmount == Amount && p.index == index) { //���� parameter���� ���� element�� �ִٸ�?
				cartPanel.totalPrice -= p.amountofPrice;//��ǰ�� �������ϱ� �� ��ǰ�� �� ���ݸ�ŭ�� ��ü �� ���ݿ��� ����.
				tmp.remove();//�׸��� �ش� Iterator�� ����������. �ƿ� �� ��ǰ�� �������ϴϱ�.
				flag = 1;//��ǰ�� �����ߴٴ� flag ó��.
				continue;//���� �ݺ����� �н�
			}
			if(flag == 1) {//flag�� 1�� ��, �� ������ ��ü ������ itemList�� ��� ��ü�� ���� 
				p.index -=1;//�ε������� �ϳ��� �ٿ��ش�. ������ ��ü�� ���ڸ��� ä����� �ϹǷ�. 
			}
			
	}
	billPanel.renewBill(cartPanel.totalPrice);//billPanel�� �ٲ� totalPrice�� �����Ѵ�.
	cartPanel.syncronizeCartList();
	//cartList�� �ʱ�ȭ�ϰ� �ٽ� �����Ѵ�.
}
	public class plus_minus_delete implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();//�̺�Ʈ�� �Ͼ�� String�� �޾ƿ�. 
			if(str.equals("+")){//Plus ��ư�� ������ ��
				itemAmount += 1;//��ǰ �� �� 1 ����
				amountofPrice = itemAmount * itemPrice;//��ǰ �� ���� = ��ǰ �� �� * ��ǰ ����
				cartPanel.totalPrice += itemPrice;//���� ���ݿ� ��ǰ ������ �ѹ� ����.
			
				Amount.setText(""+itemAmount);//Amount�� �ٽ� �� ������ itemAmount �Է�
				PriceLabel.setText(Integer.toString(amountofPrice));//PriceLabel�� �ٽ� �� ������ amountofPrice �Է�
				billPanel.renewBill(cartPanel.totalPrice);//�� �� ������ ��µǴ� billPanel�� renewBill �޼ҵ�� billPanel �缳��
				//Amount JLabel, PriceLabel �缳��
			}
			else if(str.equals("-")){//Minus ��ư�� ������ ��
				if(itemAmount == 1) {
					int result = JOptionPane.showConfirmDialog(null,itemName+" �� ��ٱ��Ͽ��� �����Ͻðڽ��ϱ�?","Confirm",JOptionPane.YES_NO_OPTION);
					//Yes or no popup â ����
					if(result == JOptionPane.YES_OPTION) {//Yes�� ������ ��
						deleteSelectedItem(itemName, itemAmount, index);//cartPanel�� deleteSelectedItem �޼ҵ带 ����ؼ� �ش� selectedItem ��ü�� itemList���� ����
						JOptionPane.showMessageDialog(null, itemName+" �����Ǿ����ϴ�.");
					}
					else if(result == JOptionPane.NO_OPTION) {//No�� ������ ��
						JOptionPane.showMessageDialog(null, "��ҵǾ����ϴ�.");
					}
				}
				else if (itemAmount >= 2) {
					itemAmount -= 1;//��ǰ �� �� 1 ����
					amountofPrice = itemAmount * itemPrice;//��ǰ �� ���� = ��ǰ �� �� * ��ǰ ����
					cartPanel.totalPrice -= itemPrice;//���� ���ݿ� ��ǰ ������ �ѹ� ��.
					
					Amount.setText(""+itemAmount);//Amount�� �ٽ� �� ������ itemAmount �Է�
					PriceLabel.setText(Integer.toString(amountofPrice));//PriceLabel�� �ٽ� �� ������ amountofPrice �Է�
					billPanel.renewBill(cartPanel.totalPrice);//�� �� ������ ��µǴ� billPanel�� renewBill �޼ҵ�� billPanel �缳��
				}
			}
			else if(str.equals("X")) {//Delete��ư�� ������ ��
				int result = JOptionPane.showConfirmDialog(null,itemName+" �� ��ٱ��Ͽ��� �����Ͻðڽ��ϱ�?","Confirm",JOptionPane.YES_NO_OPTION);
				//Yes or no popup â ����
				if(result == JOptionPane.YES_OPTION) {//Yes�� ������ ��
					deleteSelectedItem(itemName, itemAmount, index);//cartPanel�� deleteSelectedItem �޼ҵ带 ����ؼ� �ش� selectedItem ��ü�� itemList���� ����
					JOptionPane.showMessageDialog(null, itemName+" �����Ǿ����ϴ�.");
				}
				else if(result == JOptionPane.NO_OPTION) {//No�� ������ ��
					JOptionPane.showMessageDialog(null, "��ҵǾ����ϴ�.");
				}
			}
	 	}
	}
}
