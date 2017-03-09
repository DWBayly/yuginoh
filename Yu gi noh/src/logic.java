import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;


public class logic {
	static Point lclick; 
	static int currentz;
	public static List<Square>zones; 
	public static Card S; 
	public static List<Card> d1;
	public static List<Card> d2;
	public static List<Card> inplay;
	public void init() throws IOException{
		Scanner in = new Scanner(new File("L1"));
		zones=new ArrayList<Square>();
		while(in.hasNext()){
			zones.add(new Square(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt()));
		}
		in = new Scanner(new File("D1"));
		d1 = new ArrayList<Card>();
		while(in.hasNext()){
			int k = in.nextInt();
			String temp= in.next();
			for(int i= 0; i < k; i ++ ){
				d1.add(new Card(0,ImageIO.read(new File(temp))));
			}
		}
		d2 = new ArrayList<Card>();
		in = new Scanner(new File("D2"));
		while(in.hasNext()){
			int k = in.nextInt();
			String temp= in.next();
			for(int i= 0; i < k; i ++ ){
				d2.add(new Card(1,ImageIO.read(new File(temp))));
			}
		}
		in.close();
	}
	public Card draw(ArrayList<Card> deck){
		return deck.remove((int)(Math.random()*deck.size()));
	}
	public int detectZone(Point p){
		Iterator<Square> z = zones.iterator();
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
