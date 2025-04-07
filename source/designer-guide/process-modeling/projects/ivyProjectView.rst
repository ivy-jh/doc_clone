
.. _ivy-project-view:

Ivy Project View
-----------------

Here all the projects (including their content) in a given workspace are
displayed in a tree view. This is the central component to obtain an
overview of the project and to start the specific editors for all
Axon Ivy entities.

.. figure:: /_images/ivy-project/project-tree-full.png
   :alt: Axon Ivy Project View with some content

   Axon Ivy Project View with some content

Some of the entries are categorized such as User Dialogs and processes,
but in general double-clicking on the leafs opens the :ref:`corresponding editor <designer-reference-editors>`.


Filters
~~~~~~~~~~~~~~~~~~~~

Contents within the Axon Ivy Project View can be reduced or enriched with additional context information.
The menu button (with the three dots) allows you to adjust project content filters according to your needs.

The most effective way to adjust project contents is to select your role from the menu and navigating to `Role specific filters`. 
This will switch multiple filters at once according to your preferred role. 

.. figure:: ../../../_images/project-navigator/designerRoleFilters.png

Even so, you can customize the contents even further by clicking on menu (three dots) and navigating to `Filters and Customization`.



Context menu actions
~~~~~~~~~~~~~~~~~~~~

A popup menu is provided within the tree, with the most important interactions:

-  *New...* - Opens a wizard for creating new Axon Ivy entities such as
   User Dialogs or processes.

-  *Refresh* - Use this to inform and refresh the project tree whenever
   the project resources have been changed externally.

-  *Close Project* - Closes open projects. Closed project are still
   visible in the workspace but you cannot browse their content or
   execute them.

-  *Open Project* - Opens closed projects.

-  *Convert Project* - :ref:`Converts a project <project-convert>` so
   that it has the newest format.

-  *Export Axon Ivy Archive (.iar)* - Starts the :ref:`Export Wizard <designer-export-project>` 
   to export normal Axon Ivy projects to Axon Ivy Archives.

-  *Import* - Opens the Import Wizard. Very useful to :ref:`import new projects <designer-import-project>`
   from the file system or from a source repository such as Subversion or CVS

-  *Export* - Opens the :ref:`Export Wizard <designer-export-project>` 
   to exchange certain artifacts with other installations.

-  *Rename* - Let you rename your resources (User Dialog, Data Class,
   Process, etc.) while keeping references to those artifacts intact.
   This menu item is only shown, if the selected resources are eligible
   for renaming. If renaming is possible, then the :ref:`refactoring-wizards-rename`
   will be shown, where you can enter a new namespace and/or name for the selected artifact.

   .. warning::

      Please rename your resources only in Axon Ivy and not in *Java* or
      *Resource* perspectives. Trying to do renaming of Axon Ivy
      artifacts in other perspectives may result in an unusable project.

-  *Move* - Moves the selected resources to another project. The `move
   wizard <#ivy.wizards.refactoring.move>`__ will be shown, allowing you
   to select the project to which the resource(s) should be moved.

   .. note::

      If Axon Ivy artifacts (such as User Dialogs, Processes or Data
      Classes) are moved, then the wizard will show an overview of the
      references (e.g., calls to sub processes) that might be broken by
      the operation.

-  *Copy* - Copies the selected resource(s) to the clipboard

-  *Paste* - Pastes the content of the clipboard into the selected node.

   .. note::

      The copy operation is intelligent: it tries to guess the correct
      location from the contents inside the clipboard, if the selected
      target node is not suitable for pasting. If there is a conflict
      upon paste (e.g., because the result would be two resources with
      the same name) then the :ref:`refactoring-wizards-copy` is presented with a new
      name suggestion, where you may modify the name and/or namespace of
      the pasted resource(s) before the operation is executed.

-  *Delete* - Removes the selected node from the project. Multiple
   resources may be deleted at once.

   .. note::

      If Axon Ivy artifacts (such as Axon Ivy projects, User Dialogs,
      Processes or Data Classes) should be deleted, then the
      :ref:`refactoring-wizards-delete` opens and shows an
      overview of the references that might be broken by the operation.

   .. tip::

      Commit your project in SVN before performing any delete
      operations.

-  *Open with* - Lets the user choose with which editor the selected
   entity is opened. It is possible to view a textual representation or
   a possible external editor for the entity.

-  *Team* - Gives access to the Team functionality offered by CVS or SVN

-  *Compare with* - Compares the current version of the entity with an
   older version from the local history or (if used) from the source
   repository.

-  *Replace with* - Replaces the current version of the entity with an
   older version from the local history or (if used) from the source
   repository.

-  *Properties* - Useful on the project level to set the :ref:`project-preferences` of the project





