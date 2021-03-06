/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.wicket.jquery.ui.plugins.sfmenu;

import java.util.Collections;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.lang.Args;
import org.apache.wicket.util.reference.ClassReference;

/**
 * Base class for {@link SfMenuItem} item, adapted for Superfish
 *
 * @author Ludger Kluitmann - JavaLuigi
 * @author Sebastien Briquet - sebfz1
 * @since 6.12.0
 */
public abstract class AbstractSfMenuItem implements ISfMenuItem
{
	private static final long serialVersionUID = 1L;

	private IModel<String> title;
	private boolean enabled = true;

	private final ClassReference<? extends Page> pageClassReference;

	/**
	 * Constructor
	 *
	 * @param title {@link IModel} that represent the title of the menu-item
	 */
	public AbstractSfMenuItem(IModel<String> title)
	{
		this.title = title;
		this.pageClassReference = null;
	}

	/**
	 * Constructor
	 *
	 * @param title {@link IModel} that represent the title of the menu-item
	 * @param pageClass the class of the page to redirect to, when menu-item is clicked
	 */
	public AbstractSfMenuItem(IModel<String> title, Class<? extends Page> pageClass)
	{
		Args.notNull(pageClass, "pageClass");

		this.title = title;
		this.pageClassReference = ClassReference.of(pageClass);
	}

	@Override
	public IModel<String> getTitle()
	{
		return this.title;
	}

	/**
	 * Sets the menu-item title
	 *
	 * @param title the menu-item title
	 */
	public void setTitle(IModel<String> title)
	{
		this.title = title;
	}

	@Override
	public List<ISfMenuItem> getItems()
	{
		return Collections.emptyList();
	}

	@Override
	public boolean isEnabled()
	{
		return this.enabled;
	}

	/**
	 * Indicated whether the menu-item is enabled
	 *
	 * @param enabled
	 */
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	/***
	 * Get the page class registered with the link
	 *
	 * @return the page class
	 */
	@Override
	public Class<? extends Page> getPageClass()
	{
		if (this.pageClassReference != null)
		{
			return this.pageClassReference.get();
		}

		return null;
	}
}
