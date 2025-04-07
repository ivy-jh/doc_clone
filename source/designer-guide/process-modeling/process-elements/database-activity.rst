.. _process-element-db-activity:

Database Activity
===================

|image0| The *Database Activity* element is located in the
*Activity* drawer of the process editor palette.

Element Details
---------------

With this element you can execute SQL commands on the database server.
You can access all the databases that are defined in the :ref:`database-configuration`.

Inscription
-----------

.. include:: _tab-name.rst

Query Tab
~~~~~~~~~~~

Here you define which SQL command you want to execute on which database.
Depending on the kind of SQL command you are supported during the
construction of your command.

.. figure:: /_images/process-inscription/database-tab-query.png
   :alt: Query Tab

   Query Tab

Kind of Query
   Choose the kind of query you like to perform. Axon Ivy offers
   dedicated UI support for the most common query types such as
   ``Select`` (Read), ``Insert`` (Write), ``Update`` (Update) and ``Delete`` (Delete).

   If you require some non-standard SQL or if you want to issue a
   complex SQL statement that is not covered by the *Query Definition*
   mask then you may also select ``Any`` and write pure SQL instead.
   Expanding of process attributes will also work in the *Any Query*
   mode.

   .. warning::

      The use of the **Any Query** option can lead to `SQL
      injection <https://en.wikipedia.org/wiki/SQL_injection>`__
      vulnerabilities if not used carefully.

      E.g., if a ``String`` variable is passed into a query then an
      attacker could provide a valid partial SQL statement which is then
      executed in the context of the query.

      Assume the following SQL statement is configured as an SQL query:
      ``SELECT * FROM Subscriber WHERE Name LIKE 'in.searchText%'``.
      Now if an attacker manages to pass a valid SQL statement into the
      ``in.searchText`` variable then a so called SQL injection takes
      place, which can result in a complete data breach on the
      configured database. Process designers are responsible to only
      pass sanitized data into an SQL query. In some cases it might be
      better to access the Database with JPA/Hibernate or prepared
      statements using JDBC. For more information see: `SQL Injection
      Prevention Cheat
      Sheet <https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/SQL_Injection_Prevention_Cheat_Sheet.md>`__

Database
   Choose the database on which the command is executed. The database
   must be configured in the :ref:`database-configuration`.

   .. warning::

      Please note that the **DB2** database is currently not fully
      supported by the DB Step. The only query kind that is suitable for
      DB2 connections is ``Any Query``. For all other query kinds
      the *Query Definition* mask is currently not working correctly
      (e.g., query fields can not be edited / defined).

   There is also an ``IvySystemDatabase`` datasource which points to the
   current System Database. Normally you would prefer your own database
   to split valuable customer data from the system data.

   .. warning::

      Do not manipulate system database tables prefixed with ``IWA_``
      within the ``IvySystemDatabase`` this could lead to unexpected
      runtime behavior.

Query Definition
   Depending on the type of query you can compose your command with
   almost no knowledge about databases and SQL.

   Table
      The name of the database table to read from, insert into, update
      in or delete from.

   Fields
      The fields of the database table to read from, insert values into
      or update values in.

   Condition
      A condition that filters the rows of the table to read, update or
      delete.

   Sort
      Defines the fields after which the rows that are read from the
      database are sorted.

   Lot size
      Defines how many rows are read from the database. Enter 0 or leave
      it empty for no limitation.

   Start index
      Defines the number of the row that is the first row in the read
      recordset out of the overall rows which match the condition.

   Quote IvyScript variables
      IvyScript variables in the SQL query are quoted depending on the
      data type of the value of the variable. For example string values
      are quoted with single quotes (e.g., hello -> 'hello'). Sometime
      you do not want that the values are quoted because the variable do
      not contain a single value but a part of an SQL query (e.g.
      "id=123 AND name=ivy"). Therefore you can disable the quoting with
      this check box.


.. _table-column-browser:

Table Column Browser
~~~~~~~~~~~~~~~~~~~~~

Assists you in selecting a column of your associated database table in inscription blocks.

|search-action| Opens the column browser from a column related inscription part.

.. figure:: /_images/process-inscription/browser-dbColumn.png
   :alt: Column Browser

.. |search-action| image:: /_images/ui-icons/list-search.svg
   :width: 2em   


.. include:: _tab-data-cache.rst

Error Tab
~~~~~~~~~
On this tab you can configure the Error Code that is thrown whenever errors during the execution of the database command occur. The error can be handled by a catching :ref:`process-element-error-start` or by an :ref:`process-element-error-boundary-event`.

.. tip::

  SQL experts can review the generated SQL command by clicking on
  the *Show generated SQL* or by choosing *Any other query* in the
  query combo box.



.. include:: _tab-output.rst

.. |image0| image:: /_images/process-editor/elements/database.png
