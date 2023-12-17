package com.epam.mjc;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.HashMap;

public class InterfaceCreator {

	public Predicate<List<String>> isValuesStartWithUpperCase() {
		return x -> {
			for (int i = 0; i < x.size(); ++i) {
				if (x.get(i).charAt(0) < 'A' || x.get(i).charAt(0) > 'Z') {
					return false;
				}
			}
			return true;
		};
	}

	public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
		return x -> {
			int size = x.size();
			for (int i = 0; i < size; ++i) {
				if (0 == x.get(i) % 2) {
					x.add(x.get(i));
				}
			}
		};
	}

	public Supplier<List<String>> filterCollection(List<String> values) {
		return () -> {
			List<String> filteredList = new ArrayList<>();
			for (int i = 0; i < values.size(); ++i) {
				if (values.get(i).charAt(0) >= 'A'
						&& values.get(i).charAt(0) <= 'Z'
						&& values.get(i).charAt(values.get(i).length() - 1) == '.'
						&& values.get(i).split(" ").length > 3) {
					filteredList.add(values.get(i));
				}
			}
			return filteredList;
		};
	}

	public Function<List<String>, Map<String, Integer>> stringSize() {
		return x -> {
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < x.size(); ++i) {
				map.put(x.get(i), x.get(i).length());
			}
			return map;
		};
	}

	public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
		return (list1, list2) -> {
			List<Integer> concat = new ArrayList<>();
			concat.addAll(list1);
			concat.addAll(list2);
			return concat;
		};
	}
}
