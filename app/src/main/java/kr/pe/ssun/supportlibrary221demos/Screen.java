package kr.pe.ssun.supportlibrary221demos;

/**
 * Created by x1210x on 15. 5. 2..
 */
public enum Screen {
	NORMAL,
	LARGE;

	private static Screen current;

	public static void setCurrent(Screen screen) {
		current = screen;
	}

	public static Screen getCurrent() {
		return current;
	}
}
