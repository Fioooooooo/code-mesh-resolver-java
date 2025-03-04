package com.codemesh.sdk.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Fio
 * @date 2025/3/4
 */
@Data
@Builder
public class CodeMeshRequest implements Serializable {

    private static final long serialVersionUID = 6424880880797663631L;

    /**
     * workspace ID
     */
    private Long workspaceId;

    /**
     * project ID
     */
    private Long projectId;

}
