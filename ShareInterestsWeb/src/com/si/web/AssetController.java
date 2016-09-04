package com.si.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
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
import com.si.domain.Category;
import com.si.domain.User;
import com.si.service.ArticleService;
import com.si.service.CategoryService;
import com.si.service.UserService;




@Controller

//@RequestMapping("/test")
public class AssetController {
	private Logger logger = Logger.getLogger(getClass());

	//	@Autowired
	//	private final UserService userService = null;
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


	@ResponseBody
	@RequestMapping(value = "/assets/get.do", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> testphoto() throws IOException {
	    //InputStream in = context.getResourceAsStream("classpath:images/123.jpg");
		System.out.println("+++>>>"+context.getRealPath("/") + "/assets/surfing.jpg");
	    FileInputStream fis = new FileInputStream(context.getRealPath("/") + "/assets/surfing.jpg");
	    byte[] image = IOUtils.toByteArray(fis);
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
	    headers.setContentLength(image.length);
	    
	    return new ResponseEntity<>(image, headers, HttpStatus.OK);
	}
	

}
