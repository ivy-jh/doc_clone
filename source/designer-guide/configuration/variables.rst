.. _variables:

Variables
=========

Variables are dynamic key/value pairs that can be used to configure your application at runtime.
By using Variables, rather than static texts, you can master the following scenarios easily:

-  Workflow-Application customizations (branding, multi-tenancy)
-  Different runtime settings (staging vs. production) 
-  Company data (name, address, contacts)
-  Simple Rule Values (e.g., credit account)

To see and configure Variables at runtime, use the :ref:`Engine
Cockpit Variables View <engine-cockpit-variables>` on the |ivy-engine|. 


.. _variables-editor:

Variables Editor
----------------

Use the Variables Editor to create, delete, and edit Variables. 
You can import Variables from required projects to overwrite them 
such as hosts, user names and passwords of connector projects.

.. figure:: /_images/variables-editor/variables-editor.png
   :alt: Variables Editor
   :align: center
   
   Variables Editor

Variables Tree View
~~~~~~~~~~~~~~~~~~~

Shows the Variables of the current project.

- Press |add-variable-icon| to add a new Variable.
- Press |import-variables-icon| to import Variables from a required project.
- Press |delete-variable-icon| to delete the selected Variable.
- Use the search bar to filter the Variables. If part of a Variable's name or
  value matches the search text, all of its parents and children are shown.

.. |add-variable-icon| image:: /_images/ui-icons/plus.svg
   :alt: Add Variable
   :width: 16px
   :height: 16px

.. |import-variables-icon| image:: /_images/ui-icons/file-import.svg
   :alt: Import Variables
   :width: 16px
   :height: 16px

.. |delete-variable-icon| image:: /_images/ui-icons/trash.svg
   :alt: Import Variables
   :width: 16px
   :height: 16px

Variables Detail View
~~~~~~~~~~~~~~~~~~~~~

Shows the details of the selected Variable.

- :guilabel:`Name`
  The name is the identifier of the Variable (e.g. *user*).

- :guilabel:`Value`
  The value is the default value of the Variable (e.g. *username* for the
  *user* Variable).

- :guilabel:`Description`
  You can add a description to explain the purpose of the Variable.

- :guilabel:`Metadata`
  If applicable, you can specify additional metadata for a Variable:

  * **Password:** This tells the |ivy-engine| to encrypt the value of this Variable.
    
    .. tip::
      If you add a password Variable in the |ivy-designer|, 
      you get a validation warning that the Variable is not
      encrypted. You can fix this via a :ref:`problems-view` > *QuickFix*.
      
  * **Daytime:** The value of this Variable is interpreted as a time of day.
  * **Enum:** You can use this option to define a list of possible values that
    this Variable is allowed to take on.
  * **File:** This option configures the value of this Variable to be
    read from an external file. This file can be a :file:`.json` or a
    :file:`.txt` file. If your Variable is called :code:`myFile` and it should
    be a :code:`JSON` file, then your file must be located at
    :file:`<project>/config/variables/myFile.json`. Alternatively, the
    :code:`variables` prefix can also be part of the filename rather than a
    parent directory. So, the file
    :file:`<project>/config/variables.myFile.json` can contain the value for the
    Variable called :code:`myFile`.

.. tip::
  If your Variable has :code:`password` or :code:`secret` in its name (e.g.,
  :code:`hidePasswordMenu`) and no metadata option is chosen, the |ivy-engine|
  will automatically treat this Variable as a password for increased security.

.. warning::

  The Variables Editor interprets and formats the content of
  :file:`variables.yaml`. If you make manual changes to :file:`variables.yaml`,
  pay attention to the following points to prevent the loss of data:

  - Make sure the content is valid YAML.
  - Make sure :file:`variables.yaml` contains exactly one top-level key with
    the name :code:`Variables`.
  - Only put comments at the start or end of the file or before a Variable.

How to Access Variables
-----------------------

To access the Variables in your code, you can use the :public-api:`var
</ch/ivyteam/ivy/environment/Ivy.html#var>` method. In :ref:`ivyscript`, you can
use the name of the Variable to get access to your defined Variables. In addition,
this approach has the advantage that you receive validation notifications when a
Variable is removed by a developer. 

.. code:: java
  
  ivy.var.myVariable;

If you want to access Variable **Metadata**, you can also use the :code:`var`
keyword. This delivers an :public-api:`interface
</ch/ivyteam/ivy/vars/Variables.html>`. From the interface, you can get a 
:public-api:`Variable object </ch/ivyteam/ivy/vars/Variable.html>`. 
This object contains additional metadata for that Variable.

.. code:: java

  ivy.var.variable("myVariable").description();
