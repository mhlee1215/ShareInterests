package com.si.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;

import com.si.dao.CategoryDao;

public class XmlDomCreate {
	public static String number_property_strings[] = {"id", "seq_no", "id_contact", "level"};
	public static ArrayList<String> number_property_list= new ArrayList<String>();
	
	public static String number_str_strings[] = {"price", "min", "max", "level", "hour", "id"};
	public static ArrayList<String> number_str_list= new ArrayList<String>();
	
	public static String date_update_in_update_strings[] = {"modifieddate"};
	public static ArrayList<String> date_update_in_update_list= new ArrayList<String>();
	
	public static String date_update_only_insert_strings[] = {"registereddate"};
	public static ArrayList<String> date_update_only_insert_list= new ArrayList<String>();
	
	public static String class_basic_strings[] = {"query_start", "query_number"};
	public static ArrayList<String> class_basic_strings_list= new ArrayList<String>();

	
	static class QueryParams{
		String name;
		String className;
		String columns;
		String extra_columns;
		String orderStr;
		String query_start_str;
		String query_number_str;
		String alias;
		String packageName;
		
		public QueryParams(){
			this.query_start_str = "query_start";
			this.query_number_str = "query_number";
			this.alias = "a";
		}
	}
	
	public static void main(String argv[]) {
		System.out.println(getFirstUpper("abc"));
		for(int i = 0 ; i < number_property_strings.length ; i++)
			number_property_list.add(number_property_strings[i]);
		
		for(int i = 0 ; i < date_update_in_update_strings.length ; i++)
			date_update_in_update_list.add(date_update_in_update_strings[i]);
		
		for(int i = 0 ; i < date_update_only_insert_strings.length ; i++)
			date_update_only_insert_list.add(date_update_only_insert_strings[i]);
		
		for(int i = 0 ; i < class_basic_strings.length ; i++)
			class_basic_strings_list.add(class_basic_strings[i]);
		
		for(int i = 0 ; i < number_str_strings.length ; i++)
			number_str_list.add(number_str_strings[i]);
		
		QueryParams params = null;

//		params = new QueryParams();
//		params.name = "Code";
//		params.className = "com.respace.domain.RS_Code";
//		params.columns = "`code`, `name`, `category`, `seq_no`";
//		params.orderStr = "seq_no";
//		
//		params = new QueryParams();
//		params.name = "Project";
//		params.className = "com.respace.domain.RS_Project";
//		params.columns = "`id_contact`, `title`, `host_name`, `description`, `code_category`";
//		params.orderStr = "";
		
		//params = new QueryParams();
		//params.name = "Article";
		//params.className = "com.respace.domain.RS_Article";
		//params.columns = "`title`, `author`, `email`, `website`, `content`, `category`, `isvalid`, `modifieddate`, `registereddate`";
		
		//params = new QueryParams();
//		params.name = "Asset";
//		params.className = "com.respace.domain.RS_Asset";
//		params.columns = "`reference_id`, `reference_category`, `name`, `url`, `type`, `seq_no`, `registered_date`, `filename`, `filetype`, `filesize`, `modified_date`, `filepath`, `code_status`, `etc`";
//		params.orderStr = "seq_no";
//		
		List<QueryParams> qList = new ArrayList<QueryParams>();
		
		params = new QueryParams();
		params.name = "Category";
		params.packageName = "com.si.domain";
		params.className = params.packageName+"."+params.name;
		params.columns = "`id`, `name`";
		params.extra_columns = "";
		params.orderStr = "";
		qList.add(params);
		
		params = new QueryParams();
		params.name = "Hobby";
		params.packageName = "com.si.domain";
		params.className = params.packageName+"."+params.name;
		params.columns = "`id`, `title`, `categoryId`";
		params.extra_columns = "";
		params.orderStr = "";
		qList.add(params);
		
		params = new QueryParams();
		params.name = "Article";
		params.packageName = "com.si.domain";
		params.className = params.packageName+"."+params.name;
		params.columns = "`id`, `authorId`, `hobbyId`, `date`, `priceMin`, `priceMax`, `description`, `practiceHour`";
		params.extra_columns = "";
		params.orderStr = "";
		qList.add(params);
		
		params = new QueryParams();
		params.name = "Difficulty";
		params.packageName = "com.si.domain";
		params.className = params.packageName+"."+params.name;
		params.columns = "`id`, `articleId`, `level`";
		params.extra_columns = "";
		params.orderStr = "";
		qList.add(params);
		
		params = new QueryParams();
		params.name = "Comment";
		params.packageName = "com.si.domain";
		params.className = params.packageName+"."+params.name;
		params.columns = "`id`, `userId`, `articleId`, `description`";
		params.extra_columns = "";
		params.orderStr = "";
		qList.add(params);
		
		params = new QueryParams();
		params.name = "Asset";
		params.packageName = "com.si.domain";
		params.className = params.packageName+"."+params.name;
		params.columns = "`id`, `name`, `category`";
		params.extra_columns = "";
		params.orderStr = "";
		qList.add(params);
		
		params = new QueryParams();
		params.name = "Feedback";
		params.packageName = "com.si.domain";
		params.className = params.packageName+"."+params.name;
		params.columns = "`id`, `userId`, `articleId`";
		params.extra_columns = "";
		params.orderStr = "";
		qList.add(params);
		
		params = new QueryParams();
		params.name = "Media";
		params.packageName = "com.si.domain";
		params.className = params.packageName+"."+params.name;
		params.columns = "`id`, `articleId`, `type`, `url`";
		params.extra_columns = "";
		params.orderStr = "";
		qList.add(params);
		
		params = new QueryParams();
		params.name = "Hashtag";
		params.packageName = "com.si.domain";
		params.className = params.packageName+"."+params.name;
		params.columns = "`id`, `articleId`, `name`";
		params.extra_columns = "";
		params.orderStr = "";
		qList.add(params);
		
		params = new QueryParams();
		params.name = "Bookmark";
		params.packageName = "com.si.domain";
		params.className = params.packageName+"."+params.name;
		params.columns = "`id`, `userId`, `hobbyId`";
		params.extra_columns = "";
		params.orderStr = "";
		qList.add(params);
		
		
		//params = new QueryParams();
		//params.name = "User";
		//params.className = "com.respace.domain.RS_User";
		//params.columns = "`name`, `email`, `password`, `registereddate`, `deleteddate`, `verifieddate`, `status`, `isverified`, `isdeleted`, `type`";
		//params.orderStr = "";
		
		for(QueryParams qp : qList)
			writeFiles(qp);
//		String classDomain = genClassDomain(params);
//		String sqlMapXml = genSqlXML(params);
////		System.out.println(classDomain);
//		System.out.println(sqlMapXml);
		//System.out.println(genClassDomain(params.columns.replace("`",  "")));
	}
	
	public static void writeFiles(QueryParams params){
//		String classDomain = genClassDomain(params);
//		String sqlMapXml = genSqlXML(params);
		
		{
			String path = "autoGen/src/com/si/domain";
			boolean isMade = new File(path).mkdirs();
			File f = new File(path+"/"+params.name+".java");
			writeFile(f, genClassDomain(params));
		}
		
		{
			String path = "autoGen/src/com/si/dao";
			boolean isMade = new File(path).mkdirs();
			File f = new File(path+"/"+params.name+"Dao.java");
			writeFile(f, genDao(params));
		}
		
		{
			String path = "autoGen/src/com/si/service";
			boolean isMade = new File(path).mkdirs();
			File f = new File(path+"/"+params.name+"Service.java");
			writeFile(f, genService(params));
		}
		
		{
			String path = "autoGen/src/query";
			boolean isMade = new File(path).mkdirs();
			File f = new File(path+"/"+params.name+"Sql.xml");
			writeFile(f, genSqlXML(params).replaceAll("UTF-16", "UTF-8"));
		}
	}
	
	public static String genDao(QueryParams params){
		String result = "";
		String indent = "";
		
		String C = params.name;
		String c = C.toLowerCase();
		
		result += indent +"package com.si.dao;\n";

		result += indent +"import java.util.List;\n";
		result += indent +"import javax.annotation.Resource;\n";
		result += indent +"import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;\n";
		result += indent +"import org.springframework.stereotype.Repository;\n";
		result += indent +"import com.ibatis.sqlmap.client.SqlMapClient;\n";
		result += indent +"import com.si.domain."+C+";\n\n";

		result += indent +"@Repository\n";
		result += indent +"public class "+C+"Dao extends SqlMapClientDaoSupport{\n\n";
			
		indent = "\t";
		result += indent +"@Resource(name=\"sqlMapClient\")\n";
		result += indent +"protected void initDAO(SqlMapClient sqlMapClient) {\n";        
		result += indent +"\tthis.setSqlMapClient(sqlMapClient);\n";
		result += indent +"}\n\n"; 
			
			
		result += indent +"@SuppressWarnings(\"unchecked\")\n";
		
		result += indent +"public List<"+C+"> read"+C+"List("+C+" "+c+") {\n";	
		result += indent +"\tList<"+C+"> array = getSqlMapClientTemplate().queryForList(\""+C+"Sql.read"+C+"List\", "+c+");\n";
		result += indent +"\treturn array;\n";
		result += indent +"}\n\n";


		result += indent +"public "+C+" read"+C+"("+C+" "+c+") {\n";
		result += indent +"\treturn ("+C+")getSqlMapClientTemplate().queryForObject(\""+C+"Sql.read"+C+"\", "+c+");\n";
		result += indent +"}\n\n";


		result += indent +"public void create"+C+"("+C+" "+c+") {\n";
		result += indent +"\tgetSqlMapClientTemplate().insert(\""+C+"Sql.create"+C+"\", "+c+");\n";
		result += indent +"}\n\n";


		result += indent +"public void delete"+C+"("+C+" "+c+") {\n";
		result += indent +"\tgetSqlMapClientTemplate().delete(\""+C+"Sql.delete"+C+"\", "+c+");\n";
		result += indent +"}\n\n";


		result += indent +"public void update"+C+"("+C+" "+c+") {\n";
		result += indent +"\tgetSqlMapClientTemplate().update(\""+C+"Sql.update"+C+"\", "+c+");\n";
		result += indent +"}\n";
		
		indent = "";
		result += indent +"}\n";

		
		
		return result;
	}
	
	public static String genService(QueryParams params){
		String result = "";
		String indent = "";
		
		String C = params.name;
		String c = C.toLowerCase();
		
		result += indent +"package com.si.service;\n\n";

		result += indent +"import java.util.HashMap;\n";
		result += indent +"import java.util.List;\n";
		result += indent +"import java.util.Map;\n";
		result += indent +"import org.apache.log4j.Logger;\n";
		result += indent +"import org.springframework.beans.factory.annotation.Autowired;\n";
		result += indent +"import org.springframework.stereotype.Service;\n";
		result += indent +"import com.si.dao."+C+"Dao;\n";
		result += indent +"import com.si.domain."+C+";\n\n";

		result += indent +"@Service\n";
		result += indent +"public class "+C+"Service{\n";
		
		indent = "\t";
		result += indent +"private Logger logger = Logger.getLogger(getClass());\n\n";
		result += indent +"@Autowired\n";
		result += indent +"private "+C+"Dao "+c+"Dao;\n\n";
		result += indent +"public List<"+C+"> read"+C+"List("+C+" "+c+") {\n";	
		result += indent +"\treturn "+c+"Dao.read"+C+"List("+c+");\n";
		result += indent +"}\n\n";
		
		result += indent +"public "+C+" read"+C+"("+C+" "+c+") {\n";
		result += indent +"\treturn "+c+"Dao.read"+C+"("+c+");\n";
		result += indent +"}\n\n";


		result += indent +"public void create"+C+"("+C+" "+c+") {\n";
		result += indent +"\t"+c+"Dao.create"+C+"("+c+");\n";
		result += indent +"}\n\n";

		result += indent +"public void delete"+C+"("+C+" "+c+") {\n";
		result += indent +"\t"+c+"Dao.delete"+C+"("+c+");\n";
		result += indent +"}\n\n";

		result += indent +"public void update"+C+"("+C+" "+c+") {\n";
		result += indent +"\t"+c+"Dao.update"+C+"("+c+");\n";
		result += indent +"}\n\n";
		indent = "";
		result += indent +"}\n";

		return result;
	}
	
	public static void writeFile(File f, String s){
		try {
			PrintWriter pw = new PrintWriter(f);
			pw.write(s);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String genClassDomain(QueryParams params){
		String columns = params.columns.replace("`", "").replace("'", "");
		String ex_columns = params.extra_columns;
		
		String resultStr = "";
		String indent = "";
		
		resultStr += indent + "package "+ params.packageName+";\n\n";
		resultStr += indent + "public class "+params.name+"{\n";
		
		indent = "\t";
		//resultStr += indent + "int id = 0;\n";
		
		List<String> typeList = new ArrayList<String>();
		List<String> nameList = new ArrayList<String>();
		
		String[] cvs_parts = columns.split(",");
		for (String p : cvs_parts){
			//if("id".equals(p)) continue;
			
			String type = "";
			
			if(XmlDomCreate.isNumberProperty(p)){
				type = "int";
				resultStr += indent + type + " "+p+" = 0;\n";
			}
			else{
				type = "String";
				resultStr += indent + type + " "+p+" = \"\";\n";
			}
			
			
			
			typeList.add(type);
			nameList.add(p.trim());
			
		}
		for (String p : class_basic_strings_list){
			resultStr += indent + "int "+p+" = 0;\n";
			typeList.add("int");
			nameList.add(p);

		}
		String[] ex_cvs_parts = ex_columns.split(",");
		for (String p : ex_cvs_parts){
			if(!p.isEmpty()){
				resultStr += indent + "String "+p+" = \"\";\n";

				typeList.add("String");
				nameList.add(p);
			}
		}
		
		
		resultStr += indent + "\n";
		
		for(int i = 0 ; i < typeList.size() ; i++){
			String tt = typeList.get(i);
			String nn = nameList.get(i);
			
			resultStr += indent + "public "+tt+" get"+getFirstUpper(nn)+"(){\n";
			resultStr += indent + "\treturn "+nn+";\n";
			resultStr += indent + "}\n";
			
			resultStr += indent + "public void set"+getFirstUpper(nn)+"("+tt+" "+nn+"){\n";
			resultStr += indent + "\tthis."+nn+" = "+nn+";\n";
			resultStr += indent + "}\n\n";
		}
		
		
		resultStr += indent + "public String toString() {\n";
		
		resultStr += indent + "\treturn \"{";
		for(int i = 0 ; i < nameList.size() ; i++){
			String nn = nameList.get(i);
			if( i > 0) resultStr += ",";
			resultStr += "\\\""+nn+"\\\":\\\"\" + "+nn+" + \"\\\"";
		}
		resultStr += "}\";\n";
		resultStr += indent + "}\n\n";
		
		
		
		
		indent = "";
		resultStr += indent + "}";
		
		return resultStr;
	}
	
	public static String getFirstUpper(String a){
		System.out.println("???:"+a);
		String result = a.substring(0, 1).toUpperCase()+a.substring(1);
		return result;
	}

	public static String genSqlXML(QueryParams params) {
		String name = params.name;
		String className = params.className;
		String columns = params.columns.replace("`", "");
		String ex_columns = params.extra_columns.replace("`", "");
		String orderStr = params.orderStr;
		String alias = params.alias;
		String query_start = params.query_start_str;
		String query_number = params.query_number_str;
		
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			
			DOMImplementation domImpl = doc.getImplementation();
			DocumentType doctype = domImpl.createDocumentType("sqlMap",
			    "-//ibatis.apache.org//DTD SQL Map 2.0//EN",
			    "http://ibatis.apache.org/dtd/sql-map-2.dtd");
					
			doc.appendChild(doctype);	
			
					
			Element sqlMap = doc.createElement("sqlMap");
			doc.appendChild(sqlMap);
			sqlMap.setAttribute("namespace", name+"Sql");
			
				Element resultMap = doc.createElement("resultMap");
				sqlMap.appendChild(resultMap);
				
				resultMap.setAttribute("id", name);
				resultMap.setAttribute("class", className);
				
//				{
//					Element result = doc.createElement("result");
//					resultMap.appendChild(result);
//					Attr p_id = doc.createAttribute("property");
//					p_id.setValue("id");
//					result.setAttributeNode(p_id);
//					Attr property = doc.createAttribute("column");
//					property.setValue("ID");
//					result.setAttributeNode(property);
//				}
				String[] cvs_parts = columns.split(",");
				for (String p : cvs_parts){
					if(p.isEmpty()) continue;
					System.out.println(">>"+p);
					Element result = doc.createElement("result");
					resultMap.appendChild(result);
					Attr p_id = doc.createAttribute("property");
					p_id.setValue(p.trim());
					result.setAttributeNode(p_id);
					Attr property = doc.createAttribute("column");
					property.setValue(p.toUpperCase().trim());
					result.setAttributeNode(property);
				}
				
				String[] ex_cvs_parts = ex_columns.split(",");
				for (String p : ex_cvs_parts){
					if(p.isEmpty()) continue;
//					System.out.println(">>"+p);
					Element result = doc.createElement("result");
					resultMap.appendChild(result);
					Attr p_id = doc.createAttribute("property");
					p_id.setValue(p.toLowerCase().trim());
					result.setAttributeNode(p_id);
					Attr property = doc.createAttribute("column");
					property.setValue(p.toUpperCase().trim());
					result.setAttributeNode(property);
				}
				
			
			/**
			 * SELECT LIST
			 * **/
			Element select_read_list = doc.createElement("select");
			sqlMap.appendChild(select_read_list);
			select_read_list.setAttribute("parameterClass", className);
			select_read_list.setAttribute("resultMap", name);
			select_read_list.setAttribute("id", "read"+name+"List");
			
			String select_columns = "";
			for (int i = 0 ; i < cvs_parts.length ; i++){
				if(cvs_parts[i].trim().length() == 0) continue;
				
				if (i == 0)
					select_columns = alias+"."+cvs_parts[i].trim();
				else 
					select_columns += ", "+alias+"."+cvs_parts[i].trim();
			}
			
			for (int i = 0 ; i < ex_cvs_parts.length ; i++){
				if(ex_cvs_parts[i].trim().length() == 0) continue;
				select_columns += ", '' "+ex_cvs_parts[i].trim();
			}
			
			String select_read_list_text = "";
			select_read_list_text += "\n\t\t/*select read list "+name+"*/";
			select_read_list_text += "\n\t\tSELECT "+select_columns+" FROM "+name.toLowerCase()+" "+alias+" WHERE 1=1\n\t\t";
			select_read_list.setTextContent(select_read_list_text);
			for (String p : cvs_parts){
//				System.out.println("++"+p);
				p = p.trim();
				Element isnotnull2 = null;
				System.out.println("["+p+"]:"+isNumberProperty(p));
				if(isNumberProperty(p)){
					isnotnull2 = doc.createElement("isNotEqual");
					isnotnull2.setAttribute("property", p);
					isnotnull2.setAttribute("compareValue", "0");
				}else{
					isnotnull2 = doc.createElement("isNotEmpty");
					isnotnull2.setAttribute("property", p);
				}
				isnotnull2.setTextContent(" and "+alias+"."+p.toUpperCase()+" = #"+p+"#");
				select_read_list.appendChild(isnotnull2);
			}
			if(orderStr.length()>0){
				Element isnotnull2 = null;
				isnotnull2 = doc.createElement("isNotEmpty");
				isnotnull2.setAttribute("property", orderStr);
				isnotnull2.setTextContent(" order by "+orderStr);
				select_read_list.appendChild(isnotnull2);
			}
			
//			Element query_start_el = null;
//			query_start_el = doc.createElement("isNotEqual");
//			query_start_el.setAttribute("compareValue", "0");
//			query_start_el.setAttribute("property", query_start);
//			query_start_el.setTextContent(" LIMIT #"+query_start+"#");
//			select_read_list.appendChild(query_start_el);
			
			Element query_count_el = null;
			query_count_el = doc.createElement("isNotEqual");
			query_count_el.setAttribute("compareValue", "0");
			query_count_el.setAttribute("property", query_number);
			query_count_el.setTextContent(" LIMIT #"+query_start+"#"+",#"+query_number+"#");
			select_read_list.appendChild(query_count_el);
			
			
			
			
			/**
			 * SELECT
			 * **/
			Element select_read = doc.createElement("select");
			sqlMap.appendChild(select_read);
			select_read.setAttribute("parameterClass", className);
			select_read.setAttribute("resultMap", name);
			select_read.setAttribute("id", "read"+name);
			
			String select_read_text = "";
			select_read_text += "\n\t\t/*select read "+name+"*/";
			select_read_text += "\n\t\tSELECT "+select_columns+" FROM "+name.toLowerCase()+" "+alias+" WHERE 1=1 \n\t\t";
			
			select_read.setTextContent(select_read_text);
			
//			{
//				Element isnotnull = doc.createElement("isNotEqual");
//				select_read.appendChild(isnotnull);
//				isnotnull.setAttribute("property", "id");
//				isnotnull.setAttribute("compareValue", "0");
//				isnotnull.setTextContent(" and "+"id".toUpperCase()+" = #"+"id"+"#");
//			}
			for (String p : cvs_parts){
				p = p.trim();
				Element isnotnull2 = null;
				if(isNumberProperty(p)){
					isnotnull2 = doc.createElement("isNotEqual");
					isnotnull2.setAttribute("property", p);
					isnotnull2.setAttribute("compareValue", "0");
				}else{
					isnotnull2 = doc.createElement("isNotEmpty");
					isnotnull2.setAttribute("property", p);
				}				
				isnotnull2.setTextContent(" and "+alias+"."+p.toUpperCase()+" = #"+p+"#");
				select_read.appendChild(isnotnull2);
			}

			
			/**
			 * INSERT
			 * **/
			Element insert = doc.createElement("insert");
			sqlMap.appendChild(insert);
			insert.setAttribute("parameterClass", className);
			insert.setAttribute("id", "create"+name);
			

			String insert_columns = "";
			int insert_columns_added = 0;
			for (int i = 0 ; i < cvs_parts.length ; i++){
				if(cvs_parts[i].toLowerCase().equals("id"))
					continue;
				if (insert_columns_added == 0)
					insert_columns = cvs_parts[i].trim();
				else 
					insert_columns += ", "+cvs_parts[i].trim();
				insert_columns_added++;
			}
			
			String sharp_p = "";
			int sharp_p_added = 0;
			for (int i = 0 ; i < cvs_parts.length ; i++){
				if(cvs_parts[i].toLowerCase().equals("id"))
					continue;
				String p = cvs_parts[i].trim();
				if( sharp_p_added == 0)
					sharp_p += "#"+p+"#";
				else
					sharp_p += ", #"+p+"#";
				sharp_p_added++;
			}
			
			String insert_text = "";
			insert_text += "\n\t\t/* insert "+name+"*/";
			insert_text += "\n\t\tINSERT INTO "+name.toLowerCase()+"("+insert_columns+") \n\t\tVALUES ("+sharp_p+")\n\t";
			insert.setTextContent(insert_text);
			
			Element select_key = null;
			
//			select_key = doc.createElement("selectKey");
//			select_key.setAttribute("type", "post");
//			select_key.setAttribute("resultClass", "int");
//			select_key.setAttribute("keyProperty", "id");
//			
//							
//			select_key.setTextContent("SELECT max(id) FROM "+name.toLowerCase());
//			insert.appendChild(select_key);
			
			Element update = doc.createElement("update");
			sqlMap.appendChild(update);
			update.setAttribute("parameterClass", className);
			update.setAttribute("id", "update"+name);
			
			String update_text = "";
			update_text += "\n\t\t/* update "+name+"*/";
			update_text += "\n\t\tupdate" +" "+name.toLowerCase()+" SET ID = #id#\n\t\t";
			
			for (String p : cvs_parts){
				p = p.trim();
				if(p.contains("date")){
					if(date_update_in_update_list.contains(p)){
						update_text += ","+p.toUpperCase()+" = CURRENT_TIMESTAMP";
					}
				}
			}
			
			update.setTextContent(update_text);
			
			for (String p : cvs_parts){
				p = p.trim();
				if(p.contains("date")){
					
				}else{
					
					Element isnotnull2 = null;
					if(isNumberProperty(p)){
						isnotnull2 = doc.createElement("isNotEqual");
						isnotnull2.setAttribute("property", p);
						isnotnull2.setAttribute("compareValue", "0");
					}else{
						isnotnull2 = doc.createElement("isNotEmpty");
						isnotnull2.setAttribute("property", p);
					}				
					isnotnull2.setTextContent(","+p.toUpperCase()+" = #"+p+"#");
					update.appendChild(isnotnull2);
				}
			}
			
			{
				Element isnotnull = doc.createElement("isNotEqual");
				update.appendChild(isnotnull);
				isnotnull.setAttribute("property", "id");
				isnotnull.setAttribute("compareValue", "0");
				isnotnull.setTextContent(" WHERE "+"id".toUpperCase()+" = #"+"id"+"#");
			}
			
			
			
			/**
			 * DELETE
			 * **/
			Element delete = doc.createElement("delete");
			sqlMap.appendChild(delete);
			delete.setAttribute("parameterClass", className);
			delete.setAttribute("id", "delete"+name);
			
			String delete_text = "";
			delete_text += "\n\t\t/*delete "+name+"*/";
			delete_text += "\n\t\tdelete FROM "+""+name.toLowerCase()+" WHERE 1=1\n\t\t";
			
			delete.setTextContent(delete_text);
			
			
//			Element isnotnull = doc.createElement("isNotEqual");
//			delete.appendChild(isnotnull);
//			isnotnull.setAttribute("property", "id");
//			isnotnull.setAttribute("compareValue", "0");
//			isnotnull.setTextContent(" and "+"id".toUpperCase()+" = #"+"id"+"#");
			for (String p : cvs_parts){
				p = p.trim();
				Element isnotnull2 = null;
				if(isNumberProperty(p)){
					isnotnull2 = doc.createElement("isNotEqual");
					isnotnull2.setAttribute("property", p);
					isnotnull2.setAttribute("compareValue", "0");
				}else{
					isnotnull2 = doc.createElement("isNotEmpty");
					isnotnull2.setAttribute("property", p);
				}
				isnotnull2.setTextContent(" and "+p.toUpperCase()+" = #"+p+"#");
				delete.appendChild(isnotnull2);
			}
			
//			{
//				isnotnull = doc.createElement("isNotEqual");
//				delete.appendChild(isnotnull);
//				isnotnull.setAttribute("property", "id");
//				isnotnull.setAttribute("compareValue", "0");
//				isnotnull.setTextContent(" WHERE "+"id".toUpperCase()+" = #"+"id"+"#");
//			}
			
			
			/**
			 * COUNT
			 * **/
			Element count = doc.createElement("select");
			sqlMap.appendChild(count);
			count.setAttribute("parameterClass", className);
			count.setAttribute("resultClass", "int");
			count.setAttribute("id", "count"+name);
			
			
			String count_text = "";
			count_text += "\n\t\t/*count "+name+"*/";
			count_text += "\n\t\tSELECT count(*) FROM "+""+name.toLowerCase()+" "+alias+" WHERE 1=1 \n\n";
			count.setTextContent(count_text);
			for (String p : cvs_parts){
				p = p.trim();
				Element isnotnull2 = null;
				if(isNumberProperty(p)){
					isnotnull2 = doc.createElement("isNotEqual");
					isnotnull2.setAttribute("property", p);
					isnotnull2.setAttribute("compareValue", "0");
				}else{
					isnotnull2 = doc.createElement("isNotEmpty");
					isnotnull2.setAttribute("property", p);
				}
				isnotnull2.setTextContent(" and "+alias+"."+p.toUpperCase()+" = #"+p+"#");
				count.appendChild(isnotnull2);
			}
			
			//System.out.println(((DOMImplementationLS) domImpl).createLSSerializer()
			//	    .writeToString(doc));

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			// StreamResult result = new StreamResult(new
			// File("D:\\workspace2\\RedJava\\WebContent\\doc\\com\\redjava\\java\\xml\\dom\\XmlDomCreate.xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			StringWriter sw = new StringWriter();
			transformer.transform(source, new StreamResult(sw));

			String xmlResult = sw.toString();
			String prettyXmlResult = prettyFormat(xmlResult, 2);

			
			String result = printXML(doc);
			//return prettyXmlResult;
			return ((DOMImplementationLS) domImpl).createLSSerializer()
				    .writeToString(doc);
			// System.out.println(prettyXmlResult);
			//return prettyXmlResult;
			// System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
		return "fail";
	}
	
	public static boolean isNumberProperty(String str){
		boolean isNumber = false;
		
		str = str.toLowerCase();
		
		if(number_property_list.contains(str))
			isNumber = true;
		else{
			for (String numberStr : number_str_list){
				if (str.contains(numberStr))
					isNumber = true;
			}
		}
		return isNumber;
	}

	public static String prettyFormat(String input, int indent) {
		try {
			Source xmlInput = new StreamSource(new StringReader(input));
			StringWriter stringWriter = new StringWriter();
			StreamResult xmlOutput = new StreamResult(stringWriter);
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			transformerFactory.setAttribute("indent-number", indent);
			Transformer transformer = transformerFactory.newTransformer();
			
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			transformer.transform(xmlInput, xmlOutput);
			return xmlOutput.getWriter().toString();
		} catch (Exception e) {
			throw new RuntimeException(e); // simple exception handling, please
											// review it
		}
	}
	
	private static boolean skipNL;
	private static String printXML(Node rootNode) {
	    String tab = "";
	    skipNL = false;
	    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+(printXML(rootNode, tab));
	}
	private static String printXML(Node rootNode, String tab) {
	    String print = "";
	    if(rootNode.getNodeType()==Node.ELEMENT_NODE) {
	        print += "\n"+tab+"<"+rootNode.getNodeName();
	        for (int i = 0 ; i < rootNode.getAttributes().getLength() ; i++){
	        	Node node = rootNode.getAttributes().item(i);
	        	print += " "+node.getNodeName()+"=\""+node.getNodeValue()+"\"";
	        }
	        if (rootNode.getTextContent().length() > 0)
	        	print += ">";
	        else
	        	print += "/>";
	    }
	    NodeList nl = rootNode.getChildNodes();
	    if(nl.getLength()>0) {
	        for (int i = 0; i < nl.getLength(); i++) {
	        	if (i==0)
	        		print += ""+printXML(nl.item(i), tab+"  ");    // \t
	        	else
	        		print += ""+printXML(nl.item(i), tab+"  ");    // \t
	        }
	    } else {
	        if(rootNode.getNodeValue()!=null) {
	            print = "\n"+tab+rootNode.getNodeValue();
	        }
	        skipNL = true;
	    }
	    if(rootNode.getNodeType()==Node.ELEMENT_NODE) {
	        if(!skipNL) {
	            print += "\n"+tab;
	            print += "</"+rootNode.getNodeName()+">";
	        }
	        
	        	
	        skipNL = false;
	        
	    }
	    return(print);
	}
}