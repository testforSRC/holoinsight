/*
 * Copyright 2022 Holoinsight Project Authors. Licensed under Apache-2.0.
 */
package io.holoinsight.server.home.web.security;

import io.holoinsight.server.apm.common.model.specification.sw.Tag;
import io.holoinsight.server.common.model.DataQueryRequest;
import io.holoinsight.server.common.scope.MonitorUser;
import io.holoinsight.server.home.dal.model.dto.CustomPluginDTO;

import java.util.List;
import java.util.Map;

/**
 * @author masaimu
 * @version 2023-09-27 11:02:00
 */
public interface ParameterSecurityService {

  boolean checkRuleTenantAndWorkspace(String uniqueId, String tenant, String workspace);

  boolean checkMetricTenantAndWorkspace(String metricTable, String tenant, String workspace);

  boolean checkGroupTenantAndWorkspace(Long groupId, String tenant, String workspace);

  boolean checkUserTenantAndWorkspace(String uid, MonitorUser user);

  boolean checkFilterTenantAndWorkspace(String metricTable, Map<String, List<Object>> filters,
      String tenant, String workspace);

  String getTenantFromMetricInfo(String metricTable);

  String getWorkspaceFromMetricInfo(String metricTable);

  String getStorageTenantFromMetricInfo(String metricTable);


  List<String> getDetailFilters(DataQueryRequest request);

  boolean checkRelateId(String relateId, String relateType, String tenant, String workspace);

  boolean checkTenant(String target, String tenant);

  boolean checkSourceId(Long sourceId, String sourceType, String tenant, String workspace);

  Boolean checkAgentLogPath(String logpath);

  Boolean checkAgentLogPathPrefix(String logpath);


  Boolean checkCookie(String tenant, String workspace, String environment);

  Boolean checkTraceTags(String tenant, String workspace, List<Tag> tags);

  Boolean checkTraceParams(String tenant, String workspace, Map<String, String> paramsMap);



  Boolean checkCustomPluginLogConfParams(String tenant, String workspace,
      CustomPluginDTO customPluginDTO);
}
