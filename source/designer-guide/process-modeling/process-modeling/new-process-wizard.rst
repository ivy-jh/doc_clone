.. _process-new-wizard:

New Process Wizard
------------------

The *New Process Wizard* lets you create a new Business, Callable Sub or
Web Service Process.

Accessibility
~~~~~~~~~~~~~

File > New > Process


Process Definition (page 1)
~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. figure:: /_images/process-modeling/new-process-wizard-page-1.png
   :alt: New Process Wizard

   New Process Wizard

Project
   Choose the project where the new process should be created.

Namespace
   Select a group where the new process will be inserted (this is
   roughly equivalent to a namespace). Select the ``<default>`` process
   group to create a process directly below the project's processes
   folder (i.e., equal to "no group"). You can click on the group folder
   button to open the *New Process Group Wizard*, if you want to create
   a new group "on the fly". The process groups are listed relative to
   the project's *process* folder.

Name
   Enter the name of the new process.

Type
   :ref:`process-kind-business`:
   This option is the default option an creates a normal standard business
   process. Use this option to implement your business logic.

   :ref:`Callable Sub Process <process-kind-callable>`:
   This option creates a callable sub process including a
   process-call-start element and a process-call-end element. You need
   to implement your process between those two elements. It is allowed
   to have multiple Process Starts and Process End elements in a
   callable process.

   :ref:`process-kind-webservice`:
   This option creates a web service process which can be called from
   other systems. WS Start and WS End elements will be created
   automatically and you can implement your process between these
   elements. Please note that no user interaction may occur in a web
   service process.


.. _process-new-wizard-data:

Process Data (page2)
~~~~~~~~~~~~~~~~~~~~

.. figure:: /_images/process-modeling/new-process-wizard-page-2-normal.png
   :alt: Simple Process Data selection on page 2

   Simple Process Data selection on page 2

Process Data

   *existing*: Select this option to choose an already existing data
   class as data structure for the new process. Any existing Data Class
   can be chosen with the class selector button on the right side. **It
   is strongly recommended to select a data class from the project where
   the process will be created** in order to avoid dependencies on the
   implementation of another project.

   *create new*: Select this option to create a new, empty data class
   that will be associated with the new process. Enter the name of the
   new data class to create (including namespace). Initially a data
   class name that is based on the new process' name and group will be
   suggested, but you're free to change it.

Process Data with simple mapping (page2)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

.. figure:: /_images/process-modeling/new-process-wizard-page-2-mapping.png
   :alt: Process Data selection with auto data Mapping

   Process Data selection with auto data Mapping

Callable Sub Processes often consume or return data from a high level
process. The data which is passed to and given back to the caller
process can be easily mapped within this page.

Callable Sub Process Data
   Defines the Data Class which is used within the Process to create.
   The simple mapping parameters below are only available if a new Data
   Class is created or when the Callable Sub Process uses the same Data
   Class as the caller Process.

Parameters
   The *Caller Data* references the Data Class from the Caller Process.
   The fields of this Data Class can be automatically mapped to the
   Callable Sub Process Data.

   In the mapping table below the Caller Data the In and Out arguments
   for the new Process can be defined. If any mappings are chosen, the
   Wizard will automatically configure the Call Sub Start Event, its
   internal input mapping (param > in) and its output mapping (out >
   result). The calling process element of the high level process will
   also be inscribed with input- & output mappings, if the new Process
   Wizard was opened from the Call Sub inscription step.
