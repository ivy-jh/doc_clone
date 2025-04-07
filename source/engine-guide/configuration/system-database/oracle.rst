.. _systemdb-oracle:

Oracle
------

.. literalinclude:: ../../../../target/resources/includes/configuration/templates/ivy-systemdb-oracle.yaml
  :language: yaml
  :linenos:

If database will be created by the Axon Ivy Engine the collate is set to ``Latin1_General_CI_AI``.


.. tip::

  On all (reused) oracle database connections the maximum number of open cursors
  is set to 1000, independently from the default setting that may be set on the
  database itself. Those cursors are needed to cache all prepared statements and
  also for PL/SQL blocks.

  It may turn out that the number of open cursors is exceeded, which is
  indicated by an error message similar to the following:

  .. code:: bash
  
    ch.ivyteam.ivy.persistence.PersistencyException: java.sql.SQLException: 
    ORA-00604: error occurred at recursive SQL level 1
    ORA-01000: maximum open cursors exceeded

  If this should happen, then you may customize (and increase) the number of
  open cursors per connection with the Java system property
  ``ch.ivyteam.ivy.persistence.db.oracle.MaxOpenCursors``. It can be set in the
  :ref:`jvm-options`.

.. note:: Schema Creation
    
    Before you can create the system database tables on a Oracle Database you have to do the following steps:

    #. You may want to create a new Oracle database where the Axon Ivy Engine
       System Database is located. This is optional you can use an already existing
       Oracle database.
    #. Create a new user (e.g., AxonIvy) or let the Axon Ivy Engine create one
       for you with the Setup Wizard. You can use the following script to
       create a new user with sufficient permissions:

       .. literalinclude:: ../../../../target/resources/includes/db/oracle/oracle-create-user.sql
         :language: sql

    #. You may want to create a new tablespace (e.g., AxonIvy) where the Axon Ivy Engine
       System Database can store the table data. This is optional you can
       use an already existing tablespace.

.. warning:: 
    Be sure that the configuration of the database connection uses the new
    database and the Oracle Service ID reflecting the database you want to
    create the system database tables in.
