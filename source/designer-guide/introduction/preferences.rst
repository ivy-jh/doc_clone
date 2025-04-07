.. _workspace-preferences:

Preferences
===========

In the preferences you can configure some Axon Ivy Designer settings to
adapt it to your personal working style. Most of these settings you can
overwrite in the :ref:`project-preferences`.


.. _process-editor-preferences:

Process Editor Settings
-----------------------

The process editor settings are used to configure the behavior and look
of the process editor as well as some settings that are related to the
use of processes.

.. figure:: /_images/designer/preferences-processeditor.png
   :alt: Process Editor Preferences
   :align: center
   
   Process Editor Preferences


Show grid lines in the editor
   Specify whether the grid lines in the process editor are shown.


.. _workspace-preferences-process-engine:

Process Engine Settings
-----------------------

Here you can set whether the internal Browser view of Eclipse or an
external Browser is used to show the Process Start Overview and you can
configure all the settings related to the animation.

.. figure:: /_images/designer/preferences-processengine.png
   :alt: Process Engine Preferences
   :align: center
   
   Process Engine Preferences
   

Automatically start all process engines on Designer start
   If the check box is selected, all process engines are automatically
   started on Designer start. It can be disabled to prevent performance
   issues on large workspaces.

Animation speed fast < - > slow
   Sets the default speed of the animation. Setting the slider to a low
   value lets you observe the process flow easily as the animation speed
   is decreased.

   .. tip::
   
      As the animation is very slow with low slider values adjust this
      setting only when you need to debug a process in its lowest
      details and increase the speed as soon you have finished.

Simulation/Animation follow
   Here you can set in which mode the execution is animated. You can
   choose between the following values:

   -  **Do not follow the animation at all** - does nothing

   -  **Show and open all touched processes (default)** - Default setting,
      this opens a process editor window for every process (or User
      Dialog logic in case of inner User Dialogs) that is used within
      the started process

   -  **Follow only top level business processes** - Simulates and opens
      only top level business processes. Does not enter User Dialogs,
      embedded subs or callable subs.

   -  **Do not enter dialog logic** - Does not simulate User Dialogs

   -  **Follow only in open editors** - You can choose which process are
      animated by opening them in a process editor window. Note that the
      focus switches always the window displaying the currently executed
      process

   -  **Follow only in current editor on top** - If you are only interested
      to debug one specific process. Note, that this is not imperatively
      the top-level process

History
   Here you can configure how many process data snapshots are archived
   in the process engine history (:ref:`History View <simulate-process-models-debugger-history-view>`).

   -  **Activate history** - If ticked process data is archived, if not
      ticked no process data is archived.

   -  **Number of requests to keep in history** (0 means all) - Here you can
      configure the number of requests per process element for which
      snapshots of the process data are stored in the history. If you
      configure 0 the process data snapshots for all requests are
      stored.

   -  **Number of executions to keep in history** (0 means all) - Here you
      can configure the number of executions per requests and process
      element for which snapshots of the process data are stored in the
      history. If you configure 0 the process data snapshots for all
      executions are stored. A value of 10 means that the process data
      snapshots of the five oldest and youngest executions of a process
      element per request are stored in the history.

   .. note::

      In case of memory shortage during simulation the settings of
      history preferences may be ignored (resulting in less snapshots
      shown in the history).

Event Bean Simulation
   Switch off the simulation of Process Start or Intermediate Event
   Beans when you want to focus on simulations of other elements (Event
   Bean simulation may pop up process editors with the corresponding
   process and may overflow the :ref:`simulate-process-models-debugger-runtimelog-view`.
   In order to apply changes, the Engine must be restarted.

   -  Execute Start Event Beans in Simulation - If ticked, the Process
      Start Event Beans are executed, otherwise not.

   -  Execute Intermediate Event Beans in Simulation - If ticked, the
      Intermediate Start Event Beans are executed, otherwise not.
