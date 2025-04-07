.. _process-elements:

Process Elements Reference
==========================

This chapter provides detailed explanations for the usage and
configuration of all process elements, for both business processes and
user dialog logic.

Axon Ivy provides a lot of useful process elements that can be used to
define processes. These elements reside in the palette on the right edge
of the Process editor. You can drag and drop the elements on the editor
to use them in a specific process flow. You then can connect two
elements by clicking on the source element, let the moused button
pressed down, move the mouse cursor to the target element and finally
release the mouse button. Reconnecting or removal is only possible by
using the corresponding entries in the popup menu.

Every process element can be configured with its inscription view. Open
this view by double-clicking on the element, use the popup-menu or press
the ``i``-key whenever the element is selected. The inscription view is
divided into multiple sections and the order of the sections indicates the
sequence of processing. For example in the figure below, the Output
mapping is performed before the code in the second section is executed.

.. figure:: /_images/process-inscription/example-inscription-view.png
   :alt: An exemplary inscription mask

   An exemplary inscription mask

The dots on the accordions indicate their state:

-  (grey) the section has been changed by the user (default assignments
   are not considered as user entries)

-  (yellow) the tab contains warnings

-  (red) the tab contains errors


Common Tabs
-----------

.. toctree::
   :maxdepth: 2

   common-tabs


Start Events
------------

.. toctree::
   :maxdepth: 1

   start
   signal-start
   program-start
   error-start
   sub-process-start
   web-service-process-start
   user-dialog-start
   user-dialog-method-start
   user-dialog-event-start


Intermediate Events
-------------------

.. toctree::
   :maxdepth: 1

   task-switch-event
   wait-program-intermediate-event


End Events
----------

.. toctree::
   :maxdepth: 1

   process-end
   process-end-page
   error-end
   user-dialog-process-end
   user-dialog-exit-end


Boundary Events
---------------

.. toctree::
   :maxdepth: 1

   error-boundary-event
   signal-boundary-event


Gateways
--------

.. toctree::
   :maxdepth: 1

   alternative
   split
   join
   task-switch-gateway


Workflow Activities
-------------------

.. toctree::
   :maxdepth: 1

   user-task
   user-dialog
   script-step
   embedded-subprocess
   call-sub
   trigger-step


Interface Activities
--------------------

.. toctree::
   :maxdepth: 1

   database-activity
   web-service-call-activity
   rest-client-activity
   email-activity
   rule-activity
   program-interface-activity


BPMN Activities
---------------

.. toctree::
   :maxdepth: 1

   bpmn-activity-elements


Annotations
-----------

.. toctree::
   :maxdepth: 1

   note

