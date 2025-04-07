.. _engine-cockpit-monitor:

Monitor
-------

The **Engine Cockpit** allows you to :ref:`monitor <monitoring>` your Axon Ivy Engine.

OS
^^

The **OS** page shows an overview of the CPU load, memory load, network traffic
and disk read-write activity. Additionally, the memory monitor displays the max
and current memory usage of the JVM.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-os.png

Java
^^^^

The **Java** pages allow you to monitor some critical indicators of Java (Java virtual machine) in your Axon Ivy Engine:

- **JVM**: CPU load, number of threads, loaded and unloaded classes
- **Memory**: Heap and non-heap memory, garbage collection times
- **Class Histogram**: Classes and their instances allocated on the heap
- **Threads**: Threads and their CPU and user times 
- **Flight Recorder**: Start, stop and download `Java flight Recordings <https://docs.oracle.com/en/java/java-components/jdk-mission-control/>`_
- **MBeans**: :ref:`jmx` MBeans viewer

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-jvm.png

.. _engine-cockpit-monitor-class-histogram:

Class Histogram
"""""""""""""""

The **Class Histogram** view displays all classes that have currently object instances allocated on the heap. 
The view shows a filterable list of all classes, the number of allocated instances, and the allocated memory those instances consume, in bytes.
If you refresh the view, the deltas to the minimum and maximum number of instances are displayed. This allows you to find memory leaks. If the 
number of instances of a class has always an increasing Δ Min and the Δ Max is always zero, then you have a memory leak. 
If you need further details to analyze a memory leak you can press the :guilabel:`Dump Heap Memory` button to create and download a dump of the heap memory.
We recommend that you use `Eclipse Memory Analyzer <https://www.eclipse.org/mat>`_ to further analyze the produced heap dump file.  
 
.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-class-histogram.png

Threads
"""""""

The **Threads** view shows you an overview of all threads. For each thread, you see how much CPU and user time it consumes, 
in which states they are, and their priorities. 
If two threads are deadlocked the **State** of the threads is red and there is a warning icon nearby with more information about the deadlock.
You can click on a thread to get more information about it like the current stack trace.
Press on the **Save Thread Dump** icon on the top right to create a thread dump and download it to a file.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-threads.png

Java Flight Recorder
""""""""""""""""""""

You can use the **Flight Recorder** view to start, stop, download, and delete `Java Flight Recorder <https://docs.oracle.com/en/java/java-components/jdk-mission-control/>`_ recordings. 
When starting a recording, you can choose between predefined configurations that are provided by the Java Virtual Machine or you can add your own
configuration by uploading a :file:`\*.jfc` file. You can create a :file:`\*.jfc` file with Flight Recorder Template Manager that is part of the `JDK Mission Control tool <https://docs.oracle.com/en/java/java-components/jdk-mission-control/>`_.
You can download a recording to a :file:`\*.jfr` file once it is stopped. Then, use the `JDK Mission Control <https://docs.oracle.com/en/java/java-components/jdk-mission-control/>`_ tool to analyze the :file:`\*.jfr` file.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-jfr.png     

.. _engine-cockpit-monitor-mbeans:

MBeans
""""""

The **MBeans** view displays a tree with all engine :ref:`jmx` MBeans. Click on
one of the MBeans to see all of its attributes. Click on an attribute with
numeric values to display the value of the attribute over time in a chart. You
can add multiple attributes to the chart. Click on the remove icon in the table
below the chart to remove the attribute from the chart.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-mbeans.png

Engine
^^^^^^

The **Engine** pages allow you to monitor some critical indicators of your |ivy-engine|:

- **Notifications**: Overview of all user notifications
- **Sessions**: Overview of open user sessions
- **Jobs**: Jobs that are periodically executed and their metrics
- **Cache**: System database caches and their metrics
- **Health**: Health messages and checks


.. _engine-cockpit-notifications:

Notifications
"""""""""""""

The **Notifications** view gives you an overview of all user notifications.
Based on the notification subscription settings, the |ivy-engine| sends
different notification over the configured notification channels. By 
:ref:`clicking <engine-cockpit-notification-detail>` on a notification you can
see more details.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-notifications.png


.. _engine-cockpit-notification-detail:

Notification Detail
"""""""""""""""""""

A notification can be sent to multiple users over different channels. You can inspect
the state of a notification, whether the notification was successfully
delivered or not. And many more details, when it has been delivered or the error message
if the delivery was not successful.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-notification-deliveries.png


Sessions
""""""""

The **Sessions** view gives you an overview of all open user sessions.
Sessions can be destroyed and you can also see the reason for open sessions,
especially in the case of a session leak.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-sessions.png


.. _engine-cockpit-monitor-jobs:

Jobs
""""

The **Jobs** view displays a table with all jobs that are periodically executed by |ivy|.
The :guilabel:`Configuration` column shows how often or when (:ref:`configuration-cron`) a job is executed. 
The :guilabel:`Next execution` column shows when the job is executed the next time. 
Finally, columns show the number of times the job was already executed and how often it has failed.
You can click on a job to get more information about it like the last time it was successfully executed, the last time it failed, 
the reason it failed, and the execution duration.
Press the :guilabel:`Schedule` button at the end of each row to execute the job immediately.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-jobs.png

Cache
"""""

The **Cache** view displays a table with all system database caches and their metrics.
The caches reduce the number of system database read accesses.
 
Increasing the amount of data that is cached may help solve performance problems. 
You should try to increase the cache limits if you have a lot of read misses and the number 
of cached entities are near or above the limit. 
If this is the case, the number of both corresponding columns are displayed in red. 
You can configure the cache limits in the :ref:`ivy.yaml <ivy-cache-properties>` file.     

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-cache.png

.. _engine-cockpit-monitor-health:

Health
""""""

The **Health** view displays a table with the current :ref:`health messages <health>`.

The :guilabel:`Severity` column tells you how urgent the message is. 
`CRITICAL` messages should be addressed immediately.
The :guilabel:`Message` and :guilabel:`Description` columns describe the problem and gives you hints about what needs to be done.
Some health messages provide a link to another Engine Cockpit or setup page where you can either analyze or fix the problem.

Use the :guilabel:`Run Health Check` button to execute all health checks.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-health.png

To see all health checks that are available click on the :guilabel:`Health Checks` button. 


On the **Health Checks** view a list of all health checks is displayed. 
You see when a check will be executed next.
Use the :guilabel:`Disable` and :guilabel:`Enable` buttons to disable or enable a check.
With the :guilabel:`Run check now` button you can immediately execute a check.  

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-health-checks.png

.. _engine-cockpit-monitor-workflow:

Workflow
^^^^^^^^

- **Documents**: Workflow and case documents
- **Start Events**: Process start events and their metrics 
- **Intermediate Events**: Process intermediate events and their metrics

Documents
"""""""""

The **Documents** view gives you an overview of documents attached to a case
or workflow documents.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-documents.png


.. _engine-cockpit-monitor-start-events:

Start Events
""""""""""""

The **Start Events** view displays a table with all process start events.
The table shows the name, description, and request path of the start event. 
It also shows when the poll method will be called the next time. 
How often the start event has started a process (:guilabel:`Executions`) and 
how many of those attempts have failed (:guilabel:`Errors`).   
You can start and stop or schedule the execution of the poll method of a start event.
 
Press on the name of a start event to see even more detail information of the start event like configuration, errors, 
poll and execution information.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-start-events.png

.. _engine-cockpit-monitor-intermediate-events:

Intermediate Events
"""""""""""""""""""

The **Intermediate Events** view displays a table with all process intermediate events.
The table shows the name, description, and request path of the intermediate event. 
It also shows when the poll method will be called the next time. 
How often the intermediate event has fired (:guilabel:`Executions`) and 
how many of those attempts have failed (:guilabel:`Errors`).   
You can start and stop or schedule the execution of the poll method of a intermediate event.
 
Press on the name of an intermediate event to see even more detail information of the intermediate event like configuration, errors, 
poll and execution information.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-intermediate-events.png


.. _engine-cockpit-monitor-performance:

Performance
^^^^^^^^^^^

The **Performance** pages allow you to monitor performance indicators of your Axon Ivy Engine:

- **Process Execution**: Execution times of process elements
- **Slow Requests**: Analyze slow requests and their causes 
- **Traffic Graph**: Overview of the inbound and outbound traffic

Process Execution
"""""""""""""""""

The **Process Execution** view allows you to activate and analyze the :ref:`process-element-performance` statistic. 

You can start, stop, clear or refresh the statistic, or export it to an Excel file. Note: by default not all
available columns are shown. Use the configure columns button right to the search box to show or hide the columns. 

If you want to configure that the statistic is written periodically to a :ref:`process-element-performance-file`
use the configuration icon left to the help button it will take you directly to the corresponding settings 
in the :ref:`engine-cockpit-system-configuration`.  

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-process-execution.png


.. _engine-cockpit-monitor-slow-requests:

Slow Requests
"""""""""""""

The **Slow Requests** view allows you to activate and analyze the :ref:`tracing`. If activated every 
request is traced. The fifty slowest requests will be displayed in this view.

You can start, stop, clear or refresh the tracing or export it to an Excel file. 
Hover with the mouse on the name to see additional attributes of the request. 
You can click on a request to see where the time of the request was spent 
(e.g., on external calls to REST, SOAP service, databases etc.).   

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-slow-requests.png

.. _engine-cockpit-monitor-traffic-graph:

Traffic Graph
"""""""""""""

The **Traffic Graph** view gives you a quick overview of inbound  and outbound 
communication channels to and from the Axon Ivy Engine. The more request a certain 
communication channel has the wider it is displayed. The color reflects the response times. 
Green means fast response times. Red means slow request times relative to the other communication channels. 
The color of the source or target of a communication link indicates if there are errors. 
Hover over source or target of a communication channel to get more detailed information.
Like :ref:`engine-cockpit-monitor-slow-requests` you have to activate :ref:`tracing` to get useful data.
 
.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-traffic-graph.png

Logs
^^^^

The **logs** view shows the current engine log files :file:`console.log`,
:file:`config.log`, :file:`deprecation.log`, :file:`ivy.log` and :file:`usersynch.log`.
Click on :guilabel:`+` to show or :guilabel:`-` to hide the log file details. If you
want to look at the logs of an different day, you can change the date at the top right.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-logs.png

.. _engine-cockpit-monitor-services:

Services
^^^^^^^^

The **Services** pages allows you to monitor some critical indicators of external services your Axon Ivy Engine communicates with:

- **Email**: Number of mails sent, execution time to send mails. 
- **System Database**: Number of open and used connections, number of transactions and errors, transaction processing time.
- **Databases**: Number of open and used connections, number of queries and errors, query execution time of the selected database.
- **Web Services**: Number of calls and errors, execution time of the selected web service.
- **REST Clients**: Number of open and used connections, Number of calls and errors, execution time of the selected REST client.

You can open these life stats from the detailed view of the desired service using the monitor button at the right side.

.. figure:: /_images/engine-cockpit/engine-cockpit-monitor-databases.png

