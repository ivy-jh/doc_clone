User Dialog Start
=================

|image0| The *User Dialog Start* element is located in the *User Dialog*
drawer of the process editor palette.

Element Details
---------------

The User Dialog Start element is used to map a *Start Method* (as
declared in the `Interface Editor <#ivy.editors.userdialoginterface>`__)
to the process that is started by this element and that implements the
Start Method.

The element allows to initialize internal data of the User Dialog from
the *input* parameters of the call and to define *return* values from
process data (to be returned when the User Dialog finishes).

Inscription
-----------

.. include:: _tab-name.rst

Start Tab
~~~~~~~~~

This tab is used to define the name and input parameters of the *Start Method*
that is implemented by this element's process. See :ref:`process-element-tab-start`
for a more detailed description.

Result Tab
~~~~~~~~~~

This tab is used to define the return values of the User Dialog. See
:ref:`process-element-tab-result` for a more detailed description.

Result
   Return values can be defined according to the declared return types
   that the mapped *Start Method* specifies. The table on this tab shows
   a ``result`` variable which has fields for each declared return type
   (none, if the return type is ``void``).

   You can define the returned result values either in the table or by
   using the IvyScript field below it. The assignments of the table will
   be executed before the script.

   .. tip::

      The defined result object will become available to the caller on
      the *Code component* of the invoking :ref:`process-element-user-dialog`
      once the User Dialog has finished.

.. |image0| image:: /_images/process-editor/elements/hd-init-start.png
