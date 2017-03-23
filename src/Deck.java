import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;


public class Deck {
	int zone;
	BufferedImage b;
	List<Square> drawTo;
	List<Card> d;
	public Deck(){
		
	}
	public boolean draw(){
		Iterator<Square> z =  drawTo.iterator();
		//System.out.println(drawTo.toString());
		if(drawTo==null){
			System.out.println("no zone to draw to");
			return false; 
		}
		Square temp;
		while(z.hasNext()){
			temp = z.next();
			//System.out.println(z.toString());
			if(temp.c==null){
				if(!d.isEmpty()){
				temp.c=d.remove(0);
				//System.out.println("Drawing card");
				return true;
				}
				return false;
			}
		}
		System.out.println("You dun goofed");
		return false;
	}
	

}
