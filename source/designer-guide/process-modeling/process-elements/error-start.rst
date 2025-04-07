.. _process-element-error-start:

Error Start
===========

|image0| The *Error Start Event* element is located in the *Event & Gateway* drawer of the process editor palette.

Element Details
---------------

The execution of a process element can be aborted with an error. The
execution can continue at an Error Start Event which handles the
occurred error. Within the follow up flow the process can handle the
error by executing compensation steps or user activities.

See the :ref:`Error Handling <error-handling-error-start-event>` concept for
sample use cases.


Inscription
-----------

.. include:: _tab-name.rst

Error Tab
~~~~~~~~~

On this tab you can configure the Error Code that the Error Start Event
will catch.

|image2|

.. include:: _tab-output.rst

.. note::

   Additionally to the regular variables of the *Output Tab* you have
   the following variable available:

   error
      References the occurred ``BpmError``. Gives access to the occurred
      Error Code, Cause and CallStack.

.. |image0| image:: /_images/process-editor/elements/start-error.png
.. |image2| image:: /_images/process-inscription/error-start-event-tab-error.png
