package community.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import community.dao.Userdao;
import community.dao.impl.Userdaoimpl;
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

public class Usermanage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usermanage frame = new Usermanage();
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
	public Usermanage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1) {
					Add1 a=new Add1();
					a.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(10, 100, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("移除");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Userdao u=new Userdaoimpl();
					List<User> list=u.findUser();
					for(int i=0;i<list.size();i++) {
						if((table.getValueAt(i, 0)==null));
						else if((boolean)table.getValueAt(i, 0)) {
							list.remove(i);
						}
					}
					u.writeUser(list);
					JOptionPane.showMessageDialog(null,"删除成功");
					Usermanage um=new Usermanage();
					um.setVisible(true);
					setVisible(false);
				}catch(Exception e1) {
					System.out.println("错误信息为:"+e1.getMessage());
				}
			}
		});
		btnNewButton_1.setBounds(144, 100, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("查看服务");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Searchser ss=new Searchser();
				ss.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(277, 100, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("设置服务");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Setservice ss=new Setservice();
				ss.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(657, 100, 97, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("添加老人");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add1 a=new Add1();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setBounds(657, 43, 97, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("更改权限");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Userdao us=new Userdaoimpl();
					List<User> list=us.findUser();
					for(int i=0;i<list.size();i++) {
						String a=(String)table.getValueAt(i, 7);
						list.get(i).setQuanxian(a);
					}
					us.writeUser(list);
					JOptionPane.showMessageDialog(null, "修改成功");
				}catch(Exception e3) {
					System.out.println("错误信息为:"+e3.getMessage());
				}
				
			}
		});
		btnNewButton_5.setBounds(29, 485, 97, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("退出");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l=new Login();
				l.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_6.setBounds(646, 485, 97, 23);
		contentPane.add(btnNewButton_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 193, 677, 231);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"", "Id", "\u8D26\u6237", "\u59D3\u540D", "\u6027\u522B", "\u51FA\u751F\u65E5\u671F", "\u7535\u8BDD", "\u6743\u9650"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		try {
			Userdao us=new Userdaoimpl();
			List<User> list=us.findUser();
			for(int i=0;i<list.size();i++) {
				table.setValueAt(i+1,i,1);
				table.setValueAt(list.get(i).getZhanghao(),i,2);
				table.setValueAt(list.get(i).getName(),i,3);
				table.setValueAt(list.get(i).getSex(),i,4);
				table.setValueAt(list.get(i).getBirth(),i,5);
				table.setValueAt(list.get(i).getTele(),i,6);
				table.setValueAt(list.get(i).getQuanxian(),i,7);
				table.repaint();
			}
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			System.out.println(e1.getMessage());
		}
	}
}
