.. _systemdb:

System Database
===============

After initial installation, the Axon Ivy Engine runs in :ref:`demo mode
<demo-mode>`. This implies that workflow data is kept in memory and not
persisted (stored).

To run a productive engine, an external system database has to be connected,
where data will be stored.

To define the database of the Axon Ivy Engine, the :code:`SystemDb` entries have to
be set.

.. literalinclude:: ivy-systemdb.yaml
  :language: yaml
  :linenos:

The following database management systems are supported, choose one:

.. toctree::
   :maxdepth: 1

   postgres
   mysql
   mariadb
   mssql
   oracle 

Use the :ref:`setup-wizard` or the :ref:`engine-config-cli` to create the system
database. To run the Axon Ivy Engine with a system database, a :ref:`license
<license>` is required.

.. rubric:: Advanced Configuration

* User passwords are stored in encrypted form (hash) in the system database.

* In some cases, you may want to perform :ref:`case-insensitive searches
  <systemdb-case-insensitive-searches>` for tasks or cases, for example. For
  this purpose, the system database has to be configured accordingly.

* All tables and columns of the system database are described in the
  :ref:`schema reference <systemdb_schema>`.

.. toctree::
   :maxdepth: 1
   :hidden:

   case-insensitive-searches
