
.. _workflow-states:

States
---------------

During process execution, the corresponding case and tasks have various states.
Typically, cases start non-persistently, i.e., they are stored in memory only. At
this time, their state is CREATED. As soon as a case hits a task switch,
|ivy| persists the case and its tasks by storing them in the system database.
You can retrieve persisted cases and tasks only with the query APIs.
Non-persisted cases and tasks are not retrievable by API.



Process without Task switch
~~~~~~~~~~~~~~~~~~~~~~~~~~~

|image1|

.. table:: Process without Task switch

   +-----------------------+-----------------------+-----------------------+
   |                       | Process start         | Process end           |
   +=======================+=======================+=======================+
   | Case state            | CREATED               | DONE                  |
   +-----------------------+-----------------------+-----------------------+
   | Task state            | CREATED               | DONE                  |
   +-----------------------+-----------------------+-----------------------+
   | Persistent            | NO                    | NO                    |
   +-----------------------+-----------------------+-----------------------+



Process with session timeout
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

|image19|

.. table:: Process with User Dialog that reaches a session timeout

   +-----------------------+-----------------------+-----------------------+
   |                       | Process start         | User Dialog           |
   +=======================+=======================+=======================+
   | Case state            | CREATED               | DESTROYED             |
   +-----------------------+-----------------------+-----------------------+
   | Task state            | CREATED               | DESTROYED             |
   +-----------------------+-----------------------+-----------------------+
   | Persistent            | NO                    | NO                    |
   +-----------------------+-----------------------+-----------------------+



Process with Task switch
~~~~~~~~~~~~~~~~~~~~~~~~

|image2|

.. table:: Process with Task switch

   +-----------------+-----------------+-----------------+-----------------+
   |                 | Process start   | Task switch     | Process end     |
   +=================+=================+=================+=================+
   | Case state      | CREATED         | RUNNING         | DONE            |
   +-----------------+-----------------+-----------------+-----------------+
   | Task state      | CREATED         | DONE            |                 |
   | (Task 1)        |                 |                 |                 |
   +-----------------+-----------------+-----------------+-----------------+
   | Task state      |                 | SUSPENDED       | DONE            |
   | (Task 2)        |                 |                 |                 |
   +-----------------+-----------------+-----------------+-----------------+
   | Persistent      | NO              | YES             | YES             |
   +-----------------+-----------------+-----------------+-----------------+



Task switch states in detail
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

|image20|

In detail, the tasks are going to more technical task states inside a task
switch element. After a task reaches a task switch, its state is
READY_FOR_JOIN. As soon as all input tasks have arrived at the task switch,
|ivy| sets the states of these input tasks to JOINING and joins their process data
sets into one process data set forwarded to all output tasks. Then, |ivy|
marks input tasks as DONE. It then creates the output tasks in state
SUSPENDED.

.. table:: Process with Task switch

   +-----------+-----------+-----------+-----------+-----------+-----------+
   |           | Before    | Task      | Task      | Task      | After     |
   |           | Task      | switch    | switch    | switch    | Task      |
   |           | switch    | (reached) | (entry)   | (done/out | switch    |
   |           |           |           |           | put)      |           |
   +===========+===========+===========+===========+===========+===========+
   | Case      | CREATED/  | RUNNING   |           |           |           |
   | state     | RUNNING   |           |           |           |           |
   +-----------+-----------+-----------+-----------+-----------+-----------+
   | Task      | CREATED/  | READY_FOR | JOINING   | DONE      | -         |
   | state     | RESUMED   | _JOIN     |           |           |           |
   | (Task 1)  |           |           |           |           |           |
   +-----------+-----------+-----------+-----------+-----------+-----------+
   | Task      | -         | -         | -         | SUSPENDED | RESUMED   |
   | state     |           |           |           |           |           |
   | (Task 2)  |           |           |           |           |           |
   +-----------+-----------+-----------+-----------+-----------+-----------+
   | Persisten | NO/YES    | YES       |           |           |           |
   | t         |           |           |           |           |           |
   +-----------+-----------+-----------+-----------+-----------+-----------+

Task with session timeout
~~~~~~~~~~~~~~~~~~~~~~~~~

|image3|

If a user resumes a task with a user dialog and the session of the user times
out, |ivy| sets the task state back to SUSPENDED and resets the associated case
to the task switch element.

.. table:: Task with session timeout

   +-----------------+-----------------+-----------------+-----------------+
   |                 | Task switch     | User Dialog     | Task switch     |
   |                 |                 |                 | (after session  |
   |                 |                 |                 | timeout)        |
   +=================+=================+=================+=================+
   | Case state      | RUNNING         | RUNNING         | RUNNING         |
   +-----------------+-----------------+-----------------+-----------------+
   | Task state      | SUSPENDED       | RESUMED         | SUSPENDED       |
   | (Task 1)        |                 |                 |                 |
   +-----------------+-----------------+-----------------+-----------------+
   | Persistent      | YES             | YES             | YES             |
   +-----------------+-----------------+-----------------+-----------------+

User Task
~~~~~~~~~

|image4|

A User Task combines a Task Switch Event and a User Dialog. If the user starts
to work on an ordinary HTML User Dialog, |ivy| changes the task state to
RESUMED. If this is an 'Offline Dialog', |ivy| does not change the task state
before the user submits the task form. Once submitted, |ivy| changes the state
from SUSPENDED to RESUMED. |ivy| then executes subsequent steps until the task
is finally DONE. See also :ref:`offline-tasks`.


.. _signal-boundary-event:

Signal Boundary Event
~~~~~~~~~~~~~~~~~~~~~

|image5|

A User Task with an attached Signal Boundary Event listens for a signal while
its task is in SUSPENDED state. After receiving the signal, |ivy| destroys the
task. Execution continues with a newly created follow-up task.



Case Map with session timeout
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

|image22|

When a task is created by :ref:`casemap`, its initial state is SUSPENDED. |ivy|
immediately persists the task in the database. If the user session expires while
working on this initial task, |ivy| will delete it, along with the associated
Case and Business Case.

.. table:: Case Map with User Dialog that reaches a session timeout

   +-----------------------+-----------------------+-----------------------+
   |                       | Process start         | User Dialog           |
   +=======================+=======================+=======================+
   | Case state            | CREATED               | - (deleted)           |
   +-----------------------+-----------------------+-----------------------+
   | Task state            | CREATED               | - (deleted)           |
   +-----------------------+-----------------------+-----------------------+
   | Business Case state   | CREATED               | - (deleted)           |
   +-----------------------+-----------------------+-----------------------+
   | Persistent            | YES                   | -                     |
   +-----------------------+-----------------------+-----------------------+

Other task states
~~~~~~~~~~~~~~~~~

There are more task states, mainly for task synchronisation, error handing,
intermediate events, or user aborts. To learn more about task states, refer to
the enumeration ``ch.ivyteam.ivy.workflow.TaskState`` in public API.

.. |image1| image:: /_images/workflow/workflow-states-simple-start-end.png
.. |image2| image:: /_images/workflow/workflow-states-simple-start-task-switch-end.png
.. |image3| image:: /_images/workflow/workflow-states-task-with-session-timeout.png
.. |image4| image:: /_images/workflow/workflow-states-user-task.png
.. |image5| image:: /_images/workflow/workflow-states-signal-boundary-event.png
.. |image19| image:: /_images/workflow/workflow-states-session-timeout.png
.. |image20| image:: /_images/workflow/workflow-states-task-switch-states.png
.. |image22| image:: /_images/workflow/workflow-casemap-session-timeout.png
