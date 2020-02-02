package PaymentSection;

import ImageSection.*;
import CartSection.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.*;
import javax.sound.sampled.*;

public class paymentPanel extends JPanel {
	public JPanel paybuttonPanel;
	//payButton, cancelButton�� ���� JPanel
	public JButton payButton;
	public JButton cancelButton;
	//������ư�� ������� ��ư  JButton
	//�ٸ� Ŭ���������� ���� �����ϰ� publicó��
	private Clip clip;
	//���� ����ϴµ� �ʿ��� Clip
	public paymentPanel() {
		setLayout(new GridLayout(1,2));
		//��ư�� �� �ڸ��� �߰�����(�����÷��̾�)�� �� �ڸ� ������ ������ ���� GridLayoutó��
		
		paybuttonPanel = new JPanel();		
		paybuttonPanel.setLayout(new GridLayout(2,1));
		//��ư �ΰ��� ���� �ϹǷ� GridLayoutó��
		
		payButton = new JButton("�����ϱ�");
		payButton.setBackground(Color.WHITE);
		payButton.setFont(new Font("����",Font.BOLD, 20));
		cancelButton = new JButton("�������");
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setFont(new Font("����", Font.BOLD, 20));
		paybuttonPanel.add(payButton);
		paybuttonPanel.add(cancelButton);
		//������ư�� ������� ��ư�� paybuttonPanel�� �߰�.
		
		musicPlayerImage deco = new musicPlayerImage();
		//��Ŀ� �̹��� decorationImage ��ü ����
		JPanel musicPlayer = new JPanel();
		JPanel musicButton = new JPanel();
		//MusicPlayer�� �� JPanel�� �� MusicPlayer�� ������ ��ư�� �� musicButton JPanel ����
		musicButton.setLayout(new GridLayout(1,2));
		JButton start = new JButton("Start");
		start.setBackground(Color.LIGHT_GRAY);
		JButton stop = new JButton("Stop");
		stop.setBackground(Color.LIGHT_GRAY);
		//start ��ư�� stop ��ư ���� �� ��� �� �߰�.
		musicButton.add(start);
		musicButton.add(stop);
		//start ��ư�� stop ��ư�� musicButton �гο��߰�
		
		musicPlayer.setLayout(new BorderLayout());
		try{
			clip = AudioSystem.getClip();
			File audioFile = new File("music/bgm.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip.open(audioStream);
		}//�׳� Ŭ�����θ� ó���ϸ� �������� ������ try�� ���ΰ�
		catch (LineUnavailableException e) {e.printStackTrace();}
		catch (UnsupportedAudioFileException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
		//���� �� �ִ� ��� ������ ����Ͽ� ����ó��
		start.addActionListener(new audioAction());
		stop.addActionListener(new audioAction());
		//�� ��ư�� audioAction �׼Ǹ����ʸ� �߰�
		
		JLabel decoration = new JLabel(deco.musicPlayerIcon);
		//�̹����� �� decoration JLabel
		musicPlayer.add(decoration,BorderLayout.CENTER);
		musicPlayer.add(musicButton, BorderLayout.SOUTH);
		
		payButton.addActionListener(new paymentAction());
		cancelButton.addActionListener(new paymentAction());
		//������ư�� ��ҹ�ư �׼Ǹ�����ó��
		add(paybuttonPanel);
		add(musicPlayer);	
		//���������� �� ��ü�� �߰�.
	}

	class paymentAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();
			//��ư�� String �ۿ� ���� ������ ���� getSource�Ⱦ�.
			if(str.equals("�����ϱ�")) {//�����ϱ� ��ư�� ������ ��
				int result = JOptionPane.showConfirmDialog(null, cartPanel.totalPrice+"���� �����Ͻðڽ��ϱ�?","Confirm",JOptionPane.YES_NO_OPTION);
				//Yes or No �˾�â���� ���������� ������ ���� �������� �Ǵ�
				if(result == JOptionPane.YES_OPTION) {//���� Yes�� �����ٸ�
					JOptionPane.showMessageDialog(null,cartPanel.totalPrice+" ���� ���� �Ǿ����ϴ�!");
					//������ �Ǿ��ٴ� �˸� �˾�
					cartPanel.initalize();//cartPanel�� �ʱ�ȭ��Ű�� �޼��� ����
				}
				else if(result == JOptionPane.NO_OPTION) {//���� No�� �����ٸ�
					JOptionPane.showMessageDialog(null, "��ҵǾ����ϴ�.");
					//��Ұ� �Ǿ��ٴ� �˸� �˾�
				}
			}
			else if(str.equals("�������")) {//������� ��ư�� ������ ��
				int result = JOptionPane.showConfirmDialog(null, "���� ����Ͻðڽ��ϱ�?","Confirm",JOptionPane.YES_NO_OPTION);
				//Yes or No �˾�â���� ���������� ������Ҹ� ���� �������� �Ǵ�
				if(result == JOptionPane.YES_OPTION) {//���� Yes�� �����ٸ�
				cartPanel.initalize();//cartPanel�� �ʱ�ȭ��Ű�� �޼��� ����
				JOptionPane.showMessageDialog(null, "���� ��ҵǾ����ϴ�.");
				}
				//No�� ���� ��������. 
			}
		}
	}
	class audioAction implements ActionListener{
		//�߰���������
		//������� �׼� �������Դϴ�.
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "Start" : 
				clip.start();//Start ��ư�� ������ clip ����
				clip.setFramePosition(0);//�׸��� �ٽ� ��� �� �� �ְ� FramePosition �� 0���� ����
				break;
			case "Stop" : 
				clip.stop();//Stop ��ư�� ������ clip ����
				clip.setFramePosition(0);//�ٽ� ��� �� �� �ְ� FramePosition�� 0���� ����
				break;
			}
		}
	}
}
