Task Tab
~~~~~~~~

On this tab you configure the task which is created when this element is
executed by the awaited event. This task will not appear in any user
task list and is exclusively handled by the system. The values on this
tab are therefore only relevant for analyzing the finished tasks and not
for the task list itself.

.. figure:: /_images/process-inscription/wait-intermediate-event-tab-task.png

Custom fields
   The values set on this table are only informational and have no
   effect on how this task is treated by Axon Ivy.
   See :ref:`Custom Fields <process-element-tab-task-custom-fields>`.

Code
   This is a post construct code block for the Task that is defined in
   this tab. The created Task is provided as variable called ``task``.
   See :ref:`Code <process-element-tab-task-code>`.
