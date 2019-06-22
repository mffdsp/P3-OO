package com.payroll;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

public class DetailView extends JFrame {

	private JPanel contentPane;
	private JTextField TFname;
	private JTextField TFcode;
	private JTextField TFtype;
	private JTextField TFptype;
	private JTextField TFsalary;
	private JLabel LBinfo;
	private JLabel LBcustom;
	private JTextField TFcustom;

	public DetailView(Funcionario func) {
		
		//FRAME
		setTitle("Detalhes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewClass.class.getResource("/com/payroll/icons/APPICON.png")));
		setBounds(100, 100, 300, 330);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.menu);
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(32, 86, 103, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblTipo = new JLabel("Code :");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipo.setBounds(32, 116, 103, 25);
		contentPane.add(lblTipo);
		
		JLabel lblTipo_1 = new JLabel("Tipo :");
		lblTipo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipo_1.setBounds(32, 146, 103, 25);
		contentPane.add(lblTipo_1);
		
		JLabel lblRecebimentoVia = new JLabel("Recebimento via :");
		lblRecebimentoVia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRecebimentoVia.setBounds(32, 176, 103, 25);
		contentPane.add(lblRecebimentoVia);
		
		JLabel lblValor = new JLabel("Valor :");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValor.setBounds(32, 206, 103, 23);
		contentPane.add(lblValor);
		
		TFname = new JTextField();
		TFname.setBackground(SystemColor.textHighlightText);
		TFname.setText(func.getName());
		TFname.setEditable(false);
		TFname.setBounds(155, 86, 86, 25);
		contentPane.add(TFname);
		TFname.setColumns(10);
		
		TFcode = new JTextField();
		TFcode.setText(func.getCode());
		TFcode.setEditable(false);
		TFcode.setColumns(10);
		TFcode.setBackground(Color.WHITE);
		TFcode.setBounds(155, 116, 86, 25);
		contentPane.add(TFcode);
		
		TFtype = new JTextField();
		TFtype.setText(func.getType());
		TFtype.setEditable(false);
		TFtype.setColumns(10);
		TFtype.setBackground(Color.WHITE);
		TFtype.setBounds(155, 146, 86, 25);
		contentPane.add(TFtype);
		
		TFptype = new JTextField();
		TFptype.setText(func.getPayMode());
		TFptype.setEditable(false);
		TFptype.setColumns(10);
		TFptype.setBackground(Color.WHITE);
		TFptype.setBounds(155, 176, 86, 25);
		contentPane.add(TFptype);
		
		TFsalary = new JTextField();
		if(func instanceof Horista) {
			TFsalary.setText(Double.toString(((Horista) func).getSalarioBase()));
		}else TFsalary.setText(Double.toString(func.getSalary()));
		
		TFsalary.setEditable(false);
		TFsalary.setColumns(10);
		TFsalary.setBackground(Color.WHITE);
		TFsalary.setBounds(155, 206, 86, 25);
		contentPane.add(TFsalary);
		
		LBinfo = new JLabel("   Informa\u00E7\u00F5es");
		LBinfo.setIcon(new ImageIcon(DetailView.class.getResource("/com/payroll/icons/icons8-painel-de-detalhes-30.png")));
		LBinfo.setBounds(32, 11, 136, 38);
		contentPane.add(LBinfo);
		
		LBcustom = new JLabel("Agenda :");
		LBcustom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LBcustom.setBounds(32, 236, 103, 25);
		contentPane.add(LBcustom);
		
		TFcustom = new JTextField();
		
		TFcustom.setEditable(false);
		TFcustom.setColumns(10);
		TFcustom.setBackground(Color.WHITE);
		TFcustom.setBounds(155, 236, 86, 25);
	    TFcustom.setText(func.getAgendaToString());
	    contentPane.add(TFcustom);
		//FRAME
	
		
	}
}