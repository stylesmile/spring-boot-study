package com.futve.common.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量抽取
 *
 * @author zhl
 */
public final class ArtCommonConstant {
    /**
     * 格式配置信息
     */
    public interface FormatConfig {
        String FORMAT4DISPLAY = "yyyy-MM-dd HH:mm:ss";
    }

    /**
     * 角色性质配置
     */
    public interface AppType {
        String WEB = "web";
        String WECHAT = "wechat";
        String ANDROID = "androId";
        String IOS = "iOS";
    }

    /**
     * 角色权限配置
     */
    public interface RoleConfig {
        String ROLE_ADMIN = "admin";
        String ROLE_SYSTEM_ADMIN = "systemAdmin";
        String ROLE_MARKER = "marker";
        String ROLE_CHECKER = "checker";
        String ROLE_CHAIRMAN = "chairman";
        Integer ROLE_ADMIN_ID = 1;
        Integer ROLE_MARKER_ID = 2;
        Integer ROLE_CHECKER_ID = 3;
        Integer ROLE_CHAIRMAN_ID = 4;
        Integer ROLE_SYSTEM_ADMIN_ID = 8;
        Map roleMap = new HashMap() {{
            put("超级管理员", ROLE_ADMIN_ID.toString());
            put("标注员", ROLE_MARKER_ID.toString());
            put("质检员", ROLE_CHECKER_ID.toString());
            put("会长", ROLE_CHAIRMAN_ID.toString());
        }};
    }

    /**
     * 角色性质配置
     */
    public interface UserTypeConfig {
        Integer FORMAL = 0; //正式
        Integer OUTSOURCE = 1; //外包
        Integer PRACTICE = 2; //实习
        Integer PART_TIME = 3; //兼职
        Map typeMap = new HashMap() {{
            put("正式", FORMAL);
            put("外包", OUTSOURCE);
            put("实习", PRACTICE);
            put("兼职", PART_TIME);
        }};

        Map typeIndexMap = new HashMap() {{
            put(0, "正式");
            put(1, "外包");
            put(2, "实习");
            put(3, "兼职");
        }};

    }

    /**
     * mongo col配置
     */
    public interface CollectionConfig {
        String TEMPLATE_COLLECTION = "template";
        String TASK_COLLECTION = "tasks";
        String PROJECT_COLLECTION = "projects";
        String SUBPROJECT_COLLECTION = "sub_projects";
        String CHECK_TASK_COLLECTION = "check_tasks";
        String TASK_START_TIME = "task_start_time";
        String CHECK_RESULT_COLLECTION = "check_results";
        String CONFIRM_TASK_COLLECTION = "confirm_tasks";
        String CONFIRM_RESULT_COLLECTION = "confirm_results";
        String DOCUMENT_COLLECTION = "documents";
        String TASK_RECORD_INFO_COLLECTION = "task_record_info";
        String TASK_STATISTIC_COLLECTION = "task_statistics";
        String DOCUMENT_COLLECTION_DATASETTEXT = "col_emotion";
    }

    /**
     * task配置
     */
    public interface TaskConfig {

        /**
         * 未标注完成状态
         */
        List<Byte> TASK_STATUS_UNMARK_FINASH = new ArrayList<Byte>() {
            {
                add(TaskConfig.TASK_STATUS_WAIT);
                add(TaskConfig.TASK_STATUS_MARKING);
            }
        };
        /**
         * 未质检完成状态
         */
        List<Byte> TASK_STATUS_UNFINASH = new ArrayList<Byte>() {
            {
                add(TaskConfig.TASK_STATUS_WAIT_CHECK);
                add(TaskConfig.TASK_STATUS_CHECKING);
            }
        };
        /**
         * 未质检完成状态
         */
        List<Byte> TASK_STATUS_UNCHECK = new ArrayList<Byte>() {
            {
                add(TaskConfig.TASK_STATUS_COMPLETE);
                add(TaskConfig.TASK_STATUS_WAIT_CHECK);
                add(TaskConfig.TASK_STATUS_CHECKING);
            }
        };
        /**
         * 任务类型 ，标注任务
         */
        byte TASK_TYPE_MARK = 1;
        /**
         * 文本任务
         */
        byte TASK_TYPE_TEXT = 2;
        /**
         * 录音任务
         */
        byte TASK_TYPE_RECORD = 3;
        /**
         * 重复文本的任务 例如唤醒词
         */
        byte TASK_TYPE_REPEAT_TEXT = 4;
        /**
         * 录音任务
         */
        byte NEW_TASK_TYPE_RECORD = 5;

        /**
         * 用户每次获取数据数量
         */
        byte TASK_DATA_COUNT = 1;
        /**
         * 用户每次获取数据数量
         * 录音人每次获取10条
         */
        byte RECORD_TASK_DATA_COUNT = 10;
        /**
         * 获取上一条或历史记录用户每次获取数据数量
         */
        byte TASK_DATA_HISTORY_COUNT = 30;
        /**
         * 待标注
         */
        byte TASK_STATUS_WAIT = 0;
        /**
         * 标注中
         */
        byte TASK_STATUS_MARKING = 1;
        /**
         * 标注完成
         */
        byte TASK_STATUS_COMPLETE = 2;
        /**
         * 待质检
         */
        byte TASK_STATUS_WAIT_CHECK = 3;
        /**
         * 质检中
         */
        byte TASK_STATUS_CHECKING = 4;
        /**
         * 质检通过
         */
        byte TASK_STATUS_CHECK_PASS = 5;
        /**
         * 质检不通过
         */
        byte TASK_STATUS_CHECK_NOT_PASS = 6;
        /**
         * 质检完成
         */
        byte TASK_STATUS_CHECK_COMPETE = 7;
        /**
         * 质检中断
         */
        byte TASK_STATUS_CHECK_INTERRAPT = 8;
        /**
         * 待审核
         */
        byte TASK_STATUS_WAIT_CONFIRM = 9;
        /**
         * 审核中
         */
        byte TASK_STATUS_CONFIRMING = 10;
        /**
         * 审核通过
         */
        byte TASK_STATUS_CONFIRM_PASS = 11;
        /**
         * 审核不通过
         */
        byte TASK_STATUS_CONFIRM_NOT_PASS = 12;
        /**
         * 审核完成
         */
        byte TASK_STATUS_CONFIRM_COMPETE = 13;
        /**
         * 审核中断
         */
        byte TASK_STATUS_CONFIRM_INTERRAPT = 14;
        /**
         * 已交付
         */
        byte TASK_STATUS_DELIVER = 15;
        /**
         * 待标注
         */
        byte LABEL_DATA_STATUS_WAIT = 0;
        /**
         * 已占用
         */
        byte LABEL_DATA_STATUS_BEGIN = 1;
        /**
         * 已标注
         */
        byte LABEL_DATA_STATUS_COMPLETE = 2;
        /**
         * 待质检
         */
        byte LABEL_DATA_STATUS_WAIT_CHECK = 3;
        /**
         * 质检占用
         */
        byte LABEL_DATA_STATUS_BEGIN_CHECK = 4;
        /**
         * 质检通过
         */
        byte LABEL_DATA_STATUS_CHECK_SUCCESS = 5;
        /**
         * 质检未通过
         */
        byte LABEL_DATA_STATUS_CHECK_FAIL = 6;
        /**
         * 质检后标注员修改
         */
        byte LABEL_DATA_STATUS_CHECKED_MARKER_MODIFY = 7;
        /**
         * 质检后质检员修改
         */
        byte LABEL_DATA_STATUS_CHECKED_CHECKER_MODIFY = 8;

        /**
         * 初始状态
         */
        byte LABEL_DATA_HANDLE_STATUS_INIT = 0;
        /**
         * 待处理(由当前处理人后续处理)
         */
        byte LABEL_DATA_HANDLE_STATUS_WAIT = 1;
        /**
         * 已处理
         */
        byte LABEL_DATA_HANDLE_STATUS_COMPLETE = 2;
        /**
         * 质检中
         */
        byte LABEL_DATA_HANDLE_STATUS_CHECKING = 3;

        /**
         * 有效数据
         */
        byte LABEL_DATA_VALID = 0;
        /**
         * 无效数据
         */
        byte LABEL_DATA_INVALID = 1;
        /**
         * 待质检
         */
        byte LABEL_DATA_CHECK_STATUS_WAIT = 0;
        /**
         * 已占用
         */
        byte LABEL_DATA_CHECK_STATUS_HOLD = 1;
        /**
         * 已质检
         */
        byte LABEL_DATA_CHECK_STATUS_COMPLETE = 2;
        /**
         * 质检结果状态-未通过
         */
        byte LABEL_DATA_CHECK_RESULT_NOT_PASS = 0;
        /**
         * 质检结果状态-通过
         */
        byte LABEL_DATA_CHECK_RESULT_PASS = 1;

        Map taskStatusMap = new HashMap() {{
            put(0, "待标注");
            put(1, "标注中");
            put(2, "标注完成");
            put(9, "待审核");
            put(10, "审核中");
            put(11, "审核通过");
            put(12, "审核不通过");
            put(13, "审核完成");
            put(14, "审核中断");
            put(15, "交付");
        }};

        interface TaskListWhere {
            String WEB_TASK_LIST = "web_task_list";
            String ANDROID_TASK_LIST = "android_task_list";
        }
    }

    /**
     * 项目配置
     */
    public interface ProjectConfig {
        //0:初始状态,1:正常,2:提前,3:延期,4:已结束,5:已删除
        /**
         * 初始状态
         */
        byte PRO_STATUS_INIT = 0;
        /**
         * 完结状态
         */
        byte PRO_STATUS_END = 4;

        /**
         * 已删除状态
         */
        byte PRO_STATUS_DEL = 5;
        List<Byte> UNDISPLAY_STATUS = new ArrayList() {{
            add(PRO_STATUS_END);
            add(PRO_STATUS_DEL);
        }};

    }

    /**
     * 数据集配置
     */
    public interface DatasetConfig {
        /**
         * 数据集初始
         */
        byte DATASET_STATUS_INIT = 0;
        /**
         * 数据集已使用
         */
        byte DATASET_STATUS_MARK = 1;
        /**
         * 数据集已交付
         */
        byte DATASET_STATUS_DELIVER = 2;

    }

    /**
     * 数据状态列表配置
     */
    public interface LabelStatusConfig {

        /**
         * 质检抽取的所有数据状态
         */
        List<Byte> choseCheckLabelStatusAll = new ArrayList<Byte>() {{
            add(TaskConfig.LABEL_DATA_STATUS_COMPLETE);
            add(TaskConfig.LABEL_DATA_STATUS_WAIT_CHECK);
            add(TaskConfig.LABEL_DATA_STATUS_BEGIN_CHECK);
            add(TaskConfig.LABEL_DATA_STATUS_CHECK_SUCCESS);
            add(TaskConfig.LABEL_DATA_STATUS_CHECK_FAIL);
            add(TaskConfig.LABEL_DATA_STATUS_CHECKED_MARKER_MODIFY);
            add(TaskConfig.LABEL_DATA_STATUS_CHECKED_CHECKER_MODIFY);
        }};
        /**
         * 质检抽取的所有数据状态,去掉通过数据
         */
        List<Byte> choseCheckLabelStatus = new ArrayList<Byte>() {{
            add(TaskConfig.LABEL_DATA_STATUS_COMPLETE);
            add(TaskConfig.LABEL_DATA_STATUS_CHECK_FAIL);
            add(TaskConfig.LABEL_DATA_STATUS_CHECKED_MARKER_MODIFY);
        }};

        /**
         * 仅包含未质检数据
         */
        List<Byte> choseCheckLabelStatusWaitCheck = new ArrayList<Byte>() {{
            add(TaskConfig.LABEL_DATA_STATUS_COMPLETE);
            add(TaskConfig.LABEL_DATA_STATUS_WAIT_CHECK);
            add(TaskConfig.LABEL_DATA_STATUS_BEGIN_CHECK);
        }};
        /**
         * 质检抽取的已修改数据状态
         */
        List<Byte> choseCheckLabelStatusModify = new ArrayList<Byte>() {{
            add(TaskConfig.LABEL_DATA_STATUS_CHECKED_MARKER_MODIFY);
        }};
        /**
         * 已经质检数据状态
         */
        List<Byte> checkLabelStatusPass = new ArrayList<Byte>() {{
            add(TaskConfig.LABEL_DATA_STATUS_CHECK_FAIL);
            add(TaskConfig.LABEL_DATA_STATUS_CHECK_SUCCESS);
            add(TaskConfig.LABEL_DATA_STATUS_CHECKED_CHECKER_MODIFY);
        }};
        /**
         * 已经质检通过数据状态
         */
        List<Byte> checkLabelStatusPassed = new ArrayList<Byte>() {{
            add(TaskConfig.LABEL_DATA_STATUS_CHECK_SUCCESS);
            add(TaskConfig.LABEL_DATA_STATUS_CHECKED_MARKER_MODIFY);
            add(TaskConfig.LABEL_DATA_STATUS_CHECKED_CHECKER_MODIFY);
        }};
        /**
         * 已经质检不通过数据状态
         */
        List<Byte> checkLabelStatusPassFail = new ArrayList<Byte>() {{
            add(TaskConfig.LABEL_DATA_STATUS_CHECK_FAIL);
        }};
        /**
         * 质检通过数据状态
         */
        List<Byte> checkLabelStatusPassData = new ArrayList<Byte>() {{
            add(TaskConfig.LABEL_DATA_STATUS_CHECK_SUCCESS);
            add(TaskConfig.LABEL_DATA_STATUS_CHECKED_MARKER_MODIFY);
            add(TaskConfig.LABEL_DATA_STATUS_CHECKED_CHECKER_MODIFY);
        }};
        /**
         * 质检未通过数据状态
         */
        List<Byte> checkLabelStatusUnPassData = new ArrayList<Byte>() {{
            add(TaskConfig.LABEL_DATA_STATUS_CHECK_FAIL);
        }};

    }

    /**
     * 任务状态列表配置
     */
    public interface TaskStatusListConfig {

        /**
         * 生成质检报告的数据状态
         */
        List<Byte> GETCHECKRESULTSTATUS = new ArrayList<Byte>() {{
            add(TaskConfig.TASK_STATUS_CHECK_COMPETE);
            add(TaskConfig.TASK_STATUS_CHECK_INTERRAPT);
        }};

        /**
         * 生成质检报告的数据状态
         */
        List<Byte> GETCONFIRMRESULTSTATUS = new ArrayList<Byte>() {{
            add(TaskConfig.TASK_STATUS_CONFIRM_COMPETE);
            add(TaskConfig.TASK_STATUS_CONFIRM_INTERRAPT);
        }};

        /**
         * 审核结束的数据状态
         */
        List<Byte> CONFIRM_END_STATUS = new ArrayList<Byte>() {{
            add(TaskConfig.TASK_STATUS_CONFIRM_NOT_PASS);
            add(TaskConfig.TASK_STATUS_CONFIRM_PASS);
            add(TaskConfig.TASK_STATUS_CONFIRM_INTERRAPT);
        }};

        /**
         * 质检结束的数据状态
         */
        List<Byte> CHECK_END_STATUS = new ArrayList<Byte>() {{
            add(TaskConfig.TASK_STATUS_CHECK_NOT_PASS);
            add(TaskConfig.TASK_STATUS_CHECK_PASS);
            add(TaskConfig.TASK_STATUS_CHECK_INTERRAPT);
        }};
    }

    /**
     * 服务端配置
     */
    public interface ServerConfig {

        /**
         * 项目访问根路径名
         */
        String CONTEXT = "";
        /**
         * 用户单一终端登录
         */
        boolean ENABLE_LOGIN_SINGLE = true;
    }

    /**
     * 返回码映射
     *
     * @author pc
     */
    public interface ReturnCode {

        // 用户 --begin
        /**
         * 登录失败：用户参数参加检测失败
         */
        int USER_LOGIN_CHECK_FAIL = 1001;
        /**
         * 登录失败：手机号不存在
         */
        int USER_LOGIN_FAIL_PHONE_NOT_EXIST = 1003;
        /**
         * 登录失败：密码错误
         */
        int USER_LOGIN_FAIL_PWD_ERROR = 1005;
        /**
         * 登录失败：密码错误
         */
        int USER_OLD_PWD_ERROR = 1015;

        /**
         * 登录：token失效
         */
        int USER_TOKEN_TIMEOUT = 1999;
        /**
         * 创建失败：手机号或用户名已存在
         */
        int USER_ADD_FAIL_PHONE_NAME_EXIST = 1010;

        /**
         * 创建失败：公会名已存在
         */
        int ORG_ADD_FAIL_NAME_EXIST = 1012;
        /**
         * 用户不存在
         */
        int USER_NOT_EXIST = 1011;

        /**
         * 删除失败：工会有用户关联
         */
        int EXIST_USER_RELATED = 1013;
        /**
         * 删除失败：工会有用户关联
         */
        int EXIST_DATA_RELATED = 1013;
        // 用户--end

        // 通用返回码 --begin
        /**
         * 通用返回码：鉴权失败
         */
        int ERROR_AUTHENTICATE_FAIL = 9001;

        /**
         * 通用返回码: 请求参数错误 这类错误一般由于程序联调或数据紊乱造成，前端可能需要阻止用户进一步操作
         */
        int ERROR_PARAMETER_FAIL = 9003;

        /**
         * 通用返回码：用户不存在
         */
        int ERROR_USER_NOT_EXIST = 9005;

        /**
         * 通用返回码：未匹配到相应权限
         */
        int ERROR_ROLE_NOT_EXIST = 9008;
        int ERROR_UPLOAD_FAIL = 9009;
        // 通用返回码 --end
    }

    /**
     * 返回Exception
     *
     * @author pc
     */
    public interface ExceptionReturnCode {

        // 通用返回码 --begin
        /**
         * 任务完成
         */
        int TASK_FINISHED = 10101;
        /**
         * 任务试读中
         */
        int TASK_TRY_READING = 10102;
        /**
         * 无数据
         */
        int TASK_NO_DATA = 10103;
        /**
         * 无数据
         */
        int DATASET_CONTAIN_INVALID_DATA = 10104;


        /**
         * 通用返回码：参数初始化失败
         */
        int ERROR_PARAM_TRANS_FAIL = 10001;

        /**
         * 通用返回码：业务处理失败
         */
        int ERROR_DEAL_FAIL = 10002;

        /**
         * 通用返回码：token失效
         */
        int ERROR_TOKEN_TIMEOUT = 10003;

        /**
         * 通用返回码：无访问接口权限
         */
        int ERROR_NOT_LIMIT = 10004;

        /**
         * 通用返回码：文件处理异常
         */
        int ERROR_FILE_DEAL = 10005;

        // 通用返回码 --end

        // 业务异常返回码 --begin
        /**
         * 质检拒绝返回码
         */
        int CHECK_DENY = 11001;

        // 业务异常返回码 --end
    }

    /**
     * 字典类型
     */
    public interface DictionaryType {
        /**
         * 最大录音条数
         */
        String RECORD_MAX_COUNT = "record_max_count";
    }

    /**
     * 常量byte0
     */
    public static final byte CONSTANT_BYTE_ZERO = 0;
    /**
     * 常量0
     */
    public static final int CONSTANT_ZERO = 0;
    /**
     * 常量0,LONG类型
     */
    public static final long CONSTANT_LONG_ZERO = 0L;
    /**
     * 常量1
     */
    public static final int CONSTANT_ONE = 1;
    /**
     * 常量byte1
     */
    public static final int CONSTANT_BYTE_ONE = 1;
    /**
     * 常量2
     */
    public static final int CONSTANT_TWO = 2;
    /**
     * 常量3
     */
    public static final int CONSTANT_THREE = 3;

    public interface MarkType {
        /**
         * 默认语音模版
         */
        Byte defaultAsr = 0;

        /**
         * 客服语音模版
         */
        Byte customerAsr = 1;
        /**
         * nlp扩写模版
         */
        Byte nlpextend = 2;
        /**
         * 音频时间轴
         */
        Byte audiotime = 3;
        /**
         * 文本问答
         */
        Byte txtanswer = 4;
        /**
         * 音频切割校对
         */
        Byte audiocut = 5;
        /**
         * 粤语语音模板
         */
        Byte YUEYU_audiocut = 6;
        /**
         * 哈萨克语音模板
         */
        Byte YUEYU = 7;
        /**
         * 粤语2.0 模板
         */
        Byte YUEYU2 = 8;
    }
}