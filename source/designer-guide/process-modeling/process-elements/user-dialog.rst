.. _process-element-user-dialog:

User Dialog
===========

|element| The *User Dialog* element is located in the *Activity* drawer
of the process editor palette.

Element Details
---------------

The User Dialog element is used to call a User Dialog from a process.
You can both start User Dialogs from a *business process* as well as
from another *User Dialog*. Input and return parameters for/from the
started User Dialog can be mapped using the *call* and *output* tabs of
this element.

Inscription
-----------

.. include:: _tab-name.rst

.. include:: _tab-call.rst

.. include:: _tab-output.rst

.. note::

   Additionally to the regular variables of the *Output Tab* you have
   the following variables available:

   result
      If the selected *start method* defines return parameters they will
      be available as fields of the ``result`` variable.

      The variable is *not* available if the start method does not
      return any values (i.e., *void*).

.. |element| image:: /_images/process-editor/elements/dialog-call.png

