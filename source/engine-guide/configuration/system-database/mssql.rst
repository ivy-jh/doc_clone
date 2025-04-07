.. _systemdb-mssql:

Microsoft SQL Server
--------------------

There are two basic authentication schemes used to connect to a Microsoft SQL
Server, *SQL Server Authentication* and *Windows Authentication*.

SQL Server Authentication
*************************

With SQL Server Authentication you are connecting to the database with a database user.

.. literalinclude:: ../../../../target/resources/includes/configuration/templates/ivy-systemdb-mssql.yaml
  :language: yaml
  :linenos:

.. note::

   On an SQL Server installation, only Windows Authentication is enabled by
   default. If you face problems connecting to the database, check if SQL Server
   Authentication is activated.

Windows Authentication
**********************

Microsoft SQL Server can be configured to use Windows credentials to log into
the database.

There are two ways to do that:

* configure a specific Windows user (and password), 
* user credentials of the user running the Axon Ivy Engine are used.

**Using specific Windows user:**

.. literalinclude:: ../../../../target/resources/includes/configuration/templates/ivy-systemdb-mssql-windows-user.yaml
  :language: yaml
  :linenos:

**Using user credentials of the process owner:**

.. literalinclude:: ../../../../target/resources/includes/configuration/templates/ivy-systemdb-mssql-windows-service-user.yaml
  :language: yaml
  :linenos:

Instance Name
*************

Microsoft recommends not to use the ``instanceName`` and prefers specifying
the port in the connection URL, as for each connection, there is a round trip
to determine the port. Therefore you will need to configure a static
TCP port (e.g., 1433) in the **SQL Server Configuration Manager**.

If you need to work with the ``instanceName``, you have to define it as an
additional connection property and remove the port specification in the
connection URL.

.. tip:: 
  If you cannot connect to a Microsoft SQL Server, check first if the TCP/IP
  protocol for SQL Server is activated (by default, it is deactivated). If you still
  face problems, then you may check if SQL Server Authentication is activated. By
  default, only Windows Authentication is enabled.

If the database is created by the Axon Ivy Engine the collation is set to
``Latin1_General_CI_AI`` for SQL Server older than 2019 and ``Latin1_General_100_CI_AI_SC_UTF8`` for SQL Server 2019 and newer.
