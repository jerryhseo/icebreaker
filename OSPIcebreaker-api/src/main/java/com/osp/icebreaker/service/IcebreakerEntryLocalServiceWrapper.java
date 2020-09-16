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
 * Provides a wrapper for {@link IcebreakerEntryLocalService}.
 *
 * @author Jerry H. Seo
 * @see IcebreakerEntryLocalService
 * @generated
 */
@ProviderType
public class IcebreakerEntryLocalServiceWrapper
	implements IcebreakerEntryLocalService,
			   ServiceWrapper<IcebreakerEntryLocalService> {

	public IcebreakerEntryLocalServiceWrapper(
		IcebreakerEntryLocalService icebreakerEntryLocalService) {

		_icebreakerEntryLocalService = icebreakerEntryLocalService;
	}

	/**
	 * Adds the icebreaker entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param icebreakerEntry the icebreaker entry
	 * @return the icebreaker entry that was added
	 */
	@Override
	public com.osp.icebreaker.model.IcebreakerEntry addIcebreakerEntry(
		com.osp.icebreaker.model.IcebreakerEntry icebreakerEntry) {

		return _icebreakerEntryLocalService.addIcebreakerEntry(icebreakerEntry);
	}

	/**
	 * Creates a new icebreaker entry with the primary key. Does not add the icebreaker entry to the database.
	 *
	 * @param icebreakerEntryId the primary key for the new icebreaker entry
	 * @return the new icebreaker entry
	 */
	@Override
	public com.osp.icebreaker.model.IcebreakerEntry createIcebreakerEntry(
		long icebreakerEntryId) {

		return _icebreakerEntryLocalService.createIcebreakerEntry(
			icebreakerEntryId);
	}

	/**
	 * Deletes the icebreaker entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param icebreakerEntry the icebreaker entry
	 * @return the icebreaker entry that was removed
	 */
	@Override
	public com.osp.icebreaker.model.IcebreakerEntry deleteIcebreakerEntry(
		com.osp.icebreaker.model.IcebreakerEntry icebreakerEntry) {

		return _icebreakerEntryLocalService.deleteIcebreakerEntry(
			icebreakerEntry);
	}

	/**
	 * Deletes the icebreaker entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param icebreakerEntryId the primary key of the icebreaker entry
	 * @return the icebreaker entry that was removed
	 * @throws PortalException if a icebreaker entry with the primary key could not be found
	 */
	@Override
	public com.osp.icebreaker.model.IcebreakerEntry deleteIcebreakerEntry(
			long icebreakerEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _icebreakerEntryLocalService.deleteIcebreakerEntry(
			icebreakerEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _icebreakerEntryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _icebreakerEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _icebreakerEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _icebreakerEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _icebreakerEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _icebreakerEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _icebreakerEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.osp.icebreaker.model.IcebreakerEntry fetchIcebreakerEntry(
		long icebreakerEntryId) {

		return _icebreakerEntryLocalService.fetchIcebreakerEntry(
			icebreakerEntryId);
	}

	/**
	 * Returns the icebreaker entry matching the UUID and group.
	 *
	 * @param uuid the icebreaker entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public com.osp.icebreaker.model.IcebreakerEntry
		fetchIcebreakerEntryByUuidAndGroupId(String uuid, long groupId) {

		return _icebreakerEntryLocalService.
			fetchIcebreakerEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _icebreakerEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _icebreakerEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns a range of all the icebreaker entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @return the range of icebreaker entries
	 */
	@Override
	public java.util.List<com.osp.icebreaker.model.IcebreakerEntry>
		getIcebreakerEntries(int start, int end) {

		return _icebreakerEntryLocalService.getIcebreakerEntries(start, end);
	}

	/**
	 * Returns all the icebreaker entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the icebreaker entries
	 * @param companyId the primary key of the company
	 * @return the matching icebreaker entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.osp.icebreaker.model.IcebreakerEntry>
		getIcebreakerEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _icebreakerEntryLocalService.
			getIcebreakerEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of icebreaker entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the icebreaker entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching icebreaker entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.osp.icebreaker.model.IcebreakerEntry>
		getIcebreakerEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icebreaker.model.IcebreakerEntry> orderByComparator) {

		return _icebreakerEntryLocalService.
			getIcebreakerEntriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of icebreaker entries.
	 *
	 * @return the number of icebreaker entries
	 */
	@Override
	public int getIcebreakerEntriesCount() {
		return _icebreakerEntryLocalService.getIcebreakerEntriesCount();
	}

	/**
	 * Returns the icebreaker entry with the primary key.
	 *
	 * @param icebreakerEntryId the primary key of the icebreaker entry
	 * @return the icebreaker entry
	 * @throws PortalException if a icebreaker entry with the primary key could not be found
	 */
	@Override
	public com.osp.icebreaker.model.IcebreakerEntry getIcebreakerEntry(
			long icebreakerEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _icebreakerEntryLocalService.getIcebreakerEntry(
			icebreakerEntryId);
	}

	/**
	 * Returns the icebreaker entry matching the UUID and group.
	 *
	 * @param uuid the icebreaker entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching icebreaker entry
	 * @throws PortalException if a matching icebreaker entry could not be found
	 */
	@Override
	public com.osp.icebreaker.model.IcebreakerEntry
			getIcebreakerEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _icebreakerEntryLocalService.getIcebreakerEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _icebreakerEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _icebreakerEntryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _icebreakerEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the icebreaker entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param icebreakerEntry the icebreaker entry
	 * @return the icebreaker entry that was updated
	 */
	@Override
	public com.osp.icebreaker.model.IcebreakerEntry updateIcebreakerEntry(
		com.osp.icebreaker.model.IcebreakerEntry icebreakerEntry) {

		return _icebreakerEntryLocalService.updateIcebreakerEntry(
			icebreakerEntry);
	}

	@Override
	public IcebreakerEntryLocalService getWrappedService() {
		return _icebreakerEntryLocalService;
	}

	@Override
	public void setWrappedService(
		IcebreakerEntryLocalService icebreakerEntryLocalService) {

		_icebreakerEntryLocalService = icebreakerEntryLocalService;
	}

	private IcebreakerEntryLocalService _icebreakerEntryLocalService;

}