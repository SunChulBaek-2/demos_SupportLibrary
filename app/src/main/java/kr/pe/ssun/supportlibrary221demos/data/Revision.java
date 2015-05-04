package kr.pe.ssun.supportlibrary221demos.data;

/**
 * Created by x1210x on 15. 5. 2..
 */
public enum Revision {
	REV_22_1_0("revision 22.1.0", 0),
	REV_22("revision 22", 1),
	REV_21_0_3("revision 21.0.3", 2),
	REV_21_0_2("revision 21.0.2", 3),
	REV_21_0_1("revision 21.0.1", 4),
	REV_21("revision 21", 5);

	private String text;
	private long id;

	Revision(String text, long id) {
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
