.. _process-element-split:

Split
=====

|image0| The *Split Gateway* element is located in the *Event & Gateway* drawer of the process editor palette.


Element Details
---------------

This allows you to model parallel process paths. The element may split
one process path into a number of paths that are executed concurrently.
The input process data is copied to all the parallel executions but can
be manipulated in each path individually.

.. note::

   Use this element always together with the Join element.

.. tip::

   Use the split and the join element to execute parallel database or
   web service requests.

.. warning:

   Do not put any user interaction (User Dialog, HTML Page) or task
   element within a split process path.


Inscription
-----------

.. include:: _tab-name.rst

.. include:: _tab-output.rst

.. note::

   For each outgoing connection you have a separate ``outX`` object
   available which carries the data of the Xth output. Hover with the
   mouse over the outgoing connections of the element to see which
   output connection corresponds to which variable.

.. |image0| image:: /_images/process-editor/elements/gateway-split.png
