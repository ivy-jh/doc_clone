.. _process-element-task-switch-gateway:

Task Switch Gateway
===================

|image0| The *Task Switch Gateway* element is located in the *Event & Gateway* drawer of the process editor palette.

Element Details
---------------

With the task switch element a process is segmented into tasks. It
interrupts the execution of a process and allows another user to
proceed. The actual process state is stored in the system database. A
role or user is assigned that is able to pick up and start the task.

When the role SYSTEM has been chosen the process is executed by the
system, without manual intervention by a user.

.. note::

   If any error occurs during the execution of a task that is executed
   by the system the task is rolled back and its state set to error.
   After a certain time the task is resumed and the system tries again
   to execute it.

   The duration until a task with state error is resumed depends on the
   times the task had failed before (1, 2, 4, 8 minutes, ... up to 23
   hours).

   This is a default behavior. To change it consult the documentation
   of :public-api:`SystemTaskFailureBehaviour </ch/ivyteam/ivy/workflow/SystemTaskFailureBehaviour.html>`

.. warning::

   The Task Switch Gateway element can have several input and output
   arcs and acts as an AND-Gateway. It synchronizes all incoming tasks -
   it waits until all incoming tasks have been completed.

   For each outgoing arc the Task Switch Gateway element creates a
   parallel task.

.. warning::

   The process state that is stored to the system database contains all
   process data values that are stored in persistent fields. Values of
   non persistent fields are not stored to the system database and are
   therefore not initialized in the process data of the created tasks.


Inscription
-----------

.. include:: _tab-name.rst

.. include:: _tab-output.rst

.. note::

   For each incoming connection you have a separate ``inX`` object
   available which carries the data of the Xth input. Hover with the
   mouse over the incoming connections of the element to learn which
   input connection corresponds to which variable.


Tasks Tab
~~~~~~~~~

On this tab you can configure the Tasks of this Gateway. See
:ref:`process-element-tab-task` for a more detailed
description. The only difference in comparison to the referenced Task
tab is, that the Task Switch Gateway can have multiple configurable
tasks.

.. figure:: /_images/process-inscription/task-switch-gateway-tab-task.png
   :alt: Tasks tab

   Tasks tab


.. include:: _tab-case.rst


End Page Tab
~~~~~~~~~~~~

This Tab defines the page, which will be displayed in the web browser
for each task which ends at this Task Switch Element.

If no page is defined the task list will be shown.

If no task is created because *skip task list* is enabled (see
:ref:`process-element-tab-task`) the case will continue
without displaying a page or the task list.

For more information about this tab, please have a look at the :ref:`process-element-end-page`
element.


.. |image0| image:: /_images/process-editor/elements/gateway-task-switch.png
