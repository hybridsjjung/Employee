package webapp.escape;

/*
40	Black
41	Red
42	Green
43	Yellow
44	Blue
45	Magenta
46	Cyan
47	White
*/

public enum Foreground {
	BLACK(30), 
	RED(31), 
	GREEN(32),
	YELLOW(33), 
	BLUE(34),
	MAGENTA(35),
	CYAN (36),
	WHITE(37);
	
	final int value;
	
	private Foreground(int value) {
		this.value = value;
	}
}
