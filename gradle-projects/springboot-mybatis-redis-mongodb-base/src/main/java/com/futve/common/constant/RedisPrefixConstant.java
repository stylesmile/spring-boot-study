package com.futve.common.constant;

/**
 * redis前缀常量类
 *
 * @author pc
 */
public class RedisPrefixConstant {
    /**
     * redis 超时时间
     */
    public interface RedisExpireConstant {
        /**
         * 6个月，5184000=3600 * 24 * 180
         * 用处，redis领取数据的分布式锁
         */
        int TASK_COUNT_EXPIRE = 15552000;
        /**
         * 登录短信验证码超时时间
         * 300 = 60 * 5
         */
        int USER_MESSAGE_LOGIN_CODE = 300;
    }

    /**
     * 分隔符
     */
    public static final String KEY_SPLIT = "_";

    /**
     * 公共前缀
     */
    private static final String COMMON_PREFIX = "art";

    /**
     * token生效时间
     */
    public static final int USER_TOKEN_EXPIRE_SECONDS = 7200;

    /**
     * 质检状态生效时间
     */
    public static final int CHECKTASK_DENY_SECONDS = USER_TOKEN_EXPIRE_SECONDS * 2;

    /**
     * 用户信息缓存生效时间
     */
    public static final int USERINFO_EXPIRE_SECONDS = 86400;

    /**
     * 任务试读锁，缓存生效时间 30*24*3600
     */
    public static final int TASK_TRY_READ_LOCK_SECONDS = 2592000;

    /**
     * 工会信息缓存生效时间
     */
    public static final int ORGINFO_EXPIRE_SECONDS = 86400;

    /**
     * 任务信息缓存生效时间
     */
    public static final int TASKINFO_EXPIRE_SECONDS = 86400;

    /**
     * 项目信息缓存生效时间
     */
    public static final int PROJECTINFO_EXPIRE_SECONDS = 86400;

    /**
     * 质检报告信息缓存生效时间
     */
    public static final int CHECKRESULT_EXPIRE_SECONDS = 86400;

    /**
     * 分布式锁失效时间
     */
    public static final int DISTRIBUTE_LOCK_EXPIRE_SECONDS = 60;

    /**
     * 用户模块前缀
     */
    public static final String USER_MODEL_PREFIX = COMMON_PREFIX + KEY_SPLIT + "user";

    /**
     * 模板模块前缀
     */
    public static final String TEMP_MODEL_PREFIX = COMMON_PREFIX + KEY_SPLIT + "temp";

    /**
     * 文档模块前缀
     */
    public static final String DOC_MODEL_PREFIX = COMMON_PREFIX + KEY_SPLIT + "document";

    /**
     * 数据集模块前缀
     */
    public static final String DATASET_MODEL_PREFIX = COMMON_PREFIX + KEY_SPLIT + "dataset";

    /**
     * 接口模块前缀
     */
    public static final String INTERFACE_MODEL_PREFIX = COMMON_PREFIX + KEY_SPLIT + "interface";


    /**
     * 任务模块前缀
     */
    public static final String TASKS_MODEL_PREFIX = COMMON_PREFIX + KEY_SPLIT + "tasks";

    /**
     * 项目模块前缀
     */
    public static final String PROJECTS_MODEL_PREFIX = COMMON_PREFIX + KEY_SPLIT + "projects";

    /**
     * User库缓存
     *
     * @author pc
     */
    public interface UserConstant {

        /**
         * 用户信息缓存
         */
        String USERINFO = USER_MODEL_PREFIX + KEY_SPLIT + "userInfo" + KEY_SPLIT + "%s";

        String USER_MESSAGE_LOGIN_CODE = USER_MODEL_PREFIX + KEY_SPLIT + "userMessageLoginCode" + KEY_SPLIT + "%s";

        /**
         * 工会信息缓存
         */
        String ORGINFO = USER_MODEL_PREFIX + KEY_SPLIT + "orgInfo" + KEY_SPLIT + "%s";

        /**
         * 用户抽检比例信息缓存
         */
        String USER_CHOSE_PERCENT = USER_MODEL_PREFIX + KEY_SPLIT + "user_chose_percent" + KEY_SPLIT + "%s";

        /**
         * 角色映射缓存
         */
        String USER_ROLES = USER_MODEL_PREFIX + KEY_SPLIT + "roles";

        /**
         * 用户登录后的token
         */
        String USER_LOGIN_TOKEN = USER_MODEL_PREFIX + KEY_SPLIT + "token";

        /**
         * 工会映射缓存
         */
        String USER_ORG = USER_MODEL_PREFIX + KEY_SPLIT + "orgs";
    }

    /**
     * 任务库缓存
     *
     * @author pc
     */
    public interface TasksConstant {
        /**
         * 用户试读条数锁
         */
        String TASKS_TRY_READ_LOCK = "task_try_read_lock"
                + RedisPrefixConstant.KEY_SPLIT + "%s" + RedisPrefixConstant.KEY_SPLIT + "%s";
        /**
         * 模板映射缓存
         */
        String TASKS_TEMPLATE = TASKS_MODEL_PREFIX + KEY_SPLIT + "template";

        /**
         * 任务数量缓存
         */
        String TASKS_COUNT_PREFIX = TASKS_MODEL_PREFIX + KEY_SPLIT + "count";

        String TASKS_TOTAL_COUNT_PREFIX = TASKS_MODEL_PREFIX + KEY_SPLIT + "total_count";

        /**
         * 任务数量缓存
         */
        String TASKS_CURRENT_COUNT_PREFIX = TASKS_MODEL_PREFIX + KEY_SPLIT + "current_count";

        /**
         * 质检任务数量缓存
         */
        String CHECK_TASKS_COUNT_PREFIX = TASKS_MODEL_PREFIX + KEY_SPLIT + "checkCount";
        /**
         * 审核任务数量缓存
         */
        String CONFIRM_TASKS_COUNT_PREFIX = TASKS_MODEL_PREFIX + KEY_SPLIT + "confirmCount";


        /**
         * 质检任务状态缓存前缀
         */
        String CHECK_TASKS_STATUS_PREFIX = TASKS_MODEL_PREFIX + KEY_SPLIT + "checkStatus";

        /**
         * 质检任务状态缓存
         */
        String CHECK_TASKS_STATUS = TasksConstant.CHECK_TASKS_STATUS_PREFIX
                + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 任务数量缓存 标注任务使用
         */
        String TASKS_COUNT = TasksConstant.TASKS_COUNT_PREFIX
                + RedisPrefixConstant.KEY_SPLIT + "%s";
        /**
         * 任务总数量缓存 文本修改任务使用
         */
        String TASKS_TOTAL_COUNT = TasksConstant.TASKS_TOTAL_COUNT_PREFIX
                + RedisPrefixConstant.KEY_SPLIT + "%s";
        /**
         * 任务当前数量缓存 文本修改任务
         */
        String TASKS_CURRENT_COUNT = TasksConstant.TASKS_CURRENT_COUNT_PREFIX
                + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 质检任务数量缓存
         */
        String CHECK_TASKS_COUNT = TasksConstant.CHECK_TASKS_COUNT_PREFIX
                + RedisPrefixConstant.KEY_SPLIT + "%s";
        /**
         * 审核任务数量缓存
         */
        String CONFIRM_TASKS_COUNT = TasksConstant.CONFIRM_TASKS_COUNT_PREFIX
                + RedisPrefixConstant.KEY_SPLIT + "%s";


        /**
         * 任务质检数据数量缓存
         */
        String TASKS_CHECK_COUNT = TASKS_MODEL_PREFIX + KEY_SPLIT + "checkcount"
                + RedisPrefixConstant.KEY_SPLIT + "%s" + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 任务质检次数缓存
         */
        String TASKS_CHECK_TIME = TASKS_MODEL_PREFIX + KEY_SPLIT + "checktime"
                + RedisPrefixConstant.KEY_SPLIT + "%s";
        /**
         * 任务质检实时统计
         */
        String TASKS_CHECK_RESULT = TASKS_MODEL_PREFIX + KEY_SPLIT + "checkresult_count"
                + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 任务质检统计维度结果存储
         */
        String TASKS_CHECK_STATIC = TASKS_MODEL_PREFIX + KEY_SPLIT + "checkresult_static"
                + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 任务审核实时统计
         */
        String TASKS_CONFIRM_RESULT = TASKS_MODEL_PREFIX + KEY_SPLIT + "confirmresult_count"
                + RedisPrefixConstant.KEY_SPLIT + "%s";


        /**
         * 任务质检报告
         */
        String CHECKTASKS_CHECK_RESULT = TASKS_MODEL_PREFIX + KEY_SPLIT + "checkresult"
                + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 任务质检报告错误数据
         */
        String CHECKTASKS_CHECK_ERROR_DATAS = TASKS_MODEL_PREFIX + KEY_SPLIT + "check_error_datas"
                + RedisPrefixConstant.KEY_SPLIT + "%s";
        /**
         * 任务审核报告
         */
        String CONFIRMTASKS_CONFIRM_RESULT = TASKS_MODEL_PREFIX + KEY_SPLIT + "confirmresult"
                + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 任务审核报告错误数据
         */
        String CONFIRMTASKS_CONFIRM_ERROR_DATAS = TASKS_MODEL_PREFIX + KEY_SPLIT + "confirm_error_datas"
                + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 任务信息缓存
         */
        String TASKS_INFO = TASKS_MODEL_PREFIX + KEY_SPLIT + "info"
                + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 审核任务信息缓存
         */
        String CONFIRM_TASKS_INFO = TASKS_MODEL_PREFIX + KEY_SPLIT + "confirmTask" + KEY_SPLIT + "info"
                + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 质检任务实时统计细分详情
         */
        String CHECK_TASKS_DETAILSTATISTICS = TASKS_MODEL_PREFIX + KEY_SPLIT + "checkResult" + KEY_SPLIT + "detailStatistics"
                + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 质检任务实时统计细分详情计算锁
         */
        String CHECK_RESULT_CACL_LOCK = TASKS_MODEL_PREFIX + KEY_SPLIT + "checkResult" + KEY_SPLIT + "lock"
                + RedisPrefixConstant.KEY_SPLIT + "%s";
        /**
         * 每天定时开始任务 锁
         */
        String SCHEDULE_START_TASK_LOCK = TASKS_MODEL_PREFIX + KEY_SPLIT + "schedule_start_task" + KEY_SPLIT + "lock";

    }

    public interface ProjectConstant {
        /**
         * 项目信息缓存
         */
        String PROJECTS_INFO = PROJECTS_MODEL_PREFIX + KEY_SPLIT + "info"
                + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 子项目信息缓存
         */
        String SUBPROJECTS_INFO = PROJECTS_MODEL_PREFIX + KEY_SPLIT + "sub_project_info"
                + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 子项目任务数量计算锁
         */
        String SUBPROJECTS_T_NUM_LOCK = PROJECTS_MODEL_PREFIX + KEY_SPLIT + "sub_pro_task_num_lock"
                + RedisPrefixConstant.KEY_SPLIT + "%s";

        /**
         * 项目子项目数量计算锁
         */
        String PROJECTS_SUB_PRO_NUM_LOCK = PROJECTS_MODEL_PREFIX + KEY_SPLIT + "pro_sub_pro_num_lock"
                + RedisPrefixConstant.KEY_SPLIT + "%s";
    }

    /**
     * interface库缓存
     *
     * @author pc
     */
    public interface InterfacesConstant {

        /**
         * 接口信息缓存
         */
        String INTERFACEINFO = INTERFACE_MODEL_PREFIX + KEY_SPLIT + "infInfo" + KEY_SPLIT + "%s" + KEY_SPLIT + "%s";

        /**
         * 接口角色限制信息缓存
         */
        String INFROLELIMIT = INTERFACE_MODEL_PREFIX + KEY_SPLIT + "infRoleLimit" + KEY_SPLIT + "%s";

        /**
         * 接口缓存启动加载配置
         */
        String INF_START_INIT = INTERFACE_MODEL_PREFIX + KEY_SPLIT + "inf_init";
    }

    /**
     * 模板相关缓存key
     */
    public interface TempConstant {

        /**
         * nlp扩写模板序列号key
         */
        String NLP_TEMP_INDEX = TEMP_MODEL_PREFIX + KEY_SPLIT + "nlp_Temp_Index";
    }

    /**
     * 文档相关缓存key
     */
    public interface DocumentConstant {

        /**
         * 文档更新
         */
        String DOC_UPDATED = DOC_MODEL_PREFIX + KEY_SPLIT + "update_flag" + KEY_SPLIT + "%s";

        /**
         * 文档阅读记录
         */
        String DOC_READ_USER_MAP = DOC_MODEL_PREFIX + KEY_SPLIT + "read_flag" + KEY_SPLIT + "%s";
    }

    /**
     * 数据集相关缓存key
     */
    public interface DataSetConstant {

        /**
         * nlp扩写数据集序列号key
         */
        String NLP_DATASET_INDEX = DATASET_MODEL_PREFIX + KEY_SPLIT + "nlp_DataSet_Index";
        /**
         * nlp扩写数据集序列号key
         */
        String WENDA_DATASET_INDEX = DATASET_MODEL_PREFIX + KEY_SPLIT + "wenda_DataSet_Index";
    }
}
