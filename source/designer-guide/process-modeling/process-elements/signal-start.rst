.. _process-element-signal-start:

Signal Start
============

|image0| The *Signal Start Event* element is located in the *Event &
Gateway* drawer of the process editor palette.

Element Details
---------------

The Signal Start Event listens to a signal. It starts a new process when
a signal with a matching signal code has been received.

See the :ref:`Signal <signal-reference>` concept for sample use cases.

Inscription
-----------

.. include:: _tab-name.rst

.. _process-element-signal-start-tab-signal:

Signal Tab
~~~~~~~~~~

On this tab you configure the Signal Code that the Signal Start Event
will listen to.

|image2|

Case
   Define whether the triggered case should be attached to the same
   :ref:`business-case` as the signaling case.

.. include:: _tab-output.rst

.. note::

   Additionally to the regular variables of the *Output Tab* you have
   the following variable available:

   signal
      Gives access to the signal event.

.. |image0| image:: /_images/process-editor/elements/start-signal.png
.. |image2| image:: /_images/process-inscription/signal-start-event-tab-signal.png

