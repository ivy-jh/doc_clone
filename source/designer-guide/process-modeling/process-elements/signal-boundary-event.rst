.. _process-element-signal-boundary-event:

Signal Boundary Event
=====================

|image0| The *Signal Boundary Event* can be attached to a User Task by
using its context menu.

Element Details
---------------

A Signal Boundary Event destroys an open task of a user if a signal code
is received that matches the inscribed pattern.

See the :ref:`Signal <signal-reference>` concept for sample use cases.

Inscription
-----------

.. include:: _tab-name.rst

Signal Tab
~~~~~~~~~~

On this tab you configure the pattern that the Boundary Event will
listen to.

|image2|

.. include:: _tab-output.rst

.. note::

   Additionally to the regular variables of the *Output Tab* you have
   the following variable available:

   ``signal``
      Gives access to the signal event.

.. |image0| image:: /_images/process-editor/elements/boundary-signal.png
.. |image2| image:: /_images/process-inscription/signal-boundary-event-tab-signal.png
