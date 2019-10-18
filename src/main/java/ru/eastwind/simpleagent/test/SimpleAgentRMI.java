package ru.eastwind.simpleagent.test;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;

public class SimpleAgentRMI
{
    private MBeanServer mbs = null;

    //rmiregistry.exe 9999 о той же java что и в проекте
    public SimpleAgentRMI()
    {
        mbs = ManagementFactory.getPlatformMBeanServer();

        Hello helloBean = new Hello();
        ObjectName helloName = null;

        try {
            helloName = new ObjectName("SimpleAgentRMI:name=hellothere");
            mbs.registerMBean(helloBean, helloName);

            JMXServiceURL url =
                    new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/server");
            JMXConnectorServer cs =
                    JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
            cs.start();
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
        SimpleAgentRMI agent = new SimpleAgentRMI();
        System.out.println("SimpleAgent is running...");
        System.out.println((char) SimpleAgentRMI.waitForEnterPressed());
        System.out.println("Ну и зачем ты что-то нажал???");
    }
}
