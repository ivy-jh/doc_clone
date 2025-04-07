.. _process-element-performance:

Process Element Performance
===========================

To optimize the performance of your processes and process elements you can 
use process element performance statistics to analyze the performance of 
the engine. This allows you to detect long-running and performance-intensive 
process elements and processes which you then can optimize. 
 
Engine Cockpit
--------------

You can activate and analyze the results of the performance statistics in the 
:ref:`engine-cockpit-monitor-performance` view of the :ref:`engine-cockpit`.
  
.. _process-element-performance-file:
  
CSV Statistics File
-------------------

It is possible to configure Axon Ivy Engine to print out performance statistics
information periodically into a CSV formatted file. The file contains detailed 
information for each process element executed since the last dump.

After activation, all performance-related information is collected and written
to the :file:`log` directory of your Axon Ivy Engine installation. The file name
has the pattern :file:`performance_statistic_yyyy-mm-dd_hh-mm-ss.csv`
(e.g., :file:`performance_statistic_2011-03-15_09-21-05.csv`)

Process element performance statistics are not collected by default. They need to
be enabled in the :code:`ProcessEngine` section of the :ref:`ivy-yaml` file.

Analyze
-------

Time values are in milliseconds. The execution of most process elements gets
divided into two categories, internal and external.

**Internal Category**
    The internal category is used for the execution time in the process engine
    itself, without the external execution time.

**External Category**
    The external category is used for execution time in external systems. In the
    table below, the process elements that use the external category are listed.

+-----------------------+----------------------------------------------------------------------+------------------------------------------------------------+
| Process Element       | Internal Category                                                    | External Category                                          |
+=======================+======================================================================+============================================================+
| Database Step         | Parameter-mapping, caching, output-mapping, and IvyScript execution. | The execution of the SQL statement on the database server. |
+-----------------------+----------------------------------------------------------------------+------------------------------------------------------------+
| Web Service Call Step | Parameter-mapping, caching, output-mapping, and IvyScript execution. | The execution of the Web Service on the web server.        |
+-----------------------+----------------------------------------------------------------------+------------------------------------------------------------+
| E-Mail Step           | Parameter-mapping                                                    | The interaction with the Mail-Server.                      |
+-----------------------+----------------------------------------------------------------------+------------------------------------------------------------+
| Program Interface     |                                                                      | The execution of the defined Java-Class.                   |
+-----------------------+----------------------------------------------------------------------+------------------------------------------------------------+

An entry in the view is created for each executed process element. The table below
shows what information is available.

+-----------------+----------------------------------------------------------------+
| Name            | Description                                                    |
+=================+================================================================+
| Entry ID        | Entry ID. Useful to order the entries by their first execution.|
+-----------------+----------------------------------------------------------------+
| Application     | Application of the process element.                            |
+-----------------+----------------------------------------------------------------+
| Process Model   | Process Model of the process element.                          |
+-----------------+----------------------------------------------------------------+
| PM Version      | Process Model Version of the process element.                  |
+-----------------+----------------------------------------------------------------+
| Process Path    | The path to the process.                                       |
+-----------------+----------------------------------------------------------------+
| Element ID      | The identifier of the process element.                         |
+-----------------+----------------------------------------------------------------+
| Element Name    | The first line of the process element name (display name).     |
+-----------------+----------------------------------------------------------------+
| Element Type    | The type of the process element.                               |
+-----------------+----------------------------------------------------------------+
| Total Time      | Total time [ms] of internal and external execution.            |
+-----------------+----------------------------------------------------------------+
| Int. Executions | Total internal executions of the process element.              |
+-----------------+----------------------------------------------------------------+
| Total Int. Time | Total internal time [ms] of process engine executions.         |
+-----------------+----------------------------------------------------------------+
| Min. Int. Time  | Minimum internal process engine execution time [ms].           |
+-----------------+----------------------------------------------------------------+
| Avg. Int. Time  | Average internal process engine execution time [ms].           |
+-----------------+----------------------------------------------------------------+
| Max. Int. Time  | Maximum internal process engine execution time [ms].           |
+-----------------+----------------------------------------------------------------+
| Ext. Executions | Total external execution count.                                |
+-----------------+----------------------------------------------------------------+
| Total Ext. Time | Total external execution time [ms].                            |
+-----------------+----------------------------------------------------------------+
| Min. Ext. Time  | Minimum external execution time [ms].                          |
+-----------------+----------------------------------------------------------------+
| Avg. Ext. Time  | Average external execution time [ms].                          |
+-----------------+----------------------------------------------------------------+
| Max. Ext. Time  | Maximum external execution time [ms].                          |
+-----------------+----------------------------------------------------------------+
