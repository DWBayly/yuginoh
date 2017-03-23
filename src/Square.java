
public class Square {
	int id,x,y,w,h;
	Card c;
	Deck d;
	int owner;
	boolean isprivate;
	public Square(int id,int x, int y, int w, int h,int isp){
		if(isp==0){
			isprivate = false;
		}else{
			isprivate = true;
		}
		this.id=id;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		
	}
	
}
