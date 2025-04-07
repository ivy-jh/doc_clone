.. _casemap:

Case Maps
=========

Case Maps can be used to split a long running process into multiple
short running processes. See: :ref:`Adaptive Case Management: Regaining the
big picture <adapative-case-management-big-picture>`.

The Case Map controls which processes are executed automatically in
which order and which processes can be started manually by users.

.. _casemap-new-wizard:

Case Map Wizard
---------------

The *New Case Maps Wizard* lets you create a new Case Map.

Accessibility
~~~~~~~~~~~~~

File > New > Case Map

Features
~~~~~~~~

.. figure:: /_images/casemap/new-casemap-wizard.png

Project Name
   Choose the project in which you want to create a new Case Map.

Namespace
   Select a process group where the new Case Map will be inserted.
   Select the ``<default>`` process group to create a Case Map directly
   below the project's processes folder. You can click on the group
   folder button to open the *New Process Group Wizard*, if you want to
   create a new group "on the fly". The process groups are listed
   relative to the project's *processes* folder.

Name
   Enter the name of the Case Map that you want to create.

.. _casemap-editor:

Case Map Editor
---------------

The Case map editor is the editor that is shown when you open a case map
in the designer. Use it to create and edit Case Maps. At first you
typically want to name your case map and add new stages by clicking on
the plus (+) symbol.

.. figure:: /_images/casemap/casemap-editor.png
   :alt: Case Map Editor

   Case Map Editor

Case Map Element Reference
~~~~~~~~~~~~~~~~~~~~~~~~~~

Stage
^^^^^

A case map is divided into stages. Each stage defines a certain phase in
the life of a business process. A stage is a container for multiple
processes that belong to each other in a logical order. Within a stage
the processes are executed from top to bottom. If the last process of a
stage has finished the execution continues on the stage to the right.
Besides processes a stage can also contain Sidesteps, that are valid in
the current stage. The actual stage of a Business Case is also displayed
in the Workflow UI with its name and icon.

A business process can programmatically switch to another stage by using
the case map API (``ivy.casemap``).

The position of a Stage in a case map can be changed via the menu on the
stage.

.. figure:: /_images/casemap/casemap-element-stage.png
   :alt: Case Map Element: Stage

   Case Map Element: Stage

Process
^^^^^^^

A process in the Case Map references to a process start of an Axon Ivy
process. If the business process enters a stage, the first process,
which entry condition evaluates to true, will be started.

Processes and Sidesteps can be rearranged around by drag and drop.

.. figure:: /_images/casemap/casemap-element-process.png
   :alt: Case Map Element: Process

   Case Map Element: Process


Process Precondition
''''''''''''''''''''

Preconditions can be set on a process and define whether a process
should be skipped. The precondition on the first process in the case map
is not evaluated. If a precondition is not met, the execution continues
on the next process. For script features see :ref:`casemap-scripting`.

.. figure:: /_images/casemap/casemap-element-precondition.png
   :alt: Precondition symbol

   Precondition symbol

Sidestep
^^^^^^^^

Sidesteps are optionally executable processes. Sidesteps like processes
belong to a stage. They can be manually started at any time during the
ongoing business process. A typical Sidestep could be a process which is
used to involve a supervisor to ask for clarification.

Sidestep Precondition
'''''''''''''''''''''

Decides whether that Sidestep can be currently started or not. For
script features see :ref:`casemap-scripting`.

.. figure:: /_images/casemap/casemap-element-precondition.png
   :alt: Sidestep Precondition symbol

   Sidestep Precondition symbol


.. _casemap-scripting:

Case Map scripting
~~~~~~~~~~~~~~~~~~

Scripts within a Case Map can be written in ivyScript.

A simple Process Precondition could be implemented as follows:

::

   businessCase.getCreatorUserName().equals("Bruno") && creditDossier.needsApproval

Available variables
^^^^^^^^^^^^^^^^^^^

Within Case Map scripts the running Business Case is always accessible
through the variable ``businessCase``.

Any class that is annotated with ``@BusinessCaseData`` is accessible by
its simple name (e.g., if the full-qualified name of the class is
``com.axonivy.CreditDossier`` the simple name is: ``creditDossier``).
The variable value will be loaded from the :ref:`Business Data
Repository <business-data>`.

.. figure:: /_images/casemap/credit-dossier-data.png
   :alt: Sample DataClass with @BusinessCaseData annotation

   Sample DataClass with @BusinessCaseData annotation


Case Map Animation
~~~~~~~~~~~~~~~~~~

.. figure:: /_images/casemap/casemap-editor-animation.png

The execution of a Case Map can be followed in the Case Map Editor. As
known from the BPM processes the currently executing and already
executed elements in the Case Map will be marked. It uses the
:ref:`simulation` known from the BPM processes.


Case Map Statistics (Preview)
-----------------------------

The Case Map provides the ability to display different process metrics
of a Case Map in an early version. The monitoring can be enabled via the
Case Map menu on the right-hand side. Currently the Case Map statistics
only displays the metrics of the actual linked process, metrics of other
processes that might have been started from this process are not
considered.

.. figure:: /_images/casemap/casemap-metrics-process.png
   :alt: Process metrics

   Process metrics


Tasks
~~~~~

The tasks statistics are based on the expiration dates of the Case Map
tasks. Therefore, the task count is only based on tasks with an
expiration date. The tasks are divided into following three categories:

On time
   Considers the average throughput time to calculate if the tasks are
   on time. A task is considered on time when the expiry date of the
   task is more than half of the average throughput time away from the
   current time.

On risk
   Considers the average throughput time to calculate if the tasks are
   on risk. A task is considered on risk when the expiry date of the
   task is the half of the average throughput time away from the current
   time.

Overdue
   The task count of expired tasks.


Throughput time
~~~~~~~~~~~~~~~

The average throughput time per task of this process is displayed.


.. _casemap-execution:

Workflow execution of Case Map Processes
----------------------------------------

The execution of a process in a Case Map is the same as when it is
executed as a standalone process. For each started instance it will
create a task and a case. You can configure the created case and task by
using the Case and Task tab on the :ref:`process-element-start-request`
inscription mask.

Responsible role
~~~~~~~~~~~~~~~~

By default the responsible role that can work on the created task is the
one configured on the Request tab of the :ref:`process-element-start-request`.
If the :ref:`process-element-start-request` is triggerable then
also the information on the Trigger tab is considered and the task is
assigned to the responsible role or user configured on this tab. To
automatically execute a process, configure the :ref:`process-element-start-request`
to be triggerable and set the responsible role to ``SYSTEM``.

Stage switching
~~~~~~~~~~~~~~~

When a stage change happens the Case Map does not cancel tasks thats
were started in the stage before the switching happened. This is mainly
important if the stage switch was performed programmatically using the
``ivy.casemap`` API. The process developer should consider to change the
state (e.g., destroy) of existing tasks manually before switching to
another stage change.
