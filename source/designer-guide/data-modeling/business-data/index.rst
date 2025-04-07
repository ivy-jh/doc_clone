.. _business-data:

Business Data
=============

The Business Data feature allows to store and load business data in a
built-in repository without defining a schema. Compared to other
features like database steps and JPA no additional database, database
connection, schema or tables are needed

The business data structure can be defined by declaring normal data
classes. When storing a business data object all objects that are
referenced from the root object are stored as well. Loading a business
data object will recreate the whole object tree again. The data is
stored in a schemaless JSON based data format in the |ivy| standard System
database. This allows to add fields to data classes over time and still
be able to load old business data without migration.

Moreover, the business data feature allows to search the stored data by
defining field based filters.

.. toctree::
  :maxdepth: 1

  concept
  usage
  limitations
  customization
