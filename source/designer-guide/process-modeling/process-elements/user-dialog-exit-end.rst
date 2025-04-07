.. _process-element-user-dialog-exit-end:

User Dialog Exit End
====================

|image0| The *User Dialog Exit End* element is located in the *User
Dialog* drawer of the process editor palette.

Element Details
---------------

This element is used to *terminate* the execution of a User Dialog.

The *result tab* code of the originally invoked start method is executed
and the calculated results are passed back to the :ref:`process-element-user-dialog`
which called the User Dialog. Afterwards the calling process continues.

Inscription
-----------

.. include:: _tab-name.rst

.. |image0| image:: /_images/process-editor/elements/hd-exit-end.png
