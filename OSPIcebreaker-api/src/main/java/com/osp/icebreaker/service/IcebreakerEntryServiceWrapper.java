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

package com.osp.icebreaker.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link IcebreakerEntryService}.
 *
 * @author Jerry H. Seo
 * @see IcebreakerEntryService
 * @generated
 */
@ProviderType
public class IcebreakerEntryServiceWrapper
	implements IcebreakerEntryService, ServiceWrapper<IcebreakerEntryService> {

	public IcebreakerEntryServiceWrapper(
		IcebreakerEntryService icebreakerEntryService) {

		_icebreakerEntryService = icebreakerEntryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _icebreakerEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public IcebreakerEntryService getWrappedService() {
		return _icebreakerEntryService;
	}

	@Override
	public void setWrappedService(
		IcebreakerEntryService icebreakerEntryService) {

		_icebreakerEntryService = icebreakerEntryService;
	}

	private IcebreakerEntryService _icebreakerEntryService;

}