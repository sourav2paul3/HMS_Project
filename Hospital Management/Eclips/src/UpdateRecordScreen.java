import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connection.ConnectionProvider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.*;
import Connection.ConnectionProvider;
import java.awt.Window.Type;
import javax.swing.DropMode;

public class UpdateRecordScreen extends JFrame {

	private JPanel contentPane;
	private JTextField IDField;
	private JTextField NameField;
	private JTextField AgeField;
	private JTextField MobileField;
	private JTextField DateField;
	private JTextField MajorIllnessField;
	private JTextField EmailIDField;
	private JTextField BloodGroupField;

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
					UpdateRecordScreen frame = new UpdateRecordScreen();
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
	public UpdateRecordScreen() {
		setType(Type.UTILITY);
		setTitle("Update Record\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel WarningLabel = new JLabel("No Record Found!");
		WarningLabel.setForeground(Color.RED);
		WarningLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		WarningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WarningLabel.setBounds(321, 254, 327, 56);
		contentPane.add(WarningLabel);
		WarningLabel.setVisible(false);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 994, 665);
		contentPane.add(contentPane_1);
		
		JLabel IDLabel = new JLabel("ID\r\n");
		IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IDLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		IDLabel.setBounds(107, 44, 95, 43);
		contentPane_1.add(IDLabel);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		NameLabel.setBounds(107, 116, 95, 43);
		contentPane_1.add(NameLabel);
		
		JLabel AgeLabel = new JLabel("Age\r\n");
		AgeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AgeLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		AgeLabel.setBounds(107, 183, 95, 43);
		contentPane_1.add(AgeLabel);
		
		JLabel AddressLabel = new JLabel("Address");
		AddressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AddressLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		AddressLabel.setBounds(107, 261, 95, 43);
		contentPane_1.add(AddressLabel);
		
		JLabel MobileLabel = new JLabel("Mobile");
		MobileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MobileLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		MobileLabel.setBounds(89, 383, 113, 43);
		contentPane_1.add(MobileLabel);
		
		JLabel DateLabel = new JLabel("Date\r\n");
		DateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DateLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		DateLabel.setBounds(89, 444, 113, 48);
		contentPane_1.add(DateLabel);
		
		JLabel DateFormatLabel = new JLabel("DD/MM/YYYY");
		DateFormatLabel.setBounds(117, 482, 85, 22);
		contentPane_1.add(DateFormatLabel);
		
		JLabel MajorIlnessLabel = new JLabel("Major Illness\r\n");
		MajorIlnessLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MajorIlnessLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		MajorIlnessLabel.setBounds(89, 540, 139, 43);
		contentPane_1.add(MajorIlnessLabel);
		
		JLabel EmailIDLabel = new JLabel("Email ID");
		EmailIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EmailIDLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		EmailIDLabel.setBounds(585, 44, 85, 43);
		contentPane_1.add(EmailIDLabel);
		
		JLabel GenderLabel = new JLabel("Gender");
		GenderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GenderLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		GenderLabel.setBounds(585, 116, 85, 43);
		contentPane_1.add(GenderLabel);
		
		JLabel BloodGroupLabel = new JLabel("Blood Group");
		BloodGroupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BloodGroupLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		BloodGroupLabel.setBounds(551, 194, 139, 43);
		contentPane_1.add(BloodGroupLabel);
		
		JLabel DiagnosisLabel = new JLabel("Diagnosis");
		DiagnosisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DiagnosisLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		DiagnosisLabel.setBounds(585, 277, 105, 43);
		contentPane_1.add(DiagnosisLabel);
		
		IDField = new JTextField();
		IDField.setFont(new Font("Calibri", Font.BOLD, 18));
		IDField.setHorizontalAlignment(SwingConstants.CENTER);
		IDField.setColumns(10);
		IDField.setBackground(SystemColor.info);
		IDField.setBounds(222, 44, 104, 33);
		contentPane_1.add(IDField);
		
		NameField = new JTextField();
		NameField.setFont(new Font("Calibri", Font.BOLD, 16));
		NameField.setHorizontalAlignment(SwingConstants.CENTER);
		NameField.setColumns(10);
		NameField.setBackground(SystemColor.info);
		NameField.setBounds(222, 118, 250, 33);
		contentPane_1.add(NameField);
		
		AgeField = new JTextField();
		AgeField.setFont(new Font("Calibri", Font.BOLD, 16));
		AgeField.setHorizontalAlignment(SwingConstants.CENTER);
		AgeField.setColumns(10);
		AgeField.setBackground(SystemColor.info);
		AgeField.setBounds(222, 185, 104, 33);
		contentPane_1.add(AgeField);
		
		MobileField = new JTextField();
		MobileField.setFont(new Font("Calibri", Font.BOLD, 16));
		MobileField.setHorizontalAlignment(SwingConstants.CENTER);
		MobileField.setBackground(SystemColor.info);
		MobileField.setBounds(222, 385, 250, 33);
		contentPane_1.add(MobileField);
		
		DateField = new JTextField();
		DateField.setFont(new Font("Calibri", Font.BOLD, 16));
		DateField.setHorizontalAlignment(SwingConstants.CENTER);
		DateField.setColumns(10);
		DateField.setBackground(SystemColor.info);
		DateField.setBounds(222, 454, 250, 33);
		contentPane_1.add(DateField);
		
		MajorIllnessField = new JTextField();
		MajorIllnessField.setFont(new Font("Calibri", Font.BOLD, 16));
		MajorIllnessField.setHorizontalAlignment(SwingConstants.CENTER);
		MajorIllnessField.setColumns(10);
		MajorIllnessField.setBackground(SystemColor.info);
		MajorIllnessField.setBounds(222, 542, 250, 33);
		contentPane_1.add(MajorIllnessField);
		
		EmailIDField = new JTextField();
		EmailIDField.setFont(new Font("Calibri", Font.BOLD, 16));
		EmailIDField.setHorizontalAlignment(SwingConstants.CENTER);
		EmailIDField.setColumns(10);
		EmailIDField.setBackground(SystemColor.info);
		EmailIDField.setBounds(698, 44, 240, 33);
		contentPane_1.add(EmailIDField);
		
		JComboBox GenderBox = new JComboBox();
		GenderBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Others"}));
		GenderBox.setFont(new Font("Javanese Text", Font.BOLD, 14));
		GenderBox.setBounds(698, 121, 130, 33);
		contentPane_1.add(GenderBox);
		
		BloodGroupField = new JTextField();
		BloodGroupField.setFont(new Font("Calibri", Font.BOLD, 16));
		BloodGroupField.setHorizontalAlignment(SwingConstants.CENTER);
		BloodGroupField.setColumns(10);
		BloodGroupField.setBackground(SystemColor.info);
		BloodGroupField.setBounds(702, 186, 138, 33);
		contentPane_1.add(BloodGroupField);
		
		JComboBox DiagnosisBox = new JComboBox();
		DiagnosisBox.setModel(new DefaultComboBoxModel(new String[] {"Outdoor", "Radiology", "ENT", "Physiology", "Orthopedic", "Cardiology"}));
		DiagnosisBox.setFont(new Font("Javanese Text", Font.BOLD, 14));
		DiagnosisBox.setBounds(702, 266, 119, 33);
		contentPane_1.add(DiagnosisBox);
		
		JTextArea AddressField = new JTextArea();
		AddressField.setFont(new Font("Calibri", Font.BOLD, 12));
		AddressField.setBackground(SystemColor.info);
		AddressField.setBounds(222, 261, 250, 81);
		contentPane_1.add(AddressField);
		
		//Set Initial Visibility
		//Code start
		NameField.setVisible(false);
		AgeField.setVisible(false);
		MobileField.setVisible(false);
		DateField.setVisible(false);
		MajorIllnessField.setVisible(false);
		EmailIDField.setVisible(false);
		GenderBox.setVisible(false);
		BloodGroupField.setVisible(false);
		DiagnosisBox.setVisible(false);
		AddressField.setVisible(false);
		
		NameLabel.setVisible(false);
		AgeLabel.setVisible(false);
		AddressLabel.setVisible(false);
		MobileLabel.setVisible(false);
		DateLabel.setVisible(false);
		DateFormatLabel.setVisible(false);
		MajorIlnessLabel.setVisible(false);
		EmailIDLabel.setVisible(false);
		GenderLabel.setVisible(false);
		BloodGroupLabel.setVisible(false);
		DiagnosisLabel.setVisible(false);
		//Code end
		
		//Update Button
		JButton UpdateButton = new JButton("");
		UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code start
				String id=IDField.getText();
		        String name=NameField.getText();
		        String age=AgeField.getText();
		        String address=AddressField.getText();
		        String mobile=MobileField.getText();
		        String date=DateField.getText();
		        String majorillness=MajorIllnessField.getText();
		        String email=EmailIDField.getText();
		        String gender=(String)GenderBox.getSelectedItem();
		        String blood=BloodGroupField.getText();
		        String diagnosis=(String)DiagnosisBox.getSelectedItem();
				
				String query="Update patient set Name='"+name+"', Age='"+age+"', Address='"+address+"', Mobile='"+mobile+"', Date='"+date+"', `Major Illness`='"+majorillness+"',`Email ID`='"+email+"', Gender='"+gender+"', `Blood Group`='"+blood+"', Diagnosis='"+diagnosis+"' where ID='"+id+"' ";
				try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					st.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Successfully Updated");
				}catch(Exception E)
				{
					JOptionPane.showMessageDialog(null,E);
				}
				//Code end
			}
		});
		UpdateButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\rsz_update_details.png"));
		UpdateButton.setBounds(585, 400, 97, 59);
		contentPane_1.add(UpdateButton);
				
		//Code start
		UpdateButton.setVisible(false);
		//Code end
		
		//Reset Button
				JButton ResetButton = new JButton("Reset\r\n");
				ResetButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//Code start
						NameField.setVisible(false);
						AgeField.setVisible(false);
						MobileField.setVisible(false);
						DateField.setVisible(false);
						MajorIllnessField.setVisible(false);
						EmailIDField.setVisible(false);
						GenderBox.setVisible(false);
						BloodGroupField.setVisible(false);
						DiagnosisBox.setVisible(false);
						AddressField.setVisible(false);
						
						NameLabel.setVisible(false);
						AgeLabel.setVisible(false);
						AddressLabel.setVisible(false);
						MobileLabel.setVisible(false);
						DateLabel.setVisible(false);
						DateFormatLabel.setVisible(false);
						MajorIlnessLabel.setVisible(false);
						EmailIDLabel.setVisible(false);
						GenderLabel.setVisible(false);
						BloodGroupLabel.setVisible(false);
						DiagnosisLabel.setVisible(false);
						WarningLabel.setVisible(false);
						
						IDField.setEditable(true);
						IDField.setText("");
						UpdateButton.setVisible(false);
						ResetButton.setVisible(false);
						//Code end
					}
				});
				ResetButton.setFont(new Font("Javanese Text", Font.BOLD, 14));
				ResetButton.setBounds(698, 519, 113, 43);
				contentPane_1.add(ResetButton);
				
				//Code start
				ResetButton.setVisible(false);
				//Code end
				
		//Back Button
		JButton BackButton = new JButton("");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Code start
				setVisible(false);
				new HomeScreen().setVisible(true);
				//Code end
			}
		});
		BackButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\back.png"));
		BackButton.setBounds(822, 400, 97, 59);
		contentPane_1.add(BackButton);
		
		//Search Button
		JButton SearchButton = new JButton("Search\r\n");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code start
				String id=IDField.getText();
				String query="Select * from patient where ID='"+id+"'";
				try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
				
					if(!rs.isBeforeFirst())
					{
						WarningLabel.setVisible(true);
						ResetButton.setVisible(false);
						UpdateButton.setVisible(false);
					}
					else
						{
						NameField.setVisible(true);
						AgeField.setVisible(true);
						MobileField.setVisible(true);
						DateField.setVisible(true);
						MajorIllnessField.setVisible(true);
						EmailIDField.setVisible(true);
						GenderBox.setVisible(true);
						BloodGroupField.setVisible(true);
						DiagnosisBox.setVisible(true);
						AddressField.setVisible(true);
						
						NameLabel.setVisible(true);
						AgeLabel.setVisible(true);
						AddressLabel.setVisible(true);
						MobileLabel.setVisible(true);
						DateLabel.setVisible(true);
						DateFormatLabel.setVisible(true);
						MajorIlnessLabel.setVisible(true);
						EmailIDLabel.setVisible(true);
						GenderLabel.setVisible(true);
						BloodGroupLabel.setVisible(true);
						DiagnosisLabel.setVisible(true);
						WarningLabel.setVisible(false);
						
						ResetButton.setVisible(true);
						UpdateButton.setVisible(true);
						
						IDField.setEditable(false);
						
						if(rs.next())
							{
							NameField.setText(rs.getString(2));
							AgeField.setText(rs.getString(3));
							AddressField.setText(rs.getString(4));
							MobileField.setText(rs.getString(5));
							DateField.setText(rs.getString(6));
							MajorIllnessField.setText(rs.getString(7));
							EmailIDField.setText(rs.getString(8));
							GenderBox.setSelectedItem(rs.getString(9));
							BloodGroupField.setText(rs.getString(10));
							DiagnosisBox.setSelectedItem(rs.getString(11));
							}
						}
					}catch(Exception E)
						{
						JOptionPane.showMessageDialog(null, E);
						}
				//Code end
			}
		});
		SearchButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\search.png"));
		SearchButton.setFont(new Font("Javanese Text", Font.BOLD, 14));
		SearchButton.setBounds(410, 44, 113, 31);
		contentPane_1.add(SearchButton);
		
		JLabel BackgroundLabel = new JLabel("New label");
		BackgroundLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		BackgroundLabel.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\HomeScreen.png"));
		BackgroundLabel.setBounds(0, 0, 982, 652);
		contentPane_1.add(BackgroundLabel);
		
	}
}
