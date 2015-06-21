package kr.pe.ssun.supportlibrary221demos.data;

import kr.pe.ssun.supportlibrary221demos.R;

/**
 * Created by x1210x on 15. 5. 2..
 */
public enum Revision {
	REV_22_2_0("revision 22.2.0", R.drawable.ic_action_22_2_0, 0),
	REV_22_1_0("revision 22.1.0", R.drawable.ic_action_22_1_0, 1),
	REV_22("revision 22", R.drawable.ic_action_22, 2),
	REV_21_0_2("revision 21.0.2", R.drawable.ic_action_21_0_2, 4),
	REV_21("revision 21", R.drawable.ic_action_21, 6),
	REV_13("revision 13", R.drawable.ic_action_13, 7),
	REV_9("revision 9", R.drawable.ic_action_9, 8),
	REV_6("revision 6", R.drawable.ic_action_6, 9);

	private String text;
	private int resIcon;
	private long id;

	Revision(String text, int resIcon, long id) {
		this.text = text;
		this.resIcon = resIcon;
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public int getResIcon() {
		return this.resIcon;
	}

	public long getId() {
		return this.id;
	}
}
