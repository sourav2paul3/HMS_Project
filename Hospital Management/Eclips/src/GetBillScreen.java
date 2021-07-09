import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connection.ConnectionProvider;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Color;

public class GetBillScreen extends JFrame {

	private JPanel contentPane;
	private JTextField IDTextField;
	private JLabel NameLabel;
	private JLabel AgeLabel;
	private JLabel AddressLabel;
	private JLabel DateLabel;
	private JLabel MobileLabel;
	private JLabel MajorIlnessLabel;
	private JTextField MajorIllnessTextField;
	private JTextField DateTextField;
	private JTextField MobileTextField;
	private JTextArea AddressField;
	private JTextField AgeTextField;
	private JTextField NameTextField;
	private JLabel DiagnosisLabel;
	private JLabel BloodGroupLabel;
	private JTextField BloodGroupTextField;
	private JLabel GenderLabel;
	private JLabel EmailIDLabel;
	private JTextField EmailTextField;
	private JTextField GenderTextField;
	private JTextField DiagnosisTextField;
	private JTextField BillTextField;
	private JLabel BillLabel;
	private JButton PrintButton;
	private JButton CloseButton;
	private JLabel WarningLabel;
	private JButton ResetButton;
	private JLabel BackgroundLabel;

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
					GetBillScreen frame = new GetBillScreen();
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
	public GetBillScreen() {
		setTitle("Bill");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		WarningLabel = new JLabel("No Record Found!!");
		WarningLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		WarningLabel.setForeground(Color.RED);
		WarningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WarningLabel.setBounds(344, 263, 329, 43);
		contentPane.add(WarningLabel);
		
		IDTextField = new JTextField();
		IDTextField.setBackground(SystemColor.info);
		IDTextField.setFont(new Font("Calibri", Font.BOLD, 18));
		IDTextField.setBounds(183, 23, 116, 33);
		contentPane.add(IDTextField);
		IDTextField.setColumns(10);
		
		JLabel IDLabel = new JLabel("ID\r\n");
		IDLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IDLabel.setBounds(85, 26, 56, 33);
		contentPane.add(IDLabel);
		
		//Search Button
		JButton SearchButton = new JButton("Search\r\n");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code Start
				String id=IDTextField.getText();
				String query="select * from patient,diagnosis_fees where patient.ID='"+id+"' and diagnosis_fees.Diagnosis=(select Diagnosis from patient where ID='"+id+"')";
				try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					if(!rs.isBeforeFirst())
						WarningLabel.setVisible(true);
					else
					{
						IDTextField.setEditable(false);
						
						NameLabel.setVisible(true);
						AgeLabel.setVisible(true);
						AddressLabel.setVisible(true);
						DateLabel.setVisible(true);
						MobileLabel.setVisible(true);
						MajorIlnessLabel.setVisible(true);
						BloodGroupLabel.setVisible(true);
						GenderLabel.setVisible(true);
						EmailIDLabel.setVisible(true);
						DiagnosisLabel.setVisible(true);
						BillLabel.setVisible(true);
						
						NameTextField.setVisible(true);
						AgeTextField.setVisible(true);
						AddressField.setVisible(true);
						DateTextField.setVisible(true);
						MobileTextField.setVisible(true);
						MajorIllnessTextField.setVisible(true);
						BloodGroupTextField.setVisible(true);
						GenderTextField.setVisible(true);
						EmailTextField.setVisible(true);
						DiagnosisTextField.setVisible(true);
						BillTextField.setVisible(true);
						
						PrintButton.setVisible(true);
						WarningLabel.setVisible(false);
						ResetButton.setVisible(true);
						
						if(rs.next())
						{
						NameTextField.setText(rs.getString(2));
						AgeTextField.setText(rs.getString(3));
						AddressField.setText(rs.getString(4));
						MobileTextField.setText(rs.getString(5));
						DateTextField.setText(rs.getString(6));
						MajorIllnessTextField.setText(rs.getString(7));
						EmailTextField.setText(rs.getString(8));
						GenderTextField.setText(rs.getString(9));
						BloodGroupTextField.setText(rs.getString(10));
						DiagnosisTextField.setText(rs.getString(11));
						
						BillTextField.setText(rs.getString(13));
						}
					}
				}catch(Exception E)
				{
					JOptionPane.showMessageDialog(null, E);
				}
				//Code End
			}
		});
		SearchButton.setFont(new Font("Javanese Text", Font.BOLD, 18));
		SearchButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\search.png"));
		SearchButton.setBounds(357, 23, 137, 29);
		contentPane.add(SearchButton);
		
		NameLabel = new JLabel("Name");
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		NameLabel.setBounds(46, 85, 95, 43);
		contentPane.add(NameLabel);
		
		AgeLabel = new JLabel("Age\r\n");
		AgeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AgeLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		AgeLabel.setBounds(46, 141, 95, 43);
		contentPane.add(AgeLabel);
		
		AddressLabel = new JLabel("Address");
		AddressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AddressLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		AddressLabel.setBounds(553, 85, 95, 43);
		contentPane.add(AddressLabel);
		
		DateLabel = new JLabel("Date\r\n");
		DateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DateLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		DateLabel.setBounds(553, 13, 113, 48);
		contentPane.add(DateLabel);
		
		MobileLabel = new JLabel("Mobile");
		MobileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MobileLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		MobileLabel.setBounds(553, 218, 113, 43);
		contentPane.add(MobileLabel);
		
		MajorIlnessLabel = new JLabel("Major Illness\r\n");
		MajorIlnessLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MajorIlnessLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		MajorIlnessLabel.setBounds(509, 281, 139, 43);
		contentPane.add(MajorIlnessLabel);
		
		MajorIllnessTextField = new JTextField();
		MajorIllnessTextField.setHorizontalAlignment(SwingConstants.CENTER);
		MajorIllnessTextField.setFont(new Font("Calibri", Font.BOLD, 18));
		MajorIllnessTextField.setColumns(10);
		MajorIllnessTextField.setBackground(SystemColor.info);
		MajorIllnessTextField.setBounds(687, 278, 250, 43);
		contentPane.add(MajorIllnessTextField);
		
		DateTextField = new JTextField();
		DateTextField.setHorizontalAlignment(SwingConstants.CENTER);
		DateTextField.setFont(new Font("Calibri", Font.BOLD, 18));
		DateTextField.setColumns(10);
		DateTextField.setBackground(SystemColor.info);
		DateTextField.setBounds(687, 18, 250, 33);
		contentPane.add(DateTextField);
		
		MobileTextField = new JTextField();
		MobileTextField.setHorizontalAlignment(SwingConstants.CENTER);
		MobileTextField.setFont(new Font("Calibri", Font.BOLD, 18));
		MobileTextField.setBackground(SystemColor.info);
		MobileTextField.setBounds(687, 218, 250, 35);
		contentPane.add(MobileTextField);
		
		AddressField = new JTextArea();
		AddressField.setFont(new Font("Calibri", Font.BOLD, 12));
		AddressField.setBackground(SystemColor.info);
		AddressField.setBounds(687, 69, 250, 115);
		contentPane.add(AddressField);
		
		AgeTextField = new JTextField();
		AgeTextField.setHorizontalAlignment(SwingConstants.CENTER);
		AgeTextField.setFont(new Font("Calibri", Font.BOLD, 18));
		AgeTextField.setColumns(10);
		AgeTextField.setBackground(SystemColor.info);
		AgeTextField.setBounds(183, 143, 104, 33);
		contentPane.add(AgeTextField);
		
		NameTextField = new JTextField();
		NameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		NameTextField.setFont(new Font("Calibri", Font.BOLD, 18));
		NameTextField.setColumns(10);
		NameTextField.setBackground(SystemColor.info);
		NameTextField.setBounds(183, 87, 193, 33);
		contentPane.add(NameTextField);
		
		BloodGroupLabel = new JLabel("Blood Group");
		BloodGroupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BloodGroupLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		BloodGroupLabel.setBounds(46, 263, 139, 43);
		contentPane.add(BloodGroupLabel);
		
		BloodGroupTextField = new JTextField();
		BloodGroupTextField.setHorizontalAlignment(SwingConstants.CENTER);
		BloodGroupTextField.setFont(new Font("Calibri", Font.BOLD, 18));
		BloodGroupTextField.setColumns(10);
		BloodGroupTextField.setBackground(SystemColor.info);
		BloodGroupTextField.setBounds(183, 265, 108, 33);
		contentPane.add(BloodGroupTextField);
		
		GenderLabel = new JLabel("Gender");
		GenderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GenderLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		GenderLabel.setBounds(46, 210, 85, 43);
		contentPane.add(GenderLabel);
		
		EmailIDLabel = new JLabel("Email ID");
		EmailIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EmailIDLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		EmailIDLabel.setBounds(56, 327, 85, 43);
		contentPane.add(EmailIDLabel);
		
		EmailTextField = new JTextField();
		EmailTextField.setHorizontalAlignment(SwingConstants.CENTER);
		EmailTextField.setFont(new Font("Calibri", Font.BOLD, 18));
		EmailTextField.setColumns(10);
		EmailTextField.setBackground(SystemColor.info);
		EmailTextField.setBounds(183, 329, 240, 33);
		contentPane.add(EmailTextField);
		
		GenderTextField = new JTextField();
		GenderTextField.setHorizontalAlignment(SwingConstants.CENTER);
		GenderTextField.setBackground(SystemColor.info);
		GenderTextField.setFont(new Font("Calibri", Font.BOLD, 18));
		GenderTextField.setBounds(183, 212, 95, 33);
		contentPane.add(GenderTextField);
		GenderTextField.setColumns(10);
		
		DiagnosisTextField = new JTextField();
		DiagnosisTextField.setHorizontalAlignment(SwingConstants.CENTER);
		DiagnosisTextField.setBackground(SystemColor.info);
		DiagnosisTextField.setFont(new Font("Calibri", Font.BOLD, 18));
		DiagnosisTextField.setBounds(183, 414, 250, 57);
		contentPane.add(DiagnosisTextField);
		DiagnosisTextField.setColumns(10);
		
		BillTextField = new JTextField();
		BillTextField.setHorizontalAlignment(SwingConstants.CENTER);
		BillTextField.setBackground(SystemColor.info);
		BillTextField.setFont(new Font("Calibri", Font.BOLD, 18));
		BillTextField.setBounds(687, 414, 201, 57);
		contentPane.add(BillTextField);
		BillTextField.setColumns(10);
		
		BillLabel = new JLabel("Fees");
		BillLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		BillLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BillLabel.setBounds(585, 414, 116, 57);
		contentPane.add(BillLabel);
		
		DiagnosisLabel = new JLabel("Diagnosis");
		DiagnosisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DiagnosisLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		DiagnosisLabel.setBounds(32, 424, 139, 43);
		contentPane.add(DiagnosisLabel);
		
		//Initial Condition
		//Code Start
		NameLabel.setVisible(false);
		AgeLabel.setVisible(false);
		AddressLabel.setVisible(false);
		DateLabel.setVisible(false);
		MobileLabel.setVisible(false);
		MajorIlnessLabel.setVisible(false);
		BloodGroupLabel.setVisible(false);
		GenderLabel.setVisible(false);
		EmailIDLabel.setVisible(false);
		DiagnosisLabel.setVisible(false);
		BillLabel.setVisible(false);
		WarningLabel.setVisible(false);
		
		NameTextField.setVisible(false);
		AgeTextField.setVisible(false);
		AddressField.setVisible(false);
		DateTextField.setVisible(false);
		MobileTextField.setVisible(false);
		MajorIllnessTextField.setVisible(false);
		BloodGroupTextField.setVisible(false);
		GenderTextField.setVisible(false);
		EmailTextField.setVisible(false);
		DiagnosisTextField.setVisible(false);
		BillTextField.setVisible(false);
		
		NameTextField.setEditable(false);
		AgeTextField.setEditable(false);
		AddressField.setEditable(false);
		DateTextField.setEditable(false);
		MobileTextField.setEditable(false);
		MajorIllnessTextField.setEditable(false);
		BloodGroupTextField.setEditable(false);
		GenderTextField.setEditable(false);
		EmailTextField.setEditable(false);
		DiagnosisTextField.setEditable(false);
		BillTextField.setEditable(false);
		//Code End
		
		//Print Button
		PrintButton = new JButton("Print\r\n");
		PrintButton.setIcon(new ImageIcon("C:\\Users\\Sourav Paul\\Downloads\\Print.png"));
		PrintButton.setFont(new Font("Javanese Text", Font.BOLD, 18));
		//Code Start
		PrintButton.setVisible(false);
		//Code End
		PrintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Code Start
				JOptionPane.showMessageDialog(null,"Print Succesfull");
			}
		});
		PrintButton.setBounds(463, 533, 146, 57);
		contentPane.add(PrintButton);
		
		
		
		//Close Button
		CloseButton = new JButton("Close\r\n");
		CloseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code Start
				setVisible(false);
				new HomeScreen().setVisible(true);
				//Code End
			}
		});
		CloseButton.setFont(new Font("Javanese Text", Font.BOLD, 18));
		CloseButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\Close.png"));
		CloseButton.setBounds(791, 533, 146, 57);
		contentPane.add(CloseButton);
		
		//Reset Button
		ResetButton = new JButton("Reset");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code Start
				NameLabel.setVisible(false);
				AgeLabel.setVisible(false);
				AddressLabel.setVisible(false);
				DateLabel.setVisible(false);
				MobileLabel.setVisible(false);
				MajorIlnessLabel.setVisible(false);
				BloodGroupLabel.setVisible(false);
				GenderLabel.setVisible(false);
				EmailIDLabel.setVisible(false);
				DiagnosisLabel.setVisible(false);
				BillLabel.setVisible(false);
				WarningLabel.setVisible(false);
				
				NameTextField.setVisible(false);
				AgeTextField.setVisible(false);
				AddressField.setVisible(false);
				DateTextField.setVisible(false);
				MobileTextField.setVisible(false);
				MajorIllnessTextField.setVisible(false);
				BloodGroupTextField.setVisible(false);
				GenderTextField.setVisible(false);
				EmailTextField.setVisible(false);
				DiagnosisTextField.setVisible(false);
				BillTextField.setVisible(false);
				
				ResetButton.setVisible(false);
				PrintButton.setVisible(false);
				IDTextField.setEditable(true);
				IDTextField.setText("");
				
				//Code End
			}
		});
		ResetButton.setFont(new Font("Javanese Text", Font.BOLD, 18));
		ResetButton.setBounds(149, 533, 146, 57);
		//Code Start
		ResetButton.setVisible(false);
		//Code End
		contentPane.add(ResetButton);
		
		BackgroundLabel = new JLabel("");
		BackgroundLabel.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\HomeScreen.png"));
		BackgroundLabel.setBounds(0, 0, 982, 653);
		contentPane.add(BackgroundLabel);
	}
}
