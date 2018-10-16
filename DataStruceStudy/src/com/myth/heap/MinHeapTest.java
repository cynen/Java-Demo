package com.myth.heap;

import org.junit.Test;

public class MinHeapTest {
	@Test
	public void pub() {
		// 新建一个堆.
		MinHeap<Integer> heap = new MinHeap<>();
		heap.add(2);
		heap.add(3);
		heap.add(4);
		heap.add(5);
		heap.add(6);
		heap.add(7);
		heap.listAll();
		// 删除元素
		heap.delete(5);
		heap.listAll();
		// 添加元素
		heap.add(9);
		heap.listAll();
		// 弹顶
		heap.pop();
		heap.listAll();
		//弹顶.
		heap.pop();
		heap.listAll();
	}
}
