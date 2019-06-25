package com.view;

import com.adm.CalendarMT;
import com.adm.Command;
import com.adm.Utility;
import com.employee.Funcionario;
import com.employee.Horista;
import com.payroll.SignUP;
import com.schedule.Agenda;
import com.schedule.CriarAgendaView;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import java.awt.Dialog.ModalExclusionType;

public class MainView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	Utility UT = new Utility();
	Agenda agenda[] = new Agenda[500];
	private JPanel contentPane;
	private JLabel texto;
	private JLabel LBadd;
	private static int index = 0;
	
	public static void main(String[] args) {
	
		//Nimbus set
	    try {
	        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	            if ("Nimbus".equals(info.getName())) {
	                javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                break;
	            }
	        }
	    } catch (Exception ex) {
	       System.err.println(ex);
	    }
	    //Nimbus set
	    
		try {
			MainView window = new MainView();
			window.setVisible(true);
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	public MainView() {
					
		//frameset
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setType(Type.NORMAL);
		setTitle("FolhaDePagamento");
		setResizable(false);
		setForeground(UIManager.getColor("textHighlight"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 521);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setForeground(SystemColor.inactiveCaption);
		setContentPane(contentPane);
		texto = new JLabel("Sistema de Folha de pagamento vers\u00E3o 1.0");
		texto.setForeground(SystemColor.controlText);
		texto.setFont(new Font("Tahoma", Font.PLAIN, 8));
		texto.setBounds(625, 11, 180, 14);
		//frameset
		
		
		JButton BTedit = new JButton("");
		BTedit.setContentAreaFilled(false);
		BTedit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTedit.setBounds(451, 120, 81, 81);
		BTedit.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-editar-v\u00E1rios-80 (1).png")));
		
		JButton BTremove = new JButton("");
		BTremove.setContentAreaFilled(false);
		BTremove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTremove.setBounds(271, 120, 81, 81);
		
		JButton BTlist = new JButton("");
		BTlist.setContentAreaFilled(false);
		BTlist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTlist.setBounds(631, 120, 81, 81);
		
		JButton BTadd = new JButton("");
		BTadd.setContentAreaFilled(false);
		BTadd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTadd.setBounds(93, 120, 81, 81);
		BTadd.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/add.png")));
		BTadd.setToolTipText("Adicionar Funcion\u00E1rio");
		BTadd.setBackground(Color.WHITE);
		BTadd.setForeground(Color.WHITE);
		BTadd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		
		
		LBadd = new JLabel("Adicionar Funcion\u00E1rio");
		LBadd.setLabelFor(BTadd);
		LBadd.setBounds(68, 188, 164, 25);
		LBadd.setForeground(SystemColor.activeCaptionText);
		LBadd.setFont(new Font("Tahoma", Font.BOLD, 12));
		BTlist.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-lista-de-verifica\u00E7\u00E3o-64.png")));
		BTlist.setToolTipText("Listar Funcion\u00E1rios");
		BTlist.setForeground(Color.WHITE);
		BTlist.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTlist.setBackground(Color.WHITE);
		
		JLabel LBremove = new JLabel("Remover Funcion\u00E1rio");
		LBremove.setForeground(SystemColor.activeCaptionText);
		LBremove.setBounds(242, 188, 147, 25);
		LBremove.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel LBedit = new JLabel("Alterar Dados");
		LBedit.setForeground(SystemColor.activeCaptionText);
		LBedit.setBounds(451, 188, 147, 25);
		LBedit.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel LBlist = new JLabel("Listar Empregados");
		LBlist.setForeground(SystemColor.activeCaptionText);
		LBlist.setBounds(615, 188, 147, 25);
		LBlist.setFont(new Font("Tahoma", Font.BOLD, 12));
		

		
		contentPane.setLayout(null);
		contentPane.add(BTadd);
		contentPane.add(BTremove);
		contentPane.add(BTedit);
		contentPane.add(BTlist);
		contentPane.add(LBadd);
		contentPane.add(LBremove);
		contentPane.add(LBlist);
		contentPane.add(LBedit);
		contentPane.add(texto);
		
		
		
		//Screen Config
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(813, 517);
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		JLabel background = new JLabel("", new ImageIcon("img\bgteste.jpg"), JLabel.CENTER);
		background.setBounds(11, 1, 0, 0);
		background.setBackground(new Color(0,0,0,80));
		
		
		//Data
		JLabel LBdata = new JLabel();
		LBdata.setForeground(SystemColor.controlText);
		JLabel LBhora = new JLabel();
		LBhora.setForeground(SystemColor.controlText);
		LBhora.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LBdata.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LBdata.setBounds(22, 419, 103, 25);
		contentPane.add(LBdata);
		LBhora.setBounds(63, 437, 43, 25);
		contentPane.add(LBhora);
		LBdata.setText(CalendarMT.valueToString(CalendarMT.Adia) + "/"  + CalendarMT.valueToString(CalendarMT.Ames)
		+ "/"  + CalendarMT.valueToString(CalendarMT.Aano)); 
		LBhora.setText(CalendarMT.valueToString(CalendarMT.Ahora) + ":" + CalendarMT.valueToString(CalendarMT.Aminuto)); 
	
		
		Funcionario[] funcionarios = new Funcionario[500];	
		UT.setALL(funcionarios, agenda);
		Command.saveS(funcionarios);
		
		//AddFuncionario();
		BTadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				index = UT.findIndex(funcionarios);
				funcionarios[index] = new Horista();
				try {
					new SignUP(funcionarios, index).setVisible(true);
					
				}catch(ArrayIndexOutOfBoundsException exception) {
					
					System.err.println("Indice fora dos limites definidos");
				}
				
			}
		});

		//RmvFuncionario();
		BTremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditView(funcionarios, "remover", agenda).setVisible(true);
			}
		});
		
		
		BTremove.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-remover-usu\u00E1rio-masculino-64 (1).png")));
		BTremove.setToolTipText("Remover Funcion\u00E1rio");
		BTremove.setForeground(Color.WHITE);
		BTremove.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTremove.setBackground(Color.WHITE);
		
		
		//editFuncionario();
	
		BTedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditView(funcionarios, "editar", agenda).setVisible(true);
			}
		});
		BTedit.setToolTipText("Alterar Dados");
		BTedit.setForeground(Color.WHITE);
		BTedit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTedit.setBackground(Color.WHITE);
		
		
		//listarFuncionario();
		BTlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				DefaultListModel DLMA = new DefaultListModel();
				DefaultListModel DLMC = new DefaultListModel();
				DefaultListModel DLMH = new DefaultListModel();
				try {
					UT.setList(funcionarios, DLMC, DLMA, DLMH);
				}
				catch(NullPointerException e) {
					System.err.println("Exception de ponteiro nulo");
				}
				if(DLMA.getSize() == 0) {
					DLMA.addElement("Lista Vazia");
				}if(DLMH.getSize() == 0) {
					DLMH.addElement("Lista Vazia");
				}if(DLMC.getSize() == 0) {
					DLMC.addElement("Lista Vazia");
				}
				new ListView(DLMA, DLMC, DLMH, funcionarios).setVisible(true);
			}
		});
		
	
		JButton BTatthora = new JButton("");
		BTatthora.setToolTipText("Passar hora");
		BTatthora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTatthora.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-clock-adicionar-64 (1).png")));
		BTatthora.setContentAreaFilled(false);
		BTatthora.setBorderPainted(false);
		BTatthora.setBorder(null);
		BTatthora.setForeground(SystemColor.inactiveCaption);
		BTatthora.setBackground(SystemColor.activeCaption);
		BTatthora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CalendarMT.passHour(funcionarios);
				LBdata.setText(CalendarMT.valueToString(CalendarMT.Adia) + "/"  + CalendarMT.valueToString(CalendarMT.Ames)
				+ "/"  + CalendarMT.valueToString(CalendarMT.Aano)); 
				LBhora.setText(CalendarMT.valueToString(CalendarMT.Ahora) + ":" + CalendarMT.valueToString(CalendarMT.Aminuto)); 
			}
		});
		BTatthora.setBounds(95, 417, 60, 49);
		contentPane.add(BTatthora);
		
		JButton UndoBTN = new JButton("");
		UndoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		UndoBTN.setContentAreaFilled(false);
		UndoBTN.setIcon(new ImageIcon(MainView.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		UndoBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command.undo(funcionarios);
			}
		});
		UndoBTN.setBounds(10, 11, 35, 50);
		contentPane.add(UndoBTN);
		
		JButton RedoBTN = new JButton("");
		RedoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RedoBTN.setContentAreaFilled(false);
		RedoBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Command.redo(funcionarios);
			}

		});
		RedoBTN.setIcon(new ImageIcon(MainView.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		RedoBTN.setBounds(45, 11, 35, 50);
		contentPane.add(RedoBTN);
		
		JButton BTponto = new JButton("");
		BTponto.setHorizontalTextPosition(SwingConstants.CENTER);
		BTponto.setHideActionText(true);
		BTponto.setContentAreaFilled(false);
		BTponto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTponto.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-propriedade-de-tempo-80 (1).png")));
		BTponto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditView(funcionarios, "BPonto", agenda).setVisible(true);
			}
		});
		BTponto.setToolTipText("Cart\u00E3o de ponto");
		BTponto.setForeground(Color.WHITE);
		BTponto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTponto.setBackground(Color.WHITE);
		BTponto.setBounds(91, 239, 81, 81);
		contentPane.add(BTponto);
		
		JLabel LBcartao = new JLabel("Cart\u00E3o de Ponto");
		LBcartao.setLabelFor(BTponto);
		LBcartao.setForeground(SystemColor.activeCaptionText);
		LBcartao.setFont(new Font("Tahoma", Font.BOLD, 12));
		LBcartao.setBounds(80, 315, 147, 25);
		contentPane.add(LBcartao);
		
		JButton BTtaxa = new JButton("");
		BTtaxa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditView(funcionarios, "TSindical", agenda).setVisible(true);
			}
		});
		BTtaxa.setContentAreaFilled(false);
		BTtaxa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTtaxa.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-pagamento-online-64.png")));
		BTtaxa.setToolTipText("Lan\u00E7ar Taxa");
		BTtaxa.setForeground(Color.WHITE);
		BTtaxa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTtaxa.setBackground(Color.WHITE);
		BTtaxa.setBounds(268, 242, 81, 81);
		contentPane.add(BTtaxa);
		
		JLabel LBtaxa = new JLabel("Lan\u00E7ar Taxa");
		LBtaxa.setForeground(SystemColor.activeCaptionText);
		LBtaxa.setFont(new Font("Tahoma", Font.BOLD, 12));
		LBtaxa.setBounds(271, 315, 147, 25);
		contentPane.add(LBtaxa);
		
		JButton BTvenda = new JButton("");
		BTvenda.setContentAreaFilled(false);
		BTvenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTvenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditView(funcionarios, "Lvenda", agenda).setVisible(true);
			}
		});
		BTvenda.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-vender-estoque-64.png")));
		BTvenda.setToolTipText("Lan\u00E7ar Venda");
		BTvenda.setForeground(Color.WHITE);
		BTvenda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTvenda.setBackground(Color.WHITE);
		BTvenda.setBounds(444, 242, 81, 81);
		contentPane.add(BTvenda);
		
		JLabel LBagenda = new JLabel("Criar Agenda ");
		LBagenda.setForeground(SystemColor.activeCaptionText);
		LBagenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		LBagenda.setBounds(631, 315, 96, 25);
		contentPane.add(LBagenda);
		
		JButton BTagenda = new JButton("");
		BTagenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CriarAgendaView(agenda, funcionarios).setVisible(true);
			}
		});
		BTagenda.setVerticalAlignment(SwingConstants.BOTTOM);
		BTagenda.setContentAreaFilled(false);
		BTagenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTagenda.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-criar-arquivo-64 (1).png")));
		BTagenda.setToolTipText("Criar Agenda");
		BTagenda.setForeground(Color.WHITE);
		BTagenda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		BTagenda.setBackground(Color.WHITE);
		BTagenda.setBounds(631, 239, 81, 81);
		contentPane.add(BTagenda);
		
		JButton BTfolha = new JButton("");
		BTfolha.setContentAreaFilled(false);
		BTfolha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTfolha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CalendarMT.payboo[CalendarMT.DAYSGONE]){
					JOptionPane.showMessageDialog(null ,
							"Folha de pagamento já rodada hoje", "ERRO", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja rodar a folha de pagamento para hoje?", "Confirmação", dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					CalendarMT.payboo[CalendarMT.DAYSGONE] =  true;
					DefaultListModel DLMA = new DefaultListModel();
					DefaultListModel DLMC = new DefaultListModel();
					DefaultListModel DLMH = new DefaultListModel();
					try{ 
						UT.payList(funcionarios, DLMC, DLMA, DLMH);
					}
					catch(NullPointerException e2) {
						System.err.println("Exception de ponteiro nulo");
					}
					if(DLMA.getSize() == 0) {
						DLMA.addElement("Lista Vazia");
					}if(DLMH.getSize() == 0) {
						DLMH.addElement("Lista Vazia");
					}if(DLMC.getSize() == 0) {
						DLMC.addElement("Lista Vazia");
					}		
					new PayView(DLMA, DLMC, DLMH, funcionarios).setVisible(true);
					
				}
			}
		});
		BTfolha.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-transfer\u00EAncia-de-dinheiro-64 (1).png")));
		BTfolha.setToolTipText("Listar Funcion\u00E1rios");
		BTfolha.setForeground(new Color(245, 255, 250));
		BTfolha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 7));
		BTfolha.setBackground(Color.WHITE);
		BTfolha.setBounds(701, 386, 81, 81);
		contentPane.add(BTfolha);
		
		JLabel LBvenda = new JLabel("Lan\u00E7ar Venda");
		LBvenda.setForeground(SystemColor.activeCaptionText);
		LBvenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		LBvenda.setBounds(451, 315, 147, 25);
		contentPane.add(LBvenda);
		
		JLabel label_1 = new JLabel(" ");
		label_1.setBounds(10, 135, 46, 14);
		contentPane.add(label_1);
		
		JLabel LBfolha = new JLabel("Rodar Folha ");
		LBfolha.setForeground(Color.BLACK);
		LBfolha.setFont(new Font("Tahoma", Font.BOLD, 12));
		LBfolha.setBounds(705, 448, 96, 25);
		contentPane.add(LBfolha);
		
		
		JLabel LBsemana = new JLabel(CalendarMT.getWeekDay());
		LBsemana.setForeground(Color.BLACK);
		LBsemana.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LBsemana.setBounds(22, 453, 96, 25);
		contentPane.add(LBsemana); 
		
		CalendarMT.clock(LBdata, LBhora, LBsemana, funcionarios);
		
		JButton BTattdia = new JButton("");
		BTattdia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BTattdia.setContentAreaFilled(false);
		BTattdia.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/ca28g-fpnyu.png")));
		BTattdia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CalendarMT.timeChange(funcionarios);
			}
		});
		BTattdia.setBounds(145, 422, 55, 40);
		contentPane.add(BTattdia);
		
}
}

