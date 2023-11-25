package com.neo.service;

import java.util.List;

import com.neo.dao.ArtDao;
import com.neo.entity.Atricle;



public class articleService {
	
	
	public Atricle addA(Atricle art){
		ArtDao artDao=new ArtDao();

		return artDao.addA(art);
		}
	
	
	public List<Atricle> findByType(int typeId, String userName){
		ArtDao dao = new ArtDao();
		
		return dao.findByType(typeId, userName);
	}
	
	public String findType(int typeId){
		ArtDao dao = new ArtDao();
		
		return dao.findType(typeId);
	}
	
	public List<Atricle> findByTitle(String artTitle){
		ArtDao dao = new ArtDao();
		
		return dao.findByTitle(artTitle);
	}
	
	public Atricle findByArtId(int artId){
		ArtDao dao = new ArtDao();
		
		return dao.findByArtId(artId);
	}
	
	public Atricle modifyContent(Atricle art){
		ArtDao dao = new ArtDao();
		return dao.modifyContent(art);
	}
	
	public List<Atricle> findAll() {
		ArtDao dao = new ArtDao();
		
		return dao.findAll();
	}
	
	public List<Atricle> findByUserName(String userName){
		ArtDao dao = new ArtDao();
		
		return dao.findByUserName(userName);
	}
	
	public void deleteArt(Atricle art){
		ArtDao dao = new ArtDao();
		
		dao.delete(art);
	}
}
