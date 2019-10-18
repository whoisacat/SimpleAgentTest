//package ru.eastwind.simpleagent.test;
//
//import javax.management.MBeanServer;
//import javax.management.ObjectName;
//import java.lang.management.ManagementFactory;
//import com.sun.jdmk.comm.HtmlAdaptorServer;
//
//public class SimpleAgentHTTP не работает, не нашел jar для HtmlAdaptorServer
//{
//    private MBeanServer mbs = null;
//
//    public SimpleAgentHTTP()
//    {
//        mbs = ManagementFactory.getPlatformMBeanServer();
//        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
//
//        Hello helloBean = new Hello();
//        ObjectName adapterName = null;
//        ObjectName helloName = null;
//
//        try {
//            helloName = new ObjectName("SimpleAgentHTTP:name=hellothere");
//            mbs.registerMBean(helloBean, helloName);
//
//            adapterName = new ObjectName("SimpleAgent:name=htmladapter,port=18000");
//            adapterName.setPort(8000);
//            mbs.registerMBean(adapter, adapterName);
//            adapter.start();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//    private static int waitForEnterPressed()
//    {
//        try {
//            System.out.println("Press  to continue...");
//            return System.in.read();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 256;
//        }
//    }
//    public static void main(String args[])
//    {
//        SimpleAgentHTTP agent = new SimpleAgentHTTP();
//        System.out.println("SimpleAgent is running...");
//        System.out.println((char) SimpleAgentHTTP.waitForEnterPressed());
//        System.out.println("Ну и зачем ты что-то нажал???");
//    }
//}
