.. _process-element-script-activity:

Script Step
===========

|image0| The *Script Step* element is located in the *Activity* drawer
of the process editor palette.

Element Details
---------------

With this element you can perform any transformation of the process data
or start some other processing in order to make preparations for later
steps.

.. warning::

   It is strongly recommended to use the dedicated process elements if
   you intend to use specific functionality and/or technology (such as
   invoking Web Services, querying Databases and so on) as these
   elements encapsulate their use and handle exceptions internally.

Inscription
-----------

.. include:: _tab-name.rst

.. include:: _tab-output.rst

.. include:: _tab-code.rst

.. tip::

   The entered code will be executed *after* the execution of the
   *output tab*. Although this may seem a bit counter-intuitive at
   first, you should simply regard the code tab as an alternative way of
   defining output data. The general recommendation is to use the output
   table to define simple assignments and the code tab if more extensive
   scripting is needed to calculate data.

Disable Permission Checks (Execute this Script Step as SYSTEM)
   With this option enabled the scripts from the Output and Code Tab
   runs without security permission checks. The execution of the scripts
   will never throw any PermissionDeniedException.

   .. warning::

      Use this feature with caution! As the process developer you
      need to make sure that only authorized users can reach this
      Script Step in the process.

.. |image0| image:: /_images/process-editor/elements/script.png
