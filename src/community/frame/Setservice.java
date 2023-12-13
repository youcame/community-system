package community.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import community.dao.Servicedao;
import community.dao.Userdao;
import community.dao.impl.Servicedaoimpl;
import community.dao.impl.Userdaoimpl;
import community.po.Service;
import community.po.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Setservice extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Setservice frame = new Setservice();
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
	public Setservice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("生活管家");
		lblNewLabel.setBounds(33, 121, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("顾客");
		lblNewLabel_1.setBounds(333, 121, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usermanage um=new Usermanage();
				um.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(399, 295, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		FileInputStream fis;
		try {
			fis = new FileInputStream("./src/userrecord.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			List<User> list=new ArrayList<User>();
			list=(List<User>)ois.readObject();
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getQuanxian().equals("生活管家"))comboBox.addItem(list.get(i).getName());
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		comboBox.setBounds(136, 117, 104, 23);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		try {
			Userdao ud=new Userdaoimpl();
			List<User> list=ud.findUser();
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getQuanxian().equals("顾客"))comboBox_1.addItem(list.get(i).getName());
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		comboBox_1.setBounds(443, 117, 104, 23);
		contentPane.add(comboBox_1);
		//设置服务
		JButton btnNewButton = new JButton("完成");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Userdao ud=new Userdaoimpl();
					List<User> list=ud.findUser();
					String livemanager=(String) comboBox.getSelectedItem();
					String oldpeople=(String) comboBox_1.getSelectedItem();
					Service service=new Service();
					Servicedao ser=new Servicedaoimpl();
					for(int i=0;i<list.size();i++) {
						if(list.get(i).getName().equals(livemanager))service.setLivemanager(list.get(i));
						if(list.get(i).getName().equals(oldpeople))service.setOldpeople(list.get(i));
					}
					ser.saveService(service);
					JOptionPane.showMessageDialog(null,"设置成功");
					Usermanage sm=new Usermanage();
					sm.setVisible(true);
					setVisible(false);
				}catch(Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		});
		btnNewButton.setBounds(83, 295, 97, 23);
		contentPane.add(btnNewButton);
	}
}
