Join
====

|image0| The *Join Gateway* element is located in the *Event & Gateway* drawer of the process editor palette.

Element Details
---------------

This element synchronizes and joins a parallel execution of process
paths together. The output of each incoming path is copied into the
element and can be used to define its output.

.. note::

   This elements waits until all of the parallel incoming process paths
   have finished and reached this element.

.. tip::

   Use the :ref:`process-element-split` element to
   create parallel process paths.


Inscription
-----------

.. include:: _tab-name.rst

.. include:: _tab-output.rst

.. note::

   For each incoming connection you have a separate ``inX`` object
   available which carries the data of the Xth input. Hover with the
   mouse over the incoming connections of the element to see which input
   connection corresponds to which variable.

.. |image0| image:: /_images/process-editor/elements/gateway-join.png
