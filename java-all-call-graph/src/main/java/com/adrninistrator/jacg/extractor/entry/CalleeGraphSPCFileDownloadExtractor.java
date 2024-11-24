package com.adrninistrator.jacg.extractor.entry;

import com.adrninistrator.jacg.common.enums.OtherConfigFileUseListEnum;
import com.adrninistrator.jacg.conf.ConfigureWrapper;
import com.adrninistrator.jacg.handler.spring.SpringHandler;
import com.adrninistrator.javacg2.util.JavaCG2Util;

import java.util.List;

/**
 * @author adrninistrator
 * @date 2024/11/19
 * @description: 对向上的方法调用链文件进行数据提取，提取从指定被调用方法到（可能的）Spring Controller文件下载方法的信息
 */
public class CalleeGraphSPCFileDownloadExtractor extends CalleeGraphEntryExtractor {

    // 指定生成方法调用堆栈时的关键字使用代表入口方法的标志
    @Override
    protected boolean setFindStackKeyword4ee(ConfigureWrapper configureWrapper) {
        try (SpringHandler springHandler = new SpringHandler(configureWrapper)) {
            List<String> fileDownloadControllerFullMethodList = springHandler.queryFileDownloadControllerOnlyMethod();
            // 对（可能的）Spring Controller文件下载方法的处理
            fileDownloadControllerFullMethodList = handleFileDownloadControllerFullMethodList(fileDownloadControllerFullMethodList, configureWrapper);
            if (JavaCG2Util.isCollectionEmpty(fileDownloadControllerFullMethodList)) {
                return false;
            }
            configureWrapper.setOtherConfigList(OtherConfigFileUseListEnum.OCFULE_FIND_STACK_KEYWORD_4EE, fileDownloadControllerFullMethodList);
            return true;
        }
    }

    /**
     * 对（可能的）Spring Controller文件下载方法的处理，可重载进行自定义处理
     *
     * @param fileDownloadControllerFullMethodList
     * @param configureWrapper
     * @return
     */
    protected List<String> handleFileDownloadControllerFullMethodList(List<String> fileDownloadControllerFullMethodList, ConfigureWrapper configureWrapper) {
        return fileDownloadControllerFullMethodList;
    }
}