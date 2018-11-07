package com.crm.dao;

import java.util.List;

import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;

public interface CustomerMapper {
	
	public List<Customer> findCustomerByVo(QueryVo vo);
	public Integer findCustomerByVoCount(QueryVo vo);
	
	public Customer findCustomerById(Long id);
	
	
	public void updateCustomerById(Customer customer);
	public void deleteCustomerById(Long id);
}
