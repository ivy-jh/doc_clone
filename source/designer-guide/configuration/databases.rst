.. _database-configuration:

Databases
=========

To use databases in your business or User Dialog processes, start with defining
database configurations for each database you want to use. After you have
configured the databases (data sources) you can use them in your process steps.
The process steps reference only the database configuration ids.

.. _database-configuration-editor:

Database Configuration Editor
-----------------------------

The database configuration editor lets you configure the databases you use in
your project.

.. figure:: /_images/designer-configuration/database-editor.png
   :alt: Database Configuration Editor

   Database Configuration Editor

- :guilabel:`All Database Configurations` A list of all database configurations
  defined in this project. A red or green icon indicates the result of the
  connection test automatically executed upon saving a database configuration.

- :guilabel:`New`
  Add a new database configuration

- :guilabel:`Remove`
  Remove the selected database configuration

- :guilabel:`Test Connection` Test database connection. A dialog shows the
  result status. In case of failure, the reason is displayed

- :guilabel:`SQL`
  Opens a SQL editor to set up SQL Statements. The SQL Editor
  displays the query result in a result table

- :guilabel:`Database`
  Select the type and driver of the database you use. We ship some often
  used and well-tested drivers with the |ivy-designer|.

  The field :guilabel:`Max Connections` lets you specify the maximum number of
  concurrent connections to this database.
  
  Choose an :guilabel:`Icon` that represents the database. The icon will also be
  used as decorator icon on Database process elements that reference this
  database.  

- :guilabel:`Connection Properties`
  Specify the properties for the database connection.

- :guilabel:`Additional Connection Properties`
  If your database needs additional settings, you can use this section
  to define these properties.

Dynamic Properties
^^^^^^^^^^^^^^^^^^^^^^^^^
You may need to adjust property values for multiple runtime environments. 
E.g., use different database hosts for testing and production, 
consequently with other credentials and connection URIs.

If you anticipate this need, then you can simplify these configuration
adjustments for operations by using :ref:`dynamic-config` expressions in both
properties and other configuration values. E.g., the property
``databaseName=${ivy.var.cloudDb}`` is evaluated at runtime and has the value of
the variable called ``cloudDb``. Thus, your database name is now configurable
using variable ``cloudDb``. Operations need to set this variable correctly; they
do not need to dive into the configuration of this external database.
