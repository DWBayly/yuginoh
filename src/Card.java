import java.awt.image.BufferedImage;


public class Card {
	int x;
	int y;
	int zone;
	int owner;
	
	BufferedImage b;
	public Card(int owner,int zone, BufferedImage b){
		//this.x=x;
		//this.y=y;
		this.owner=owner;
		this.zone=zone;
		this.b=b;
	}
	

}
