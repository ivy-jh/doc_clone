.. _axonivy-workbench:

Axon Ivy Workbench
====================

Axon Ivy is based on the Eclipse platform. So when you start the Axon Ivy Designer
you launch an Eclipse workbench.

The first thing you see after starting Axon Ivy Designer is a dialog
that allows you to select the location of the **workspace**. The
workspace is the root directory where your work will be stored.

After the workspace location is chosen, the workbench window is
displayed. Initially, at the first start the Welcome Screen is
displayed. On this screen, different links to tutorials and documents are
displayed. New users should click on the :dev-url:`Quick Start Tutorial </tutorial>`
to learn how to use Axon Ivy Designer.

You can get the Welcome Screen back at any time by selecting :guilabel:`Help` >
:guilabel:`Welcome`.

.. figure:: /_images/designer/workbench.png
   :alt: Axon Ivy Workbench Overview
   :align: center

   Axon Ivy Workbench Overview



Axon Ivy Editors and Views
----------------------------

Editors and views are visual components in the workbench. They are the
tools to work with.

A **view** is typically used to display properties for an active editor
or to navigate through a hierarchy of information. Modifications made in
a view are saved immediately.

An **editor** is used to edit a certain type of a resource like a
process model diagram or a dialog panel. Modifications made in an editor
follow the open-save-close life cycle model. Multiple instances of an
editor can be open within a workbench window.

The name of the resource that is shown in the editor appears in the
editor's tab label. If an asterisk (*) appears at the left side of the
label this indicates that the editor has unsaved changes. When an
attempt is made to close the editor or exit the Workbench with unsaved
changes a prompt to save the editor's changes will appear.

Double clicking the tab of an editor or view will expand the part to
full size of the workbench window. Double click the tab of an expanded
part again to toggle back to default size and location.

Have a look at our reference for all available :ref:`designer-reference-views`
and :ref:`designer-reference-editors`.
