package com.dbms;

import java.util.Map;

public class Storage {

	public Map<Long,CustomerInfo> customerMap;
	public Map<Long, Map<Long, AccountInfo>> accountMap;
	
public void cacheFile(Map<Long,CustomerInfo> customerMap,Map<Long,Map<Long,AccountInfo>> accountMap)
{
	this.customerMap=customerMap;
	this.accountMap=accountMap;	
}

}
