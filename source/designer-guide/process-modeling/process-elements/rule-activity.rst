.. _process-element-rule-activity:

Rule Activity
=============

|image0| The *Rule Activity* element is located in the *Activity* drawer
of the process editor palette.

Element Details
---------------

This element allows to apply a rule set defined in DRL or XLS documents.
By specifying a rule namespace and a data object class, this activity will
apply all rules defined in the namespace to the data object.

Inscription
-----------

.. include:: _tab-name.rst

Tab Call
~~~~~~~~

In this tab you can configure the rule set and the data object.

|image1|

Namespace
   The namespace of the rule set. Child namespaces will not be applied.
   Only one namespace can be chosen. If you want to choose more than one
   namespace you need to use our Java Rules API.

Data Object
   The data object to apply the ruleset to. It must match the type defined
   in the rule set.

.. |image0| image:: /_images/process-editor/elements/rule.png
.. |image1| image:: /_images/process-inscription/rule-tab-configuration.png
