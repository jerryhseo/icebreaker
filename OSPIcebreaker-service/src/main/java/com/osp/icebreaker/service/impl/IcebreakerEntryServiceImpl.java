/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.osp.icebreaker.service.impl;

import com.liferay.portal.aop.AopService;

import com.osp.icebreaker.service.base.IcebreakerEntryServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the icebreaker entry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icebreaker.service.IcebreakerEntryService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Jerry H. Seo
 * @see IcebreakerEntryServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=icebreaker",
		"json.web.service.context.path=IcebreakerEntry"
	},
	service = AopService.class
)
public class IcebreakerEntryServiceImpl extends IcebreakerEntryServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.osp.icebreaker.service.IcebreakerEntryServiceUtil</code> to access the icebreaker entry remote service.
	 */
}