.. _process-element-error-boundary-event:

Error Boundary Event
====================

|image0| The *Error Boundary Event* can be attached to any activity by
using its context menu.

Element Details
---------------

The execution of an activity can be aborted with an error. The execution
is then redirected to this Error Boundary Event element and continued
from there. Within the follow up flow the process can handle the error
by executing compensation steps or user activities.

See the `Error Handling <#ivy.concepts.error.catch.boundary>`__ concept
for sample use cases.

Inscription
-----------

.. include:: _tab-name.rst

Error Tab
~~~~~~~~~

On this tab you can configure the Error Code that the Boundary Event
will catch.

|image2|

.. include:: _tab-output.rst

.. note

   Additionally to the regular variables of the *Output Tab* you have
   the following variable available:

   error
      References the occurred ``BpmError``. Gives access to the occurred
      Error Code, Cause and CallStack.


.. |image0| image:: /_images/process-editor/elements/boundary-error.png
.. |image2| image:: /_images/process-inscription/error-boundary-event-tab-error.png
