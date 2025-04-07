

.. _project-preferences:

Project Preferences
--------------------

You can access the properties and preferences of a project either over
the item *Properties* in the popup menu of the :ref:`ivy-project-view` 
or over the menu item *Project -> Properties*.
Here you can redefine almost all of the global :ref:`workspace-preferences`
and override them with project specific values.

Additionally, the project preferences allow you to define values for
some project specific properties, that do not have a global default
value. Those are described in the sections below.


Axon Ivy - Project Information
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

The main project properties page shows information about the project.

.. figure:: /_images/ivy-project/preferences-convert-project.png
   :alt: Project Properties Axon Ivy information

   Project Properties Axon Ivy information

Project format version
   Shows the version of the project format. If the project was created
   with an old version of Axon Ivy, this is indicated with an warning
   message. Consult the Chapter :ref:`project-convert` to learn how to convert your
   project to a new version of the project format.

Number of process Elements
   Shows the number of :ref:`Process Elements <process-elements>` in this project.



Data Class Settings
~~~~~~~~~~~~~~~~~~~

Allows you to specify the default namespace of the project.



IvyScript Engine
~~~~~~~~~~~~~~~~

Automatically imported classes
  Allows you to specify fully qualified class names which should be
  automatically available with their simple class names in every ivy
  script code.



Java
~~~~

With these preferences you can adjust the Java settings of the project.

.. figure:: /_images/ivy-project/preferences-java.png
  :alt: Java preferences

  Java preferences

Optional classpath containers
  Defines optional libraries that can be accessed in your Java or IvyScript
  code.
