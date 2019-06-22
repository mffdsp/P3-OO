package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.adm.Command;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.payroll.BaterPonto;
import com.payroll.RealEdit;
import com.payroll.TaxaS;
import com.schedule.Agenda;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditView extends JFrame {

	private JPanel contentPane;
	private JTextField codeField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//EditView frame = new EditView(null, "editar");
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static int getIndex(String codigo){
        int i = 0;
        int index = 0;
        //2019265
        int pt = codigo.length() - 5;
        while(i < codigo.length() - 4 )
        {
            index += Math.pow(10, pt - i) * Character.getNumericValue(codigo.charAt(i + 4));
            i += 1;
        }
        return index;
	}

	/**
	 * Create the frame.
	 */
	public EditView(Funcionario[] func, String action , Agenda[] agenda) {
		
		setResizable(false);
		setTitle("Insira o C�digo de Acesso");
		setForeground(Color.WHITE);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 145);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		contentPane.setLayout(null);
		
		codeField = new JTextField();
		codeField.setColumns(10);
		codeField.setBackground(SystemColor.textHighlightText);
		codeField.setBounds(20, 22, 168, 37);
		
		contentPane.add(codeField);
		
		
		JButton btnIr = new JButton("IR");
		
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = 0;
				boolean notvalid = true;
				boolean sinnotvalid = true;
				try {
					int teste = Integer.parseInt(codeField.getText());
					indice = getIndex(codeField.getText());
					notvalid = func[indice] == null || Integer.parseInt(codeField.getText()) < 20190 || !func[indice].isSaved();
					sinnotvalid = func[indice] == null || Integer.parseInt(codeField.getText()) < 19190 || !func[indice].isSaved();
				}
				catch(Exception e0) {
					System.err.print(e0);
					JOptionPane.showMessageDialog(null ,
							"Formato inv�lido", "ERRO", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(action.equals("editar"))
				{
					if(notvalid)
					{
						JOptionPane.showMessageDialog(null ,
								"C�digo incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					//JOptionPane.showMessageDialog(null, texto1.getText());
					else {
						setVisible(false);
						new RealEdit(func, indice, agenda).setVisible(true);
					}
				}
				if(action.equals("remover"))  
				{
					 
					if(notvalid)
					{
						JOptionPane.showMessageDialog(null ,
								"C�digo incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					//JOptionPane.showMessageDialog(null, texto1.getText());
					else {
						int dialogButton = JOptionPane.YES_NO_OPTION;
						 DetailView DV = new DetailView(func[indice], true);
						 DV.setVisible(true);
						int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja remover o funcionario?", "Confirma��o", dialogButton);
						if(!(dialogResult == JOptionPane.YES_OPTION) ){
							DV.setVisible(false);
							return;
						}
						DV.setVisible(false);
						func[indice].setSaved(false);
						JOptionPane.showMessageDialog(null ,
						"Funcion�rio removido com sucesso", "Remover", JOptionPane.INFORMATION_MESSAGE);
						Command.saveS(func);
						setVisible(false);
					}
				}
				if(action.equals("TSindical"))
				{
					if(sinnotvalid)
					{
						JOptionPane.showMessageDialog(null ,
								"C�digo incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					//JOptionPane.showMessageDialog(null, texto1.getText());
					else {
						if(func[indice].isSindicaty()) {
							new TaxaS(func, indice).setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null ,
									"Funcion�rio n�o est� associado ao sindicato\n"
									+ "Para Associar-se Dirija-se a edi��o de dados", "ERRO", JOptionPane.ERROR_MESSAGE);
						}
						setVisible(false);
					}
				}
				if(action.equals("Lvenda"))
				{
					if(notvalid)
					{
						JOptionPane.showMessageDialog(null ,
								"C�digo incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					//JOptionPane.showMessageDialog(null, texto1.getText());
					else {
						if(func[indice] instanceof Comissionado) {
							new SellView(func, indice).setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null ,
									"Funcion�rio n�o � do tipo Comissionado\n"
									+ "Para modificar, Dirija-se a edi��o de dados", "ERRO", JOptionPane.ERROR_MESSAGE);
						}
						setVisible(false);
					}
				}
				if(action.equals("BPonto"))
				{
					if(notvalid)
					{
						JOptionPane.showMessageDialog(null ,
								"C�digo incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					//JOptionPane.showMessageDialog(null, texto1.getText());
					else {
						new BaterPonto(func, indice).setVisible(true);
						setVisible(false);
					}
				}
				
			}
		});
		
		btnIr.setBounds(141, 66, 50, 34);
		contentPane.add(btnIr);
	}
}
