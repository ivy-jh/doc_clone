Common Tabs
===========

This section describes the most common tabs that are used on more than
one element inscription mask.


.. _process-element-tab-general:

General Tab
-----------

This tab is included in the inscription mask of all process elements and
contains the name and a description of the element.

.. figure:: /_images/process-inscription/common-tab-general.png
   :alt: Name tab

   Name tab

Element Name
   Name of the element in the process.

   The name will be displayed in the process editor.

   .. tip::

      Give each element a name, always. This increases the overview and
      simplifies the exchange of models between you and your colleagues.
      If you work in a team, the use of naming conventions is strongly
      recommended.

Description
   Describes the function of the element.

   This text appears as tool tip in the process editor whenever the
   mouse stays over the element.
   
   .. tip::

      You may format the descriptive text with Markdown to improve it's readability.
      Here's a cheat-sheet with the most common keywords https://www.markdownguide.org/cheat-sheet/.

Means/Documents
   A list with references to additional stuff that is related to this
   process step, i.e., documentation, templates, example forms and many
   more.


.. _process-element-tab-general-tags:

Tags
~~~~~~

Contains a list of keywords associated with the process element. These tags
help to describe elements and allow them to be found again by searching. 
Any word can be added as tag name.

There are pre-defined tags with special functionality for some start elements:

- ``DEPRECATED``: This tag marks a Sub Process Start, a Request Start or a WebService Start element as deprecated. 
  Call elements using a deprecated element will be marked with a deprecation validation warning.
- ``CONNECTOR``: Setting this tag allows a Sub Process Start element to be displayed in the Extensions Dialog. 
  See :ref:`process-element-extension-item`
- ``DEMO``: Marks a Request Start of a process as demonstration process. Such demo processes will be automatically opened, 
  while the project that contains it is being imported to the Axon Ivy Designer. 
  We recommend to use it for demo processes, which are consumed from the Axon Ivy Market.


.. _process-element-tab-output:

Output Data Tab
---------------

On this tab you can set all values in the output Data Class. By default
the output variable is mapped directly to the input variable, but the
user can overwrite either the assignment of the whole output Data Class
or only of single member of it.

.. note::

   In Axon Ivy input and output of process are always set to the
   corresponding data class, i.e., in a User Dialog logic element it is
   the User Dialog Data Class and in a process element it is the project
   Data Class (or the one which was assigned to the process).

.. figure:: /_images/process-inscription/common-tab-output.png
   :alt: Output tab

   Output tab

Output Tree
   Shows the whole structure of the output variable including each of
   its members with the assigned values/expressions. You may use the
   :ref:`attribute-method-browser` and the :ref:`function-browser` to construct
   the expressions.

Tree Toolbar
   |search-button| Allows the filtering of the shown values by your own criteria.

   |filter-button| Sets a filter to only show rows with an assigned value.

Code Block
   In the code block below the tree table you can express any complex
   mapping that does not fit into the tree table. For instance you might
   prefer to use the code block to assign values by using a loop
   statement.

.. |search-button| image:: /_images/ui-icons/search.svg
  :width: 2em
.. |filter-button| image:: /_images/ui-icons/rule.svg
  :width: 2em

.. _process-element-tab-code:

Code Tab
--------

The code tab is part of almost all inscription masks and allows the user
to define the semantics (behavior) of the corresponding process element
with the built-in :ref:`ivyscript`.

.. figure:: /_images/process-inscription/common-tab-code.png
   :alt: Code Tab

   Code Tab

Code Editor
   You can write IvyScript code snippets into many parts of the inscription. 
   The editor supports code completion and error highlighting. 
   Red underlined code indicates an error.

   .. tip::

      For more information about IvyScript, see :ref:`ivyscript`.

Code Toolbar
   |maximize-action| Open the current code editor in a :ref:`large-code-browser`.

   |search-action| Open the :ref:`process-inscription-browsers` to select contents from your project environment. 

.. |search-action| image:: /_images/ui-icons/list-search.svg
   :width: 2em   
.. |maximize-action| image:: /_images/ui-icons/arrows-maximize.svg
   :width: 2em   



.. _process-element-tab-start:

Start Tab
---------

The start tab defines the name and the input parameters to start the
process. The signature is a definition of the name with the parameter
types and its order. Elements like :ref:`process-element-call-sub` or :ref:`process-element-trigger-step` 
are referenced to this signature.

.. figure:: /_images/process-inscription/common-tab-start.png
   :alt: Start Tab

   Start Tab

Signature
   Displays the current signature. Namespaces of the parameter types are
   not displayed, but they are still a part of the signature, that
   identifies a start uniquely.

Name
   Signature name is case sensitive and can only contain letters (a-Z),
   numbers (0-9) and underscores (_).

Definition of input parameters
   Defines the input parameter of the interface. The type of the
   parameters and its order is used for the signature. Changing the
   order or the type, changes also the signature. All referenced
   elements have to be updated. The list may be left empty if the
   operation does not require any input parameters. To add a new
   parameter, click the green plus icon and specify the name, type 
   and description of the parameter.

Mapping of input parameters
   The input parameters defined above are available as fields on the
   ``param`` variable. You can assign the parameter values to the
   internal data fields in the table.

   .. note::

      The reason why you have to assign the incoming parameters to local
      data is to keep the implementation independent from the
      declaration.

   .. tip::

      You may already specify the type of the parameter here by adding a
      colon ':' to the parameter name, followed by desired type (e.g.
      ``myDateParameter:Date``). When only adding a colon to the name
      without a type, the default data type will be String.

Code
   In this code block you can insert any logic needed. The context is
   the same as in the Mapping of input parameters.

.. note::

   The reason you have to assign the incoming parameters to local data
   is to keep the internal implementation independent from the signature
   declaration. The mapping of parameters serves as a flexible adapter
   mechanism. The implementation can be changed (rename data, use
   different data types, etc.) without changing the signature. That way
   none of the clients of the process have to be changed as long as only
   the implementation changes and the signature stays.

.. note::

   Only the defined input parameter on the signature can be assigned to
   the process data. The internal process data is hidden and
   encapsulated from the environment. This makes it impossible to inject
   unintended, insecure data into the process data.   

.. _process-element-tab-result:

Result Tab
----------

This tab is used to define the values that will be returned to the
caller when the process ends. All logic in this tab will be executed
when the end element is reached. E.g., when the :ref:`process-element-user-dialog-exit-end` is reached.

.. figure:: /_images/process-inscription/common-tab-result.png
   :alt: Result Tab

   Result Tab

Output Parameters
   This table is used to define the output parameters of the operation.
   The list may be left empty if the operation does not return any data.
   To add a new parameter, click the green plus icon and specify the
   name, type and description of the parameter.

Mapping of process data
   For each defined output parameter you must now specify the value that
   will be returned. In most cases, this is a process attribute. However
   you may specify any valid IvyScript expression.

Using the defined return parameters
   The declared return parameters are shown in the table as fields of a
   ``result`` variable (none if the defined return value is ``void``).


.. _process-element-tab-data-cache:

Cache Tab
--------------

Process activities that read data from an external system can cache
values of previous executions in the memory and re-use them on follow up
executions. This is an optimization for external systems that execute
expensive operations or have slow response times.

For more information about this topic, please refer to the :ref:`data-cache` section.

.. figure:: /_images/process-inscription/common-tab-data-cache.png
   :alt: Data Cache tab

   Data Cache tab

Caching Mode
   -  **Do not cache**: Does not use the data caching mechanism at all,
      the element is executed normally. This is the default setting for
      all elements.

   -  **Cache**: Uses the data caching mechanism to execute the element.
      First the whole data cache is searched for the entry described
      below in the *Group/Entry* part. If found, the cached value is
      returned and the execution of the element ends. If not found, the
      element is executed normally, but in the end the result is stored
      in the data cache.

   -  **Invalidate Cache**: Explicitly invalidates the data cache entry
      specified in the *Group/Entry* part. Use this when your element
      performs a write operation that changes data which is cached. The
      step is executed normally, but in addition the specified data
      cache entry is invalidated.

Scope
   Cache entries are always bound to their scope.

   -  **Session**: the cache entry is linked to the currently logged in
      user (i.e., is specific for each user and is invalidated when the
      user logs out).

   -  **Application**: the cache entry is linked to the Application

   .. warning::

      Use caches sparingly and with precaution! If you cache results
      from process steps with huge results (in terms of memory usage),
      your memory can fill up very fast. This can even get worse if you
      frequently use the session scope and the result is cached multiple
      times (once for each session i.e., user)

Group
   -  **Name**: Cache entries need a group name. Several entries can
      share the same group in order to invalidate multiple entries at
      the same time.

   -  **Lifetime**: Groups can be invalidated either on request (see
      Caching Mode: Invalidate Cache), at a specific time of the day 
      (String with time format :code:`"HH:mms:ss"`, e.g., :code:`"23:50:00"`) or
      after a configurable period of time (In seconds, e.g., 
      :code:`3600` for one hour). Invalidating a group always means to 
      remove all its entries from the cache.

Entry
   -  **Name**: Must be unique within the group but you are allowed to
      have multiple entries with the same name in different groups. Use
      always the same entry names (as well for the group) if you want to
      use the same data cache entry in multiple process steps.

   -  **Lifetime**: Single cache entries can be invalidated either on
      request (see Caching Mode: Invalidate Cache), at a specific time
      of the day (String with time format :code:`"HH:mm:ss"`, e.g., :code:`"23:50:00"`) 
      or after a configurable period of time (In seconds, e.g., 
      :code:`3600` for one hour).


.. _process-element-tab-case:

Case Tab
--------

Every time a :ref:`process <glossar-process>` is started a
:ref:`case <glossar-case>` is created. This tab allows you to define
additional information for the cases. The information defined on this
tab has no effect how Axon Ivy treats the cases. But they can be
accessed through the :public-api:`Public API </>`, which allows you
to use them for example to filter the task list.

You can define the name, the description and the category for the
corresponding case.

.. note::

   Look at the :ref:`workflow concept <workflow-categories>` for some more
   information about categorization.
   Look at the :ref:`multilingual concept <workflow-languages>` for multilingual case names and descriptions.


.. figure:: /_images/process-inscription/common-tab-case.png
   :alt: Case Tab

   Case Tab

.. _process-element-tab-case-custom-fields:

Case Custom Fields
   .. figure:: /_images/process-inscription/common-section-task-custom-fields.png
      :alt: Task Custom Fields

      Case Custom Fields

   Here you can set additional information for the created case. The set
   values are only informational and have no effect on how this case is
   treated by Axon Ivy. These :ref:`custom fields <custom-fields>` can easily be queried on
   case user interfaces to allow sorting and filtering.

   .. include:: _embedInFrame.rst
   If ``embedInFrame`` is set to ``false`` on the case tab custom fields, all the
   following tasks are gonna open on a full screen page.


.. _process-element-tab-task:

Task Tab
--------

This tab defines the parameters for the tasks created by the Task
Switch. The task tab is used by 
:ref:`process-element-task-switch-event`,
:ref:`process-element-task-switch-gateway` and
:ref:`process-element-user-task`.

**Name, description:** of the task that appear in the task list of the
addressed role or user. 

.. note::

   Look at the :ref:`multilingual concept <workflow-languages>` for multilingual task names and descriptions.

**Category:** It is recommended practice to define and reference the text
from the CMS. See :ref:`here <workflow-categories>`.

**Responsible:** The role or user to assign the task

  .. include:: _responsible.rst

.. note::

   A user can be informed by mail if a new task has been created for
   him.

.. figure:: /_images/process-inscription/common-tab-task.png
   :alt: Task tab

   Task tab

Task Options
   .. figure:: /_images/process-inscription/common-section-task-options.png
      :alt: Task Options

      Task Options

   **Skip Tasklist**

   Normally a user interaction ends at a Task Switch element. It will be
   redirected to the task list or an end page is shown. If *Skip
   tasklist* is activated for a task the user interaction may not end at
   the Task Switch element. It is automatically redirected to this new
   task marked with *Skip tasklist*. But only if it is allowed to work
   on the task and the Task Switch is not waiting for any other tasks to
   finish.
   
   Onle one task of a Task Switch element can activate *Skip tasklist*.

   **Delay**

   The task can be blocked before a user can work on it. So the user
   will not see the task in his tasklist or get any notification about
   its existence until the delay period is over. This ivyScript
   expression defines the :ref:`ivyscript-datatype-duration` the task is
   blocked.

Task Expiry
   .. figure:: /_images/process-inscription/common-section-task-expiry.png
      :alt: Task Expiry

      Task Expiry

   **Timeout**

   An IvyScript expression defines the
   :ref:`ivyscript-datatype-duration` until the task
   will expire. If that happens the escalation procedure defined by the
   following parameters is executed. You can also use a simple
   :public-api:`Duration </ch/ivyteam/ivy/scripting/objects/Duration.html>` 
   syntax like :code:`2D`. 

   .. note::

      If a Delay is defined, the expiry timeout begins after the Delay.

   **Error**

   Executes an :ref:`process-element-error-start` that
   compensates the expired task. Here you can implemented any custom
   behavior and access the full workflow API.

   **Responsible**

   Defines the role or user to reassign the task to after it has expired.

   .. include:: _responsible.rst

   **Priority**

   Defines the new Priority of the task after it has expired.


.. _process-element-tab-task-custom-fields:

Task Custom Fields
   .. figure:: /_images/process-inscription/common-section-task-custom-fields.png
      :alt: Task Custom Fields

      Task Custom Fields

   Here you can set additional information for the created task. The set
   values are only informational and have no effect on how this task is
   treated by Axon Ivy. These :ref:`custom fields <custom-fields>` can easily be queried on
   task user interfaces to allow sorting and filtering.

   .. include:: _embedInFrame.rst
   If ``embedInFrame`` is set to ``false`` on the task tab custom fields, the next 
   task is gonna open on a full screen page.


.. _process-element-tab-task-notification:

Task Notification
   .. figure:: /_images/process-inscription/common-section-task-notification.png
      :alt: Task Notification

      Task Notification

   **Suppress Notification**

   A notification is generated when a task is created or assigned.
   If *Suppress Notification* is enabled, no notifications will be generated for this task.

   **Template**

   A template which is located in the cms :file:`/Notification/new-task/Templates/[template]/[channel]/Subject|Content`
   e.g. the :code:`Subject` template :code:`my-custom-template` for the :code:`mail` channel: 
   :file:`/Notification/new-task/Templates/my-custom-template/mail/Subject`. See als :ref:`Templating <notification-templating>`.


.. _process-element-tab-task-code:

Task Code
   .. figure:: /_images/process-inscription/common-section-task-code.png
      :alt: Task Code

      Task Code

   This is a post construct code block for the Task that is defined in
   this tab. The created Task is provided as variable called ``task``.
   Classically you can use is to call custom API that relates to the
   task, but there is no feasible UI element available to configure it.
   E.g., the :public-api:`BusinessCalendar </ch/ivyteam/ivy/application/calendar/IDefaultBusinessCalendar.html>`
   of the created Task could be defined in this place. Or if you need to
   define Custom Fields with dynamic keys out of a third party source
   you'd rather do this in this code block than with the ui table above
   where the key names and types are static.
