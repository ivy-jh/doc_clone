.. _dev-workflow-ui:

Developer Workflow UI
*********************

Login Table
-----------

On the login table, you see all the users with their roles. You can switch between
users. Users currently logged-in are highlighted in the table.

|image1|

.. _dev-workflow-ui-case-details:

Case Details
------------

The new Case Details view is an overview of the most important information about
the case. You can also have an overview of a Case Map or case hierarchy. If a
Case Map has sidesteps, you can start them in the Case Map panel.

|image2|

The :ref:`custom fields <custom-fields>` defined for a case are displayed here.

.. _dev-workflow-ui-task-details:

Task Details
------------

On the Task Details view, you can see all the information about the task. In the
top right corner of the panel, you see the actions dropdown. You can execute
some actions on the task, e.g., change its state or delegate the task to a
different role or user.

|image3|

The :ref:`custom fields <custom-fields>` defined for a task are displayed here.


Developer Section
-----------------

The Developer section in the navigation bar will show up if your user has the
permissions `IPermission.TASK_READ_ALL` and `IPermission.CASE_READ_ALL`. The
"Developer" user in designer has these permissions. 

Additionally, you find information and some tools like Signals, Intermediate
Events, Cleanup and API Browser.


Intermediate Events
~~~~~~~~~~~~~~~~~~~

On the Intermediate Events page, you will be able to see all active Intermediate Events
and their sub-events.

|image4|
|image5|


API Browser
~~~~~~~~~~~

Browse through available REST resources in the API Browser.

|image6|


Signals
~~~~~~~

The first box on the Signals page is where you can send a signal with or
without a payload. You can either type in your signal code that can be autocompleted or 
use the dropdown and choose a visible signal.
If you have any waiting or boundary signals, you can fire them directly by clicking the
paper plane icon on the table in the Boundary signals box.

|image7|

Cleanup
~~~~~~~

On the cleanup page, you can delete different types of data from the running |ivy-engine|.
You will see four checkboxes: 

The first one deletes all Cases, Tasks, and dependent objects like documents or
custom fields from the system database.

The second checkbox deletes business data from the system database as well as from the
associated Search Engine index.

The third checkbox deletes OAuth2 identity tokens which you might have collected
by calling third-party REST services.

And the last checkbox clears data caches like the cache of a Database or a web
service request. Fin additional information  in :ref:`data-cache` and
:ref:`process-element-tab-data-cache`.

|image8|


.. |image1| image:: /_images/dev-wf-ui/workflow-ui-loginTable.png
.. |image2| image:: /_images/dev-wf-ui/workflow-ui-caseMap.png
.. |image3| image:: /_images/dev-wf-ui/workflow-ui-taskDetails.png
.. |image4| image:: /_images/dev-wf-ui/workflow-ui-intermediateEvents.png
.. |image5| image:: /_images/dev-wf-ui/workflow-ui-intermediateElementDetails.png
.. |image6| image:: /_images/dev-wf-ui/workflow-ui-swagger-ui.png
.. |image7| image:: /_images/dev-wf-ui/workflow-ui-signals.png
.. |image8| image:: /_images/dev-wf-ui/workflow-ui-cleanup.png
