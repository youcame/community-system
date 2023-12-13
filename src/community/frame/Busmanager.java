package community.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import community.dao.Busdao;
import community.dao.impl.Busdaoimpl;
import community.po.Bus;
import community.po.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class Busmanager extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busmanager frame = new Busmanager();
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
	public Busmanager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("删除");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//删除班车
				
				try {
					Busdao bs=new Busdaoimpl();
					List<Bus> list=bs.findbus();
					for(int i=0;i<list.size();i++) {
						if((table.getValueAt(i, 0)==null));
						else if((boolean)table.getValueAt(i, 0)) {
							list.remove(i);
						}
					}
					bs.writeBus(list);
					JOptionPane.showMessageDialog(null,"删除成功");
					Busmanager um=new Busmanager();
					um.setVisible(true);
					setVisible(false);
				}catch(Exception e1) {
					System.out.println("错误信息为:"+e1.getMessage());
				}
				
			}
		});
		btnNewButton.setBounds(33, 80, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("确认截止时间");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					Busdao bs=new Busdaoimpl();
					List<Bus> list=bs.findbus();
					for(int i=0;i<list.size();i++) {
						String a=(String)table.getValueAt(i, 8);
						list.get(i).setEndtime(a);
					}
					bs.writeBus(list);
					JOptionPane.showMessageDialog(null, "设置成功！");
				}catch(Exception e1) {
					System.out.println("异常为:"+e1.getMessage());
				}
			}
		});
		btnNewButton_1.setBounds(160, 80, 113, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("登记");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Busdao bs=new Busdaoimpl();
					List<Bus> list=bs.findbus();
					for(int i=0;i<list.size();i++) {
						if(table.getValueAt(i,0)==null) ;
						else {
								int a = Integer.parseInt(list.get(i).getNum());
								a++;
								String s = String.valueOf(a);
								list.get(i).setNum(s);
						}
					}
					bs.writeBus(list);
				}
				catch(Exception e1) {
					System.out.println("错误信息为:"+e1.getMessage());
				}
				AddoldPeople a=new AddoldPeople();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(283, 80, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("查看乘客");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowPassenger sp=new ShowPassenger();
				sp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(647, 80, 97, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("新建");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Busadd ba=new Busadd();
				ba.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setBounds(647, 32, 97, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("保存");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"保存成功");
			}
		});
		btnNewButton_5.setBounds(95, 460, 97, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("返回");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l=new Login();
				l.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_6.setBounds(595, 460, 97, 23);
		contentPane.add(btnNewButton_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 158, 734, 269);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"", "ID", "\u7EBF\u8DEF\u4EE3\u7801", "\u8DEF\u7EBF\u540D\u79F0", "\u65B9\u5411", "\u8FD0\u8425\u65E5\u671F", "\u8FD0\u8425\u65F6\u6BB5", "\u53D1\u8F66\u65F6\u95F4", "\u622A\u6B62\u65F6\u95F4", "\u9884\u7EA6\u4EBA\u6570"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("如：13：00");
		lblNewLabel.setBounds(583, 121, 70, 15);
		contentPane.add(lblNewLabel);
		try {
			Busdao bs=new Busdaoimpl();
			List<Bus> list=bs.findbus();
			for(int i=0;i<list.size();i++) {
				table.setValueAt(i+1,i,1);
				table.setValueAt(list.get(i).getDaima(),i,2);
				table.setValueAt(list.get(i).getName(),i,3);
				table.setValueAt(list.get(i).getDirection(),i,4);
				table.setValueAt(list.get(i).getDate(),i,5);
				table.setValueAt(list.get(i).getDate1(),i,6);
				table.setValueAt(list.get(i).getDate2(),i,7);
				table.setValueAt(list.get(i).getEndtime(),i,8);
				table.setValueAt(list.get(i).getNum(),i,9);
				table.repaint();
			}
		}
		catch(Exception e){
			System.out.println("异常信息：" + e.getMessage());
		}
	}
}