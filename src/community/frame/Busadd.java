package community.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import community.dao.Busdao;
import community.dao.impl.Busdaoimpl;
import community.po.Bus;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Busadd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busadd frame = new Busadd();
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
	public Busadd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("线路代码");
		lblNewLabel.setBounds(52, 63, 58, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(146, 60, 110, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("线路名称");
		lblNewLabel_1.setBounds(403, 63, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(515, 60, 130, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("线路类型");
		lblNewLabel_2.setBounds(52, 149, 58, 15);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("岛内班车");
		rdbtnNewRadioButton.setBounds(129, 145, 90, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("岛外班车");
		rdbtnNewRadioButton_1.setBounds(221, 145, 127, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_3 = new JLabel("线路方向");
		lblNewLabel_3.setBounds(403, 149, 58, 15);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("上行");
		rdbtnNewRadioButton_2.setBounds(490, 145, 73, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("下行");
		rdbtnNewRadioButton_3.setBounds(583, 145, 73, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		ButtonGroup group1=new ButtonGroup();
		group1.add(rdbtnNewRadioButton_1);
		group1.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_4 = new JLabel("运营日期");
		lblNewLabel_4.setBounds(52, 254, 58, 15);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("星期一");
		comboBox.addItem("星期二");
		comboBox.addItem("星期三");
		comboBox.addItem("星期四");
		comboBox.addItem("星期五");
		comboBox.addItem("星期六");
		comboBox.addItem("星期日");
		comboBox.addItem("每天");
		comboBox.setBounds(146, 254, 110, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("运营时段");
		lblNewLabel_5.setBounds(403, 258, 58, 15);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("上午");
		comboBox_1.addItem("下午");
		comboBox_1.addItem("晚上");
		comboBox_1.setBounds(506, 254, 90, 23);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_6 = new JLabel("发车时间");
		lblNewLabel_6.setBounds(52, 366, 58, 15);
		contentPane.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 363, 96, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("例：13：50等");
		lblNewLabel_7.setBounds(146, 411, 96, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("备注");
		lblNewLabel_8.setBounds(403, 366, 58, 15);
		contentPane.add(lblNewLabel_8);
		
		textField_3 = new JTextField();
		textField_3.setBounds(490, 363, 204, 63);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Busdao busdao=new Busdaoimpl();
				Bus bus=new Bus();
				bus.setDaima(textField.getText());
				bus.setName(textField_1.getText());
				bus.setDate2(textField_2.getText());
				String date=(String)comboBox.getSelectedItem();
				bus.setDate(date);
				String date1=(String)comboBox_1.getSelectedItem();
				bus.setDate1(date1);
				bus.setNum("0");
				if(rdbtnNewRadioButton.isSelected())bus.setType("岛内班车");
				else bus.setType("岛外班车");
				if(rdbtnNewRadioButton_2.isSelected())bus.setDirection("上行");
				else bus.setDirection("下行");
				bus.setEndtime("未确定");
				try {
					busdao.saveBus(bus);
					JOptionPane.showMessageDialog(null,"添加成功");
					Busmanager bm=new Busmanager();
					bm.setVisible(true);
					setVisible(false);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(189, 449, 97, 23);
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
		btnNewButton_1.setBounds(386, 449, 97, 23);
		contentPane.add(btnNewButton_1);
	}
}
