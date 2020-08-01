package com.futve.common.base;

import com.futve.common.constant.ArtCommonConstant;
import com.futve.common.exception.FutveException;
import com.futve.common.tools.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ApiModel(description = "请求封装的对象")
public class RequestForm {

    @NotNull(message = "方法名不能为空")
    @Size(min = 1, max = 32, message = "url前缀长度应该在1-32个字符之间")
    @ApiModelProperty(value = "url前缀", example = "dataset")
    private String modular;

    @NotNull(message = "方法名不能为空")
    @Size(min = 1, max = 50, message = "姓名长度应该在1-50个字符之间")
    @ApiModelProperty(value = "方法名", example = "login")
    private String method;

    @NotNull(message = "令牌不能为空")
    @Size(min = 1, max = 64, message = "令牌长度应该在1-64个字符之间")
    @ApiModelProperty(value = "令牌", example = "sdfalskj234234sdjlksjdf")
    private String accessToken;

    @NotNull(message = "应用类型不能为空")
    @Size(min = 1, max = 32, message = "类型长度应该在1-32个字符之间")
    @ApiModelProperty(value = "应用类型", example = "web")
    private String appType;

    /**
     * TODO ApiController 替换为拦截器 统一处理 分页码 1与0 问题
     */
    private int pageNo = 1;
    private int pageSize = 10;
    /**
     * json字符串
     */
    private String p;


    /**
     * 获取具体业务的请求参数封装对象
     *
     * @param type
     * @param <T>
     * @return
     */
    public <T> T getContent(Class<T> type) {
        try {
            if (StringUtils.isNotBlank(p)) {
                return JsonUtil.fromJson(p, type);
            } else {
                return type.newInstance();
            }
        } catch (Exception e) {
            throw new FutveException(String.valueOf(ArtCommonConstant.ExceptionReturnCode.ERROR_PARAM_TRANS_FAIL), "参数初始化失败", e);
        }
    }

    public int getOffset() {
        return (this.pageNo - 1) * this.pageSize;
    }
}
