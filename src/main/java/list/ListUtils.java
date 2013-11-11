package list;

public class ListUtils {
	public static Object[] reverse(Object[] array) {
		Object[] result = new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			result[array.length - 1 - i] = array[i];
		}
		return result;
	}

	public static MinimaList reverse(MinimaList list) {
		MinimaList result = new MinimaList();
		for (int i = 0; i < list.size(); i++) {
			result.add(list.get(list.size() - 1 - i));
		}
		return result;
	}
}
