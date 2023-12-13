package community.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import community.dao.Servicedao;
import community.dao.impl.Servicedaoimpl;
import community.po.Service;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Livemanager extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Livemanager frame = new Livemanager();
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
	public Livemanager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("修改个人信息");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JOptionPane.showMessageDialog(null, "现在可以开始编辑");
				ModifyInfo mf=new ModifyInfo();
				mf.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(480, 31, 144, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("保存");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"保存成功");
			}
		});
		btnNewButton_1.setBounds(87, 335, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lm=new Login();
				lm.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(443, 335, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 89, 591, 223);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"", "Id", "\u59D3\u540D", "\u6027\u522B", "\u51FA\u751F\u65E5\u671F", "\u7535\u8BDD"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);
		try {
			int judge=0;
			int j=0;
			FileInputStream fis=new FileInputStream("./src/temp.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			String Zhanghao=(String)ois.readObject();
			Servicedao sd=new Servicedaoimpl();
			List<Service> list=sd.findService();
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getLivemanager().getZhanghao().equals(Zhanghao)) {
					if(judge==0) {
						j++;
						table.setValueAt(j, 0, 1);
						table.setValueAt(list.get(i).getLivemanager().getName(), 0, 2);
						table.setValueAt(list.get(i).getLivemanager().getSex(), 0, 3);
						table.setValueAt(list.get(i).getLivemanager().getBirth(), 0, 4);
						table.setValueAt(list.get(i).getLivemanager().getTele(), 0, 5);
						judge=1;
					}
					j++;
					table.setValueAt(j, j-1, 1);
					table.setValueAt(list.get(i).getOldpeople().getName(), j-1, 2);
					table.setValueAt(list.get(i).getOldpeople().getSex(), j-1, 3);
					table.setValueAt(list.get(i).getOldpeople().getBirth(), j-1, 4);
					table.setValueAt(list.get(i).getOldpeople().getTele(), j-1, 5);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
