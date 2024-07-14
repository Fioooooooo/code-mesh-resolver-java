package com.adrninistrator.jacg.handler.writedb;

import com.adrninistrator.jacg.common.annotations.JACGWriteDbHandler;
import com.adrninistrator.jacg.common.enums.DbTableInfoEnum;
import com.adrninistrator.jacg.dto.writedb.WriteDbData4MyBatisMSTable;
import com.adrninistrator.jacg.dto.writedb.WriteDbResult;
import com.adrninistrator.jacg.extensions.codeparser.jarentryotherfile.MyBatisMySqlSqlInfoCodeParser;
import com.adrninistrator.jacg.util.JACGFileUtil;

import java.util.Set;

/**
 * @author adrninistrator
 * @date 2023/3/14
 * @description: 写入数据库，MyBatis Mapper方法操作的数据库表信息（使用MySQL）
 */
@JACGWriteDbHandler(
        readFile = true,
        otherFileName = MyBatisMySqlSqlInfoCodeParser.FILE_NAME,
        minColumnNum = 6,
        maxColumnNum = 6,
        dbTableInfoEnum = DbTableInfoEnum.DTIE_MYBATIS_MS_TABLE
)
public class WriteDbHandler4MyBatisMSTable extends AbstractWriteDbHandler<WriteDbData4MyBatisMSTable> {

    // 保存MyBatis Mapper唯一类名
    private Set<String> myBatisMapperSimpleNameSet;

    public WriteDbHandler4MyBatisMSTable(WriteDbResult writeDbResult) {
        super(writeDbResult);
    }

    @Override
    protected WriteDbData4MyBatisMSTable genData(String[] array) {
        String mapperClassName = array[0];
        // 根据类名前缀判断是否需要处理
        if (!isAllowedClassPrefix(mapperClassName)) {
            return null;
        }

        String mapperMethodName = array[1];
        String sqlStatement = array[2];
        int tableSeq = Integer.parseInt(array[3]);
        String tableName = array[4];
        String xmlFilePath = array[5];
        String xmlFileName = JACGFileUtil.getFileNameFromPathInJar(xmlFilePath);
        String mapperSimpleClassName = dbOperWrapper.getSimpleClassName(mapperClassName);
        // 记录MyBatis Mapper唯一类名
        myBatisMapperSimpleNameSet.add(mapperSimpleClassName);
        return new WriteDbData4MyBatisMSTable(
                mapperSimpleClassName,
                mapperMethodName,
                sqlStatement,
                tableSeq,
                tableName,
                mapperClassName,
                xmlFileName,
                xmlFilePath
        );
    }

    @Override
    protected Object[] genObjectArray(WriteDbData4MyBatisMSTable data) {
        return new Object[]{
                genNextRecordId(),
                data.getMapperSimpleClassName(),
                data.getMapperMethodName(),
                data.getSqlStatement(),
                data.getTableSeq(),
                data.getTableName(),
                data.getMapperClassName(),
                data.getXmlFileName(),
                data.getXmlFilePath()
        };
    }

    @Override
    public String[] chooseFileColumnDesc() {
        return new String[]{
                "MyBatis Mapper接口类名",
                "MyBatis Mapper方法名",
                "sql语句类型",
                "数据库表序号",
                "数据库表名",
                "MyBatis XML文件路径"
        };
    }

    @Override
    public String chooseNotMainFileDesc() {
        return "MyBatis Mapper方法操作的数据库表信息（使用MySQL）";
    }

    @Override
    public String[] chooseFileDetailInfo() {
        return new String[]{
                "使用MySQL时，MyBatis的Mapper接口方法中涉及到的数据库表信息"
        };
    }

    public void setMyBatisMapperSimpleNameSet(Set<String> myBatisMapperSimpleNameSet) {
        this.myBatisMapperSimpleNameSet = myBatisMapperSimpleNameSet;
    }
}
