.. _process-element-trigger-step:

Trigger Step
============

|image0| The *Trigger Step* element is located in the *Activity* drawer
of the process editor palette.

Element Details
---------------

With the Trigger element its possible to start a new workflow. The
trigger element triggers a :ref:`process-element-start-request`
element, which has
an enabled triggered start mechanism. On call, the trigger element
creates a case and a task with the defined configuration on the
:ref:`process-element-start-request`. element. The new
created task is returned to the Trigger element.

On call, after the creation of the new case and task, the workflow goes
ahead through the process. When the created task starts (some time
later, by user interaction or automatically by the system), the process
starts at the *Triggered Start* element.

Inscription
-----------

.. include:: _tab-name.rst

Process Tab
~~~~~~~~~~~

On this tab you can configure the Start Signature and the mapping of
input parameter to the process data. The Start Signature is defined by
its name and its parameter type and order.

|image2|

.. include:: _tab-output.rst

The variable ``result`` contains the created task that are returned by
the triggered :ref:`process-element-start-request`.

.. |image0| image:: /_images/process-editor/elements/trigger.png
.. |image2| image:: /_images/process-inscription/trigger-tab-trigger.png
