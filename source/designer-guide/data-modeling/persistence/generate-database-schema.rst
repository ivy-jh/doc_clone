.. _persistence-generate-database-schema:

Generate database schema
------------------------

Click on :guilabel:`Generate Schema` in the persistence unit.

Generation options
^^^^^^^^^^^^^^^^^^

On the first wizard page you can specify the type of the schema generation.

.. figure:: /_images/persistence/generate-database-schema-options.png
   :alt: Database schema generation option

   Database schema generation option

**Data source**
   For the schema generation the data source of the persistence unit is
   used.

**Type**
   Specify the type of the schema generation. You can choose between
   update and create.

   -  update: Does update the current available schema on the database.

      .. warning::

         The update does not refactor any changed table names, field
         names or field types. If a table or field does not exist in the
         database a new one is created even if the same table or field
         with another name exists.

   -  create: Does drop the current schema on the database and create a
      new one.

      .. warning::

         This option does delete all data which is stored in the
         database.

Generation preview
^^^^^^^^^^^^^^^^^^

The second wizard page shows a preview what will be executed on the
database.

.. figure:: /_images/persistence/generate-database-schema-preview.png
   :alt: Database schema generation preview

   Database schema generation preview


Primary Key Columns
^^^^^^^^^^^^^^^^^^^

Hibernate works by default with sequences for primary key columns.
This means it will create a table called :code:`hibernate_sequence` which is used
to generate the primary keys. If you want to use the auto increment approach
of your database management system you can set the property
:code:`hibernate.id.new_generator_mappings` to :code:`false` in your persistence unit.
