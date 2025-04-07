.. _process-element-error-end:

Error End
=========

|image0| The *Error End Event* element is located in the *Event &
Gateway* drawer of the process editor palette.

Element Details
---------------

The Error End Event can be used to leave the happy path of a process by
throwing an error (e.g., if an approval is denied). It can also be used
to re-throw previously caught errors.

See the :ref:`Error Handling <error-handling-error-start-event>`
concept for sample use cases.

Inscription
-----------

.. include:: _tab-name.rst

Error Tab
~~~~~~~~~

On this tab you can configure the Error Code of the error that will be
thrown or the error object that should be re-thrown.

|image2|

.. include:: _tab-code.rst

.. note::

   Additionally to the regular variables of the *Code Tab* you have the
   following variable available:

   error
      References the ``BpmError`` which will be thrown.

.. |image0| image:: /_images/process-editor/elements/end-error.png
.. |image2| image:: /_images/process-inscription/error-end-event-tab-error.png
