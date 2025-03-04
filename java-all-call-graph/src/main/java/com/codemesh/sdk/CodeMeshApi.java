package com.codemesh.sdk;

import com.codemesh.sdk.request.AddCallChainRequest;
import com.codemesh.sdk.request.CleanCallChainsRequest;
import com.codemesh.sdk.request.CodeMeshRequest;
import com.codemesh.sdk.request.LogReportRequest;
import com.codemesh.sdk.request.TaskStatusRequest;

/**
 * @author Fio
 * @date 2025/3/4
 */
public class CodeMeshApi {

    public static boolean updateTaskStatus(TaskStatusRequest.StatusEnum status) {
        TaskStatusRequest request = TaskStatusRequest.builder().status(status).build();
        return false;
    }

    public static boolean logReport(LogReportRequest request) {
        return false;
    }

    public static boolean cleanCallChains(Long workspaceId, Long projectId) {
        CodeMeshRequest request = CleanCallChainsRequest.builder()
                .workspaceId(workspaceId).projectId(projectId).build();
        return false;
    }

    public static boolean addCallChain(AddCallChainRequest request) {
        return false;
    }

}
