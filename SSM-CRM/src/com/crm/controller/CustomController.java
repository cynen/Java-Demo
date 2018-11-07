package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crm.pojo.BaseDict;
import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;
import com.crm.service.CustomerService;

import cn.itcast.utils.Page;

@Controller
@RequestMapping("/customer")
public class CustomController {
	
	@Autowired
	private CustomerService customerService;
	
	@Value("${Customer.dict.source}")
	private String source;
	@Value("${Customer.dict.industry}")
	private String industry;
	@Value("${Customer.dict.level}")
	private String level;
	
	
	@RequestMapping("/list")
	public String list(QueryVo vo,Model model) throws Exception {
		// 客户来源
		List<BaseDict> sourceList = customerService.findDictByTypeCode(source);
		//industry
		List<BaseDict> industryList = customerService.findDictByTypeCode(industry);
		//level
		List<BaseDict> levelList = customerService.findDictByTypeCode(level);
		
//		get请求  乱码处理
//			vo.setCustName(new String(vo.getCustName().getBytes("iso8859-1"),"utf-8"));不用处理,web.xml已经处理了
//		if (vo.getCustName() != null) {
//			System.out.println(".....");
//		}
		// 设置查询其实位置.
		if (vo.getPage() == null) {
			vo.setPage(1);
		}
		
		vo.setStart((vo.getPage() -1) * vo.getSize());
		
		// 查询数据列表和数据总数.
		List<Customer> customerList = customerService.findCustomerByVo(vo);
		Integer count = customerService.findCustomerByVoCount(vo);
		
		Page<Customer> page = new Page<Customer>();
		page.setPage(vo.getPage());// 当前页.
		page.setRows(customerList); //数据集.
		page.setSize(vo.getSize()); // 每页数.
		page.setTotal(count);// 数据总数.
		
		//数据集返回到页面
		model.addAttribute("page", page);
		
		
		// 高级查询下拉列表
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		// 高级查询数据回显.
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		model.addAttribute("custName", vo.getCustName());
		
		return "customer";
	}
	
	@RequestMapping("/detail")
	@ResponseBody
	public Customer detail(Long id) throws Exception{
		Customer customer = customerService.findCustomerById(id);
		return customer;
	} 
	
	
	// 更新客户信息
	@RequestMapping("/update")
	public String updateCustomer(Customer customer) throws Exception{
		customerService.updateCustomerById(customer);
		return "customer";
	}
	
	// 删除客户信息
	@RequestMapping("/deletecustomer")
	public String deleteCustomer(Long id) throws Exception{
		customerService.deleteCustomerById(id);
		return "ok";
	}
	
}	
