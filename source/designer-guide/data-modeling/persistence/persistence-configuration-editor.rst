.. _persistence-configuration-editor:

Persistence Configuration Editor
--------------------------------

The Persistence Configuration Editor lets you configure the persistence
units you use in your project and projects depending on it.

Usually, you only need a single persistence unit that manages all of your
project's entity data classes. In this case, you can simply create a new
persistence unit, associate it with a data source (i.e., a database) and
you're done. All of the project's entity classes will then automatically
be managed by this unit.

However, if you wish to do so, you can divide your entity data classes
into subsets and manage each subset through an individual persistence
unit. In this case, you need to specify multiple persistence units and
then define an explicit list of managed entity classes for each unit.

.. warning::

   Although it is theoretically possible to have the same entity class
   managed by two or more persistence units, you should be aware of the
   consequences. Once you have generated/attached an object of a
   specific class to a specific persistence unit, you must ensure
   that it is managed uniquely by that unit.

   Example: Assume that you have two different objects of the same
   entity class, e.g., ``Person``, generated through different
   persistence units, e.g., ``employee`` through ``employee_unit`` and
   ``customer`` through ``customer_unit``. In this case, you must
   avoid mixing persistence units and objects. For the above
   example, handing over an ``employee`` to ``customer_unit`` (or
   a ``customer`` to ``employee_unit``) will consequently result in
   errors.

.. figure:: /_images/persistence/persistence-configuration-editor-single-unit.png
   :alt: Persistence Configuration Editor (single persistence unit)

   Persistence Configuration Editor (single persistence unit)

.. figure:: /_images/persistence/persistence-configuration-editor-multiple-unit.png
   :alt: Persistence Configuration Editor (multiple persistence units)

   Persistence Configuration Editor (multiple persistence units)

**New**
   Add a new persistence unit configuration

**Remove**
   Remove the selected persistence unit(s)

**Generate Schema**
   Generates the database schema out of the entity classes that belong to
   the selected persistence unit. See :ref:`persistence-generate-database-schema`
   for details.

Accessibility
^^^^^^^^^^^^^

*|ivy| Project Tree > double click on the Persistence label.*

Features
^^^^^^^^

Data source
   Here, you have to choose a database configuration which will be the
   data source of this persistence unit, i.e., all the data is loaded
   and stored within this database. Go to the :ref:`database-configuration-editor`
   to configure available data sources.

   There is also a ``IvySystemDatabase`` data source that points to the
   current System Database. Usually, you will use your own database
   to split customer data from the |ivy| system data.

Description
   Describe your persistence unit here.

Managed Classes
   Specify the list of classes to be managed in this persistence unit. If
   'Exclude unlisted classes' is checked, only the entity classes defined in the
   list are included in the persistence unit. Otherwise, all entity classes of
   the project are included automatically in addition to the entity classes
   explicitly defined in the list.

Properties
   Specify properties for the persistence unit. This is optional. This
   freedom comes with responsibility - know what you are doing.
