.. _process-element-start-request:

Start
=====

|image0| The **Start** (Request Start) element is located in the *Event & Gateway* drawer of the Process editor palette.

Element Details
---------------

The Request Start element is the start point of a workflow. A workflow
contains one case and at least one task. Each start of a Request Start
creates a new case and task.

There are two ways to start a new workflow:

-  Request

   Most workflows are started with a HTTP request. The start Links can
   be found on the Process Start Overview HTML page and can be placed on
   an external web sites or as shortcut on the desktop.

   The public API provides also a ways to get a list of all request
   starts for custom start lists or own implemented start mechanism:

   ``ivy.session.getStartableProcessStarts()``

   The HTTP request start can be configured on the :ref:`process-element-start-request-tab-request`.

-  Triggered

   The second way to start a new workflow is by a :ref:`process-element-trigger-step`. On call, it creates
   a new case and a new task to the Request Start with the defined
   configurations (and parameters). This offers a simple way to create
   several workflows inside a other workflow.

   The trigger start can be configured on the :ref:`process-element-start-request-trigger-tab`.

These two start types could be enabled or disabled separately.

Inscription
-----------

.. include:: _tab-name.rst

Start Tab
~~~~~~~~~

On this tab you can define a name and parameters (which results in a so
called Signature) to start the process. See :ref:`process-element-tab-start` for a more detailed
description.

.. note::

   To submit parameters with a HTTP-Request you can simply add them to
   the URL.

   If you have for example defined a parameter named *myParameter* in
   the signature, append ``?myParameter=hallo`` to the URL to pass the
   value *hallo* to the parameter *myParameter*.

   If you want to pass values for multiple parameters the following
   parameter need an & instead of an ?. For example:
   ``?param1=value1&param2=value2&param3=value3``

.. _process-element-start-request-tab-request:

Request Tab
~~~~~~~~~~~

This tab contains the configuration for the HTTP-Request start. 
Name, description and category which is displayed on the start list. 
The required permissions to start the process, and the workflow mode.

Name, description and category
will be used as :ref:`case <glossar-case>` name, description and category if not otherwise configured on the 
:ref:`process-element-tab-case`. 

.. figure:: /_images/process-inscription/request-start-tab-request.png

Enablement
   If *Yes, this start can be started with a HTTP-request/ -Link* is
   checked, the HTTP request mechanism for this start element is
   enabled. Otherwise it is not possible to start the request start with
   a HTTP request.

Start link
   Contains the name of the Process Start link. Notice that this link
   always has to end on *.ivp*. This is required for proper association
   of the request by the web server. Important: this name has to be
   unique within its process.

Start list
   Defines whether this process should appear in the start list of the
   Process Start Overview HTML page or not.

Name
   Defines the display name of the process start in the start list.

Description
   Sets a description of the process start. It is displayed in the start
   list of the Process Start Overview HTML page.

Category
   Defines the category of the process start. 
   This is used to group process starts on the start list.
   
   .. note::

     Look at the :ref:`workflow concept <workflow-categories>` for some more
     information about categorization.
     
.. _process-element-tab-start-custom-fields:
     
Custom Fields 
   Here you can set additional information for the start. The set
   values are only informational and have no effect on how this start is
   treated by Axon Ivy. These :ref:`custom fields <custom-fields>` can easily be queried on
   the :public-api:`IWebStartable </ch/ivyteam/ivy/workflow/start/IWebStartable.html>` interface to allow sorting, filtering or 
   displaying additional information in start lists.
   
   .. tip::

      To display an icon for a start on start lists configure the ``cssIcon``
      custom field. You can find a list of possible icons in the :ref:`Html
      Dialog Demos <importing-demo-projects>`.

      .. include:: _embedInFrame.rst
      If ``embedInFrame`` is set to ``false`` on the request tab custom fields, the
      initial dialog will be embedded in a frame.

Responsible Role
   Users which want to start the process must be assigned to this role.

   .. tip::

      In the Designer you can create test users and assign them the role
      to test this element, on the Axon Ivy Engine you must create the
      real users separately (roles can be imported from the designer).

Anonymous
   If the checkbox has been checked anonymous users (which own the
   *Everybody* role by default) may start the process. If unchecked it
   limits the process to users that are registered in the Axon Ivy Engine
   as users.

Violation error
   The selected exception element is thrown when the user lacks the
   required role. The error can be handled by a catching :ref:`process-element-error-start`.

   .. note::

      If the option is selected, the task can be reset in the process
      (with ``task.reset()``). This will reset the process data and the
      current user who got the task assigned.

   .. note::

      When a session timeout occurs, ``task.reset()`` is called
      automatically on the task. Thereby the user has the task again in
      his task list.

   .. tip::

      Usually only processes including at least one :ref:`process-element-task-switch-gateway` have this option
      selected. Because per default a new task is in state ``CREATED``
      until the task become persisted. If the option is selected, the
      task gets directly into the state ``RESUMED``. With this behavior
      it's possible to distinguish tasks which have a :ref:`process-element-task-switch-gateway` in their process and
      others without one. This helps to separate tasks in the task
      overview from workflow starts (with different steps) and simple
      process starts (which e.g., only outputs some information).


.. _process-element-start-request-trigger-tab:

Trigger Tab
~~~~~~~~~~~

This tab holds definitions for starting this workflow with a :ref:`process-element-trigger-step`.

|image4|

Enablement
   If *Yes, this start can be started with a trigger element* is
   checked, the trigger mechanism for this start element is enabled.
   Otherwise it is not possible to choose the *Request Start* element in
   a :ref:`process-element-trigger-step`.

   .. note::

      When an already related :ref:`process-element-trigger-step` links to a
      disabled start, this will not prohibit the execution at runtime.
      An error is logged to the log file and the process starts with its
      defined configuration.

Responsible Role / User
   Defines the role or user required to carry out the task created with
   the :ref:`process-element-trigger-step`.

   Use *Role from Attr.* or *User from Attr.*, if the role or user must
   be set dynamically during process execution. For example from a
   parameter set by the :ref:`process-element-trigger-step`.

   Use *Role* if you know the responsible role when editing the element.

   - The role SYSTEM means that no human intervention is required. The
     system executes the task automatically.

   - The role CREATOR means that the user who has started the current case
     is responsible for the task created by the :ref:`process-element-trigger-step`.

Delay (blocking period)
   The task can be blocked before a user can work on it. This ivyScript
   expression defines the :ref:`ivyscript-datatype-duration` the task is blocked.

Case
   Define whether the triggered case should be attached to the same :ref:`business-case` as the triggering case.


Task Tab
~~~~~~~~

This tab defines information relevant to the task. Only tasks created
with the :ref:`process-element-trigger-step` (see :ref:`process-element-start-request-trigger-tab`)
will appear in the task list as suspended tasks. Tasks started with a
HTTP request (see :ref:`process-element-start-request-tab-request`) normally
do not appear in the task list.

|image6|

Entry in Task List
   Defines the name and description of the task that appear in the task
   list of the assigned role or user.

Options
   If *Persist task* is selected, the case and task are directly
   persistent on request start. The case state will be RUNNING instantly
   (skipping the state CREATED) and the Task state will be RESUMED
   (skipping the state CREATED). The task could also be reset after the
   Start Request and the next Task Switch or Process End. This option is
   only available when the option *Anonymous* on the :ref:`process-element-start-request-tab-request`
   is disabled.

Priority
   Here you select the priority of the task. In the task list you can
   filter the tasks according the priority.

Expiry
   An IvyScript expression defines the
   :ref:`ivyscript-datatype-duration` until the
   task will expire. If that happens the escalation procedure defined by
   the following parameters is executed.

   -  Exception: Starts an exception process if defined. *>> Ignore
      Exception* will not start an exception process.

   -  Responsible Role / User after expiry: Defines the Role / User to
      reassign the task to.

   -  Priority after expiry: Defines the new Priority of the task after
      it has expired.

   .. note::

      A task created with a HTTP request (see :ref:`process-element-start-request-tab-request`) is
      executed immediately. Defining expiry timeout makes only sense in
      combination when starting with a :ref:`process-element-trigger-step` (see :ref:`process-element-start-request-trigger-tab`)

Custom fields
   The values set on this table are only informational and have no
   effect on how this task is treated by Axon Ivy.

Code
   This is a post construct code block for the Task that is defined in
   this tab. The created Task is provided as variable called ``task`` (:ref:`process-element-tab-task`).


Case Tab
~~~~~~~~

On this tab you can configure the Case created by this Start Request.
See :ref:`process-element-tab-case` in the Common Tabs
section.

.. |image0| image:: /_images/process-editor/elements/start-request.png
.. |image4| image:: /_images/process-inscription/request-start-tab-trigger.png
.. |image6| image:: /_images/process-inscription/request-start-tab-task.png
