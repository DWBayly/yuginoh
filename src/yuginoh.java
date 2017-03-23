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
import javax.swing.JTextField;
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
		super.paint(g);
		/*if(isTester()){
			t.update();
		}else{
			try{
			c.update();
			}catch(Exception e){
				System.out.println("Client not found");
			}
		}*/
		
		g.setColor(Color.white);
		//g.drawRect(200, 200, 30, 30);
		if(l!= null){
			System.out.println("Redrawing");
			Iterator<Square> z = l.zones.iterator();
			Square temp;
			while(z.hasNext()){
				temp = z.next();
				g.drawRect(temp.x, temp.y, temp.w, temp.h);
				if (temp.c!=null){
					if(!temp.isprivate){
						g.drawImage(temp.c.b, temp.x, temp.y, temp.w, temp.h, null);
					}else if(Tester){
						if(temp.c.owner==0){
							g.drawImage(temp.c.b, temp.x, temp.y, temp.w, temp.h, null);
						}else{
							g.drawImage(cardback,temp.x,temp.y,temp.w,temp.h,null);
						}
					}else{
						if(temp.c.owner==1){
							g.drawImage(temp.c.b, temp.x, temp.y, temp.w, temp.h, null);
						}else{
							g.drawImage(cardback,temp.x,temp.y,temp.w,temp.h,null);
						}
					}
					
				}else if (temp.d!=null){
					if(!temp.d.d.isEmpty())
						g.drawImage(cardback,temp.x,temp.y,temp.w,temp.h,null);
					}
				}
				//System.out.println(temp.toString());
			
			
			
		}else{
			System.out.println("WTF");
			g.drawRect(100, 100, 90,90);
		}
		
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
		try{
			cardback = ImageIO.read(new File("cardback.jpg"));
		}catch(Exception e){
			System.exit(0);
		}
		panel= new yuginoh();
		JFrame frame = new JFrame();
		panel.setBackground(Color.black);
		frame.setLayout(new GridLayout(1,1));
		//frame.add(new JTextField());
		panel.setVisible(true);
		frame.setVisible(true);
		frame.setSize(1000, 1100);
		frame.add(panel);
		panel.addMouseListener(panel);
		//panel.repaint();
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public int detectZone(Point p){
		if(this.l!= null){
			return l.detectZone(p);
		}else{
			Iterator<Square> z = getL().zones.iterator();
			Square temp;
			while(z.hasNext()){
				temp=z.next();
				if(temp.x<=p.x && (temp.x+temp.w)> p.x && temp.y<p.y && (temp.y+temp.h)> p.y){
					return temp.id;
				}
			}
			return -1;
		}
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
		
		currentz = detectZone(e.getPoint());
		if(currentz!=-1){
		if(l.zones.get(currentz).d!=null){
			l.zones.get(currentz).d.draw();
		}else if(l.zones.get(currentz).c!=null){
			S=l.zones.get(currentz).c;
		}
		}
		panel.repaint();
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		// TODO Auto-generated method stub
		lclick = new Point(e.getX(),e.getY());
		if(currentz>=0 && currentz <33){
		
		if(l.zones.get(currentz).c!=null){
			if(detectZone(lclick)!=currentz && detectZone(lclick)>=0){
				l.move(detectZone(lclick),currentz);
				if(Tester){
					t.move();
				}else{
					
				}
			}
		}
		}
		S= null;
		panel.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public logic getL() {
		return l;
	}
	public void setL(logic l) {
		this.l = l;
	}
	public static Client getC() {
		return c;
	}
	public void setC(Client c) {
		yuginoh.c = c;
	}
	public static boolean isTester() {
		return Tester;
	}
	public static void setTester(boolean tester) {
		Tester = tester;
	}
}
