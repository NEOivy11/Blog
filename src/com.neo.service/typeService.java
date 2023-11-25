package com.neo.service;

import java.util.List;

import com.neo.dao.ArtDao;
import com.neo.dao.TypeDao;
import com.neo.entity.Atricle;
import com.neo.entity.Type;

public class typeService {
	public Type addType(Type type){
		TypeDao typeDao=new TypeDao();

		if(exists(type.getTypeId(), type.getUserName()))
			return null;
		
		return typeDao.add(type);
		}
	
	public boolean exists(int typeId, String userName){
		Type oldType = findByType(typeId,userName);
		if(oldType != null)
			return true;
		else
			return false;
	}
	
	public Type findByType(int typeId, String userName){
		TypeDao dao = new TypeDao();
		
		return dao.findByType(typeId, userName);
	}
	
	public List<Type> findAll(String userName) {
		TypeDao dao = new TypeDao();
		
		return dao.findAll(userName);
	}
	
	public Type modifyType(Type type){
		TypeDao dao = new TypeDao();
		return dao.modifyType(type);
	}
	
	public boolean deleteType(Type type){
		TypeDao dao = new TypeDao();
		return dao.delete(type);
	}
}
