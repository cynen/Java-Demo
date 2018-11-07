package com.crm.service;

import java.util.List;

import com.crm.pojo.BaseDict;
import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;

public interface CustomerService {
	public List<BaseDict> findDictByTypeCode(String typecode);
	public List<Customer> findCustomerByVo(QueryVo vo);
	public Integer findCustomerByVoCount(QueryVo vo);
	
	public Customer findCustomerById(Long id);
	
	public void updateCustomerById(Customer customer);
	
	public void deleteCustomerById(Long id);
}
