/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in Myungji University.
 */
package Framework;

import Components.Sink.SinkFilter;
import Components.Source.SourceFilter;
import Components.Department.DepartmentFilter;
import Components.Prerequisite.Prerequisitefilter;

public class LifeCycleManager {
    public static void main(String[] args) {
        try {
            CommonFilter sourceFilter = new SourceFilter("Students.txt");
            CommonFilter departmentFilter = new DepartmentFilter();
            CommonFilter prerequisiteFilter = new Prerequisitefilter();
            CommonFilter sinkFilter = new SinkFilter("Output.txt");
            
            sourceFilter.connectOutputTo(departmentFilter);
            departmentFilter.connectOutputTo(prerequisiteFilter);
            prerequisiteFilter.connectOutputTo(sinkFilter);
            
            Thread sourceThread = new Thread(sourceFilter);
            Thread departmentThread = new Thread(departmentFilter);
            Thread prerequisiteThread = new Thread(prerequisiteFilter);
            Thread sinkThread = new Thread(sinkFilter);
            
            sourceThread.start();
            departmentThread.start();
            prerequisiteThread.start();
            sinkThread.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
