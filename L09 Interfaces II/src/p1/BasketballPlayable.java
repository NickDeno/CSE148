package p1;

public class BasketballPlayable implements Playable {

	@Override
	public void play() {
		System.out.println("Play basketball!");
	}
	
	public void walk() {
		System.out.println("Walk!");
	}

}
