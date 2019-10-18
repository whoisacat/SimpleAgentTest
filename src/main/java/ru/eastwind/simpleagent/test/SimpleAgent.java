package ru.eastwind.simpleagent.test;

import javax.management.*;
import java.lang.management.*;

public class SimpleAgent
{
    private MBeanServer mbs = null;

    public SimpleAgent()
    {
        mbs = ManagementFactory.getPlatformMBeanServer();

        Hello helloBean = new Hello();
        ObjectName helloName = null;

        try {
            helloName = new ObjectName("SimpleAgent:name=hellothere");
            mbs.registerMBean(helloBean, helloName);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static int waitForEnterPressed()
    {
        try {
            System.out.println("Press  to continue...");
            return System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
            return 256;
        }
    }
    public static void main(String args[])
    {
        SimpleAgent agent = new SimpleAgent();
        System.out.println("SimpleAgent is running...");
        System.out.println((char) SimpleAgent.waitForEnterPressed());
        System.out.println("Ну и зачем ты что-то нажал???");
    }
}
