/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.dao;

import java.util.List;
import com.dyr.team1.xms.amsw.entity.Category;

/**
 * Project:AssetManagementSystemWeb
 * Package:com.dyr.team1.xms.amsw.dao
 * FileName:CategoryDAO.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015-2-10 下午6:08:18
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@SuppressWarnings("unchecked")
public class CategoryDAO extends BaseDAO{

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-13 下午5:24:01
	 * Description
	 * @return
	 */
	public List<Category> selectAllCate(){
		List<Category> categories = getCurrentSession().createQuery("from Category").list();
		return categories.size()>0?categories:null;
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015-2-24 下午5:09:55
	 * Description
	 * @param name
	 * @return
	 */
	//@Select("select * from CategoryTable where category_name=#{name} ")
	public Category selectCateByName(String name){
		return null;
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-23 下午5:06:39
	 * Description 添加大类
	 * @param bigCate
	 * @return
	 */
	public int insertBigCate(String name){
		Category category = new Category();
		category.setName(name);
		getCurrentSession().save(category);
		return 1;
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-23 下午5:17:46
	 * Description 添加小类
	 * @param smallCate
	 * @param bigCateSelect
	 * @return
	 */
	public int addSmallCate(String small, Integer bigCateSelect){
		Category bc = (Category) getCurrentSession().get(Category.class, bigCateSelect);
		Category sc = new Category();
		sc.setName(small);
		sc.setSuperCate(bc);
		bc.getCategories().add(sc);
		getCurrentSession().save(bc);
		return 0;
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-23 下午5:33:32
	 * Description 删除类别
	 * @param name
	 * @return
	 */
	//@Delete("delete from CategoryTable where category_name=#{name} ")
	public int deleteCate(String name){
		return 0;
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-23 下午5:48:19
	 * Description 修改类别
	 * @param oldName
	 * @param newName
	 * @return
	 */
	//@Update("update CategoryTable set category_name=#{newName} where category_name=#{oldName} ")
	public int updateCate(String oldName, String newName){
		return 0;
	}

}
