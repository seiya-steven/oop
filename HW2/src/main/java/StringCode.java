import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		if (str.isEmpty()) return 0;

		int len = str.length();
		int maxLen = 1;

		int l = 0, r;

		while (l < len) {
			r = l;
			while (r < len && str.charAt(l) == str.charAt(r)) {
				r++;
			}
			maxLen = Math.max(maxLen, r - l);
			l = r;
		}

		return maxLen;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		int len = str.length();
		while (len > 0 && Character.isDigit(str.charAt(len - 1))) {
			len--;
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			if (Character.isDigit(ch)) {
				int j = Character.getNumericValue(ch);
				for (int k = 0; k < j; k++) {
					sb.append(str.charAt(i + 1));
				}
			} else {
				sb.append(ch);
			}
		}

		return sb.toString();
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if (a.length() < len || b.length() < len) {
			return false;
		}

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i <= a.length() - len; i++) {
			set.add(a.substring(i, i + len));
		}

		for (int i = 0; i <= b.length() - len; i++) {
			if (set.contains(b.substring(i, i + len))) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(stringIntersect("bbacd", "kkbac", 3));
	}
}
