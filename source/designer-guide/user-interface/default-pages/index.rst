.. _standard-processes:

Default Pages
*************

With default pages, you can change the default workflow behavior by simply
providing a custom implementation in your Axon Ivy project.

For example: Once a user has completed a task, he will be redirected to his
personal task list. The default task list is workflow-driven and may be too
technical for your end-users. With a standard process, you can easily provide a
branded and use case driven task list that fits perfectly into your domain.


Implementation
--------------

To customize a default page, you need to do the following: 

#. Implement a process with a predefined process start signature in an ivy
   project. See the following subchapters for more information.
#. :ref:`Deploy <deployment>` the Axon Ivy project with the customized standard
   processes in the application. 
#. Optional: If you have multiple projects which provide the default pages
   you may need to fix the provider in :ref:`app-yaml`.

.. literalinclude:: standardprocess-app.yaml
  :language: yaml
  :linenos:


.. _standard-processes-default-pages:

Pages
-----

To customize default pages, you have to implement processes with a predefined
process start signature. The following default pages can be customized: 

.. table::

    +-------------------------------------------------------------------------------------------------+----------------------------------------------------+
    | Default Page                                                                                    | Process Start Signature                            |
    +=================================================================================================+====================================================+
    | **Application Home Page** as the entry page to the application.                                 | DefaultApplicationHomePage()                       |
    +-------------------------------------------------------------------------------------------------+----------------------------------------------------+
    | **Task List** with all tasks the current user can work on.                                      | DefaultTaskListPage()                              |
    +-------------------------------------------------------------------------------------------------+----------------------------------------------------+
    | **Task Detail Page** with detailed information about a task.                                    | DefaultTaskDetailPage(String id)                   |
    +-------------------------------------------------------------------------------------------------+----------------------------------------------------+
    | **Case Detail Page** with detailed information about a case.                                    | DefaultCaseDetailPage(String id)                   |
    +-------------------------------------------------------------------------------------------------+----------------------------------------------------+
    | **Process Start List** with all processes which the current user can start.                     | DefaultProcessStartListPage()                      |
    +-------------------------------------------------------------------------------------------------+----------------------------------------------------+
    | **End Page** which will be displayed to the user after a task or process is completed.          | DefaultEndPage(Number endedTaskId)                 |
    +-------------------------------------------------------------------------------------------------+----------------------------------------------------+
    | **Login Page** which comes up whenever authentication is needed.                                | DefaultLoginPage(String originalUrl)               |
    +-------------------------------------------------------------------------------------------------+----------------------------------------------------+
    | **User Notification Settings Page** allows to change notification settings of the current user. | DefaultUserNotificationSettingsPage()              |
    +-------------------------------------------------------------------------------------------------+----------------------------------------------------+
    | **Error Page** which visualizes error on the front end                                          | no signature: globally defined in :ref:`web-xml`   |
    +-------------------------------------------------------------------------------------------------+----------------------------------------------------+
    | **Frame Page** as the entry page to embed a given URL in a frame.                               | DefaultFramePage(String relativeUrl,               |
    |                                                                                                 | Number runningTaskId)                              |
    +-------------------------------------------------------------------------------------------------+----------------------------------------------------+

.. figure:: /_images/dev-wf-ui/workflow-ui-tasks.png
    :align: center

    Task List
