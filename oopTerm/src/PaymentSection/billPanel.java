package PaymentSection;

import javax.swing.*;
import java.awt.*;

public class billPanel extends JPanel {
	static JLabel amountofPrice;//��ٱ����� ��� ��ǰ���� ������ �� ��.
	public billPanel(int AmountofPrice) {
		setLayout(new BorderLayout());//ǥ ó�� ����� �; BorderLayoutó��
		JPanel nameTag = new JPanel();//�� ���̶�� ���ڰ� �� JPanel
		JLabel billTag = new JLabel("�� ��");//�� ���̶�� ���ڰ� �� JLabel
		billTag.setHorizontalAlignment(JLabel.CENTER);//�ش� Label �������
		nameTag.setBackground(Color.WHITE);
		nameTag.setForeground(Color.BLACK);
		//������ White, �۾�ü�� Black���� ó��
		nameTag.add(billTag);
		//nameTag JPanel�� Label�߰�

		JPanel pricePanel = new JPanel();
		pricePanel.setBackground(Color.WHITE);
		amountofPrice = new JLabel(AmountofPrice+" Won");//��� ��ǰ���� �� ������ ��Ÿ���� Label
		amountofPrice.setHorizontalAlignment(JLabel.CENTER);
		amountofPrice.setFont(new Font("Arial", Font.BOLD, 40));
		pricePanel.add(amountofPrice);
		//�߾� ���� �� ��Ʈ ����
		
		add(nameTag,BorderLayout.NORTH);
		add(pricePanel, BorderLayout.CENTER);
		//������ �뵵�� �°� ��ġ ����.
	}
	public static void renewBill(int AmountofPrice){
		amountofPrice.setText(AmountofPrice+" Won");
		amountofPrice.setHorizontalAlignment(JLabel.CENTER);
		amountofPrice.setFont(new Font("Arial", Font.BOLD, 40));
		//Parameter ������ amountofPrice Label�� �缳����Ű�� �޼���
	}
}
