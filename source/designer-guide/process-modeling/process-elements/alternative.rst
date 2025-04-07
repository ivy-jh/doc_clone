.. _process-element-alternative:

Alternative
===========

|image0| The *Alternative Gateway* element is located in the *Event & Gateway* drawer of the process editor palette.

Element Details
---------------

An Alternative is a switch that connects the process flow to one of the
exits of the element depending on the evaluation of the exit conditions.
So, you can use this element to perform business rules (in the form of
*if - else if - else* decisions) or to build loops in the process flow.

Inscription
-----------

.. include:: _tab-name.rst


Tab Condition
~~~~~~~~~~~~~

.. figure:: /_images/process-inscription/alternative-tab-condition.png
   :alt: Condition tab

   Condition tab

Conditions
   Each row in this table is assigned to an exit of this element. In the
   column ``Condition`` boolean expressions must be entered. The
   conditions are evaluated from the top to the bottom and the exit of
   the first one that evaluates to *true* is chosen, i.e., the process
   will proceed by the path connected to this exit.

.. |image0| image:: /_images/process-editor/elements/gateway-alternative.png
