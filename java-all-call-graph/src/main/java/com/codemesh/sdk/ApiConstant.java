package com.codemesh.sdk;

/**
 * @author Fio
 * @date 2025/3/4
 */
public class ApiConstant {

    private static final String API_VERSION = "1.0.0";

    private static final String API_PREFIX = "http://127.0.0.1:7071/openApi";

    /**
     * 更新任务状态，start / finish
     */
    public static final String UPDATE_TASK_STATUS = API_PREFIX + "/updateTaskStatus";

    /**
     * 任务日志上报
     */
    public static final String LOG_REPORT = API_PREFIX + "/logReport";

    /**
     * 清理工程所有的 call chain
     */
    public static final String CLEAN_CALL_CHAINS = API_PREFIX + "/cleanCallChain";

    /**
     * 添加新的 call chain
     */
    public static final String ADD_CALL_CHAIN = API_PREFIX + "/addCallChain";

}
