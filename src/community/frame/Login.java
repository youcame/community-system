package community.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import community.dao.Userdao;
import community.dao.impl.Userdaoimpl;
import community.po.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String zhanghao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("账号");
		lblNewLabel.setBounds(64, 99, 93, 37);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(225, 99, 177, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(64, 204, 93, 37);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(225, 209, 177, 37);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		//登录按钮捏
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int judge=0;
				try {
					Userdao ud=new Userdaoimpl();
					List<User> list=ud.findUser();
					if(e.getButton()==MouseEvent.BUTTON1) {
						String zhanghao=textField.getText();
						String mima=textField_1.getText();
						for(int i=0;i<list.size();i++) {
							if(zhanghao.equals(list.get(i).getZhanghao())) {
								if(list.get(i).getQuanxian().equals("管理员"))judge=1;
								if(list.get(i).getQuanxian().equals("生活管家")) {
									judge=2;
									try {
										FileOutputStream fos=new FileOutputStream("./src/temp.txt");
										ObjectOutputStream oos=new ObjectOutputStream(fos);
										oos.writeObject(zhanghao);
										oos.flush();
										oos.close();
										fos.close();
									}
									catch(Exception e1) {
										System.out.println(e1.getMessage());
									}
								}
								if(list.get(i).getQuanxian().equals("后勤管家"))judge=3;
								if(list.get(i).getQuanxian().equals("顾客"))judge=4;
								break;
							}
						}
						if(judge==0)JOptionPane.showMessageDialog(null,"账号或密码输入错误");
						else {
							if(judge==1) {
								Usermanage um=new Usermanage();
								um.setVisible(true);
								setVisible(false);
							}
							else if(judge==2) {
								Livemanager lm=new Livemanager();
								lm.setVisible(true);
								setVisible(false);
							}
							else if(judge==3) {
								Busmanager bm=new Busmanager();
								bm.setVisible(true);
								setVisible(false);
							}
							else if(judge==4) {
								JOptionPane.showMessageDialog(null,"您无权登录");
							}
						}
						judge=0;
					}
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(126, 316, 97, 23);
		contentPane.add(btnNewButton);
		
		//返回按钮
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1) {
					setVisible(false);
				}
			}
		});
		btnNewButton_1.setBounds(364, 316, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("8-20位");
		lblNewLabel_2.setBounds(412, 220, 58, 15);
		contentPane.add(lblNewLabel_2);
	}
}
