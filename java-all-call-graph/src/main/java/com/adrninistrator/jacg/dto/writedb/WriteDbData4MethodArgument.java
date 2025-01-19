package com.adrninistrator.jacg.dto.writedb;

import com.adrninistrator.jacg.dto.writedb.base.BaseWriteDbData;

/**
 * @author adrninistrator
 * @date 2023/4/12
 * @description: 用于写入数据库的数据，方法的参数
 */
public class WriteDbData4MethodArgument implements BaseWriteDbData {

    private int recordId;
    private String methodHash;
    private Integer argSeq;
    private String simpleArgType;
    private String argName;
    private String argType;
    private int arrayDimensions;
    private String argCategory;
    private int existsGenericsType;
    private String simpleClassName;
    private String fullMethod;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getMethodHash() {
        return methodHash;
    }

    public void setMethodHash(String methodHash) {
        this.methodHash = methodHash;
    }

    public Integer getArgSeq() {
        return argSeq;
    }

    public void setArgSeq(Integer argSeq) {
        this.argSeq = argSeq;
    }

    public String getSimpleArgType() {
        return simpleArgType;
    }

    public void setSimpleArgType(String simpleArgType) {
        this.simpleArgType = simpleArgType;
    }

    public String getArgName() {
        return argName;
    }

    public void setArgName(String argName) {
        this.argName = argName;
    }

    public String getArgType() {
        return argType;
    }

    public void setArgType(String argType) {
        this.argType = argType;
    }

    public int getArrayDimensions() {
        return arrayDimensions;
    }

    public void setArrayDimensions(int arrayDimensions) {
        this.arrayDimensions = arrayDimensions;
    }

    public String getArgCategory() {
        return argCategory;
    }

    public void setArgCategory(String argCategory) {
        this.argCategory = argCategory;
    }

    public int getExistsGenericsType() {
        return existsGenericsType;
    }

    public void setExistsGenericsType(int existsGenericsType) {
        this.existsGenericsType = existsGenericsType;
    }

    public String getSimpleClassName() {
        return simpleClassName;
    }

    public void setSimpleClassName(String simpleClassName) {
        this.simpleClassName = simpleClassName;
    }

    public String getFullMethod() {
        return fullMethod;
    }

    public void setFullMethod(String fullMethod) {
        this.fullMethod = fullMethod;
    }
}
