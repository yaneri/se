package com.yaneri.se.config;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

public class ActionBeanDefinitionParser implements BeanDefinitionParser {
	
	public static final String ID = "id";
	public static final String CLASS = "class";
	public static final String REF = "ref";
	public static final String NAME = "name";
	
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		RootBeanDefinition beanDef = new RootBeanDefinition();
		// never null since the schema requires it 
		String id = element.getAttribute(ID);
		String classname = element.getAttribute(CLASS);
		if (!(StringUtils.hasLength(classname))) {
			System.out.println("Tag 'action' must have a 'class' attribute");
			return null;
		}
		beanDef.setBeanClassName(classname);
		parseRef(element, beanDef);
		// create a bean definition holder to be able to register the
		// bean definition with the bean definition registry
		// (obtained through the ParserContext)
		BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDef, id);
		// register the BeanDefinitionHolder (which contains the bean definition)
		// with the BeanDefinitionRegistry

		BeanDefinitionReaderUtils.registerBeanDefinition(holder, parserContext.getRegistry());
		
		return beanDef;
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
}
