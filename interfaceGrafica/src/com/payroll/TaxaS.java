package com.payroll;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TaxaS extends JFrame {

	private JPanel contentPane;
	private JTextField TFvalor;

	public TaxaS(Funcionario[] func, int index) {
		Utility UT = new Utility();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 205);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Registrar Taxa");
		
		JEditorPane TFobs = new JEditorPane();
		TFobs.setBackground(SystemColor.textHighlightText);
		TFobs.setText("Insira as observa\u00E7\u00F5es sobre a Taxa");
		TFobs.setBounds(0, 87, 141, 79);
		contentPane.add(TFobs);
		
		TFvalor = new JTextField();
		TFvalor.setBackground(SystemColor.textHighlightText);
		TFvalor.setBounds(113, 24, 86, 29);
		contentPane.add(TFvalor);
		TFvalor.setColumns(10);
		
		JLabel LBtaxa = new JLabel("Valor de Taxa:");
		LBtaxa.setHorizontalAlignment(SwingConstants.LEFT);
		LBtaxa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LBtaxa.setBounds(10, 31, 93, 14);
		contentPane.add(LBtaxa); 
		
		JButton BTsave = new JButton("Save");
		BTsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					double value = Double.parseDouble(TFvalor.getText());
					double salary = func[index].getSalary();
					func[index].setSalary( salary - value);
					JOptionPane.showMessageDialog(null ,
							"Taxa debitada com sucesso �: \n"
							+ func[index].getName() + "\nC�digo Sindical: " + func[index].getSindicatycode(), "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
					Command.saveS(func);
					setVisible(false);
							
				} catch(Exception ex0) {
					UT.ERRO();
					System.err.print(ex0); 
					return;
				}
			}
		});
		BTsave.setBounds(140, 87, 69, 79);
		contentPane.add(BTsave);
		
	}
}
