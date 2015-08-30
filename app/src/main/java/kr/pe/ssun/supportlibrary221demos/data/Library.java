package kr.pe.ssun.supportlibrary221demos.data;

/**
 * Created by x1210x on 15. 5. 5..
 */
public enum Library {
	V4_SUPPORT("v4 support"),
	V7_APPCOMPAT("v7 appcompat"),
	V7_DESIGN("v7 design"),
	V7_CARDVIEW("v7 cardview"),
	V7_PALETTE("v7 palette"),
	V7_RECYCLERVIEW("v7 recyclerview"),
	V7_PREFERENCE("v7 preference"),
	V14_PREFERENCE("v14 preference"),
	CUSTOM_TABS("custom tabs"),
	PERCENT("percent");

	private String text;

	Library(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}
}
