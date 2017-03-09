import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.rmi.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JTextField;
import javax.swing.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class yuginoh extends JPanel implements KeyListener,MouseInputListener{
	static final long serialVersionUID = 1;
	static yuginoh panel;
	static Point lclick; 
	static int currentz;
	public static Card S; 
	public static BufferedImage cardback;
	public static logic l;
	public static boolean Tester;
	public static Client c;
	public static Tester t;
	public void mouseDragged(MouseEvent e){
		
	}
	public void paint(Graphics g){
		if(Tester){
			t.update();
		}else{
			//c.update();
		}
		super.paint(g);
	}
	public void keyTyped(KeyEvent e){
		
	}
	public void keyReleased(KeyEvent e){
			
	}
	public void keyPressed(KeyEvent e){
		
	}
	public void draw( int player){
		
		repaint();
	}
	public static void main(String [] args){
		lclick=new Point(0,0);
		currentz=-1;
		panel= new yuginoh();
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(1,1));
		frame.add(panel);
		panel.addMouseListener(panel);
		panel.setVisible(true);
		frame.setVisible(true);
		frame.setSize(1000, 1100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public int detectZone(Point p){
		Iterator<Square> z = l.zones.iterator();
		Square temp;
		while(z.hasNext()){
			temp=z.next();
			if(temp.x<=p.x && (temp.x+temp.w)> p.x && temp.y<p.y && (temp.y+temp.h)> p.y){
				return temp.id;
			}
		}
		return -1;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		/*lclick = new Point(e.getX(),e.getY());
		currentz=detectZone(lclick);
		if(currentz!=-1){
			if(l.zones.get(currentz).c!=null){
				S=l.zones.get(currentz).c;
			}else{
				S=null;
			}
		}
		panel.repaint();*/
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		/*lclick = new Point(e.getX(),e.getY());
		int temp=detectZone(lclick);
		if(temp!=currentz && temp>-1){
			if(S!=null){
				if(S.zone!=temp){
					S.zone=temp;
					l.zones.get(currentz).c=null;
					l.zones.get(temp).c=S;
				}
			}
		}
			currentz=temp;
		
		panel.repaint();*/
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
