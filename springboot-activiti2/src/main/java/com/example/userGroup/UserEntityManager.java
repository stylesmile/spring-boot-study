package com.example.userGroup;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author felixu
 * @Date 2018.08.14
 */
@Service
public class UserEntityManager extends org.activiti.engine.impl.persistence.entity.UserEntityManager {

    private IdentityService getIdentityService() {
        return ApplicationContextRegister.getBean(IdentityService.class);
    }

    @Override
    public User createNewUser(String userId) {
        return new UserEntity(userId);
    }

    @Override
    public void insertUser(User user) {
        throw new RuntimeException("not implement method.");
    }

    public void updateUser(UserEntity updatedUser) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public UserEntity findUserById(String userId) {
        return ExtUtils.toActivitiUser(ExtUtils.getUserInfo(userId));
    }

    @Override
    public void deleteUser(String userId) {
        Optional.ofNullable(findUserById(userId))
                .ifPresent(user -> getIdentityService().deleteUser(userId));
    }

    @Override
    public List<User> findUserByQueryCriteria(UserQueryImpl query, Page page) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public long findUserCountByQueryCriteria(UserQueryImpl query) {
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
    public UserQuery createNewUserQuery() {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId, String key) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public List<String> findUserInfoKeysByUserIdAndType(String userId, String type) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public Boolean checkPassword(String userId, String password) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public List<User> findPotentialStarterUsers(String proceDefId) {
        throw new RuntimeException("not implement method.");

    }

    @Override
    public List<User> findUsersByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public long findUserCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new RuntimeException("not implement method.");
    }
}
