.. _form-editor:

Form Editor
-----------

The Form Editor allows you to build User Interfaces fast with minimal technical knowledge.
It is based on different sections:

-  the :ref:`form-editor-area`, where the process logic is constructed element
   for element

-  the :ref:`form-editor-properties`, where the current selected component can be modified

-  the :ref:`form-editor-tool-bar`, where some tools are located and also all
   elements, which can be added to the process

-  the :ref:`form-editor-quick-actions`, where you find quick actions according to the current selection

|form-editor|


Accessibility
~~~~~~~~~~~~~

|ivy| project tree -> double click on the *Form* node of an HTML Dialog. 
If there is none, create a new HTML Dialog and select the type :code:`Dialog Form` on the first wizard page.


.. _form-editor-tool-bar:

Toolbar
~~~~~~~

The **Tool Bar** collects all tools that can be helpful for working with the form editor:

Left
^^^^

|device-mode| Device Mode: Simulate how the form looks like on different devices (Desktop, Table, Mobile).

|edit-mode| Edit / Preview Mode: Toggle between *edit mode*

  - Edit Mode: provides wider gaps between the components for ease drag and drop
  - Preview Mode: simulate how the form will look like for the end user

|undo-tool| Undo: your last changes.

|redo-tool| Redo: your last changes.

.. |device-mode| image:: /_images/ui-icons/event-start.svg
   :width: 2em

.. |edit-mode| image:: /_images/ui-icons/edit.svg
   :width: 2em

.. |undo-tool| image:: /_images/ui-icons/undo.svg
   :width: 2em

.. |redo-tool| image:: /_images/ui-icons/redo.svg
   :width: 2em

Center
^^^^^^

You can create many different components, by drag and drop the wished element to the :ref:`form-editor-area`.
To keep the overview they are divided into different categories: 

|all-components| All Components: All components with are known in the form editor

|structure| Structures: Components which allow to have sub components

|elements| Elements: Input, selection and text components

|actions| Actions: Action components

|composite| Composites: All reusable :ref:`html-dialog-component`

|data| Data: Create components :ref:`from data class <form-editor-create-from-data>`

.. |all-components| image:: /_images/ui-icons/task.svg
   :width: 2em

.. |structure| image:: /_images/ui-icons/lane-swimlanes.svg
   :width: 2em

.. |elements| image:: /_images/ui-icons/change-type.svg
   :width: 2em

.. |actions| image:: /_images/ui-icons/multi-selection.svg
   :width: 2em

.. |composite| image:: /_images/ui-icons/file.svg
   :width: 2em

.. |data| image:: /_images/ui-icons/database-link.svg
   :width: 2em


Right
^^^^^

|open-dataclass| Opens the :ref:`data-class-editor` of the form.

|open-process| Opens the :ref:`process-editor` of the form.

|inscription-toggle| Opens or closes the :ref:`form-editor-properties` of the selected component.

|options-toggle| Open view options:

   - Theme: Toggle between dark and light theme.

.. |open-dataclass| image:: /_images/ui-icons/database-link.svg
   :width: 2em

.. |open-process| image:: /_images/ui-icons/process.svg
   :width: 2em

.. |options-toggle| image:: /_images/ui-icons/settings.svg
   :width: 2em

.. |inscription-toggle| image:: /_images/ui-icons/layout-sidebar-right-collapse.svg
   :width: 2em


.. _form-editor-area:

Editor Area
~~~~~~~~~~~

In the editor area you can layout and design your forms by drag and drop. To
add new components, open the palette from the :ref:`form-editor-tool-bar` and
drag and drop it to this area. 

Per default, components are structured from top to bottom with full width. To
change this you can use a :code:`Layout` component. With this you can arrange components
side by side in a grid.

On each component you have a :ref:`form-editor-quick-actions`, which provides useful actions.


.. _form-editor-quick-actions:

Quick Action Menu
^^^^^^^^^^^^^^^^^

To open the **Quick Action Menu** simply select a component in the editor. The
available actions can be different based on the component type:

|delete| Delete the current selection.

|duplicate| Duplicate the current selection.

|create-column| Create new column. Only available on the :code:`Table` component.

|create-data| Create components from the :ref:`form data class <form-editor-create-from-data>`.

|create-component| Create components inline via palette.


.. |delete| image:: /_images/ui-icons/trash.svg
   :width: 2em

.. |duplicate| image:: /_images/ui-icons/duplicate.svg
   :width: 2em

.. |create-column| image:: /_images/ui-icons/pool-swimlanes.svg
   :width: 2em
   :class: rotate-90

.. |create-data| image:: /_images/ui-icons/database-link.svg
   :width: 2em

.. |create-component| image:: /_images/ui-icons/task.svg
   :width: 2em


.. _form-editor-properties:

Properties
~~~~~~~~~~

Having a component selected, you can define its features within the `Properties`
view on the right. In this section you can change the config of each component. 

|form-editor-properties|

There are also settings which are only available, if a certain parent component
is present. E.g. if you have a :code:`Layout` component with the type *Grid* and
column *Free* you will get on each child a new section where you can define how
much space it should take on different screen sizes.

.. tip:: 

   You can also open the properties view of a component with a *double click*.


.. _form-editor-outline:

Outline
~~~~~~~

The form editor provides an outline, to give you a better overview of your current form with all the components.
You can open it inside the :ref:`form-editor-properties` panel via the outline switch at the top.

|form-editor-outline|



.. _form-editor-create-from-data:

Create from data
~~~~~~~~~~~~~~~~

You can create components from the form data by click on the *Data* in the
:ref:`form-editor-tool-bar`, via the :ref:`form-editor-quick-actions` or if you
have an empty form the button *Create from data*. The following wizard shows you
the form data class, where you can select attributes to directly create the
components for them. You can also create a :code:`Proceed` and :code:`Cancel`
button to control the workflow.

|form-editor-data-class-dialog|

.. note::
   
   Only data class attributes which can be rendered as component are shown in the wizard.

.. |form-editor| image:: /_images/form-editor/editor.png
.. |form-editor-properties| image:: /_images/form-editor/view-properties.png
.. |form-editor-outline| image:: /_images/form-editor/view-outline.png
.. |form-editor-data-class-dialog| image:: /_images/form-editor/dialog-create-from-data.png
