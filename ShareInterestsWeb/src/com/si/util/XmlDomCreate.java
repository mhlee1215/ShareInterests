package com.si.util;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

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

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;

public class XmlDomCreate {
	public static String number_property_strings[] = {"id", "seq_no", "id_contact"};
	public static ArrayList<String> number_property_list= new ArrayList<String>();
	
	public static String number_str_strings[] = {"price", "min", "max"};
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
		
		public QueryParams(){
			this.query_start_str = "query_start";
			this.query_number_str = "query_number";
			this.alias = "a";
		}
	}
	
	public static void main(String argv[]) {
 
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
		params = new QueryParams();
		params.name = "Article";
		params.className = "com.si.domain.Article";
		params.columns = "`id`, `authorId`, `hobbyId`, `date`, `priceMin`, `priceMax`, `description`";
		params.extra_columns = "";
		params.orderStr = "";
		
		//params = new QueryParams();
		//params.name = "User";
		//params.className = "com.respace.domain.RS_User";
		//params.columns = "`name`, `email`, `password`, `registereddate`, `deleteddate`, `verifieddate`, `status`, `isverified`, `isdeleted`, `type`";
		//params.orderStr = "";
		
		String classDomain = genClassDomain(params);
		String sqlMapXml = genSqlXML(params);
//		System.out.println(classDomain);
		System.out.println(sqlMapXml);
		//System.out.println(genClassDomain(params.columns.replace("`",  "")));
	}
	
	public static String genClassDomain(QueryParams params){
		String columns = params.columns.replace("`", "");
		String ex_columns = params.extra_columns;
		
		String resultStr = "int id = 0;";
		
		String[] cvs_parts = columns.split(",");
		for (String p : cvs_parts){
			resultStr += "String "+p+" = \"\";";
		}
		for (String p : class_basic_strings_list){
			resultStr += "int "+p+" = 0;";
		}
		String[] ex_cvs_parts = ex_columns.split(",");
		for (String p : ex_cvs_parts){
			if(!p.isEmpty())
				resultStr += "String "+p+" = \"\";";
		}
		
		return resultStr;
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
					p_id.setValue(p.toLowerCase().trim());
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
				if (i == 0)
					select_columns = alias+"."+cvs_parts[i].trim();
				else 
					select_columns += ", "+alias+"."+cvs_parts[i].trim();
			}
			
			for (int i = 0 ; i < ex_cvs_parts.length ; i++){
				select_columns += ", '' "+ex_cvs_parts[i].trim();
			}
			
			String select_read_list_text = "";
			select_read_list_text += "/*select read list "+name+"*/";
			select_read_list_text += "SELECT "+alias+".id,"+select_columns+" FROM "+name.toLowerCase()+" "+alias+" WHERE 1=1";
			select_read_list.setTextContent(select_read_list_text);
			for (String p : cvs_parts){
//				System.out.println("++"+p);
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
				isnotnull2.setTextContent(" and "+alias+"."+p.toUpperCase()+" = #"+p.toLowerCase()+"#");
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
			select_read_text += "/*select read "+name+"*/";
			select_read_text += "SELECT "+alias+".id,"+select_columns+" FROM "+name.toLowerCase()+" "+alias+" WHERE 1=1 ";
			
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
				isnotnull2.setTextContent(" and "+alias+"."+p.toUpperCase()+" = #"+p.toLowerCase()+"#");
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
				if(cvs_parts[i].toLowerCase().contains("date") || cvs_parts[i].toLowerCase().contains("id"))
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
				if(cvs_parts[i].toLowerCase().contains("date") || cvs_parts[i].toLowerCase().contains("date"))
					continue;
				String p = cvs_parts[i].trim();
				if( sharp_p_added == 0)
					sharp_p += "#"+p.toLowerCase()+"#";
				else
					sharp_p += ", #"+p.toLowerCase()+"#";
				sharp_p_added++;
			}
			
			String insert_text = "";
			insert_text += "/* insert "+name+"*/";
			insert_text += "INSERT INTO "+name.toLowerCase()+"("+insert_columns+") VALUES ("+sharp_p+")";
			insert.setTextContent(insert_text);
			
			Element select_key = null;
			
			select_key = doc.createElement("selectKey");
			select_key.setAttribute("type", "post");
			select_key.setAttribute("resultClass", "int");
			select_key.setAttribute("keyProperty", "id");
			
							
			select_key.setTextContent("SELECT max(id) FROM "+name.toLowerCase());
			insert.appendChild(select_key);
			
			Element update = doc.createElement("update");
			sqlMap.appendChild(update);
			update.setAttribute("parameterClass", className);
			update.setAttribute("id", "update"+name);
			
			String update_text = "";
			update_text += "/* update "+name+"*/";
			update_text += "update" +" "+name.toLowerCase()+" SET ID = #id#";
			
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
					isnotnull2.setTextContent(","+p.toUpperCase()+" = #"+p.toLowerCase()+"#");
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
			delete_text += "/*delete "+name+"*/";
			delete_text += "delete FROM "+""+name.toLowerCase()+" WHERE 1=1";
			
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
				isnotnull2.setTextContent(" and "+p.toUpperCase()+" = #"+p.toLowerCase()+"#");
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
			count_text += "/*count "+name+"*/";
			count_text += "SELECT count(*) FROM "+""+name.toLowerCase()+" "+alias+" WHERE 1=1";
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
				isnotnull2.setTextContent(" and "+alias+"."+p.toUpperCase()+" = #"+p.toLowerCase()+"#");
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