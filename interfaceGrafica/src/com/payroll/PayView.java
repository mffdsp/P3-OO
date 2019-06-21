package com.payroll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.AbstractListModel;
import java.awt.Cursor;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;

public class PayView extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public PayView(DefaultListModel DLMA, DefaultListModel DLMC,  DefaultListModel DLMH) {
		
		setForeground(Color.WHITE);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Lista de funcionários pagos hoje");
		setBounds(100, 100, 546, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(SystemColor.inactiveCaption);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 11, 385, 244);
		contentPane.add(scrollPane);
		

		JList hlist = new JList();
		scrollPane.setViewportView(hlist);
		hlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		hlist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hlist.setForeground(Color.BLACK);
		hlist.setBackground(Color.WHITE);
		hlist.setBorder(new CompoundBorder());
		hlist.setSelectedIndices(new int[] {2});
		hlist.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		JList list_1 = new JList();
		list_1.setBounds(135, 11, -128, 232);
		list_1.setBorder(null);
		contentPane.add(list_1);
		hlist.setModel(DLMH);
		JButton btnNewButton = new JButton("Horistas");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.setIcon(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hlist.setModel(DLMH);
			}
		}); 
		btnNewButton.setBounds(10, 11, 115, 59);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Comissionados");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hlist.setModel(DLMC);
			}
		});
		button.setBounds(10, 196, 115, 59);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Assalariados");
		button_1.setBackground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hlist.setModel(DLMA);
			}
		});
		button_1.setBorder(null);
		button_1.setBounds(10, 102, 115, 59);
		contentPane.add(button_1);

		
		
	}
}
