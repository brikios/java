package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import controllers.ControleurCiterne1;
import interfaces.*;
import model.*;

public class CiterneView1 extends JFrame implements Observer{
	Citerne cmodel;
	JTextField tvolume = new JTextField("1000");
	JLabel lunites = new JLabel ("Volume en litres");
	JButton btnAdd = new JButton ("Add");
	JButton btnDrain = new JButton ("Drain");
	JLabel lcurrent = new JLabel ("Volume actuel: ");
	JLabel lcurrentV = new JLabel ("0.0 litres");
	JLabel lpourc = new JLabel ("Pourcentage de remplissage");
	JLabel lpourcV = new JLabel ("0%");
	public JSlider slide = new JSlider ();
	JPanel p,p1, p2, p3, p4;
	public CiterneView1 (Citerne ct)
	{	super ("Citerne (View1)");
		cmodel=ct;
		cmodel.addObserver(this);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(1,2));
		p1.add(lunites);p1.add(tvolume);
		p1.add(btnAdd);p1.add(btnDrain);
		p2 = new JPanel();
		p2.add(btnAdd); p2.add(btnDrain);
		p3 = new JPanel();
		p3.setBackground(Color.LIGHT_GRAY);
		p3.setLayout(new GridLayout(2,2));
		p3.add(lcurrent);p3.add(lcurrentV);
		p3.add(lpourc);
		p3.add(lpourcV);
		slide.setValue(0);
		p4 = new JPanel();
		p4.setLayout(new BoxLayout(p4,BoxLayout.LINE_AXIS));
		p4.add(slide);
		p= new JPanel();
		p.setLayout(new GridLayout(4,1));
		p.add(p1);p.add(p2);
		p.add(p3);p.add(p4);
		btnAdd.addActionListener(new ControleurCiterne1(this));
		btnDrain.addActionListener(new ControleurCiterne1(this));
		slide.addMouseMotionListener(new ControleurCiterne1(this));
		setSize(new Dimension (400, 400));
		getContentPane().add(p);
		setVisible(true);
		
		
	}
	public Citerne getCiterne()
	{
		return cmodel;
	}
	public int getValueSlider()
	{
		return slide.getValue();
	}
	public String getVolume() {
		return tvolume.getText();
	}
	
	@Override
	public void update(Observable ov, Object v) 
	{
		lcurrentV.setText(cmodel.getCurrentVolume()+" litres");
		lpourcV.setText(cmodel.getCurrentRate()+" %");
		slide.setValue((int)cmodel.getCurrentRate());
	}
	public static void main (String []argv)
	{
		Citerne c = new Citerne(100,200);
		CiterneView1 view1 =new CiterneView1(c);
		CiterneView2 view2 = new CiterneView2(c);
	}
}



