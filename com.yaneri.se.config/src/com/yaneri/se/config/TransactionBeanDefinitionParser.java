package com.yaneri.se.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

public class TransactionBeanDefinitionParser implements BeanDefinitionParser {
	
	public static final String ID = "id";
	public static final String TEMPLATE = "template";
	public static final String DESCRIPTION = "description";
	public static final String ACTION = "action";
	public static final String FIELDS = "fields";
	public static final String FIELD = "field";
	public static final String REF = "ref";
	public static final String NAME = "name";
	public static final String CHANNEL = "channel";
	public static final String TYPE = "type";
	public static final String PATH = "path";
	public static final String HTTP = "http";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String JSON = "json";
	
	public static final String DEFAULT_CLASS = "com.insight.ix.http.core.IxConfigImpl";
	
	private String classname = null;
	
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		RootBeanDefinition beandef = new RootBeanDefinition();
		// never null since the schema requires it 
		String id = element.getAttribute(ID);
		if(classname == null || classname.isEmpty())
			classname = DEFAULT_CLASS;
		beandef.setBeanClassName(classname);
		
		parseTemplate(element, beandef);
		beandef.setDescription(DomUtils.getChildElementValueByTagName(element, DESCRIPTION));
		parseAction(element, beandef);
		parseFields(element, beandef, parserContext);
		parseChannel(element, beandef);
		BeanDefinitionHolder holder = new BeanDefinitionHolder(beandef, id);
		// register the BeanDefinitionHolder (which contains the bean definition)
		// with the BeanDefinitionRegistry
		BeanDefinitionReaderUtils.registerBeanDefinition(holder, parserContext.getRegistry());
		
		return beandef;
	}
	
	public void parseRef(Element element, RootBeanDefinition beandef) {
		List<Element> refs = DomUtils.getChildElementsByTagName(element, REF);
		if (refs == null) {
			return;
		}
		String name = null;
		String value = null;
		for (Element ele : refs) {
			name = ele.getAttribute(NAME);
			value = DomUtils.getTextValue(ele);
			if(name == null) {
				System.out.println("Tag 'ref' must have a 'name' attribute");
				return;
			}
			beandef.getPropertyValues().add(name, new RuntimeBeanReference(value));
		}
	}
	
	public void parseTemplate(Element element, RootBeanDefinition beandef) {
		String template = element.getAttribute(TEMPLATE);
		if (!(StringUtils.hasLength(template))) {
			System.out.println("Tag 'transaction' must have a 'template' attribute");
			return;
		}
		beandef.getPropertyValues().add(TEMPLATE, new RuntimeBeanReference(template));
	}

	public void parseAction(Element element, RootBeanDefinition beandef) {
		Element ele = DomUtils.getChildElementByTagName(element, ACTION);
		if (ele == null) {
			return;
		}
		String action = ele.getAttribute(REF);
		if (!(StringUtils.hasLength(action))) {
			System.out.println("Tag 'action' must have a 'ref' attribute");
			return;
		}
		beandef.getPropertyValues().add(ACTION, new RuntimeBeanReference(action));
	}

	public void parseFields(Element element, RootBeanDefinition beandef, ParserContext parserContext) {
		Element fieldsele = DomUtils.getChildElementByTagName(element, FIELDS);
		if (fieldsele == null) {
			return;
		}
		List<Element> fieldlist = DomUtils.getChildElementsByTagName(fieldsele, FIELD);
		if (fieldlist.size() == 0) {
			return;
		}
		Map<String, RuntimeBeanReference> fields = new ManagedMap<String, RuntimeBeanReference>();
		String fieldname = null;
		for (Element field : fieldlist) {
			fieldname = field.getAttribute(NAME);
			if (!(StringUtils.hasLength(fieldname))) {
				System.out.println("Tag 'field' must have a 'name' attribute");
				return;
			}
			if("".equals(DomUtils.getTextValue(field))){
				fields.put(fieldname, null);
			} else {
				fields.put(fieldname, new RuntimeBeanReference(DomUtils.getTextValue(field)));
			}
		}
		beandef.getPropertyValues().addPropertyValue(FIELDS, fields);
	}

	public void parseChannel(Element element, RootBeanDefinition beandef) {
		List<Element> channels = DomUtils.getChildElementsByTagName(element, CHANNEL);
		Map<String, Map<String, String>> channel = new HashMap<String, Map<String, String>>();
		Map<String, String> path = null;
		List<Element> paraele = null;
		String type = null;
		String name = null;
		String value = null;
		if(channels == null || channels.size() == 0) {
			path = new HashMap<String, String>();
			path.put(SUCCESS, JSON);
			channel.put(HTTP, path);
		} else {
			for (Element ch : channels) {
				type = ch.getAttribute(TYPE);
				if(type == null)
					type = HTTP;
				paraele = DomUtils.getChildElementsByTagName(ch, PATH);
				if(paraele.size() == 0) {
					System.out.println("Tag 'channel' must have a 'para' element");
					return;
				}
				path = new HashMap<String, String>();
				for (Element pa : paraele) {
					name = pa.getAttribute(NAME);
					value = DomUtils.getTextValue(pa);
					if (!(StringUtils.hasLength(name))) {
						System.out.println("Tag 'para' must have a 'name' attribute");
						return;
					}
					if (!(StringUtils.hasLength(value))) {
						System.out.println("Tag 'para' must have a node value");
						return;
					}
					path.put(name, value);
				}
				channel.put(type, path);
			}
		}
		beandef.getPropertyValues().addPropertyValue(CHANNEL, channel);
	}
	
	public void setBeanClassName(String name){
		this.classname = name;
	}
}
