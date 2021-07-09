import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

import Connection.ConnectionProvider;
import java.awt.SystemColor;
import java.awt.Window.Type;
public class AddNewRecordScreen extends JFrame {

	private JPanel contentPane;
	private JTextField IDField;
	private JTextField NameField;
	private JTextField AgeField;
	private JTextField MobileField;
	private JTextField DateField;
	private JTextField MajorIllnessField;
	private JTextField EmailIDField;
	private JTextField BloodGroupField;
	private JComboBox GenderBox;
	private JComboBox DiagnosisBox;
	private JTextArea AddressField;

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
					AddNewRecordScreen frame = new AddNewRecordScreen();
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
	public AddNewRecordScreen() {
		setType(Type.UTILITY);
		setTitle("Patient Details");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel IDLabel = new JLabel("ID\r\n");
		IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IDLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		IDLabel.setBounds(107, 44, 95, 43);
		contentPane.add(IDLabel);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		NameLabel.setBounds(107, 116, 95, 43);
		contentPane.add(NameLabel);
		
		JLabel AgeLabel = new JLabel("Age\r\n");
		AgeLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		AgeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AgeLabel.setBounds(107, 183, 95, 43);
		contentPane.add(AgeLabel);
		
		JLabel AddressLabel = new JLabel("Address");
		AddressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AddressLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		AddressLabel.setBounds(107, 261, 95, 43);
		contentPane.add(AddressLabel);
		
		JLabel MobileLabel = new JLabel("Mobile");
		MobileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MobileLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		MobileLabel.setBounds(89, 383, 113, 43);
		contentPane.add(MobileLabel);
		
		JLabel DateLabel = new JLabel("Date\r\n");
		DateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DateLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		DateLabel.setBounds(89, 444, 113, 48);
		contentPane.add(DateLabel);
		
		JLabel MajorIlnessLabel = new JLabel("Major Illness\r\n");
		MajorIlnessLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MajorIlnessLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		MajorIlnessLabel.setBounds(89, 540, 139, 43);
		contentPane.add(MajorIlnessLabel);
		
		JLabel EmailIDLabel = new JLabel("Email ID");
		EmailIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EmailIDLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		EmailIDLabel.setBounds(574, 44, 85, 43);
		contentPane.add(EmailIDLabel);
		
		JLabel GenderLabel = new JLabel("Gender");
		GenderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GenderLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		GenderLabel.setBounds(579, 116, 80, 43);
		contentPane.add(GenderLabel);
		
		JLabel BloodGroupLabel = new JLabel("Blood Group");
		BloodGroupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BloodGroupLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		BloodGroupLabel.setBounds(551, 194, 139, 43);
		contentPane.add(BloodGroupLabel);
		
		JLabel DiagnosisLabel = new JLabel("Diagnosis");
		DiagnosisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DiagnosisLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		DiagnosisLabel.setBounds(579, 261, 105, 43);
		contentPane.add(DiagnosisLabel);
		
		IDField = new JTextField();
		IDField.setBackground(SystemColor.info);
		IDField.setHorizontalAlignment(SwingConstants.CENTER);
		IDField.setFont(new Font("Calibri", Font.BOLD, 18));
		IDField.setBounds(222, 44, 104, 33);
		contentPane.add(IDField);
		IDField.setColumns(10);
		
		NameField = new JTextField();
		NameField.setFont(new Font("Calibri", Font.BOLD, 18));
		NameField.setBackground(SystemColor.info);
		NameField.setHorizontalAlignment(SwingConstants.CENTER);
		NameField.setBounds(222, 118, 250, 33);
		contentPane.add(NameField);
		NameField.setColumns(10);
		
		//Code for auto ID
		  int ID;
		 try{
			 String query="Select count(*) from patient";
	        	Connection con=ConnectionProvider.getCon();
		        Statement st=con.createStatement();
	            
	            ResultSet rs=st.executeQuery(query);
	            rs.next();
	            ID=rs.getInt(1)+1;
	            IDField.setText(Integer.toString(ID));
	            IDField.setEditable(false);
		 }catch(Exception E)
		 {
			 JOptionPane.showMessageDialog(null, E);
		 }
		 
		//Code end
		 System.out.println(NameField.getText());
		//Submit Button
		JButton SubmitButton = new JButton("");
		SubmitButton.addActionListener(new ActionListener() {
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
		        
		        String query="INSERT INTO patient VALUES('"+id+"','"+name+"','"+age+"','"+address+"','"+mobile+"','"+date+"','"+majorillness+"','"+email+"','"+gender+"','"+blood+"','"+diagnosis+"')";
		        
		        try{
		        	Connection con=ConnectionProvider.getCon();
			        Statement st=con.createStatement();
		            st.executeUpdate(query);
		            JOptionPane.showMessageDialog(null,"Successfully Uploaded");
		            setVisible(false);
		            new HomeScreen().setVisible(true);
		        }catch(Exception E)
		        {
		            JOptionPane.showMessageDialog(null,E);
		        }
		        //Code end
			}
		});
		
		SubmitButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\save-icon--1.png"));
		SubmitButton.setBounds(585, 400, 97, 43);
		contentPane.add(SubmitButton);
		
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
		BackButton.setBounds(822, 400, 97, 43);
		contentPane.add(BackButton);
		
		AgeField = new JTextField();
		AgeField.setFont(new Font("Calibri", Font.BOLD, 18));
		AgeField.setBackground(SystemColor.info);
		AgeField.setHorizontalAlignment(SwingConstants.CENTER);
		AgeField.setBounds(222, 185, 104, 33);
		contentPane.add(AgeField);
		AgeField.setColumns(10);
		
		MobileField = new JTextField();
		MobileField.setFont(new Font("Calibri", Font.BOLD, 18));
		MobileField.setBackground(SystemColor.info);
		MobileField.setHorizontalAlignment(SwingConstants.CENTER);
		MobileField.setBounds(222, 385, 250, 33);
		contentPane.add(MobileField);
		
		DateField = new JTextField();
		DateField.setFont(new Font("Calibri", Font.BOLD, 18));
		DateField.setBackground(SystemColor.info);
		DateField.setHorizontalAlignment(SwingConstants.CENTER);
		DateField.setBounds(222, 454, 250, 33);
		contentPane.add(DateField);
		DateField.setColumns(10);
		
		MajorIllnessField = new JTextField();
		MajorIllnessField.setFont(new Font("Calibri", Font.BOLD, 18));
		MajorIllnessField.setBackground(SystemColor.info);
		MajorIllnessField.setHorizontalAlignment(SwingConstants.CENTER);
		MajorIllnessField.setBounds(222, 542, 250, 33);
		contentPane.add(MajorIllnessField);
		MajorIllnessField.setColumns(10);
		
		EmailIDField = new JTextField();
		EmailIDField.setFont(new Font("Calibri", Font.BOLD, 18));
		EmailIDField.setBackground(SystemColor.info);
		EmailIDField.setHorizontalAlignment(SwingConstants.CENTER);
		EmailIDField.setBounds(715, 46, 240, 33);
		contentPane.add(EmailIDField);
		EmailIDField.setColumns(10);
		
		GenderBox = new JComboBox();
		GenderBox.setBackground(SystemColor.info);
		GenderBox.setFont(new Font("Javanese Text", Font.BOLD, 14));
		GenderBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Others"}));
		GenderBox.setBounds(715, 121, 130, 33);
		contentPane.add(GenderBox);
		
		BloodGroupField = new JTextField();
		BloodGroupField.setFont(new Font("Calibri", Font.BOLD, 18));
		BloodGroupField.setBackground(SystemColor.info);
		BloodGroupField.setHorizontalAlignment(SwingConstants.CENTER);
		BloodGroupField.setBounds(715, 193, 138, 33);
		contentPane.add(BloodGroupField);
		BloodGroupField.setColumns(10);
		
		DiagnosisBox = new JComboBox();
		DiagnosisBox.setBackground(SystemColor.info);
		DiagnosisBox.setFont(new Font("Javanese Text", Font.BOLD, 14));
		DiagnosisBox.setModel(new DefaultComboBoxModel(new String[] {"Outdoor", "Radiology", "ENT", "Physiology", "Orthopedic", "Cardiology"}));
		DiagnosisBox.setBounds(715, 266, 119, 33);
		contentPane.add(DiagnosisBox);
		
		JLabel lblNewLabel = new JLabel("DD/MM/YYYY");
		lblNewLabel.setBounds(117, 482, 85, 22);
		contentPane.add(lblNewLabel);
		
		AddressField = new JTextArea();
		AddressField.setFont(new Font("Calibri", Font.BOLD, 12));
		AddressField.setBackground(SystemColor.info);
		AddressField.setBounds(222, 261, 250, 81);
		contentPane.add(AddressField);
		
		JLabel BackgroundLabel = new JLabel("New label");
		BackgroundLabel.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\HomeScreen.png"));
		BackgroundLabel.setBounds(0, 0, 994, 665);
		contentPane.add(BackgroundLabel);
	}
}
