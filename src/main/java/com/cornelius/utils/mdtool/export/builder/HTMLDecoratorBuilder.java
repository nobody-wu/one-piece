package com.cornelius.utils.mdtool.export.builder;

import com.youbenzi.mdtool.export.Decorator;
import com.youbenzi.mdtool.export.HTMLDecorator;
import com.youbenzi.mdtool.export.builder.DecoratorBuilder;

public class HTMLDecoratorBuilder implements DecoratorBuilder {

	public Decorator build() {
		return new HTMLDecorator();
	}

}
