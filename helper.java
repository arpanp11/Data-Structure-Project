import java.util.*;
import java.util.Map.Entry;

public class Helper {
	/**
	 * This method used to get the key values from a map base on its values
	 * 
	 * @param map
	 * @param value
	 * @return key
	 */
	public String getVertexByID(Map<String, Integer> map, int value) {

		for (Entry<String, Integer> entry : map.entrySet()) {
			if (Objects.equals(value, entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	/**
	 * This method take a map and sort the map based on its values
	 * 
	 * @param map
	 * @return sorted map
	 */
	public Map<String, Integer> getSortedMapByValues(
			Map<String, Integer> map) {

		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(
				map.entrySet());

		// sort on the basis of values
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		/**
		 * LinkedHashMap is used to hold sorted the map
		 */
		Map<String, Integer> sortedByValueMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) {
			sortedByValueMap.put(entry.getKey(), entry.getValue());
		}

		return sortedByValueMap;
	}

	/**
	 * This method is used to print the city list
	 * 
	 * @param map
	 */
	public void printMenu(Map<String, Integer> map) {
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getValue() + " " + entry.getKey());
		}
	}
}
