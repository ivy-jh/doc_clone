Use the Engine
--------------

The main page of the Axon Ivy Engine looks as follows:

.. figure:: /_images/engine-getting-started/engine-mainpage.png

The Axon Ivy Engine is running in :ref:`demo mode <demo-mode>`. This is because
you have not installed a valid license yet.

.. Note::
  While running in demo mode, the Axon Ivy Engine is fully functional. 
  However, everything is lost when you shut down the engine. 

For a quick spin, use the engine in demo mode to test the pre-installed Portal
application by clicking on the :guilabel:`Home` link. 

To log in, use one of the predefined demo users: **demo**, **guest**, or
**admin**. The passwords of the demo users are equal to the user names (E.g.
**demo** for the **demo** user). Login as **demo** and navigate to **Processes** by clicking
on the third icon at the menu bar left. Then try to start the **Leave Request** process (Image of a Rocket).

.. figure:: /_images/engine-getting-started/engine-portal-starts.png

Fill in the leave request form. Choose the **Portal Guest User** as **Aprover**.

.. figure:: /_images/engine-getting-started/engine-portal-form.png

Press **Submit leave request** button. Your leave request is being submitted and you will be redirected back 
to the **Portal Dashboard**. 

Then, log out as **demo** and log in as **guest**. On the task list, you now see the
**open task** from the workflow process that you just started. Try to work on
the task by clicking on it:

.. figure:: /_images/engine-getting-started/engine-portal-tasks.png

As **guest** user you can now **Approve** or **Reject** the leave request from the **demo** user. 
By doing so you finish the process and there is no task left in your **Your Tasks** widget on the Dashboard.

Congratulations, you have successfully started your first process and finished all of its tasks. 
If you want to learn how to design and implement such processes have a look at the :ref:`Designer <designer-guide>` guide.

.. Note::
  In Axon Ivy, a task is a piece of work (a part of a process) assigned to a user
  or a role. A user can work on a task if this task is assigned to him or if
  he has the role that the task is assigned to. When a user works on a task, the
  task disappears from the task list of other users who would be able to work on
  the task, too. Only one user can work on a task at a time. In a process, it is
  possible to define parallel tasks. Therefore, two or more
  users may work in parallel on different tasks of the same process instance. In
  Axon Ivy, a process instance is called a **case**.
