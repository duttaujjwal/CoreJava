import java.io.Serializable;

public class Logger implements Cloneable,Serializable{

	private static final long serialVersionUID = 1L;
	private static Logger logger;

	private Logger(){}
	
	public static Logger getLogger() {
		if (logger == null) {
			synchronized(Logger.class) {
				if (logger == null) {
					logger = new Logger();
				}
			}
		}
		return logger;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new CloneNotSupportedException();
	}
	
	protected Object readResolve() {
		return logger;
	}
	
}
