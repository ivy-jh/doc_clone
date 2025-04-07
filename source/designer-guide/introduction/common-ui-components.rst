Common UI Components
====================


Axon Ivy uses some UI components that are widely used in the UI panels
of the product. This chapter introduces these components.


Refactoring Wizards
-------------------

Refactoring wizards appear when you *rename*, *move*, *delete* or
*copy/paste* Axon Ivy artifacts.

The wizards allow you to specify the new name/namespace/location of the
artifacts that should be refactored and will give you an overview of the
result of the operation before it is actually executed, so that you can
estimate the consequences.

All refactoring wizards have the same structure:

-  On the *first page* you enter the **parameters** of the operation
   (e.g., new name and/or namespace, target project, etc.) if any are
   required. Also you may chose whether any existing references to the
   refactored artifact should be updated automatically (e.g., if you
   rename a sub process then all callers to that sub process will be
   updated, so that they point to the renamed instance). This is the
   default behavior.

-  On the *second page* you will be presented with a **list of
   references that will be broken** after the operation is executed.
   This page is not displayed, if no broken references are detected.
   This page is only displayed for *delete* or *move* refactorings, i.e.
   if the artifact will no longer exist in the scope of any callers that
   referred to it before the operation.
   
   .. figure:: /_images/designer/refactoring-broken-references-page.png
      :alt: Refactoring Broken References Page
      :align: center
   
      Refactoring Broken References Page

-  On the *third page*, you will eventually be presented with a
   **detailed list of operations** that will be performed as a result of
   the selected refactoring and possibly a preview of any old and new
   resources that will be created. You may individually deselect any
   operations, they will then not be executed when you press *Finish*.

   .. warning::

      It is recommended that you don't uncheck any of the scheduled
      operations (unless you know exactly what you're doing), since this
      may leave the workspace in an inconsistent state.


.. figure:: /_images/designer/refactoring-overview-page.png
   :alt: Refactoring Overview Page
   :align: center
   
   Refactoring Overview Page

You can get from one page to another by pressing the *Next* and *Back*
buttons, however there is no requirement to have a look at all three
pages. As soon as the *Finish* button is enabled (this may not be the
case, if some required input is missing on the first page), you may
press it and execute the operation immediately.





.. _refactoring-wizards-rename:

Rename Wizard
~~~~~~~~~~~~~

.. figure:: /_images/designer/refactoring-rename-wizard.png
   :alt: Rename Wizard
   :align: center
   
   Rename Wizard

Change the name and/or namespace. If you enter invalid values then an
error will be displayed.

If you leave the *Update references* box checked, then all existing
references to the renamed artifact (within the current workspace) will
be updated automatically. Otherwise, no callers or references will be
updated, which will possibly result in broken references.

.. note::

   Please note, that the namespace for processes is written with forward
   slashes '/' as separators (e.g., 'MyProcesses/Customer/Invoice') while
   the namespace for Data Classes and User Dialogs is written with a dot
   '.' as separator (e.g., 'customerportal.users.Employee').

Click on :guilabel:`Finish` to actually rename the selected resource(s) or on
:guilabel:`Cancel` to abort the operation.


.. _refactoring-wizards-move:

Move Wizard
~~~~~~~~~~~

.. figure:: /_images/designer/refactoring-move-wizard.png
   :alt: Move Wizard
   :align: center
   
   Move Wizard

Select the destination project for the move operation from the proposed
list. The moved artifact will keep its original name and namespace.

Click on :guilabel:`Finish` to actually move the selected resource(s) to the
selected project or on :guilabel:`Cancel` to abort the operation.


.. _refactoring-wizards-delete:

Delete Wizard
~~~~~~~~~~~~~

.. figure:: /_images/designer/refactoring-delete-wizard.png
   :alt: Delete Wizard
   :align: center
   
   Delete Wizard

If the selected resources are not Axon Ivy artifacts, then you will be
presented with a confirmation dialog for the delete operation.

If you select an Axon Ivy artifact (Axon Ivy projects, User Dialog,
Process, Data Class) for deletion, then you might be presented with a
list of references that will break, if the operation is executed.

Click on :guilabel:`Finish` to actually delete the selected resource(s) or on
:guilabel:`Cancel` to abort the operation.



.. _refactoring-wizards-copy:

Copy Wizard
~~~~~~~~~~~

.. figure:: /_images/designer/refactoring-copy-wizard.png
   :alt: Copy Wizard
   :align: center
   
   Copy Wizard

The copy wizard appears when you execute the *Paste* operation (either
through the menu action *Paste* or with *Ctrl-V*) after having copied
something to the clipboard (e.g., through the menu action *Copy* or with
*Ctrl-C*).

The copy wizard lets you change the project, name and namespace of the
copy that will be created. All of the parameters are already filled in,
the system tries to make educated guesses, if the selected target
location is not valid or does not supply sufficient information (e.g., if
a resource with the same name already exists at the paste location, then
the name of the copy will be automatically have a "CopyOf" prefix).

Click on :guilabel:`Finish` to actually paste the copied resource(s) to the
defined location or on :guilabel:`Cancel` to abort the operation.
