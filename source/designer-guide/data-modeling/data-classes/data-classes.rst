.. _data-classes:

Data Classes
============

This chapter deals with |ivy| Data Classes. A Data Class generally holds the
data that flows through your business or User Dialog process. You can build
complex data structures in your Data Classes. Use composition to split up your
data if the amount of your data is getting large.

Types of Data Classes
---------------------

There are four kinds of Data Classes in |ivy|.

Global Data Classes
   The global Data Classes are located in the Data Class node in your project
   tree. They are accessible in your project and projects depending on it.

User Dialog Data Class
   Each User Dialog has its Data Class. This class holds the data that flows
   through your User Dialog process. In your User Dialog Data Class, you can
   define attributes with a type of a global Data Class. The User Dialog Data
   Class is visible only in the associated User Dialog Process.

Web Service (WS) Data Classes
   |ivy| generates a Web Service Data Class automatically when you create a Web
   Service configuration. The Web Service Data Class, like a global Data Class,
   is accessible in your project and projects depending on it. Use this Data
   Class to communicate with your Web Services.

Entity Classes
   :ref:`persistence-entity-classes` are like Global Data Classes but with
   additional information on where and how to store the data of a class and its
   attributes to a relational database.

.. _data-class-new-wizard:

New Data Class Wizard
---------------------

The New Data Class wizard lets you create a new global Data Class. Start the
wizard by selecting *File > New > Data Class*.

.. figure:: /_images/data-class/data-class-new-wizard.png
   :alt: New Data Class Wizard

   New Data Class Wizard

Features
^^^^^^^^

Project Name
   Choose the project, to which the new Data Class should belong.

Namespace
   Choose a namespace for your Data Class. The namespace lets you create a
   structure to organize your data. Use the dot character '.' to separate the
   folders. The namespace will be visible in the |ivy| project tree.

Data Class Name
   Enter the name of your Data Class.

.. _data-class-editor:

Data Class Editor
-----------------

Use this editor to add, delete, and edit your Data Class and its attributes.

.. figure:: /_images/dataclass-editor/dataclass-editor.png
   :alt: Data Class Editor

   Data Class Editor

.. note::
  If you open an Entity Class, additional properties are configurable in this
  editor. They are documented in the :ref:`persistence-entity-class-editor`.

.. note::
  If you are familiar with the Data Class editor from previous versions, you can
  still use it by selecting *Open With > Data Class Editor (Classic)* in the
  context menu of the Data Class.

Features
^^^^^^^^

When you have no attribute selected, you can view and edit the properties of the
Data Class.

Name / Description
  Name
    Shows the fully qualified name of the Data Class. To change the name,
    perform the "Rename" refactoring by selecting "Rename" in the context menu
    of the Data Class in your project tree.
  
  Description
    Use this field to document your Data Class.
  
Annotations
  Use annotations on your Data Class for advanced configuration. The annotations
  will be written as is into the generated Java file. Therefore, you need to use
  the fully qualified name of the annotation and provide all desired arguments.

Class type
  Change the type of your Data Class:
  
    - :ref:`Data <data-classes>`
    - :ref:`Business Data <business-data>`
    - :ref:`Entity <persistence-entity-classes>`

Attributes
""""""""""

The attributes specify the Data Class contents. Select an attribute in the table
to view and edit its properties.

Name / Type / Comment
  Name
    The name of your attribute. The name must not contain any special characters
    or spaces.

  Type
    The type of your attribute. Press |data-type-browser-icon| to open the
    :ref:`data-type-browser`.

  Comment
    Use this field to document your attribute.

.. |data-type-browser-icon| image:: /_images/ui-icons/list-search.svg
   :alt: Data Type Browser Button
   :width: 16px
   :height: 16px

Properties
  Persistent
    Decide if the data should be persistent between task switches. If the data
    is not set to be persistent, then you lose all information if the execution
    of the process passes a task switch process element.

Annotations
  Use annotations on your attributes for advanced configuration. The annotations
  will be written as is into the generated Java file. Therefore, you need to use
  the fully qualified name of the annotation and provide all desired arguments.

Attribute Refactoring
^^^^^^^^^^^^^^^^^^^^^

The Data Class editor supports Data Class attribute refactoring.

Combine Attributes Refactoring
""""""""""""""""""""""""""""""

Over time, the number of attributes in a Data Class may become excessive. This
decreases the maintainability and reusability of your process logic. Therefore,
the editor allows you to combine multiple attributes from an existing Data Class
into a new Data Class. The combined attributes will be replaced with a delegate
attribute for the new Data Class.

If you have a Data Class that describes a person, you could combine the
attributes that belong to the address part into an extra address Data Class.

.. list-table::
  :width: 100%

  * - .. figure:: /_images/data-class/data-class-editor-extract-refactoring-original-structure.png
         :alt: Data Class before refactoring
         :scale: 75
      
         Data Class before refactoring

    - .. figure:: /_images/data-class/data-class-editor-extract-refactoring-modified-classes.png
         :alt: Data Class after refactoring
         :scale: 75
      
         Data Class after refactoring

**Start Refactoring**

Select the attributes to combine in the table, then press
|combine-attributes-icon| to open the refactoring wizard.

.. |combine-attributes-icon| image:: /_images/ui-icons/wrap-to-subprocess.svg
   :alt: Combine Attributes Button
   :width: 16px
   :height: 16px

**Define the new Data Class**

The first refactoring wizard page lets you define the location and name of the
Data Class.

.. figure:: /_images/data-class/data-class-editor-extract-refactoring-wizard-page-1.png
   :alt: Wizard Page 1 - Define the new Data Class

   Wizard Page 1 - Define the new Data Class

**Review modifications**

The second page previews all changes that will be applied to your artifacts. You
can inspect some of the changes within the textual compare view on the lower
part of the page.

.. figure:: /_images/data-class/data-class-editor-extract-refactoring-wizard-page-2.png
   :alt: Wizard Page 2 - Review modifications

   Wizard Page 2 - Review modifications

The refactoring will modify all programmatic references to attributes.
Statements written in Java, IvyScript, JSP or El-Expressions may be changed by
this refactoring.
