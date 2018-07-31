package com.gr.emp.xml.parser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import java.io.IOException;
import java.io.FileOutputStream;  
import com.gr.emp.domain.Employee;
import java.util.List;



public class EmployeeXmlParser {

	public Map<Integer, Employee> readEmployees() {	
		HashMap<Integer, Employee> empMap = new HashMap<>();
		Document doc = null;
        try {
        	File xmlFile = new File("/home/srini/greeshma/employee-service/conf/employees.xml");
        	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    doc = dBuilder.parse(xmlFile);
		    Element rootElement = doc.getDocumentElement();
		    
		    System.out.println("Root element :" + rootElement.getNodeName());
		     	      
		    ArrayList<Node> employeesChilds = getChildNodes(rootElement);
			
		    System.out.println("----------------------------");
	   

	    	for(Node nNode: employeesChilds) {
				Employee e = new Employee();
				
		    	/*System.out.println("\nCurrent Element :" + nNode.getNodeName());
				HashMap<String, String> atbrMap = getAttributes(nNode);
				for (Map.Entry<String, String> entry : atbrMap.entrySet()) {
		    		System.out.println(entry.getKey() + " = " + entry.getValue());
				}*/
		    
            	ArrayList<Node> employeeChildNodes = getChildNodes(nNode);
            
            	for (Node employeeChildNode : employeeChildNodes) {
					if(employeeChildNode.getNodeName().equals("id")) {
						e.setId(Integer.valueOf(employeeChildNode.getTextContent()));
					} else if (employeeChildNode.getNodeName().equals("name")) {
						e.setName(employeeChildNode.getTextContent());	
					}

					/*System.out.println(employeeChildNode.getNodeName() + " : " + employeeChildNode.getTextContent());
					HashMap<String, String> employeeAtbrMap = getAttributes(employeeChildNode);
					for (Map.Entry<String, String> entry : employeeAtbrMap.entrySet()) {
		    			System.out.println(entry.getKey() + " = " + entry.getValue());
					}*/
            	}
				
				
				empMap.put(e.getId(), e);
			}
		
		}  catch (Exception e) { 
	        e.printStackTrace();
	   } 
		return empMap;
		
   }















/* public static void main(String args[]) {
	saveToXML("employees.xml");
        Document doc = null;
        try {
        File xmlFile = new File("/home/srini/srinivas/employees.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    doc = dBuilder.parse(xmlFile);
	    Element rootElement = doc.getDocumentElement();
	    
	    System.out.println("Root element :" + rootElement.getNodeName());
	     	      
	    ArrayList<Node> employeesChilds = getChildNodes(rootElement);
			
	    System.out.println("----------------------------");
	   

	    for(Node nNode: employeesChilds) {
				
		    System.out.println("\nCurrent Element :" + nNode.getNodeName());
			HashMap<String, String> atbrMap = getAttributes(nNode);
			for (Map.Entry<String, String> entry : atbrMap.entrySet()) {
		    	System.out.println(entry.getKey() + " = " + entry.getValue());
			}
		    
            ArrayList<Node> employeeChildNodes = getChildNodes(nNode);
            
            for (Node employeeChildNode : employeeChildNodes) {

                System.out.println(employeeChildNode.getNodeName() + " : " + employeeChildNode.getTextContent());
				HashMap<String, String> employeeAtbrMap = getAttributes(employeeChildNode);
				for (Map.Entry<String, String> entry : employeeAtbrMap.entrySet()) {
		    		System.out.println(entry.getKey() + " = " + entry.getValue());
				}
            }

		}
		
		}  catch (Exception e) { 
	        e.printStackTrace();
	   }
}*/

    private static ArrayList<Node> getChildNodes(Node parentNode) {
           ArrayList<Node> aList = new ArrayList<>();
           NodeList childNodeList = parentNode.getChildNodes();
           for(int c=0;c<childNodeList.getLength();c++) {
                Node childNode = childNodeList.item(c);
                 if (childNode.getNodeType() == Node.ELEMENT_NODE)
                    aList.add(childNode);
           }
           return aList;
    }
   private static HashMap<String, String> getAttributes(Node node) {
		HashMap<String, String> atbrMap = new HashMap<>();
		if(node.hasAttributes()) {
			 NamedNodeMap nMap = node.getAttributes();
			 for(int j=0;j<nMap.getLength();j++) {
		            Node atbrNode = nMap.item(j);
					if(atbrNode.getNodeType() == Node.ATTRIBUTE_NODE)
						atbrMap.put(atbrNode.getNodeName(), atbrNode.getTextContent());
		     }
		}
		return atbrMap;
	}

private static Element createEmpElement(Document dom,String type,String id,String name) {
	Element e = dom.createElement("employee");
		
	e.setAttribute("type", type);
	Element childEle = dom.createElement("id");
	childEle.appendChild(dom.createTextNode(id));	
	e.appendChild(childEle);
		
	childEle = dom.createElement("name");
	childEle.appendChild(dom.createTextNode(name));	
	e.appendChild(childEle);
	
	return e;
}

public void saveToXML(List<Employee> eList) {
    Document dom;
    Element e = null;

    // instance of a DocumentBuilderFactory
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    try {
        // use factory to get an instance of document builder
        DocumentBuilder db = dbf.newDocumentBuilder();
        // create instance of DOM
        dom = db.newDocument();

        // create the root element
        Element rootEle = dom.createElement("employees");

        // create data elements and place them under root
        /*e = dom.createElement("employee");
		
		e.setAttribute("type", "fulltime");
		Element childEle = null;
		childEle = dom.createElement("id");
		childEle.appendChild(dom.createTextNode("111"));	
		e.appendChild(childEle);
		
		childEle = dom.createElement("name");
		childEle.appendChild(dom.createTextNode("srini"));	
		e.appendChild(childEle);*/
		
		for(Employee emp: eList) {
			rootEle.appendChild(createEmpElement(dom, "fulltime", String.valueOf(emp.getId()), emp.getName()));
		}

		/*e = dom.createElement("employee");
        e.setAttribute("type", "parttime");

		childEle = dom.createElement("id");
		childEle.appendChild(dom.createTextNode("222"));	
		e.appendChild(childEle);
		
		childEle = dom.createElement("name");
		childEle.appendChild(dom.createTextNode("gree"));	
		e.appendChild(childEle);*/

		//rootEle.appendChild(createEmpElement(dom, "parttime", "222", "gree"));
		//rootEle.appendChild(createEmpElement(dom, "parttime", "333", "meena"));

        dom.appendChild(rootEle);

        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
           // tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
           tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // send DOM to file
            tr.transform(new DOMSource(dom), 
                                 new StreamResult(new FileOutputStream("/home/srini/greeshma/employee-service/conf/employees.xml")));

        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    } catch (ParserConfigurationException pce) {
        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
    }
}
}

