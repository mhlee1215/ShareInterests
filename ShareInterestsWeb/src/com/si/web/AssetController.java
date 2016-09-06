package com.si.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.si.domain.Article;
import com.si.domain.Asset;
import com.si.domain.Category;
import com.si.domain.User;
import com.si.service.ArticleService;
import com.si.service.AssetService;
import com.si.service.CategoryService;
import com.si.service.UserService;




@Controller

@RequestMapping("/assets")
public class AssetController {
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private final AssetService assetService = null;
	//	
	//	@Autowired
	//	private final CategoryService categoryService = null;

	@Autowired
    ServletContext context; 
	
	private ResourceLoader resourceLoader = new DefaultResourceLoader();

//	@ResponseBody
//	@RequestMapping(value = "/assets/get.do", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
//	public byte[] testphoto() throws IOException {
//	    InputStream in = context.getResourceAsStream("classpath:images/123.jpg");
//	    FileInputStream fis = new FileInputStream(getServletContext().getRealPath("/") + "/");
//	    return IOUtils.toByteArray(in);
//	}


	//Not work in AWS
//	@ResponseBody
//	@RequestMapping(value = "/get.do", method = RequestMethod.GET)
//	public ResponseEntity<byte[]> testphoto(HttpServletRequest request) throws IOException {
//	    //InputStream in = context.getResourceAsStream("classpath:images/123.jpg");
//		String id = ServletRequestUtils.getStringParameter(request, "id", "");
//		System.out.println("+++>>>"+context.getRealPath("/") + "/assets/"+id);
//		File f = new File(context.getRealPath("/") + "/assets/"+id);
//		FileInputStream fis = null;
//
//		if(!f.exists()){
//			System.out.println("NOT FOUND : alternative path : "+context.getRealPath("/") + "/assets/not-found.png");
//	    	fis = new FileInputStream(context.getRealPath("/") + "/assets/not-found.png");
//		}
//	    else{
//	    	System.out.println("FOUND : current-path : "+context.getRealPath("/") + "/assets/"+id);
//	    	fis = new FileInputStream(context.getRealPath("/") + "/assets/"+id);
//	    }
//	    
//	    byte[] image = IOUtils.toByteArray(fis);
//	    HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.IMAGE_PNG);
//	    //headers.setContentType(MediaType.IMAGE_JPEG);
//	    headers.setContentLength(image.length);
//	    
//	    return new ResponseEntity<>(image, headers, HttpStatus.OK);
//	} 
//	
//	//Not work in AWS
//	@ResponseBody
//	@RequestMapping(value = "/get2.do", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
//	public byte[] testphoto2(HttpServletRequest request) throws IOException {
//		String id = ServletRequestUtils.getStringParameter(request, "id", "");
//		System.out.println("+++>>>"+context.getRealPath("/") + "/assets/"+id);
//		File f = new File(context.getRealPath("/") + "/assets/"+id);
//		FileInputStream fis = null;
//
//		if(!f.exists()){
//			System.out.println("NOT FOUND : alternative path : "+context.getRealPath("/") + "/assets/not-found.png");
//	    	fis = new FileInputStream(context.getRealPath("/") + "/assets/not-found.png");
//		}
//	    else{
//	    	System.out.println("FOUND : current-path : "+context.getRealPath("/") + "/assets/"+id);
//	    	fis = new FileInputStream(context.getRealPath("/") + "/assets/"+id);
//	    }
//	    return IOUtils.toByteArray(fis);
//	}
	
	//Work in AWS !!!! 
	@RequestMapping(value = "/get.do", method = RequestMethod.GET)
	  public void showImage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = ServletRequestUtils.getStringParameter(request, "id", "");
		System.out.println("+++>>>"+context.getRealPath("/") + "/assets/"+id);
		File f = new File(context.getRealPath("/") + "/assets/"+id);
		FileInputStream fis = null;

		if(!f.exists()){
			System.out.println("NOT FOUND : alternative path : "+context.getRealPath("/") + "/assets/not-found.png");
	    	fis = new FileInputStream(context.getRealPath("/") + "/assets/not-found.png");
		}
	    else{
	    	System.out.println("FOUND : current-path : "+context.getRealPath("/") + "/assets/"+id);
	    	fis = new FileInputStream(context.getRealPath("/") + "/assets/"+id);
	    }

	    byte[] imgByte = IOUtils.toByteArray(fis);

	    response.setHeader("Cache-Control", "no-store");
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
	    response.setContentType("image/jpeg");
	    ServletOutputStream responseOutputStream = response.getOutputStream();
	    responseOutputStream.write(imgByte);
	    responseOutputStream.flush();
	    responseOutputStream.close();
	  }
	
	@RequestMapping(value = "/fileUpload.do", method = RequestMethod.GET)
    public String dragAndDrop(Model model) {
         
        return "fileUpload";
         
    }
     
    @RequestMapping(value = "/fileUpload/post.do") //ajax에서 호출하는 부분
    @ResponseBody
    public String upload(MultipartHttpServletRequest multipartRequest) { //Multipart로 받는다.
         
        Iterator<String> itr =  multipartRequest.getFileNames();
         
        while (itr.hasNext()) { //받은 파일들을 모두 돌린다.
             
            MultipartFile mpf = multipartRequest.getFile(itr.next());
            String originFileName = mpf.getOriginalFilename();
            System.out.println("FILE_INFO: "+originFileName); //받은 파일 리스트 출력
            
            try {
				//File fileTobeUploaded = multipartToFile(mpf);
            	String uniqueID = UUID.randomUUID().toString();
            	System.out.println("UUID: "+uniqueID);
                File convFile = new File( context.getRealPath("/") + "assets/"+uniqueID);//mpf.getOriginalFilename());
                mpf.transferTo(convFile);
                
                Asset newAsset = new Asset();
                newAsset.setName(uniqueID);
                newAsset.setCategory("test");
                assetService.createAsset(newAsset);
                
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            System.out.println("+++>>>"+context.getRealPath("/") + "assets/surfing.jpg");
             
       }
         
        return "success";
    }
    
//    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException 
//    {
//    		String uniqueID = UUID.randomUUID().toString();
//            File convFile = new File( context.getRealPath("/") + "assets/"+multipart.getOriginalFilename());
//            multipart.transferTo(convFile);
//            return convFile;
//    }

}
