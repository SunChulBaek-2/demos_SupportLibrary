package kr.pe.ssun.supportlibrary221demos;

/**
 * Created by x1210x on 15. 5. 2..
 */
public enum Version {
	V22_1("v22.1", 0);

	private String text;
	private long id;

	Version(String text, long id) {
		this.text = text;
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public long getId() {
		return this.id;
	}
}
