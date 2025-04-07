Debugger
--------

The debugger provides a set of views and features to inspect the
execution (including its history) of your processes and User Dialogs.
Akin to a debugger in an Integrated Development Environment (IDE) such
as Eclipse, NetBeans or VisualStudio it is possible to set breakpoints
to pause an execution, to iterate through executions step-by-step and to
examine the history and the current state of the execution in depth.


.. _debugger-debug-view:

Debug View
~~~~~~~~~~

The Debug view shows in a tree per open project all the currently
handled requests i.e., all processes under execution in the simulation
engine.

.. figure:: /_images/simulation-debugging/debug-view.png
   :alt: Debug view in action

   Debug view in action

For each request to the engine the current state (i.e., the currently
executed process step) are shown and can be manipulated individually
with the following buttons on the toolbar:

.. figure:: /_images/simulation-debugging/buttons-debugging.png

Resume
   Resumes the execution of the selected process/request until the end
   of the process to the next breakpoint

Terminate
   Terminates the execution of the selected process/request

Step Into
   This can be used to step into a (callable) process element. The
   current step is executed and then execution is suspended on the next
   step again.

Step Over
   This can be used to step over a (callable) process element. The
   current step is executed and then execution is suspended on the next
   step in the current process.

Step Out
   This can be used to step out of the current process, the execution is
   suspended again on the caller process element.

If you select a stack element then the process editor shows the process
element that is executed at this stack element. Moreover, the
:ref:`debugger-variables-view` will display the current values of the
process data at the process element of the selected stack element.


.. _simulate-process-models-debugger-history-view:

History View
~~~~~~~~~~~~

In this view you see the values of your process data (the ``in``
variable) during all runs of the currently selected process element in
the process editor. The topmost tree entry shows the data of the first
execution of the selected element during the first request whereas the
entry at the bottom corresponds to the most current execution.

.. figure:: /_images/simulation-debugging/history-view.png
   :alt: History view in action

   History view in action

The following buttons on the toolbar can be used to navigate to process
elements and to configure the history:

Go to process element (|image12|)
   Marks the process element in the process editor whose history is
   currently displayed.

Go to next process element (|image13|)
   Shows the history of the next process element.

Go to previous process element (|image14|)
   Shows the history of the previous process element.

History view preferences (|image15|)
   Opens the preference page with the settings for the history.

.. note::

   In case of memory shortage during simulation or due to history
   settings process data snapshots may be discarded. This is indicated
   by the message "history data no longer available".


.. _debugger-breakpoints-view:

Breakpoints View
~~~~~~~~~~~~~~~~

This view lists all the breakpoint which are currently set and offers
some functionality to edit and filter single breakpoints.

.. figure:: /_images/simulation-debugging/breakpoint-view.png
   :alt: Breakpoints view in action

   Breakpoints view in action

You can configure and control the View with the toolbar and menu:

Remove Breakpoints (|image16| |image17|)
   You can remove either the selected process(es) or all processes.

Show Breakpoints Supported by Selected Target (|image18|)
   Shows only the breakpoints in the list which are included in the
   process start under execution.

Go to File for Breakpoint (|image19|)
   Opens an editor with the file containing the breakpoint or sets the
   focus on the corresponding editor window.

Skip all Breakpoints (|image20|)
   If set, all breakpoints are skipped.

   .. tip::

      This is helpful when you need to debug only some executions of a
      process steps. You can skip the breakpoints at the beginning and
      switch this button off, when the execution reaches the part you
      are interested in.

Expand All / Collapse All (|image21| |image22|)
   If you have grouped the breakpoints together, you can quickly expand
   or collapse the whole tree

Link with Debug View (|image23|)
   Links this view together with the Debug View.

Add Java Exception Breakpoint (|image24|)
   Adds a breakpoint for a type of Java Exceptions, which will be used
   whenever this Java Exception is thrown throughout the execution.

   .. warning::

      Use this feature only if you are familiar with the Java
      programming language and its exception handling mechanism

Toolbar Menu (|image25|)
   Here you can group the breakpoints according to some categories,
   select whether you want to restrict the view on a specific working
   set and set whether you want to see fully qualified names for
   breakpoints in Java code.

Condition
   If you select a process breakpoint, you can add an :ref:`expression condition
   <process-element-breakpoints>` to the breakpoint in the input field below.


.. _debugger-variables-view:

Variables View
~~~~~~~~~~~~~~

This view shows a list of all variable in the context (or scope) of the
currently executed process step. You are able to examine the structure,
the types and the values of variables and it is even possible to change
the values of variables which have a simple data type (such as
``String``, ``Number``, ``Boolean``, ``Time``, ``Date`` or
``DateTime``). The view is divided into a variable tree showing the
structure, value and type of each variable (including its members) and a
detail pane that displays the values for deeper examination.

.. figure:: /_images/simulation-debugging/variables-view.png
   :alt: Variables View in action

   Variables View in action

Collapse All (|image26|)
   Collapse the whole variable tree to its root items.

Toolbar Menu (|image27|)
   
   .. figure:: /_images/simulation-debugging/variables-view-menu.png

   Layout
      You can switch on and off the detail pane, set its orientation
      (vertical or horizontal) and set whether and which columns should
      be displayed.

   Detail pane
      Setting for the size of the buffer for the detail pane, the higher
      the longer values you can examine (e.g., very long strings) but the
      more memory you use.

   Wrap Text in Details Pane
      Wrap text in details pane when it does not fit in the available
      space

Popup Menu

   .. figure:: /_images/simulation-debugging/variables-view-popup.png

   Select All
      Selects all elements in the list.

   Copy Variables
      Copies all selected variables into the clipboard (e.g., for use in
      the :ref:`debugger-expressions-view`).

   Find ...
      Allows to find a specific variable with a filter string.

   Change Value ...
      The values of primitive Java data types may be changed here.

   Create Watch Expression
      Creates a new expression in the :ref:`debugger-expressions-view`.

.. warning::

   Changing the value may cause exceptions or introduce undesired side
   effects with very weird behavior in the continuation of the
   execution. Please use this feature with precaution!


.. _debugger-expressions-view:

Expressions View
~~~~~~~~~~~~~~~~

In this view you can define expressions, evaluate them and examine their
values (similar to the :ref:`debugger-variables-view`). In
the expression you can use all valid IvyScript operators and language
elements and at a certain point of time, only variables which are in the
scope of the currently executed process step can be evaluated.

.. figure:: /_images/simulation-debugging/expressions-view.png
   :alt: Expressions View in action

   Expressions View in action

Show Type Names (|image28|)
   Shows the type names of the variables in the front of the variable.

Collapse All (|image29|)
   Collapse the whole expression tree to its root items.

Remove Selected Expressions / Remove All Expressions (|image30|)
   You can remove either the selected or all expressions.

Toolbar Menu (|image31|)

   .. figure:: /_images/simulation-debugging/expressions-view-menu.png

   Layout
      You can switch on and off the detail pane, set its orientation
      (vertical or horizontal).

   Detail pane
      Setting for the size of the buffer for the detail pane, the higher
      the longer values you can examine (e.g., very long strings) but the
      more memory you use.

   Wrap Text in Details Pane
      Wrap text in details pane when it does not fit in the available
      space.

Popup Menu

   .. figure:: /_images/simulation-debugging/expressions-view-popup.png

   Select All
      Selects all elements in the list.

   Copy Expressions
      Copies all selected expressions and their state into the
      clipboard.

   Find ...
      Allows to find a specific variable with a filter string.

   Add Watch Expression ...
      Adds a watch expression into the expression view.

   Reevaluate Watch Expression
      Computes the current value of the expression (e.g., if expression
      reads data which was manipulated by concurrent threads).

   Disable / Enable
      Disables or enables the automatic evaluation of expressions when
      changes occur.

   Edit Watch Expression ...
      Edits the selected watch expression.

.. |image12| image:: /_images/simulation-debugging/button-goto-process-element.png
.. |image13| image:: /_images/simulation-debugging/button-goto-next-process-element.png
.. |image14| image:: /_images/simulation-debugging/button-goto-previous-process-element.png
.. |image15| image:: /_images/simulation-debugging/button-history-preferences.png
.. |image16| image:: /_images/simulation-debugging/button-breakpoint-remove-one.png
.. |image17| image:: /_images/simulation-debugging/button-breakpoint-remove-all.png
.. |image18| image:: /_images/simulation-debugging/button-breakpoint-target.png
.. |image19| image:: /_images/simulation-debugging/button-breakpoint-goto-file.png
.. |image20| image:: /_images/simulation-debugging/button-breakpoint-skip-all.png
.. |image21| image:: /_images/simulation-debugging/button-breakpoint-tree-expand.png
.. |image22| image:: /_images/simulation-debugging/button-breakpoint-tree-unexpand.png
.. |image23| image:: /_images/simulation-debugging/button-breakpoint-link.png
.. |image24| image:: /_images/simulation-debugging/button-breakpoint-java.png
.. |image25| image:: /_images/simulation-debugging/button-breakpoint-menu.png
.. |image26| image:: /_images/simulation-debugging/button-variable-collapse.png
.. |image27| image:: /_images/simulation-debugging/button-breakpoint-menu.png
.. |image28| image:: /_images/simulation-debugging/button-expression-type-names.png
.. |image29| image:: /_images/simulation-debugging/button-variable-collapse.png
.. |image30| image:: /_images/simulation-debugging/button-breakpoint-remove.png
.. |image31| image:: /_images/simulation-debugging/button-breakpoint-menu.png



.. _simulate-process-models-debugger-runtimelog-view:

Runtime Log View
~~~~~~~~~~~~~~~~

The Runtime Log view displays a list of events. This events occur during
the simulation. When you start the Axon Ivy process engine, this log
view is opened by default and all entries are cleared.

.. figure:: /_images/simulation-debugging/runtimelog-view.png

Accessibility
^^^^^^^^^^^^^

Window > Show View > Runtime Log

Window > Show View > Other ... > Other... > Axon Ivy > Runtime Log

Columns
^^^^^^^

The following columns are displayed in the Runtime Log view:

First narrow column without name
   In this column an icon is displayed that symbolizes the type of
   logged event (info / warning / error message)

Request
   The request (HTTP, etc. with its ID) is displayed in which the log
   message occurred.

Project
   The name of the project the log event was logged in.

Element
   The identifier of the process element which logged the event.

Category
   The log category refers to the Axon Ivy part which has logged the
   event (e.g., user_code: ivyScript by user; process: log from/during
   process model execution).

Message
   The event message is displayed here.


Logged Event Details
^^^^^^^^^^^^^^^^^^^^

When you double click on a log entry, a detail window will appear.

.. figure:: /_images/simulation-debugging/runtimelog-view-details.png
   :alt: Runtime Log View Event Details

   Runtime Log View Event Details

The following fields are displayed in this window:

Time
   Time, when the event was logged.

Request
   The request (HTTP, etc. with its ID) in which the log message
   occurred.

Severity
   Shows how serious the logged event is (debug, info, warning, or
   error).

Project
   The name of the project the log event was logged.

Category
   The log category refers to the Axon Ivy part which has logged the
   event (e.g., user_code: ivyScript by user; process: log from/during
   process model execution).

Element
   The identifier of the process element which logged the event.

Message
   The log message is displayed here.

Stack
   If an exception was logged with the event, and it contains a stack
   trace (calling hierarchy), then it is displayed here.

On the right hand side the following buttons are located:

|dimage0| Previous event
   Clicking on this button will open the previous event of the logged
   events list.

|dimage1| Next event
   Clicking on this button will open the next event of the logged events
   list.

|dimage2| Goto User Dialog
   This button is available only if the log event contains User Dialog
   information. Clicking on this button opens a new editor showing the
   User Dialog which that has logged the event.

|dimage3| Goto process element
   If you click on this button a process is opened and the process
   element that has logged the event is selected.

|dimage4| Copy event details to clipboard
   If you click on this button all log event information are copied to
   clipboard.

|dimage5| Save Error Report
   If you click on this button an error report that contains information
   about the error, the designer machine and the current state of the
   Axon Ivy Designer.

How to log
^^^^^^^^^^

This chapter describes how you can log to the runtime log.

Open any process elements that contain IvyScript (like: Step, Web
Service, etc.) and type a script like the one you find in the figure
below:

.. literalinclude:: includes/log.txt
    :language: java

Find out more about Axon Ivy scripting language :ref:`ivyscript`.

.. |dimage0| image:: /_images/simulation-debugging/runtimelog-view-details-button-previous-event.png
.. |dimage1| image:: /_images/simulation-debugging/runtimelog-view-details-button-next-event.png
.. |dimage2| image:: /_images/simulation-debugging/runtimelog-view-details-button-goto-userdialog-view.png
.. |dimage3| image:: /_images/simulation-debugging/runtimelog-view-details-button-goto-process-element.png
.. |dimage4| image:: /_images/simulation-debugging/runtimelog-view-details-button-copy-event-details.png
.. |dimage5| image:: /_images/simulation-debugging/runtimelog-view-details-button-save-error-report.png





.. _process-performance-view:

Process Performance View
~~~~~~~~~~~~~~~~~~~~~~~~

The Process Performance View displays process performance statistics.
This allows to analyze the performance and to detect long running and
performance intensive process elements and processes. The view contains
detailed information of each executed process element.

.. figure:: /_images/simulation-debugging/process-performance-view.png
   :alt: Process Performance View

   Process Performance View

.. note::

   On the Axon Ivy Engine there is the possibility to dump out
   performance statistics to a comma separated value file (*.csv). Check
   the Engine Guide for more information: *Monitoring > Process Element
   Performance Statistic and Analysis*

Accessibility
^^^^^^^^^^^^^

*Window > Show View > Other... > Axon Ivy > Process Performance*

Analyze the Performance Statistic
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

All time values are in milliseconds. The execution of some process
elements are separated in two categories internal and external.

Internal Category
   The internal category is used for the execution time in the process
   engine itself without the external execution.

External Category
   The external category is used for execution time in external systems.
   In the table below the process elements are listed which use the
   external category.

   .. table:: Process elements with usage of external category

      +-----------------------+---------------------------------------------------------------------+------------------------------------------------------------+
      | Process Element       | Internal Category                                                   | External Category                                          |
      +=======================+=====================================================================+============================================================+
      | Database Step         | Parameter-mapping, caching, output-mapping and IvyScript execution. | The execution of the SQL statement on the database server. |
      +-----------------------+---------------------------------------------------------------------+------------------------------------------------------------+
      | Web Service Call Step | Parameter-mapping, caching, output-mapping and IvyScript execution. | The execution of the Web Service on the web server.        |
      +-----------------------+---------------------------------------------------------------------+------------------------------------------------------------+
      | E-Mail Step           | Parameter-mapping                                                   | The interaction with the Mail-Server.                      |
      +-----------------------+---------------------------------------------------------------------+------------------------------------------------------------+
      | Program Interface     |                                                                     | The execution of the defined Java-Class.                   |
      +-----------------------+---------------------------------------------------------------------+------------------------------------------------------------+

For each executed process element one entry in the view is created. See
the table below which information is available.

.. table:: Column Description

   +-----------------+------------------------------------------------------------+
   | Name            | Description                                                |
   +=================+============================================================+
   | Entry ID        | Entry ID, useful to order the entries by its execution     |
   +-----------------+------------------------------------------------------------+
   | Process Path    | The path to the process.                                   |
   +-----------------+------------------------------------------------------------+
   | Element ID      | The identifier of the process element.                     |
   +-----------------+------------------------------------------------------------+
   | Element Name    | The first line of the process element name (display name). |
   +-----------------+------------------------------------------------------------+
   | Element Type    | The type of the process element.                           |
   +-----------------+------------------------------------------------------------+
   | Total Time      | Total time [ms] of internal and external execution.        |
   +-----------------+------------------------------------------------------------+
   | Int. Executions | Total internal executions of the process element.          |
   +-----------------+------------------------------------------------------------+
   | Total Int. Time | Total internal time [ms] of process engine executions.     |
   +-----------------+------------------------------------------------------------+
   | Min. Int. Time  | Minimum internal process engine execution time [ms].       |
   +-----------------+------------------------------------------------------------+
   | Avg. Int. Time  | Average internal process engine execution time [ms].       |
   +-----------------+------------------------------------------------------------+
   | Max. Int. Time  | Maximum internal process engine execution time [ms].       |
   +-----------------+------------------------------------------------------------+
   | Ext. Executions | Total external execution count.                            |
   +-----------------+------------------------------------------------------------+
   | Total Ext. Time | Total external execution time [ms].                        |
   +-----------------+------------------------------------------------------------+
   | Min. Ext. Time  | Minimum external execution time [ms].                      |
   +-----------------+------------------------------------------------------------+
   | Avg. Ext. Time  | Average external execution time [ms].                      |
   +-----------------+------------------------------------------------------------+
   | Max. Ext. Time  | Maximum external execution time [ms].                      |
   +-----------------+------------------------------------------------------------+
