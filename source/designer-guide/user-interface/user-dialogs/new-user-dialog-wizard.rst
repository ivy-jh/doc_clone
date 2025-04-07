.. _user-dialog-new-wizard:

New User Dialog Wizard
----------------------

The New User Dialog wizard lets you create a new User Dialog. This can
be a *Form Dialog*, an *HTML Dialog* or an *Offline Dialog*.

The wizard creates several resources for the new User Dialog:

View
   The visual component of the User Dialog (different technologies are
   possible).

Process
   The Process contains the logic of the User Dialog.

Data Class
   The Data Class holds the data of the User Dialog.

Accessibility
^^^^^^^^^^^^^

File -> New -> HTML Dialog


.. _user-dialog-new-wizard-page-1:

Page 1: Dialog Definitions
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. figure:: /_images/user-interface/new-user-dialog.png
   :alt: The New User Dialog Wizard Page 1

   The New User Dialog Wizard Page 1

Project
   Choose the project that your User Dialog belongs to.

Namespace
   Enter a namespace for your User Dialog. Use namespaces to group your
   User Dialogs. The grouping hierarchy is separated by the dot
   character. This is a similar concept to *packages* in the Java
   programming language.

Name
   Enter the name of the User Dialog that you want to create.

Dialog Type
   Select the type of User Dialog that you want to create.

   .. tip::

      Since *HTML Dialog* as well as *Offline Dialog* are based on JSF
      technology, it's possible to switch between those two dialog types
      after creation.

View Type
   A view type defines how the User Dialog will be constructed. This depends on
   the dialog type. You can choose if a User Dialog should be created with a
   *css grid*, so it acts responsively to the display width or not. If you want to create a
   reusable HTML component, select type *Component*.

Layout
   The layout can only be changed if you choose *HTML Dialog* but not
   *Component* as the view type. All your templates which are located in your
   webContent/layouts folder are listed here. 

Page 2: Dialog Data
^^^^^^^^^^^^^^^^^^^

.. figure:: /_images/user-interface/new-user-dialog-data.png
   :alt: The New User Dialog Wizard Page 2

   The New User Dialog Wizard Page 2

This page provides the functionality to create required configurations for a
User Dialog simply and quickly. The starting point is a data class, e.g., the
data class of the process that calls the User dialog. Based on this data class,
you can create the following configurations:

Start-Method
   A start method is created based on the selected In and Out attributes. The
   necessary parameter mapping will be generated automatically.

Data Class fields
   For each selected In/Out attribute a field is created in the Data Class of
   the User Dialog. The name of the created field is defined in the column
   'Field Name'.

Form (for HTML/Offline Dialogs)
   For each selected UI attribute, a form field is created in the view,
   e.g., for a field birthday of type Date, a label and a date picker
   is generated.


.. tip::

   Create a User Dialog in the context of a User Dialog Process Element:
   If the New User Dialog Wizard is opened on a User Dialog Process
   Element, the initial Caller Class will be the class of the calling
   process and the in/out parameter mapping from the process to the User
   Dialog and back will be generated automatically.

.. tip::

   Create a User Dialog in the context of a Data Class: If the New User
   Dialog Wizard is started via the context menu on a Data Class, the
   initial Caller Class will be the selected Data Class.

.. warning::
   
   If you create a new form, the UI flag is not respected. However, after 
   the creation of your new form you can create these fields based on the data class.
