import java.io.*;
public class GLauncher {

	public static void main(String[] args)throws IOException {
		GuessGame gg = new GuessGame();
		wallpaper wp = new wallpaper();
		
	   	wp.wall();
	   	gg.menu();	   	
	}
}