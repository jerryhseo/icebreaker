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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for IcebreakerEntry. This utility wraps
 * <code>com.osp.icebreaker.service.impl.IcebreakerEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo
 * @see IcebreakerEntryLocalService
 * @generated
 */
@ProviderType
public class IcebreakerEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icebreaker.service.impl.IcebreakerEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the icebreaker entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param icebreakerEntry the icebreaker entry
	 * @return the icebreaker entry that was added
	 */
	public static com.osp.icebreaker.model.IcebreakerEntry addIcebreakerEntry(
		com.osp.icebreaker.model.IcebreakerEntry icebreakerEntry) {

		return getService().addIcebreakerEntry(icebreakerEntry);
	}

	/**
	 * Creates a new icebreaker entry with the primary key. Does not add the icebreaker entry to the database.
	 *
	 * @param icebreakerEntryId the primary key for the new icebreaker entry
	 * @return the new icebreaker entry
	 */
	public static com.osp.icebreaker.model.IcebreakerEntry
		createIcebreakerEntry(long icebreakerEntryId) {

		return getService().createIcebreakerEntry(icebreakerEntryId);
	}

	/**
	 * Deletes the icebreaker entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param icebreakerEntry the icebreaker entry
	 * @return the icebreaker entry that was removed
	 */
	public static com.osp.icebreaker.model.IcebreakerEntry
		deleteIcebreakerEntry(
			com.osp.icebreaker.model.IcebreakerEntry icebreakerEntry) {

		return getService().deleteIcebreakerEntry(icebreakerEntry);
	}

	/**
	 * Deletes the icebreaker entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param icebreakerEntryId the primary key of the icebreaker entry
	 * @return the icebreaker entry that was removed
	 * @throws PortalException if a icebreaker entry with the primary key could not be found
	 */
	public static com.osp.icebreaker.model.IcebreakerEntry
			deleteIcebreakerEntry(long icebreakerEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteIcebreakerEntry(icebreakerEntryId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.osp.icebreaker.model.IcebreakerEntry fetchIcebreakerEntry(
		long icebreakerEntryId) {

		return getService().fetchIcebreakerEntry(icebreakerEntryId);
	}

	/**
	 * Returns the icebreaker entry matching the UUID and group.
	 *
	 * @param uuid the icebreaker entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static com.osp.icebreaker.model.IcebreakerEntry
		fetchIcebreakerEntryByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchIcebreakerEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	public static java.util.List<com.osp.icebreaker.model.IcebreakerEntry>
		getIcebreakerEntries(int start, int end) {

		return getService().getIcebreakerEntries(start, end);
	}

	/**
	 * Returns all the icebreaker entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the icebreaker entries
	 * @param companyId the primary key of the company
	 * @return the matching icebreaker entries, or an empty list if no matches were found
	 */
	public static java.util.List<com.osp.icebreaker.model.IcebreakerEntry>
		getIcebreakerEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getIcebreakerEntriesByUuidAndCompanyId(
			uuid, companyId);
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
	public static java.util.List<com.osp.icebreaker.model.IcebreakerEntry>
		getIcebreakerEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icebreaker.model.IcebreakerEntry> orderByComparator) {

		return getService().getIcebreakerEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of icebreaker entries.
	 *
	 * @return the number of icebreaker entries
	 */
	public static int getIcebreakerEntriesCount() {
		return getService().getIcebreakerEntriesCount();
	}

	/**
	 * Returns the icebreaker entry with the primary key.
	 *
	 * @param icebreakerEntryId the primary key of the icebreaker entry
	 * @return the icebreaker entry
	 * @throws PortalException if a icebreaker entry with the primary key could not be found
	 */
	public static com.osp.icebreaker.model.IcebreakerEntry getIcebreakerEntry(
			long icebreakerEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getIcebreakerEntry(icebreakerEntryId);
	}

	/**
	 * Returns the icebreaker entry matching the UUID and group.
	 *
	 * @param uuid the icebreaker entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching icebreaker entry
	 * @throws PortalException if a matching icebreaker entry could not be found
	 */
	public static com.osp.icebreaker.model.IcebreakerEntry
			getIcebreakerEntryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getIcebreakerEntryByUuidAndGroupId(uuid, groupId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the icebreaker entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param icebreakerEntry the icebreaker entry
	 * @return the icebreaker entry that was updated
	 */
	public static com.osp.icebreaker.model.IcebreakerEntry
		updateIcebreakerEntry(
			com.osp.icebreaker.model.IcebreakerEntry icebreakerEntry) {

		return getService().updateIcebreakerEntry(icebreakerEntry);
	}

	public static IcebreakerEntryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<IcebreakerEntryLocalService, IcebreakerEntryLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			IcebreakerEntryLocalService.class);

		ServiceTracker<IcebreakerEntryLocalService, IcebreakerEntryLocalService>
			serviceTracker =
				new ServiceTracker
					<IcebreakerEntryLocalService, IcebreakerEntryLocalService>(
						bundle.getBundleContext(),
						IcebreakerEntryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}