
Now, let's configure the Axon Ivy Engine with a license and a system database. 

First, you have to provide a valid Axon Ivy Engine license. Please refer to :ref:`license`.

If you do not have a license at this time, skip this section and continue with
the next section. Your Axon Ivy Engine will run in Demo Mode.


Besides the license, you need 

*  to have a supported SQL database management system server up and running

*  a database user who has the rights to create new databases and execute data
   definition language (DDL), as well as data manipulation language (DML)
   statements. The configuration and creation of the system database differ
   depending on the database system you use. In the following chapters, we will
   use a PostgreSQL database server.

.. important:: 

  We support that a DBA creates the database before you start the engine
  configuration. However, we do not support the external creation or migration
  of the database structure. 
  
  We require DDL permissions during installation and migrations. In normal
  operations, the database user provided to the engine needs DML permissions
  only.

There are multiple ways to configure the engine:

* **Using the Engine Cockpit Setup Wizard or Migration Wizard**

  This is the most convenient way to configure the engine if this is a
  one-of-a-kind installation. Please refer to :ref:`Setup Wizard <setup-wizard>`
  or :ref:`Migration Wizard <migration-wizard>` for details.

* **Manually**

  See below.

* **Scripted** 

  If you have several environments and want to set them up in a standardized
  way, your best option is to automate the manual steps using scripts. We do not
  provide a script template because there are too many ways to supply licenses,
  database user credentials, and other data.

