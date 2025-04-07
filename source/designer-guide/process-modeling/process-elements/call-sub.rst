.. _process-element-call-sub:

Call Sub
========

|image0| The *Call Sub* element is located in the *Activity* drawer of
the process editor palette.


Element Details
---------------

The Call Sub element allows to embed a process (independent subprocess)
into an other. This is like jumping from the main process into the
called sub process, execute the sub process and afterwards jump back.
Process data attributes from the main process are mapped to parameters
for the called sub process and the called sub process will return result
parameters back to the main process.

.. note::

   The input and result parameters of the called process are defined on
   the start element of the called process.

Inscription
-----------

.. include:: _tab-name.rst

Process Tab
~~~~~~~~~~~~~~~~

|image2|

In this tab you choose the process to be called and map process data
attributes to the input parameters of the called process. You can use
any IvyScript expression in the parameter mapping. 
Use the tooltip of a parameter to get the parameter description. 

.. include:: _tab-output.rst

The variable ``result`` contains the output parameters that are returned
by the called sub process (according to its interface definition).

E.g., if the called process returns a ``String errorMessage`` and an
``Employee`` object ``employee`` then the variable ``result`` will have
two fields: ``errorMessage`` and ``employee``, respectively. You can map
those fields to the attributes of the outgoing process data:

::

                   out.msg = result.errorMessage is initialized 
                       ? ("An error occurred during selection: " 
                           + result.errorMessage) 
                       : "";
                   out.selectedEmployee = result.employee;
               

.. |image0| image:: /_images/process-editor/elements/call-sub.png
.. |image2| image:: /_images/process-inscription/call-sub-tab-process-call.png
