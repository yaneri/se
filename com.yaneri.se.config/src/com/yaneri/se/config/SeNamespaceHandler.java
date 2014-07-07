package com.yaneri.se.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class SeNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		registerBeanDefinitionParser("transaction", new TransactionBeanDefinitionParser());
		registerBeanDefinitionParser("action", new ActionBeanDefinitionParser());
	}

}