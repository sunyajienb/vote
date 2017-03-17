package com.yajie.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yajie.bean.Competitor;
import com.yajie.dao.CompetitorDao;
import com.yajie.daoFactory.CompetitorDaoImplFactory;

public class Enrol extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException{
		//req.setCharacterEncoding("gbk");
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(dfif);
		Competitor competitor = new Competitor();
		CompetitorDao competitorDao = CompetitorDaoImplFactory.getCompetitorDaoInstance();
	
		try {
			 List<FileItem> list = fileUpload.parseRequest(req);
			 for(FileItem fileItem : list)
			 {
				 if(fileItem.isFormField()){//普通属性
					 String fieldName = fileItem.getFieldName();
					 if(fieldName.equals("name")){
						 competitor.setName(fileItem.getString());
					 }else if(fieldName.equals("age")){						 
						 competitor.setAge(Integer.parseInt(fileItem.getString()));
					 }else if(fieldName.equals("sex")){
						 competitor.setSex(fileItem.getString());
					 }
				 }//普通属性
				 else{
					 String savePath = getServletContext().getRealPath("/upload");
					 int count = competitorDao.findAllCount() + 1;//文件名称为编号
					 //File file = new File(savePath,String.valueOf(count));
					 File file = new File(savePath + "\\" + count + ".jpg");
					 
					 fileItem.write(file);
					 //competitor.setPhotoPath(savePath + "\\" + count + ".jpg");
					 competitor.setPhotoPath("\\wxVote\\upload" + "\\" + count + ".jpg");
				 }
			 }
			 competitorDao.add(competitor);
			 res.sendRedirect("/wxVote");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException{
		doGet(req,res);
	}

}
