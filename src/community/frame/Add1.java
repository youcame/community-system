package community.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import community.dao.Userdao;
import community.dao.impl.Userdaoimpl;
import community.po.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Add1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add1 frame = new Add1();
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
	public Add1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("账号：");
		lblNewLabel.setBounds(34, 74, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setBounds(34, 130, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("姓名:");
		lblNewLabel_2.setBounds(34, 188, 58, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("性别:");
		lblNewLabel_3.setBounds(34, 242, 58, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("出生日期:");
		lblNewLabel_4.setBounds(34, 306, 58, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("联系电话:");
		lblNewLabel_5.setBounds(34, 368, 58, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("权限:");
		lblNewLabel_6.setBounds(34, 431, 58, 15);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(194, 71, 178, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 127, 178, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 185, 178, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setBounds(194, 238, 91, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setBounds(286, 238, 127, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(194, 306, 178, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(194, 365, 178, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("请选择");
		comboBox.addItem("生活管家");
		comboBox.addItem("后勤管家");
		comboBox.addItem("顾客");
		comboBox.setBounds(194, 427, 110, 23);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String zhanghao=textField.getText();
				String mima=textField_1.getText();
				String name=textField_2.getText();
				String sex;
				if(rdbtnNewRadioButton.isSelected())sex="男";
				else sex="女";
				String Birth=textField_3.getText();
				String tele=textField_4.getText();
				String quanxian=(String)comboBox.getSelectedItem();
				User user=new User();
				user.setBirth(Birth);
				user.setQuanxian(quanxian);
				user.setMima(mima);
				user.setName(name);
				user.setSex(sex);
				user.setTele(tele);
				user.setZhanghao(zhanghao);
				user.setId("无");
				Userdao userdao=new Userdaoimpl();
				if(mima.length()<8||mima.length()>20)JOptionPane.showMessageDialog(null,"密码长度须在8-20之间");
				else{
					try {
						userdao.saveUser(user);
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"注册成功");
					Usermanage um=new Usermanage();
					um.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(99, 534, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usermanage u=new Usermanage();
				u.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(385, 534, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("如：2003-03-03");
		lblNewLabel_7.setBounds(409, 309, 102, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("8-20位");
		lblNewLabel_8.setBounds(409, 130, 127, 15);
		contentPane.add(lblNewLabel_8);
	}
}

