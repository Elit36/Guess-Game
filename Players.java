import java.io.*;
public final class Players {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int in = 0;
	
	protected int input()throws IOException {
		this.in = Integer.parseInt(br.readLine());
		return in;
	}
}
