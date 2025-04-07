Menus
=====

The main window of Axon Ivy contains multiple menus. This section
explains the most important menus and menu items for Axon Ivy users.

.. Note::

   The availability and enablement of many menu items is dependent on
   the current selection and the currently active editor. They may
   therefore slightly vary and not exactly correspond to the screenshots
   below.


File Menu
---------

.. figure:: /_images/designer/menu-file.png
   :alt: File menu
   :align: center
   
   File menu


1 - New ...
   This menu item opens a sub menu with all available *new wizards* to
   create new resources for editing. Some of the shown wizards are
   contributed by the Eclipse system and are not Axon Ivy specific.

   To create new Axon Ivy resources it is recommended to use the menu
   entry :guilabel:`Axon Ivy` > :guilabel:`New...` or to use the context
   menu in the Axon Ivy project tree.

2 - Switch Workspace...
   Allows you to switch to a different workspace. A workspace is a
   directory that contains a collection of projects that are related to
   each other in some way.

   In the opening dialog simply select a different workspace directory.
   If you have switched workspaces before, you can also chose from a
   list of previously used workspaces.

3 - Import...
   Use this menu to import :guilabel:`General` > :guilabel:`Existing Projects into Workspace`
   or to import :guilabel:`Other` > :guilabel:`Checkout Projects from SVN`.

   Existing projects (that can be located anywhere on your machine, also
   in a different workspace) can be chosen to be imported by reference
   only or by copying the whole project.

4 - Export...
   This menu can be used to export projects or parts of projects from
   the current workspace. Use :guilabel:`General` 
   > :guilabel:`Archive File or General` > :guilabel:`File System`.


Search Menu
-----------

.. figure:: /_images/designer/menu-search.png
   :alt: Search Menu
   :align: center
   
   Search Menu


1 - Search...
   Opens the Search dialog where search tabs allow you to search for
   Axon Ivy artifacts or file contents.

2 - File...
   Same as :guilabel:`Search...` but opens directly on the 
   :guilabel:`File` tab of the
   Search dialog, where search queries for any text within any resource
   of the current project or even in the whole workspace can be started.

3 - Axon Ivy Search
   Same as :guilabel:`Search...` but opens directly on the :ref:`designer-search`
   tab of the Search dialog, where a search for
   Processes, CMS Objects or Data Classes can be started.


Project Menu
------------

.. figure:: /_images/designer/menu-project.png
   :alt: Project Menu
   :align: center
   
   Project Menu


1 - Clean...
   Deletes all temporary and generated files (such as compiled Java
   class files, compiled Data class files, etc.) from your project or
   workspace and rebuilds them. This may help to resolve building problems.

2 - Build Automatically
   Enables / disables automatic building (i.e., compiling) of project
   resources such as Java classes or Data classes. This means that all
   the necessary resources are automatically built and updated if
   changes are made in a project.


Axon Ivy Menu
---------------

.. figure:: /_images/designer/menu-ivy.png
   :alt: Axon Ivy Menu
   :align: center
   
   Axon Ivy menu


1 - New ...
   This menu item opens a sub menu with all available *new wizards* to
   create new Axon Ivy specific resources (such as User Dialogs or Data
   classes or Axon Ivy projects).

2 - Engine Menu
   Offers the operations 
   :guilabel:`Start Engine (Page)`, 
   :guilabel:`Start Engine`,
   :guilabel:`Stop Engine`,
   :guilabel:`Engine Speed` and
   :guilabel:`Enable/Disable Animation`.

   See also :ref:`toolbar` section.

3 - Preferences
   Opens the Preferences editor for the Axon Ivy specific preferences
   only.

   See also :ref:`workspace-preferences` section.


Window Menu
-----------

.. figure:: /_images/designer/menu-window.png
   :alt: Window Menu
   :align: center
   
   Window Menu


1 - Open Perspective
   Opens a sub menu with the available perspectives. Non-standard
   perspectives can be selected from the sub menu :guilabel:`Other...`.

2 - Show View
   Opens a sub menu with the available views for the current
   perspective. Non-standard views can be selected from the sub menu
   :guilabel:`Other...`. The complete set of Axon Ivy specific views is available
   below the Axon Ivy folder.

3 - Preferences...
   Opens the Preferences editor for the all settings that are
   available on the Eclipse platform. The Axon Ivy specific
   preferences are available under the Axon Ivy branch of the
   preferences tree.

   For convenience use the menu :guilabel:`Axon Ivy` >
   :guilabel:`Preferences...` to open the
   preference editor for the Axon Ivy specific settings only.

   See also :ref:`workspace-preferences` section.


Help Menu
---------

.. figure:: /_images/designer/menu-help.png
   :alt: Help Menu
   :align: center
   
   Help Menu


1 - Welcome
   Opens the welcome screen as shown on the first start of Axon Ivy
   after installation.

2 - Help (Designer Guide)
   Opens the Help browser to access this documentation here.

3 - About Axon Ivy Designer
   Shows system information about the used Axon Ivy Designer application
   (e.g., version and build number).
