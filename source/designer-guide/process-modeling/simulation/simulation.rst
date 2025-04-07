.. _simulation:

Simulation
----------

A simulation can be started directly on the :ref:`Start Element
<process-editor-quick-actions-start-process>` or on the Designer Workflow UI
Overview page displayed either in the browser view of the :ref:`Process
Development Perspective <perspectives-axonivy>` or in a separate browser window,
depending on the setting in the :ref:`corresponding preference
<workspace-preferences-process-engine>`. This Process Start Overview web page
shows all processes that can be started by clicking on the link.

The Web Services are displayed on the Process Start Overview page, too.
By clicking a Web Service Process link, the corresponding WSDL is
displayed.


.. _designer-workflow-ui:

.. figure:: /_images/simulation-debugging/process-start-overview.png
   :alt: Designer Workflow UI

   Designer Workflow UI

.. tip::

   You can switch off the simulation of Process Start Events and
   Intermediate Process Events when you want to simulate or test other
   parts of a project. Just set the corresponding options in the
   :ref:`preferences <workspace-preferences-process-engine>`.


Engine Actions
~~~~~~~~~~~~~~

You are able to control the simulation and to influence the animation
using the actions in the toolbar or the Axon Ivy menu.

.. figure:: /_images/simulation-debugging/menu-engine.png
   :alt: Engine Sub-Menu

   Engine Sub-Menu

Starting the engine and show overview page
   Select the entry |image1| in the menu or as button in the toolbar to start
   the Simulation Engine, open the Process Development Perspective and refresh
   the Process Start Overview page.

Starting the engine
   Select the entry |image3| in the menu or as button  in the
   toolbar to start the Simulation Engine and refresh the Process Start
   Overview page but without opening the Process Development Perspective.

Stopping the engine
   Select the entry |image5| in the menu or the corresponding button in the
   toolbar to stop the Simulation Engine.

Adjust the engine animation speed
   Select the entry |image7|\ in the menu or the corresponding button in the
   toolbar to show the slider to adjust the speed of the animation. This
   overwrites the :ref:`corresponding setting <workspace-preferences-process-engine>` in the
   preferences.

Suppressing the engine animation
   Select the entry |image9| in the menu or the corresponding button in the
   toolbar to switch the engine animation on and off. This overwrites
   the :ref:`corresponding setting <workspace-preferences-process-engine>` in the
   preferences.



.. _language-settings:

Language Settings
~~~~~~~~~~~~~~~~~

This dialog allows to edit the content, formatting and workflow
languages. The :guilabel:`Simulation Languages` settings are used at design time for displaying
the User Dialogs. If option ::guilabel:`Enable language simulation` is checked,
the settings are also used at runtime. 

:ref:`Workflow languages <workflow-languages>` controls for which languages case and task name and description are stored. 

.. figure:: /_images/simulation-debugging/content-formatting-language-settings.png

Accessibility
^^^^^^^^^^^^^

Press |image20d| in the toolbar.

Settings
^^^^^^^^^^^^^

You can confîgure the following language settings:

Enable language simulation
   If checked, then the content and the formatting language settings will
   be used while simulating. If **not** checked then the settings of the
   browser will be used.

Content Language
   The content language is used to select the values of content objects.

Formatting Language
   The formatting language is used when objects are formatted using the
   ``format()`` method.
   
Workflow Languages
   The :ref:`languages <workflow-languages>` names and descriptions of cases or tasks are stored.


How to use in IvyScript
^^^^^^^^^^^^^^^^^^^^^^^

To get or set the content or formatting language in IvyScript use
``ivy.session.contentLocale`` respectively
``ivy.session.formattingLocale``.

Find out more about Axon Ivy's scripting language :ref:`ivyscript`.

.. |image20d| image:: /_images/simulation-debugging/button-languages.png



.. _simulate-process-models-breakpoints:

Breakpoints
~~~~~~~~~~~

A breakpoint is a marker that tells the simulation engine to pause the
execution. It is then possible to inspect the execution history, to view
the values of internal variables and evaluate user defined expressions
without being interfered by the running execution. The execution has to be
resumed by the user explicitly using the functionality of the
:ref:`Debug View <debugger-debug-view>`. You can see a list of your breakpoints and
edit them in the :ref:`Breakpoint View <debugger-breakpoints-view>`.

.. _process-element-breakpoints:

Process Element Breakpoints
^^^^^^^^^^^^^^^^^^^^^^^^^^^

A process element breakpoint is a breakpoint that can be set on a
process element. The execution of the process will be interrupted before
the process element is executed.

**Add / Remove a breakpoint**

You can add process element breakpoints in a :ref:`process-editor` or User Dialog Logic
editor window by using the :ref:`Quick Action Menu
<process-editor-quick-actions-toggle-breakpoint>`. Select the process step on
which you intend to set the breakpoint and click on the bug.

**Edit a breakpoint**

You can add a *condition* to a breakpoint in the
:ref:`debugger-breakpoints-view`. If you do so, the breakpoint is only active if
the expression evaluates to `true` and will then suspend the execution. In the
expression, you have access to all variables in the context of the process 
step, including ``in``. 

**Disable a breakpoint**

You can disable a specific breakpoint in the :ref:`debugger-breakpoints-view` or by clicking
on the breakpoint in the :ref:`process-editor`. It is also possible to disable all
breakpoints in the :ref:`debugger-breakpoints-view`. 

.. |image1| image:: /_images/simulation-debugging/button-engine-start-with-page.png
.. |image3| image:: /_images/simulation-debugging/button-engine-start.png
.. |image5| image:: /_images/simulation-debugging/button-engine-stop.png
.. |image7| image:: /_images/simulation-debugging/button-engine-speed.png
.. |image9| image:: /_images/simulation-debugging/button-engine-animation.png
