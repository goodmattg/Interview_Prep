public class Reverse_string {

	private String input;

	public Reverse_string(String input) {
		this.input = input;
	}

	public static String reverse(String str) {

		int len = str.length();

		if (len == 1) {
			return str;
		} else {
			return (str.substring(len - 1) + reverse(str.substring(0, len - 1)));
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Reverse_string.reverse("abcdefg"));

	}
}
