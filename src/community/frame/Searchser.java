package community.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import community.dao.Servicedao;
import community.dao.impl.Servicedaoimpl;
import community.po.Bus;
import community.po.Service;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Searchser extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searchser frame = new Searchser();
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
	public Searchser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("所有服务");
		lblNewLabel.setBounds(35, 26, 58, 15);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 85, 270, 264);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u751F\u6D3B\u7BA1\u5BB6", "\u987E\u5BA2"
			}
		));
		scrollPane.setViewportView(table);
		try {
			Servicedao sv=new Servicedaoimpl();
			List<Service> list=sv.findService();
			for(int i=0;i<list.size();i++) {
				table.setValueAt(list.get(i).getLivemanager().getName(),i,0);
				table.setValueAt(list.get(i).getOldpeople().getName(),i,1);
				table.repaint();
			}
		}
		catch(Exception e){
			System.out.println("异常信息：" + e.getMessage());
		}
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usermanage um=new Usermanage();
				um.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(229, 378, 97, 23);
		contentPane.add(btnNewButton);
	}
}
