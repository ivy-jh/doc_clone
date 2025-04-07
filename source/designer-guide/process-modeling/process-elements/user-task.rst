.. _process-element-user-task:

User Task
=========

|element| The *User Task* element is located in the *Activity* drawer of
the process editor palette.

Element Details
---------------

The *User Task* element calls a User Dialog in a new Task. Thus, it
combines the behavior of a :ref:`process-element-task-switch-event`
and a :ref:`process-element-user-dialog`. You can either call
a normal HTML Dialog or an Offline Dialog - they both are based on JSF
technology and can run in a Web Browser as well as on a mobile client.

Inscription
-----------

.. include:: _tab-name.rst

.. include:: _tab-call.rst

.. note::

    The behavior of the task will be noticeable different either if
    you select an HTML Dialog or an Offline Dialog. By selecting an
    Offline Dialog, an :ref:`offline-tasks` -
    designed for processing without continuous connection to the
    workflow server - will be generated.

.. include:: _tab-task.rst

.. include:: _tab-case.rst

.. include:: _tab-output.rst

.. note::

   Additionally to the regular variables of the *Output Tab* you have
   the following variable available:

   result
      If the selected *start method* defines return parameters they will
      be available as fields of the ``result`` variable.

      The variable is *not* available if the start method does not
      return any values (i.e., *void*).

.. |element| image:: /_images/process-editor/elements/user-task.png

