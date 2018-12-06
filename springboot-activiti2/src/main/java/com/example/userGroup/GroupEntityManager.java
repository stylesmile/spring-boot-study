package com.example.userGroup;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author felixu
 * @Date 2018.08.14
 */
@Service
public class GroupEntityManager extends org.activiti.engine.impl.persistence.entity.GroupEntityManager {

    @Override
    public Group createNewGroup(String groupId) {
        return new GroupEntity(groupId);
    }

    @Override
    public void insertGroup(Group group) {
        throw new RuntimeException("not implement method.");
    }


    @Override
    public void deleteGroup(String groupId) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public GroupQuery createNewGroupQuery() {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public List<Group> findGroupByQueryCriteria(GroupQueryImpl query, Page page) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public List<Group> findGroupsByUser(String userId) {
        return ExtUtils.getUserRoles(userId)
                .stream()
                .map(ExtUtils::toActivitiGroup)
                .collect(Collectors.toList());
    }

    @Override
    public List<Group> findGroupsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public long findGroupCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new RuntimeException("not implement method.");
    }
}
