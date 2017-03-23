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
	public List<Square>zones; 
	public static Card S; 
	public static List<Card> d1;
	public static List<Card> d2;
	public static List<Card> inplay;
	public void init() throws IOException{
		Scanner in = new Scanner(new File("L2"));
		zones=new ArrayList<Square>();
		int i,temp,owner;
		List<Square> LastGrid= new ArrayList<Square>();
		i=0;
		try{
		while(in.hasNext()){
			
			switch (in.next()){
			
			case"Z":
				zones.add(new Square(i,in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt()));
				i++;
			break;
			case"D":
				owner=in.nextInt();
				temp = in.nextInt();
				Deck temptd = new Deck();
				temptd.d=new ArrayList<Card>();
				String cname;
				int quantity;
				for(int k= 0;k<temp;k++){
					cname=in.next();
					System.out.println(cname);
					quantity=in.nextInt();
					for(int j=0;j<quantity;j++){
						System.out.println("owner");
						if(owner==0){
							temptd.d.add(new Card(0,zones.size(),ImageIO.read(new File(cname))));
						}else
							temptd.d.add(new Card(1,zones.size(),ImageIO.read(new File(cname))));
						}
					}
				
				zones.get(zones.size()-1).d=temptd;
				if(LastGrid!=null){
					zones.get(zones.size()-1).d.drawTo=LastGrid;
					LastGrid=new ArrayList<Square>();
				}
			break;
			case"G":
				LastGrid.clear();
				int sx = in.nextInt();
				int sy = in.nextInt();
				int gx = in.nextInt();
				int gy = in.nextInt();
				int w = in.nextInt();
 				int h = in.nextInt();
 				int isp = in.nextInt();
				for(int j = 0; j<gx;j++){
					for(int k = 0; k<gy; k++){
						zones.add(new Square(i,sx+w*j,sy+h*k,w,h,isp));
						LastGrid.add(zones.get(i));
						i++;
					}
				}
				
				
				
			break;
		
		
		
		}
			//zones.add(new Square(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt()));
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
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
	public void move(int z1, int z2){
		Card temp = zones.get(z1).c;
		zones.get(z1).c= zones.get(z2).c;
		zones.get(z2).c = temp;
		
	}
	
}
