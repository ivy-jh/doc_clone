.. _reference-view:

Reference View
--------------

The Reference view shows the references between the various Axon Ivy
project artifacts. A reference of an artifact is everything which is
used/called from the artifact (e.g., call to a callable process or User
Dialog) or which is embedded in the artifact (e.g., embedded sub element
in a process or processes inside a project). Inverse references are the
opposite of references. This means an inverse reference of an artifact
is everything which uses/calls the artifact or which contains it.

.. figure:: /_images/process-modeling/reference-view.png

.. tip::

   To work with references of process elements, there are also some
   useful features on the Process Editor :ref:`process-editor-quick-actions`.

Accessibility
~~~~~~~~~~~~~

Window > Show View > Reference View

Right click on a project, process, User Dialog or embedded sub element
in the project tree > Show References or Show Inverse References

.. figure:: /_images/process-modeling/reference-menu.png
   :alt: Reference Menus

   Reference Menus

Features
~~~~~~~~

The Reference view has the following functions:

Refresh (|img-reference-view0|)
   This function reloads the actual showed references.

Stop (|img-reference-view1|)
   This function stops the calculation of references.

Show References (|img-reference-view2|)
   This option shows the references of the actual root object.

Show Inverse References (|img-reference-view3|)
   This option shows the inverse references of the actual root object.

.. |img-reference-view0| image:: /_images/process-modeling/reference-view-refresh.png
.. |img-reference-view1| image:: /_images/process-modeling/reference-view-stop.png
.. |img-reference-view2| image:: /_images/process-modeling/reference-view-references.png
.. |img-reference-view3| image:: /_images/process-modeling/reference-view-inverse-references.png
