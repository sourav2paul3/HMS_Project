import java.awt.BorderLayout;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.sql.*;
import net.proteanit.sql.*;
import Connection.ConnectionProvider;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class ViewRecordScreen extends JFrame {

	private JPanel contentPane;
	private JTable Table;
	private JScrollPane scrollPane;
	private JLabel IDLabel;
	private JTextField IDTextField;
	private JTextField DateField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		                if ("Nimbus".equals(info.getName())) {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
		            }
					ViewRecordScreen frame = new ViewRecordScreen();
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
	public ViewRecordScreen() {
		setType(Type.UTILITY);
		setTitle("View Record\r\n");
		
		JButton button = new JButton("New button");
		getContentPane().add(button, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Close Button
		JButton CloseButton = new JButton("Close\r\n");
		CloseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code start
				setVisible(false);
				new HomeScreen().setVisible(true);
				//Code end
			}
		});
		
		JLabel DiagnosisLabel = new JLabel("Diagnosis");
		DiagnosisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DiagnosisLabel.setFont(new Font("Javanese Text", Font.BOLD, 14));
		DiagnosisLabel.setBounds(584, 21, 116, 29);
		contentPane.add(DiagnosisLabel);
		CloseButton.setFont(new Font("Javanese Text", Font.BOLD, 18));
		CloseButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\Close.png"));
		CloseButton.setBounds(791, 544, 122, 44);
		contentPane.add(CloseButton);
		
		JLabel WarningLabel = new JLabel("No Record Found!");
		WarningLabel.setForeground(Color.RED);
		WarningLabel.setBackground(Color.WHITE);
		WarningLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		WarningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WarningLabel.setBounds(341, 162, 286, 29);
		
		//Code start
		WarningLabel.setVisible(false);
		//Code end
		
		contentPane.add(WarningLabel);
		
		JComboBox DiagnosisBox = new JComboBox();
		DiagnosisBox.setBackground(SystemColor.info);
		DiagnosisBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Outdoor", "Radiology", "ENT", "Physiology", "Orthopedic", "Cardiology"}));
		DiagnosisBox.setFont(new Font("Javanese Text", Font.BOLD, 14));
		DiagnosisBox.setBounds(727, 21, 116, 29);
		contentPane.add(DiagnosisBox);
		
		//View All Record Button
		JButton ViewAllRecord = new JButton("View All\r\n");
		ViewAllRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code start
				try {
					IDTextField.setText("");
					DateField.setText("");
					DiagnosisBox.setSelectedItem("Select");
					Table.setVisible(true);
					String query="select * from patient order by cast(ID as unsigned Integer);";
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					
					//Table.setAutoResizeMode(Table.AUTO_RESIZE_OFF);
					if(!rs.isBeforeFirst())
						WarningLabel.setVisible(true);
					else
						{
						Table.setModel(DbUtils.resultSetToTableModel(rs));
						WarningLabel.setVisible(false);
						}
				}catch(Exception E){
					JOptionPane.showMessageDialog(null,E);
				}
				//Code end
			}
		});
		
		ViewAllRecord.setFont(new Font("Javanese Text", Font.BOLD, 18));
		ViewAllRecord.setBounds(135, 544, 122, 44);
		contentPane.add(ViewAllRecord);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 204, 958, 313);
		contentPane.add(scrollPane);
		
		Table = new JTable();
		Table.setEnabled(false);
		Table.setForeground(Color.BLACK);
		Table.setBackground(SystemColor.info);
		Table.setFont(new Font("Dialog", Font.PLAIN, 13));
		scrollPane.setViewportView(Table);
		Table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		Table.setRowSelectionAllowed(false);
		
		IDLabel = new JLabel("Patient ID\r\n");
		IDLabel.setFont(new Font("Javanese Text", Font.BOLD, 14));
		IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IDLabel.setBounds(108, 13, 79, 44);
		contentPane.add(IDLabel);
		
		
		IDTextField = new JTextField();
		IDTextField.setBackground(SystemColor.info);
		IDTextField.setHorizontalAlignment(SwingConstants.CENTER);
		IDTextField.setFont(new Font("Dialog", Font.BOLD, 14));
		IDTextField.setBounds(276, 17, 218, 30);
		contentPane.add(IDTextField);
		IDTextField.setColumns(10);
		
		DateField = new JTextField();
		DateField.setFont(new Font("Dialog", Font.BOLD, 14));
		DateField.setBackground(SystemColor.info);
		DateField.setHorizontalAlignment(SwingConstants.CENTER);
		DateField.setBounds(276, 96, 218, 30);
		contentPane.add(DateField);
		DateField.setColumns(10);
		
		
		//Search Button
		JButton SearchButton = new JButton("Search");
		SearchButton.setBackground(SystemColor.controlHighlight);
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Code start
				String query="";
				String id=IDTextField.getText();
				String date=DateField.getText();
				String diagnosis=(String)DiagnosisBox.getSelectedItem();
				if(id.length()!=0)
					query="Select * from patient where ID='"+id+"'";
				else
					{
						if((!diagnosis.equals("Select")) && (date.length()!=0))
							query="Select * from patient where Diagnosis='"+diagnosis+"' and Date='"+date+"' ";
						else
						{	
							if(!(diagnosis.equals("Select")))
								query="Select * from patient where Diagnosis='"+diagnosis+"' ";
					
							if(date.length()!=0)
								query="Select * from patient where Date='"+date+"'";
						}
					}
				try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					
					if(!rs.isBeforeFirst())
						{
						WarningLabel.setVisible(true);
						Table.setVisible(false);
						}
					else {
						Table.setVisible(true);
						Table.setModel(DbUtils.resultSetToTableModel(rs));
						WarningLabel.setVisible(false);
						}
				}catch(Exception E){
					JOptionPane.showMessageDialog(null,"Connection Error");
				}
				//Code end
			}
		});
		SearchButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\search.png"));
		SearchButton.setFont(new Font("Javanese Text", Font.BOLD, 14));
		SearchButton.setBounds(599, 98, 116, 32);
		contentPane.add(SearchButton);
		
		JLabel DateLabel = new JLabel("Date");
		DateLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		DateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DateLabel.setBounds(108, 102, 79, 24);
		contentPane.add(DateLabel);
		
		
		JLabel OrLabel = new JLabel("Or\r\n");
		OrLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		OrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		OrLabel.setBounds(356, 60, 68, 29);
		contentPane.add(OrLabel);
		
		JLabel DateFormatLabel = new JLabel("DD/MM/YYYY");
		DateFormatLabel.setFont(new Font("Javanese Text", Font.BOLD, 14));
		DateFormatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DateFormatLabel.setBounds(102, 129, 107, 30);
		contentPane.add(DateFormatLabel);
		
		JLabel BackgroundLabel = new JLabel("New label");
		BackgroundLabel.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\HomeScreen.png"));
		BackgroundLabel.setBounds(0, 0, 982, 653);
		contentPane.add(BackgroundLabel);
		
	}
}
