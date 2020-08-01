package com.futve.common.constant;

import java.util.ArrayList;
import java.util.List;

public class TaskConstant {
    /**
     * 重录状态
     */
    public interface RerecordStatus {
        /**
         * 初始
         */
        byte RECORD_START = 0;
        /**
         * 待重录
         */
        byte RECORD_WAIT = 1;
        /**
         * 重录完成
         */
        byte RECORDED_FINISH = 2;
        /**
         * 重录数据质检中
         */
        byte RECORD_WAIT_CHECK = 3;
        /**
         * 质检完成
         */
        byte RECORD_CHECK_FINISH = 4;
        /**
         * 质检中断
         */
        byte RECORD_CHECK_INTERRUPT = 5;
        /**
         * 不能打回成全部重录的状态
         */
        List<Byte> unBackAll = new ArrayList() {{
            add(RerecordStatus.RECORDED_FINISH);
            add(RerecordStatus.RECORD_WAIT_CHECK);
        }};
    }

}
