
public final class machine {
	int m_num=0;
	
	protected void g_machine() {		// Machine will generate random numbers
		this.m_num = (int) (Math.rint(Math.random() * 10));
	}
}
