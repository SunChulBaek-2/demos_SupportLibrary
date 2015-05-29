package kr.pe.ssun.supportlibrary221demos.data;

/**
 * Created by x1210x on 15. 5. 5..
 */
public enum Library {
	V4_SUPPORT("v4 support"),
	V7_APPCOMPAT("v7 appcompat"),
	V7_DESIGN("v7 design"),
	V7_RECYCLERVIEW("v7 recyclerview");

	private String text;

	Library(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}
}
