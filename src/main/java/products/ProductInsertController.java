package products;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import common.DataBaseConnect;
import DAO.ProductDAO;
import beans.Product_bean;

/**
 * Servlet implementation class ProductInsertController
 */
@WebServlet("/product_insert_controller")
public class ProductInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
System.out.println("This is ProductInsertController.java ");
		
		Product_bean pb=new Product_bean();
		StringBuffer uploadMsg=new StringBuffer();
		
		
		
		Integer id=null;
		String name=null;
		String quantity=null;
		Float cost=null;
		String brand=null;
		String available=null;
		String fileName=null;
		Integer fileSize=null;
		
		boolean isMultiPart=ServletFileUpload.isMultipartContent(request);
		
		List<FileItem> itemList=null;
		InputStream fileDataIs=null;
		
		if(isMultiPart){
			ServletFileUpload sfu=new ServletFileUpload(new DiskFileItemFactory());
			try{
				itemList=sfu.parseRequest(request);
			}catch(FileUploadException e){
				System.out.println("File Upload Exception Error");
				e.printStackTrace();
			}
			
			FileItem idFileItem=itemList.get(0);
			FileItem nameFileItem=itemList.get(1);
			FileItem quantityFileItem=itemList.get(2);
			FileItem costFileItem=itemList.get(3);
			FileItem brandFileItem=itemList.get(4);
			FileItem availableFileItem=itemList.get(5);
			FileItem docFileItem=itemList.get(6);
			
			
			id=Integer.parseInt(idFileItem.getString());
			name=nameFileItem.getString();
			quantity=quantityFileItem.getString();
			cost=Float.parseFloat(costFileItem.getString());
			brand=brandFileItem.getString();
			available=availableFileItem.getString();
			fileName=docFileItem.getName();
			System.out.println("name  "+name+ "cost "+cost+" id "+id+" brand"+brand+" file name"+fileName);
			
			
			fileSize=(int)docFileItem.getSize();
			fileDataIs=docFileItem.getInputStream();
			
			
			
			String uploadDirFullPath="C:\\eclipse\\workSpace\\GeneralStore\\src\\main\\webapp\\img\\Products";
			//fileName=fileName;
			
			
			String fullFilePath=uploadDirFullPath+File.separatorChar + fileName;
			
			System.out.println("fullFilePath="+fullFilePath);
			
			File file=new File(fullFilePath);
			FileOutputStream fos=null;
			
			try{
				fos=new FileOutputStream(file);
				byte[]mybuff=new byte[1024*1024];
				int readLength;
				
				while((readLength=fileDataIs.read(mybuff))!=-1){
					fos.write(mybuff,0, readLength);
				}

			}catch(Exception e){
				System.out.println("File not create ");
			}finally{
				if(fos!=null){
					System.out.println("fos closed..");
					fos.close();
					uploadMsg.append("upload successfully");
					uploadMsg.append("insert file saved  "+file.getAbsolutePath());
				}
			}
			
			
		}//isMultiPart
		
		
		pb.setId(id);
		pb.setName(name);
		pb.setQuantity(quantity);
		pb.setCost(cost);
		
		pb.setBrand(brand);
		pb.setAvailable(available);

		pb.setFileName(fileName);
		
		
		System.out.println("*******   ******");
		
		System.out.println("id="+pb.getId());
		System.out.println("name="+pb.getName());
		System.out.println("Quantity="+pb.getQuantity());
		System.out.println("cost="+pb.getCost());
		System.out.println("Brand="+pb.getBrand());
		System.out.println("Available="+pb.getAvailable());
		System.out.println("fileName"+pb.getFileName());
		System.out.println("file Size="+fileSize);
		
		System.out.println("upload message"+uploadMsg);
		
		 response.getWriter().print(uploadMsg);
		
		 try{
			 boolean b=new ProductDAO(DataBaseConnect.connect()).insert(pb);
			 if(b){
				 response.sendRedirect("admin/product.jsp?status=success");
			 }else{
				 response.sendRedirect("admin/product.jsp?status=failed");
				 
			 }
			 
		 }catch(Exception e){
			 
		 }
	}

}
