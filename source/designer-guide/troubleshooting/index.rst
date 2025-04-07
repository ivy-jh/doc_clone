Troubleshooting
***************

.. include:: ../../engine-guide/troubleshooting/_intro.rst


Error Dialogs
=============

Error Id
--------

Error Dialogs shown to the user contain a unique error id. This error id
can be used to search the log files for more information about this
error.

Error Report
------------

On Error Dialogs it is possible to generate an Error Report. This report
contains information about the error, the designer machine and the
current state of the Axon Ivy Designer.

.. note::

   If you need to contact the support because of an error, please
   generate an Error Report for it. Most of the time it contains the
   necessary information, to find and solve the problem.

On the HTML error page use the :guilabel:`Open Error Report` button at the end of
the error page to open the Error Report. Use :guilabel:`CTRL-A` and :guilabel:`CTRL-C`
to copy the Error Report to the clipboard.

The Event Details View of the
:ref:`simulate-process-models-debugger-runtimelog-view` provides a
button to generate and save an error report for a given log entry.

Moreover, you can also use the menu :guilabel:`Axon Ivy` > :guilabel:`Debug` > :guilabel:`Save Debug Report`
to generate and save such a report without an error.





Memory Problems
===============

.. _ivy.troubleshooting.memory.heap:

OutOfMemoryException: Java Heap Space
-------------------------------------

If this error occurs, then the Designer requests more memory than it is
allowed to use. This can happen when a lot of data is used during the
process simulations. Ensure, that your computer has enough memory. Then
you can increase the maximal memory consumption of the Axon Ivy Designer.
Just open the ``AxonIvyDesigner.ini`` and change the value in
the line after ``-Xmx`` to a higher one.
