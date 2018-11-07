package com.crm.dao;

import java.util.List;

import com.crm.pojo.BaseDict;

public interface DictMapper {
	
	public List<BaseDict> findDictByTypeCode(String code);
}
