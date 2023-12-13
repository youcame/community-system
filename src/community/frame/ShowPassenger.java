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

import community.dao.Passengerdao;
import community.dao.impl.Passengerdaoimpl;
import community.po.Passenger;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ShowPassenger extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowPassenger frame = new ShowPassenger();
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
	public ShowPassenger() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("乘客列表");
		lblNewLabel.setBounds(31, 24, 92, 28);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 92, 344, 378);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u7EBF\u8DEF\u4EE3\u7801", "\u4E58\u5BA2\u59D3\u540D", "\u4E58\u5BA2\u6027\u522B", "\u4E58\u5BA2\u7535\u8BDD"
			}
		));
		scrollPane.setViewportView(table);
		try {
			Passengerdao pd=new Passengerdaoimpl();
			List<Passenger> list=pd.findPassenger();
			for(int i=0;i<list.size();i++) {
				table.setValueAt(list.get(i).getBusDai(), i, 0);
				table.setValueAt(list.get(i).getName(), i, 1);
				table.setValueAt(list.get(i).getSex(), i, 2);
				table.setValueAt(list.get(i).getTele(), i, 3);
			}
		}catch(Exception e2){
			e2.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Busmanager b=new Busmanager();
				b.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(288, 491, 97, 23);
		contentPane.add(btnNewButton);
	}
}
