package com.myth.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 
*<p> Title: RadixSort  </p>
*<p> Description: 
*	基数排序:
*	桶排序.
*	假设只对整数进行排序.
*	基数排序(Radix Sort)，时间复杂度为O(n)
*
*	思路:
*	1.将需要排序的数据,按照一定的基数进行分类...这个过程可以做一次桶排序.
*	2.顺序取出后,更换基础重新排序.排序完成.
*	
*
*	举例:
*	50,37,34,32,45,71
*	第一次排序,按照个位:
*	50,71,32,34,45,37
*	第二次排序,按照十位:
*	32,34,37,45,50,71

*</p>
*<p> Copyright: Copyright (c) 2018</p>  
*<p> Company: myth</p>  
* @author myth
* @date 2018年10月21日  
* @version v1.0
 */
public class RadixSortUtils {
	private static final int BUCKET_NUM = 10;
	
	public static List<Integer> RadixSort(List<Integer> preSortlist) {
		if (preSortlist.isEmpty()) {
			return null;
		}
		// 定义10个桶.
		List<List<Integer>> buckets = new ArrayList<>(BUCKET_NUM);
		
		//对入参的数据进行处理,求得最大的基数个数.(最大元素的位数.)
		int radix = 0; // 默认的最大基数为0
		int maxRadixNum = 0; // 最大基数处的数字
		boolean end = false;
		// 处理数组.
		while(true) {
			// 获得当前数据的最大基数.
			maxRadixNum = getMaxRadix(radix+1);//比如,当前radix =1 , maxRadixNum = 10;比10大的需要进行二次判断.
			
			// 初始化10个数组.
			buckets.clear();
			for (int i=0;i<BUCKET_NUM ; i++) {
				buckets.add(new ArrayList<>());
			}
			end = true;
			// 第一步.根据基数进行分桶.
			for (Integer integer : preSortlist) {
				//计算元素属于哪个桶,比如,当前基数是0, 那么213就应该属于3这个桶.
				// 当前基数是10,那么213这数就应该属于1这个桶.
				int radixnum = getRadix(integer,radix);
				buckets.get(radixnum).add(integer);
				//遍历的时候,如果发现当前的数据大于最大基数.说明有高位存在.
				if (integer > maxRadixNum) {
					end = false;
				}
			}
			
			// 第二步:遍历桶,放回原数组内.
			preSortlist.clear();
			for (List<Integer> list : buckets) {
				preSortlist.addAll(list);
			}
			
			if (end) {
				break;
			}else {
				radix += 1;
			}
		}
		return preSortlist;
	}
	/**
	 * 传入需要计算的数,返回其基数的索引值.
	 * 比如传入参数: 123,0
	 * 实际需要获得23的个位数.  返回3
	 * 传入参数: 123,10
	 * 实际返回的是23的十位数. 返回2
	 * 传入参数:123,100
	 * 实际需要返回的是1,
	 * <p>Description: </p>  
	 * @param integer
	 * @param radix
	 * @return
	 */
	private static int getRadix(Integer integer, int radix) {
		return integer/getMaxRadix(radix)%10;
	}
	/**
	 * 获得最大基数.比如radix = 0 ,表示最大基数10
	 * radix = 1  最大基数为100.(99小于100)
	 * <p>Description: </p>  
	 * @param radix
	 * @return
	 */
	public static int getMaxRadix(int radix) {
		int num = 1;
		for (int i = 1; i <= radix; i++) {
			num = num*10;
		}
		return num;
	}
}
