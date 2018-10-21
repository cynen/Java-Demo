package com.myth.heap;
/**
 * 
*<p> Title: MaxHeap  </p>
*<p> Description: 
*	最大堆的实现

这里为了方便，我们直接占用了数组下标为0的位置，
在0的位置放置了一个null，
这样数组中实际有效值的下标就和我们完全二叉树中层序遍历的实际序号对应了。
这样，完全二叉树中，如果结点值为n,那么其左子树则为2n,右子树为2n+1；
换句话说，对于任一结点n,其父结点为n/2 取整即可。



*</p>
*<p> Copyright: Copyright (c) 2018</p>  
*<p> Company: myth</p>  
* @author myth
* @date 2018年10月16日  
* @version v1.0
 */

import java.util.ArrayList;
import java.util.List;

public class MaxHeap<T extends Comparable<T>> {
	// 堆使用数组实现.
	private List<T> mHeap;
	// 最大堆的构造函数,
	public MaxHeap(){
		// 所以,所有的堆操作,都是基于数组的操作.
		mHeap = new ArrayList<>();
		// 是数组的第一个元素始终有数据,这样,具体的数据的index就对应到了对应的元素.index=1就是第一个元素.
		mHeap.add(0, null);
	}
	
	// 遍历堆. 使用广度优先.
	public void listAll() {
		// 直接顺序输出数组.
		for (T t : mHeap) {
			if (t== null) {
				continue;
			}
			System.out.print(t+"   ");
		}
		System.out.println();
	}
	/**
	 *这里需要注意的是，当插入结点大于父结点时，我们并没有交换两个元素的算法，而只是把小的元素“降”了下来，
	 *因为我们最终只是想要找到一个正确的位置而已，交换是不必要，只需要在最后在合适的位置把值放上去就可以了。 
	 */
	public void add(T value) {
		// 新插入的元素放到最后,保证完全二叉树.
		mHeap.add(value);
		// 获取插入前的最后一个元素
		int index = mHeap.size() - 1; // mheap的size时刻记住第一个位置占了元素.
		//插入元素的父节点
		int pIndex = index/2;  // 完全二叉树按照  广度优先遍历.第一个元素为null.但是占了位置. 
		
        //在数组范围内，比较这个插入值和其父结点的大小关系，大于父结点则用父结点替换当前值，index位置上升为父结点
		// 循环替换.直到新插入的元素,小于其父节点.
        while (index > 1) {
            // 插入结点小于等于其父结点，则不用调整
            if (compare(value, mHeap.get(pIndex)) <= 0) {
                break;
            } else {
                // 依次把父结点较小的值“将”下来,将父节点的值,替换到最后.也就是新插入元素的位置.
                mHeap.set(index, mHeap.get(pIndex));
                // 向上升一层(准备将当前新值插入到其父节点.新插入元素的索引已经变为其父节点)
                index = pIndex;
                // 获得新的父结点
                pIndex = index / 2; 
            }
        }
        // 注意,是将得到的准备插入位置index的值,进行替换,不是add!!!
        // 因为index处的值,已经被替换到其他位置.
        mHeap.set(index, value);
	}
	
	
	/**
	 * 堆的任意值删除操作
	 */
	
	public boolean delete(T value) {
		if(this.isEmpty()) {
			return false;
		}
		// 查看要删除的元素是否在堆中.  (都是基于数组的操作.)
		int index = mHeap.indexOf(value);
		if(index == -1) {
			return false;
		}
		
		// 删除任意元素后,为了满足完全二叉树的要求,需要将最后一个元素插入当前位置.
		int lastindex = mHeap.size() -1 ;
		// 用最后一个元素替换删除的元素.
		T temp = mHeap.get(lastindex);
		mHeap.set(index, temp);
		
		// 调整, 一当节点为父节点,和左右子树进行判断对比.
		int parent ;
		for (parent = index; parent * 2 <= mHeap.size()-1; parent = index) {
			// 求左子树的下标.
			index = parent * 2; 
			// 比较当前index的左右子树的大小.
			// 左子树下标不等于数组长度，因此必然有右子树 ,
			//则左右子树比较大小，这里-1 是因为数组下标=1 开始
			if ((index != mHeap.size()-1 ) && (compare(mHeap.get(index), mHeap.get(index+1)) < 0)){
				// 右子树大.指针指向右节点.
				index = index + 1;
			}
			
			if (compare(temp, mHeap.get(index))> 0) {
				// 当前节点temp(队尾移上来的数据大) 不移.
				break;
			}else {
				// 节点需要下移.
				mHeap.set(parent, mHeap.get(index));
			}
		}
		// parent 索引就是最终节点该待的地方.
		mHeap.set(parent, temp);
		// 删除数组最后一个元素.
		mHeap.remove(lastindex);
		return true;
	}
	
	
	/**
	 * 堆,从堆顶删除元素.直接使用pop,弹出最顶上的元素.
	 * 弹出最顶上的元素.会将最后的元素移到顶部.进行自调整.
	 * 优先队列模式
	 */
	public boolean pop() {
		if(this.isEmpty()) {
			return false;
		}
		// 最后元素的索引.
		int lastindex = mHeap.size() - 1;
		// 最后一个元素
		T temp = mHeap.get(lastindex);
		mHeap.set(1, temp);
		int parent = 1; // parent 索引位置
		int index = 2; // 左子节点的位置.
		 
		for (parent  = 1 ; parent * 2 <= mHeap.size() -1 ; parent= index) {
			// 左子树的下标.
			index = parent * 2;
			// 左子节点不是最后一个元素.
			// 左右子树进行对比
			if((index != mHeap.size()-1 )&&(compare(mHeap.get(index), mHeap.get(index+ 1)) < 0)) {
				// 右子树较大.
				index = index+1;
			}
			// 使用当前元素,和子节点最大值进行对比
			if (compare(temp, mHeap.get(index))> 0) {
				// 当前节点temp(队尾移上来的数据大) 不移.
				break;
			}else {
				// 当前节点需要下移.
				mHeap.set(parent, mHeap.get(index));
			}
		}
		
		mHeap.set(parent, temp);
		mHeap.remove(lastindex);
		return true;
	}
	
	
	/**
	 * mheap是否为空
	 */
	public boolean isEmpty() {
		
		return mHeap.size() <=  1;
	}
	
	
	
	
	
	
    /**
     *  
     * @param a
     * @param b
     * @return a>b 返回值大于0，反之小于0
     */
    private int compare(T a, T b) {
        return a.compareTo(b);
    }

	
}
