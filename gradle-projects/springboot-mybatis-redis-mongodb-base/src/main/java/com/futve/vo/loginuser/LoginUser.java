package com.futve.vo.loginuser;

import com.futve.entity.Role;
import com.futve.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenye
 */
@Getter
@Setter
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 4267941084513384638L;
    private String accessToken;
    private String secretKey;
    private User user;
    private List<Role> roles;

    /**
     * 用来缓存token相关信息
     *
     * @author chenye
     */
    @Getter
    @Setter
    public static class TokenUserInfo {
        /**
         * accountToken
         */
        private String accountToken;
        /**
         * 用户基础信息
         */
        private LoginUser loginUser;

        public TokenUserInfo() {
        }

        public TokenUserInfo(String accountToken, LoginUser loginUser) {
            this.accountToken = accountToken;
            this.loginUser = loginUser;
        }
    }
}
