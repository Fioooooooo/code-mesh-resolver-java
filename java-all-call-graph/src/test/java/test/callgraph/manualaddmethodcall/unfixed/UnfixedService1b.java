package test.callgraph.manualaddmethodcall.unfixed;

import test.callgraph.methodargument.TestArgument1;

import java.util.LinkedList;

/**
 * @author adrninistrator
 * @date 2022/12/6
 * @description:
 */
public class UnfixedService1b extends AbstractUnFixedService1<TestArgument1, LinkedList> {
    @Override
    protected LinkedList execute(TestArgument1 t, LinkedList list) {
        System.getProperty(null);
        return null;
    }
}
