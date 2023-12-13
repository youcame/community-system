package community.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import community.dao.Passengerdao;
import community.dao.impl.Passengerdaoimpl;
import community.po.Bus;
import community.po.Passenger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

public class AddoldPeople extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddoldPeople frame = new AddoldPeople();
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
	public AddoldPeople() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("男");
		comboBox.addItem("女");
		comboBox.setBounds(183, 194, 55, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("乘客姓名：");
		lblNewLabel.setBounds(38, 42, 115, 81);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String a=textField.getText();
				String b=textField_1.getText();
				String c=(String)comboBox.getSelectedItem();
				String d=(String)textField_2.getText();
				Passenger p=new Passenger();
				p.setName(a);
				p.setTele(b);
				p.setSex(c);
				p.setBusDai(d);
				try {
					Passengerdao ps=new Passengerdaoimpl();
					List<Passenger> list =ps.findPassenger();
					list.add(p);
					ps.writePassenger(list);
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"登记成功");
				Busmanager bm=new Busmanager();
				bm.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(82, 295, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Busmanager bm=new Busmanager();
				bm.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(273, 295, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("乘客电话：");
		lblNewLabel_1.setBounds(38, 107, 97, 57);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(183, 72, 133, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 125, 133, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("乘客性别：");
		lblNewLabel_2.setBounds(38, 198, 67, 15);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 10, 133, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("班车代码");
		lblNewLabel_3.setBounds(38, 17, 58, 15);
		contentPane.add(lblNewLabel_3);
		
	}
}
