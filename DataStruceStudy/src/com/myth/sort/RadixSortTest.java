package com.myth.sort;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RadixSortTest {
	
	/**
	 * 桶排序测试.
	 */
	@Test
	public void test() {
		List<Integer> list = new ArrayList<>();
		list.add(23);
		list.add(43);
		list.add(24);
		list.add(45);
		list.add(35);
		list.add(29);
		list.add(141);
		list.add(371);
		list.add(12);
		
		list = RadixSortUtils.RadixSort(list);
		System.out.println(list);
	}
	
}
