package Kiosk;

import MenuSection.*;
import CartSection.*;
import PaymentSection.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Kiosk extends JFrame {
	/*
	 * ���� Ŭ����. �� Kiosk Ŭ������ main Ŭ����
	 */
	public menuPanel menu; //�޴� Ŭ����
	public cartPanel cart; //��ٱ��� Ŭ����
	public billPanel bill;//�� ���� Ŭ����
	public paymentPanel payment; //����â Ŭ����
	//�ٸ� ��Ű������ �׼Ǹ����� ����� ���� �ʵ忡 ��ü����
	public Kiosk() {
		setTitle("Sonstar Coffee KIOSK");//�����̸��� ���α׷� â�� �߰� �ϱ� ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container Ct = getContentPane();
		Ct.setLayout(new GridLayout(2,1,10,10));//�޴��гΰ� ��ٱ���, ���� �г��� ������ �и��ϱ� GridLayout���
		
		menu = new menuPanel(); //�޴� Ŭ����
		cart = new cartPanel(); //��ٱ��� Ŭ����
		bill = new billPanel(cart.totalPrice);//��ǰ�� �� ���� Ŭ����
		payment = new paymentPanel(); //����â Ŭ����
		
		JPanel cart_paySection = new JPanel();//��ٱ���â�� ����â Ŭ������ ���� �г�
		cart_paySection.setLayout(new GridLayout(2,1));//������ ������ �ذ��� �����̹Ƿ� GridLayout ó��
		cart_paySection.add(cart);//cart_paySection�� cart�߰�.
		
		JPanel bill_paybuttonSection = new JPanel();//billPanel�� paymentPanel�� ���� �г�
		bill_paybuttonSection.setLayout(new GridLayout(1,2));//������ ���� �����̹Ƿ� GridLayout ó��
		bill_paybuttonSection.add(bill);//bill_paybutotnSection�� bill Ŭ���� �߰�
		bill_paybuttonSection.add(payment);//bill_paybutotnSection�� payment Ŭ���� �߰�
		
		cart_paySection.add(bill_paybuttonSection);//cart_paySection�� bill_paybuttonSection�߰�.
	
		Ct.add(menu);
		Ct.add(cart_paySection);
		//���������� �����̳ʿ� menu�� cart_paySection�߰�
		
		//setLocationRelativeTo(null);//ȭ�� �߰��� ���α׷� ��ġ 
		setSize(600,800);//������ ����
		setResizable(false);//������ ���� �Ұ����ϵ��� �ϱ� ���� �߰���
		setVisible(true);
	}
	public static void main(String[] args) {
		new Kiosk();
	}
}
