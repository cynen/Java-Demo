package com.myth.tree.binarytree;
/**
 * 二叉树的节点.(无需排序.)
 * 
*<p> Title: BinaryNode  </p>
*<p> Description: </p>
*<p> Copyright: Copyright (c) 2018</p>  
*<p> Company: myth</p>  
* @author myth
* @date 2018年10月21日  
* @version v1.0
 */
public class BinaryNode {
	public Object element;
	public BinaryNode left;
	public BinaryNode right;
	
	public BinaryNode(Object element) {
		this.element = element;
	}

	public BinaryNode() {
		super();
	}
	
}	
