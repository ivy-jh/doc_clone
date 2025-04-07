.. _persistence:

Persistence
===========

This chapter introduces the :ref:`persistence-configuration-editor` and the
:ref:`persistence-api` of |ivy|. The persistence framework is based on the `Java
Persistence API <http://en.wikipedia.org/wiki/Java_Persistence_API>`__, a.k.a. JPA)
and provides support for storing and loading business objects from and to a
database.

To use automated persistence in your business or User Dialog processes, you need
to define :ref:`persistence-entity-classes` first. An entity class is similar to
a data class (i.e., a business object) but holds additional information that is
used to map the class to a database table and its attributes to database table
columns.

You need to define at least one persistence unit configuration. A persistence
unit manages all or a subset of your entity classes and defines the database
where those entities are stored. Once you have configured one or more
persistence units, you can use them in your process steps with the
:ref:`persistence-api` to load/update entity objects directly from the database
or save and update them in the database.


.. toctree::
  :maxdepth: 1

  entity-classes
  new-entity-class-wizard
  entity-class-editor
  persistence-configuration-editor
  generate-database-schema
  persistence-api
